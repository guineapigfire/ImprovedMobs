package io.github.flemmli97.improvedmobs.config;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.github.flemmli97.improvedmobs.ImprovedMobs;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;

public class MobClassMapConfig {

    private final Map<ResourceLocation, List<EntityType<?>>> map = Maps.newLinkedHashMap();
    public Map<ResourceLocation, Predicate<Class<? extends Mob>>> preds = new HashMap<>();

    @Nullable
    public List<EntityType<?>> get(ResourceLocation res) {
        return this.map.get(res);
    }

    public MobClassMapConfig readFromString(List<String> ss) {
        this.map.clear();
        for (String s : ss) {
            String[] sub = s.replace(" ", "").split("-");
            if (sub.length < 2)
                continue;
            EntityType<?> type = BuiltInRegistries.ENTITY_TYPE.getOptional(new ResourceLocation(sub[1])).orElse(null);
            if (type == null) {
                ImprovedMobs.LOGGER.error("Entity {} does not exist/is not registered", sub[1]);
                continue;
            }
            this.map.merge(new ResourceLocation(sub[0]), Lists.newArrayList(type), (old, oth) -> {
                old.add(type);
                return old;
            });
        }
        return this;
    }

    public List<String> writeToString() {
        List<String> l = new ArrayList<>();
        for (Entry<ResourceLocation, List<EntityType<?>>> ent : this.map.entrySet()) {
            for (EntityType<?> type : ent.getValue()) {
                l.add(ent.getKey().toString() + "-" + BuiltInRegistries.ENTITY_TYPE.getKey(type));
            }
        }
        return l;
    }

    public static String use() {
        return "[mob id]-[mob id] where second value is the target.\n e.g. minecraft:zombie-minecraft:skeleton makes all zombies target skeletons";
    }
}
