package io.github.flemmli97.improvedmobs.forge.config;

import com.google.common.collect.Lists;
import io.github.flemmli97.improvedmobs.config.BreakableBlocks;
import io.github.flemmli97.improvedmobs.config.Config;
import io.github.flemmli97.improvedmobs.config.EntityItemConfig;
import io.github.flemmli97.improvedmobs.config.EntityModifyFlagConfig;
import io.github.flemmli97.improvedmobs.config.MobClassMapConfig;
import net.minecraft.ChatFormatting;
import net.neoforged.fml.config.IConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.Tags;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ConfigSpecs {

    public static final IConfigSpec<?> CLIENT_SPEC;
    public static final ClientConfigVals CLIENT_CONF;

    public static final IConfigSpec<?> COMMON_SPEC;
    public static final CommonConfigVals COMMON_CONF;

    static class ClientConfigVals {

        public final ModConfigSpec.IntValue guiX;
        public final ModConfigSpec.IntValue guiY;
        public final ModConfigSpec.EnumValue<ChatFormatting> color;
        public final ModConfigSpec.DoubleValue scale;
        public final ModConfigSpec.BooleanValue showDifficulty;
        public final ModConfigSpec.EnumValue<Config.DifficultyBarLocation> location;

        public ClientConfigVals(ModConfigSpec.Builder builder) {
            builder/*.translation("improvedmobs.gui")*/.comment("Gui Configs").push("gui");
            this.guiX = builder.defineInRange("Gui X", Config.ClientConfig.guiX, 0, Integer.MAX_VALUE);
            this.guiY = builder.defineInRange("Gui Y", Config.ClientConfig.guiY, 0, Integer.MAX_VALUE);
            this.color = builder.comment("Textformatting codes for the display of the difficulty").defineEnum("Difficulty color", Config.ClientConfig.color);
            this.scale = builder.comment("Scaling of the difficulty text").defineInRange("Text Scale", Config.ClientConfig.scale, 0, Double.MAX_VALUE);
            this.showDifficulty = builder.comment("Show the the difficulty text").define("Show Difficulty", Config.ClientConfig.showDifficulty);
            this.location = builder.comment("Relative location of the difficulty text in regards to the screen.").defineEnum("Difficulty location", Config.ClientConfig.location);
            builder.pop();
        }
    }

    static class CommonConfigVals {

        //General
        public final ModConfigSpec.BooleanValue enableDifficultyScaling;
        public final ModConfigSpec.IntValue difficultyDelay;
        public final ModConfigSpec.BooleanValue ignoreSpawner;
        public final ModConfigSpec.ConfigValue<List<String>> increaseHandler;
        public final ModConfigSpec.BooleanValue ignorePlayers;
        public final ModConfigSpec.BooleanValue shouldPunishTimeSkip;
        public final ModConfigSpec.BooleanValue friendlyFire;
        public final ModConfigSpec.ConfigValue<List<String>> petArmorBlackList;
        public final ModConfigSpec.BooleanValue petWhiteList;
        public final ModConfigSpec.BooleanValue doIMDifficulty;
        public final ModConfigSpec.EnumValue<Config.DifficultyType> difficultyType;
        public final ModConfigSpec.ConfigValue<String> centerPos;

        //Black-WhiteList
        public final ModConfigSpec.ConfigValue<List<String>> flagBlacklist;
        public final ModConfigSpec.ConfigValue<List<String>> entityBlacklist;
        public final ModConfigSpec.BooleanValue mobAttributeWhitelist;
        public final ModConfigSpec.BooleanValue armorMobWhitelist;
        public final ModConfigSpec.BooleanValue heldMobWhitelist;
        public final ModConfigSpec.BooleanValue mobListBreakWhitelist;
        public final ModConfigSpec.BooleanValue mobListUseWhitelist;
        public final ModConfigSpec.BooleanValue mobListLadderWhitelist;
        public final ModConfigSpec.BooleanValue mobListStealWhitelist;
        public final ModConfigSpec.BooleanValue mobListBoatWhitelist;
        public final ModConfigSpec.BooleanValue mobListFlyWhitelist;
        public final ModConfigSpec.BooleanValue targetVillagerWhitelist;
        public final ModConfigSpec.BooleanValue neutralAggroWhitelist;

        //Integration
        public final ModConfigSpec.BooleanValue useScalingHealthMod;
        public final ModConfigSpec.BooleanValue usePlayerEXMod;
        public final ModConfigSpec.BooleanValue useLevelZMod;
        public final ModConfigSpec.BooleanValue varySizebyPehkui;
        public final ModConfigSpec.DoubleValue sizeMin;
        public final ModConfigSpec.DoubleValue sizeMax;

        //AI
        public final ModConfigSpec.ConfigValue<List<String>> breakableBlocks;
        public final ModConfigSpec.BooleanValue breakingAsBlacklist;
        public final ModConfigSpec.BooleanValue useBlockBreakSound;
        public final ModConfigSpec.DoubleValue breakerChance;
        public final ModConfigSpec.IntValue breakerInitCooldown;
        public final ModConfigSpec.IntValue breakerCooldown;
        public final ModConfigSpec.BooleanValue ignoreHarvestLevel;
        public final ModConfigSpec.IntValue restoreDelay;
        public final ModConfigSpec.BooleanValue idleBreak;
        public final ModConfigSpec.DoubleValue stealerChance;
        public final ModConfigSpec.ConfigValue<List<String>> blackListedContainerBlocks;
        public final ModConfigSpec.BooleanValue breakTileEntities;
        public final ModConfigSpec.ConfigValue<List<String>> breakingItems;
        public final ModConfigSpec.DoubleValue neutralAggressiv;
        public final ModConfigSpec.ConfigValue<List<String>> autoTargets;
        public final ModConfigSpec.DoubleValue difficultyBreak;
        public final ModConfigSpec.DoubleValue difficultySteal;
        public final ModConfigSpec.DoubleValue guardianAIChance;
        public final ModConfigSpec.DoubleValue flyAIChance;
        public final ModConfigSpec.BooleanValue tntBlockDestruction;

        //Equipment
        public final ModConfigSpec.ConfigValue<List<String>> equipmentModBlacklist;
        public final ModConfigSpec.BooleanValue equipmentModWhitelist;
        public final ModConfigSpec.ConfigValue<List<String>> itemuseBlacklist;
        public final ModConfigSpec.BooleanValue itemuseWhitelist;
        public final ModConfigSpec.ConfigValue<List<String>> entityItemConfig;

        public final ModConfigSpec.DoubleValue baseEquipChance;
        public final ModConfigSpec.DoubleValue baseEquipChanceAdd;
        public final ModConfigSpec.DoubleValue diffEquipAdd;
        public final ModConfigSpec.DoubleValue baseWeaponChance;
        public final ModConfigSpec.DoubleValue diffWeaponChance;
        public final ModConfigSpec.DoubleValue baseEnchantChance;
        public final ModConfigSpec.DoubleValue diffEnchantAdd;
        public final ModConfigSpec.ConfigValue<List<String>> enchantCalc;
        public final ModConfigSpec.ConfigValue<List<String>> enchantBlacklist;
        public final ModConfigSpec.BooleanValue enchantWhitelist;
        public final ModConfigSpec.DoubleValue baseItemChance;
        public final ModConfigSpec.DoubleValue diffItemChanceAdd;
        public final ModConfigSpec.BooleanValue shouldDropEquip;

        //Attributes
        public final ModConfigSpec.DoubleValue healthIncrease;
        public final ModConfigSpec.DoubleValue healthMax;
        public final ModConfigSpec.DoubleValue roundHP;
        public final ModConfigSpec.DoubleValue damageIncrease;
        public final ModConfigSpec.DoubleValue damageMax;
        public final ModConfigSpec.DoubleValue speedIncrease;
        public final ModConfigSpec.DoubleValue speedMax;
        public final ModConfigSpec.DoubleValue knockbackIncrease;
        public final ModConfigSpec.DoubleValue knockbackMax;
        public final ModConfigSpec.DoubleValue magicResIncrease;
        public final ModConfigSpec.DoubleValue magicResMax;
        public final ModConfigSpec.DoubleValue projectileIncrease;
        public final ModConfigSpec.DoubleValue projectileMax;
        public final ModConfigSpec.DoubleValue explosionIncrease;
        public final ModConfigSpec.DoubleValue explosionMax;

        public CommonConfigVals(ModConfigSpec.Builder builder) {
            builder.comment("Default difficulty caps at 250")/*.translation("improvedmobs.general")*/.push("general");
            this.enableDifficultyScaling = builder.comment("Disable/Enables the whole difficulty scaling of this mod. Requires a mc restart").define("Enable difficulty scaling", Config.CommonConfig.enableDifficultyScaling);
            this.difficultyDelay = builder.comment("Time in ticks for which the difficulty shouldnt increase at the beginning. One full minecraft day is 24000 ticks").defineInRange("Difficulty Delay", Config.CommonConfig.difficultyDelay, 0, Integer.MAX_VALUE);
            this.ignoreSpawner = builder.comment("If true ignores mobs from spawners").define("Ignore Spawner", Config.CommonConfig.ignoreSpawner);
            this.increaseHandler = builder.comment("Handles increase in difficulty regarding current difficulty.",
                    "Format is <minimum current difficulty>-<increase every 2400 ticks>", "Example [\"0-0.01\",\"10-0.1\",\"30-0\"]",
                    "So the difficulty increases by 0.01 every 2400 ticks (->0.1 per mc day since a mc day has 24000 ticks) till it reaches a difficulty of 10.",
                    "Then it increases by 1 per mc day till it reaches 30 and then stops.").define("Difficulty Increase", Config.CommonConfig.increaseHandler.writeToString(), stringList());
            this.ignorePlayers = builder.comment("Wether difficulty should only increase with at least one online players or not").define("Ignore Players", Config.CommonConfig.ignorePlayers);
            this.shouldPunishTimeSkip = builder.comment("If true will increase difficulty by the amount of time skipped. Else will only increase difficulty once.").define("Punish Time Skip", Config.CommonConfig.shouldPunishTimeSkip);
            this.friendlyFire = builder.comment("Disable/Enable friendly fire for owned pets.").define("FriendlyFire", Config.CommonConfig.friendlyFire);
            this.petArmorBlackList = builder.comment("Blacklist for pet you should't be able to give armor to. Pets from mods, which have custom armor already should be included here (for balancing reasons).").define("Pet Blacklist", Config.CommonConfig.petArmorBlackList, stringList());
            this.petWhiteList = builder.comment("Treat pet blacklist as whitelist").define("Pet Whitelist", Config.CommonConfig.petWhiteList);
            this.doIMDifficulty = builder.comment("Increase difficulty with time", "Here untill its back as a gamerule").define("Difficulty toggle", Config.CommonConfig.doIMDifficulty);
            this.difficultyType = builder.comment("How the difficulty at a position is calculated. Supported values are: ",
                    "GLOBAL: Serverwide difficulty value",
                    "PLAYERMAX: Maximum difficulty of players in a 256 radius around the position",
                    "PLAYERMEAN: Average difficulty of players in a 256 radius around the position",
                    "DISTANCE: Uses the distance to the position defined in Center Position to define the difficulty",
                    "DISTANCESPAWN: Uses the distance to the world spawn to define the difficulty",
                    "If the type is any of the distance types the functionality of Difficulty Increase is changed to the following where the 1. value is the minimum distance and the 2. is the difficulty that applies. ",
                    "E.g. [\"0-0\",\"1000-5\"] translates to 0 difficulty between 0-1000 distance and 5 difficulty for distance >= 1000",
                    "You can also define it as a triple x-y-z instead where z is the increase per block in for that area.",
                    "E.g. [\"0-0-0.1\",\"1000-5-1\"] the difficulty increases between 0-1000 by 0.1 per block and >= 1000 by 1 per block with a starting value of 5").defineEnum("Difficulty type", Config.CommonConfig.difficultyType);
            this.centerPos = builder.comment("Position used for DISTANCE difficulty type").define("Center Position", Config.CommonConfig.centerPos.writeToString());
            builder.pop();

            builder.comment("Black/Whitelist for various stuff").push("list");
            this.entityBlacklist = builder.comment(EntityModifyFlagConfig.use()).define("Entity Configs", Lists.newArrayList("UNINITIALIZED"));
            this.flagBlacklist = builder.comment("Any of the following ", EntityModifyFlagConfig.Flags.toggable().toString(), "added here will disable that feature completely.", "E.g. [\"GUARDIAN\"] will disable the guardian feature").define("Flag Blacklist", Config.CommonConfig.flagBlacklist, stringList());
            this.mobAttributeWhitelist = builder.comment("Treat ATTRIBUTES flags as whitelist").define("Attribute Whitelist", Config.CommonConfig.mobAttributeWhitelist);
            this.armorMobWhitelist = builder.comment("Treat ARMOR flags as whitelist").define("Armor Equip Whitelist", Config.CommonConfig.armorMobWhitelist);
            this.heldMobWhitelist = builder.comment("Treat HELDITEMS flags as whitelist").define("Held Equip Whitelist", Config.CommonConfig.heldMobWhitelist);
            this.mobListBreakWhitelist = builder.comment("Treat BLOCKBREAK flags as whitelist").define("Breaker Whitelist", Config.CommonConfig.mobListBreakWhitelist);
            this.mobListUseWhitelist = builder.comment("Treat USEITEM flags as whitelist").define("Use Flag Whitelist", Config.CommonConfig.mobListUseWhitelist);
            this.mobListLadderWhitelist = builder.comment("Treat LADDER flags as whitelist").define("Ladder Whitelist", Config.CommonConfig.mobListLadderWhitelist);
            this.mobListStealWhitelist = builder.comment("Treat STEAL flags as whitelist").define("Steal Whitelist", Config.CommonConfig.mobListStealWhitelist);
            this.mobListBoatWhitelist = builder.comment("Treat GUARDIAN flags as whitelist").define("Guardian Whitelist", Config.CommonConfig.mobListBoatWhitelist);
            this.mobListFlyWhitelist = builder.comment("Treat PARROT flags as whitelist").define("Phantom Whitelist", Config.CommonConfig.mobListFlyWhitelist);
            this.targetVillagerWhitelist = builder.comment("Treat TARGETVILLAGER flags as whitelist").define("Villager Whitelist", Config.CommonConfig.targetVillagerWhitelist);
            this.neutralAggroWhitelist = builder.comment("Treat NEUTRALAGGRO flags as whitelist").define("Neutral Aggro Whitelist", Config.CommonConfig.neutralAggroWhitelist);
            builder.pop();

            builder.comment("Settings for mod integration").push("integration");
            this.useScalingHealthMod = builder.comment("Should the scaling health mods difficulty system be used instead of this ones. (Requires scaling health mod)").define("Use Scaling Health Mod", Config.CommonConfig.useScalingHealthMod);
            this.usePlayerEXMod = builder.comment("If true and playerEx is installed will use the level from playerEx as difficulty").define("Use Player EX Mod", Config.CommonConfig.usePlayerEXMod);
            this.useLevelZMod = builder.comment("If true and LevelZ is installed will use the the total skill level from LevelZ as difficulty").define("Use LevelZ Mod", Config.CommonConfig.useLevelZMod);
            this.varySizebyPehkui = builder.comment("Using pehkui to vary the size of mobs").define("Use pehkui Mod", Config.CommonConfig.varySizebyPehkui);
            this.sizeMax = builder.comment("The Max scale of mobs. Range [1.0,10], default 2.0").defineInRange("Max size Multiplier", Config.CommonConfig.sizeMax, 1.0, 10.0);
            this.sizeMin = builder.comment("The Minimum scale of mobs. Range (0,1.0), default 0.5").defineInRange("Minimum size Multiplier", Config.CommonConfig.sizeMin, 0, 1.0);
            builder.pop();

            builder.comment("Settings regarding custom ai for mobs").push("ai");
            this.breakableBlocks = builder.comment("Whitelist for blocks, which can be actively broken. ", BreakableBlocks.use(), "Note: If you include common blocks (like grass blocks) the pathfinding can have undesirable results.").define("Block Break Whitelist", Config.CommonConfig.breakableBlocks.writeToString(), stringList());
            this.breakingAsBlacklist = builder.comment("Treat Block Whitelist as Blocklist").define("Breaklist as Blacklist", Config.CommonConfig.breakingAsBlacklist);
            this.useBlockBreakSound = builder.comment("Use the block breaking sound instead of a knocking sound").define("Sound", Config.CommonConfig.useBlockBreakSound);
            this.breakerChance = builder.comment("Chance for a mob to be able to break blocks").defineInRange("Breaker Chance", Config.CommonConfig.breakerChance, 0, 1);
            this.breakerInitCooldown = builder.comment("Initial cooldown for block breaking mobs").defineInRange("Breaker Initial Cooldown", Config.CommonConfig.breakerInitCooldown, 0, Integer.MAX_VALUE);
            this.breakerCooldown = builder.comment("Cooldown for breaking blocks").defineInRange("Breaker Cooldown", Config.CommonConfig.breakerCooldown, 0, Integer.MAX_VALUE);
            this.ignoreHarvestLevel = builder.comment("By default mobs can only break the block they can harvest with the current tool they holding. Set this to true to disable that check (The block will not drop if they cant harvest it though!).").define("Ignore Harvest Check", Config.CommonConfig.ignoreHarvestLevel);
            this.restoreDelay = builder.comment("Blocks will be restored after x ticks being broken. If set to 0 will never restore", "This will not restore block entity data!").defineInRange("Restore delay", Config.CommonConfig.restoreDelay, 0, Integer.MAX_VALUE);
            this.idleBreak = builder.comment("If mobs should break blocks when not chasing a target").define("Idle Break", Config.CommonConfig.idleBreak);
            this.stealerChance = builder.comment("Chance for a mob to be able to steal items from inventory blocks").defineInRange("Stealer Chance", Config.CommonConfig.stealerChance, 0, 1);
            this.blackListedContainerBlocks = builder.comment("List of blocks mobs shouldn't steal from. You can also add a modid to blacklist whole mods").define("Steal Block Blacklist", Config.CommonConfig.blackListedContainerBlocks, stringList());
            this.breakingItems = builder.comment("Items which will be given to mobs who can break blocks. Empty list = no items. Syntax: id;weight", "Note: Mobs can only break blocks if the tool they are holding can break the blocks").define("Breaking items", Lists.newArrayList("minecraft:diamond_pickaxe;1", "minecraft:iron_axe;2"), stringList());
            this.breakTileEntities = builder.comment("Should mobs be able to break block entities? Evaluated before the break list").define("Break BlockEntities", Config.CommonConfig.breakTileEntities);
            this.neutralAggressiv = builder.comment("Chance for neutral mobs to be aggressive").defineInRange("Neutral Aggressive Chance", Config.CommonConfig.neutralAggressiv, 0, 1);
            this.autoTargets = builder.comment("List for of pairs containing which mobs auto target others. Syntax is " + MobClassMapConfig.use()).define("Auto Target List", Config.CommonConfig.autoTargets.writeToString(), stringList());
            this.difficultyBreak = builder.comment("Difficulty at which mobs are able to break blocks").defineInRange("Difficulty Break AI", Config.CommonConfig.difficultyBreak, 0, Double.MAX_VALUE);
            this.difficultySteal = builder.comment("Difficulty at which mobs are able to steal items").defineInRange("Difficulty Steal AI", Config.CommonConfig.difficultySteal, 0, Double.MAX_VALUE);
            this.guardianAIChance = builder.comment("Chance for mobs to be able to summon an aquatic mount").defineInRange("Guardian Chance", Config.CommonConfig.guardianAIChance, 0, 1);
            this.flyAIChance = builder.comment("Chance for mobs to be able to summon a flying mount").defineInRange("Phantom Chance", Config.CommonConfig.flyAIChance, 0, 1);
            this.tntBlockDestruction = builder.comment("Set this to true to allow tnt thrown by mobs to destroy blocks").define("TNT Block Destruction", Config.CommonConfig.tntBlockDestruction);
            builder.pop();

            builder.comment("Configs regarding mobs spawning with equipment").push("equipment");
            this.equipmentModBlacklist = builder.comment("Blacklist items from whole mods. Add modid to prevent items from that mod being equipped. (For individual items use the equipment.json)").define("Item Blacklist", Config.CommonConfig.equipmentModBlacklist);
            this.equipmentModWhitelist = builder.comment("Use blacklist as whitelist").define("Item Whitelist", Config.CommonConfig.equipmentModWhitelist);
            this.itemuseBlacklist = builder.comment("Blacklist for items mobs should never be able to use.", "Use as in using the item similar to players (e.g. shooting bows)").define("Item Use Blacklist", Config.CommonConfig.itemuseBlacklist);
            this.itemuseWhitelist = builder.comment("Turn the use blacklist into a whitelist").define("Item Use Whitelist", Config.CommonConfig.itemuseWhitelist);
            this.entityItemConfig = builder.comment("Blacklist for specific mobs and items they shouldnt use (e.g. skeletons already use bows)", EntityItemConfig.use()).define("Entity Item Use Blacklist", Config.CommonConfig.entityItemConfig.writeToString(), stringList());
            this.baseEquipChance = builder.comment("Base chance that a mob can have one piece of armor").defineInRange("Equipment Chance", Config.CommonConfig.baseEquipChance, 0, 1);
            this.baseEquipChanceAdd = builder.comment("Base chance for each additional armor pieces").defineInRange("Additional Equipment Chance", Config.CommonConfig.baseEquipChanceAdd, 0, 1);
            this.diffEquipAdd = builder.comment("Adds additional x*difficulty% to base equip chance").defineInRange("Equipment Addition", Config.CommonConfig.diffEquipAdd, 0, Double.MAX_VALUE);
            this.baseWeaponChance = builder.comment("Chance for mobs to have a weapon").defineInRange("Weapon Chance", Config.CommonConfig.baseWeaponChance, 0, 1);
            this.diffWeaponChance = builder.comment("Adds additional x*difficulty% to base weapon chance").defineInRange("Weapon Chance Add", Config.CommonConfig.diffWeaponChance, 0, Double.MAX_VALUE);
            this.baseEnchantChance = builder.comment("Base chance for each armor pieces to get enchanted").defineInRange("Enchanting Chance", Config.CommonConfig.baseEnchantChance, 0, 1);
            this.diffEnchantAdd = builder.comment("Adds additional x*difficulty% to base enchanting chance").defineInRange("Enchanting Addition", Config.CommonConfig.diffEnchantAdd, 0, Double.MAX_VALUE);
            this.enchantCalc = builder.comment("Specify min and max enchanting levels according to difficulty. difficulty-minLevel-maxLevel").define("Enchanting Calc", Config.CommonConfig.enchantCalc.writeToString(), stringList());
            this.enchantBlacklist = builder.comment("Blacklist enchantments from being applied to equipments").define("Enchanting Blacklist", Config.CommonConfig.enchantBlacklist, stringList());
            this.enchantWhitelist = builder.comment("Turn the enchant blacklist to a whitelist").define("Enchanting Whitelist", Config.CommonConfig.enchantWhitelist);
            this.baseItemChance = builder.comment("Chance for mobs to have an item in offhand").defineInRange("Item Equip Chance", Config.CommonConfig.baseItemChance, 0, 1);
            this.diffItemChanceAdd = builder.comment("Adds additional x*difficulty% to base item chance").defineInRange("Item Chance add", Config.CommonConfig.diffItemChanceAdd, 0, Double.MAX_VALUE);
            this.shouldDropEquip = builder.comment("Should mobs drop the armor equipped through this mod? Will not change drops if the mob obtained the armor through other means (e.g. vanilla)").define("Should drop equipment", Config.CommonConfig.shouldDropEquip);
            builder.pop();

            builder.comment("Settings for attribute modifiers").push("attributes");
            this.healthIncrease = builder.comment("Health will be multiplied by 1 + difficulty*0.016*x. Set to 0 to disable").defineInRange("Health Increase Multiplier", Config.CommonConfig.healthIncrease, 0, Double.MAX_VALUE);
            this.healthMax = builder.comment("Health will be multiplied by at maximum this. Set to 0 means no limit").defineInRange("Max Health Increase", Config.CommonConfig.healthMax, 0, Double.MAX_VALUE);
            this.roundHP = builder.comment("Round health to the nearest x. Set to 0 to disable").defineInRange("Round HP", Config.CommonConfig.roundHP, 0, Double.MAX_VALUE);
            this.damageIncrease = builder.comment("Damage will be multiplied by 1 + difficulty*0.008*x. Set to 0 to disable").defineInRange("Damage Increase Multiplier", Config.CommonConfig.damageIncrease, 0, Double.MAX_VALUE);
            this.damageMax = builder.comment("Damage will be multiplied by at maximum this. Set to 0 means no limit").defineInRange("Max Damage Increase", Config.CommonConfig.damageMax, 0, Double.MAX_VALUE);
            this.speedIncrease = builder.comment("Speed will be increased by difficulty*0.0008*x. Set to 0 to disable").defineInRange("Speed Increase", Config.CommonConfig.speedIncrease, 0, Double.MAX_VALUE);
            this.speedMax = builder.comment("Maximum increase in speed").defineInRange("Max Speed", Config.CommonConfig.speedMax, 0, 1);
            this.knockbackIncrease = builder.comment("Knockback will be increased by difficulty*0.002*x. Set to 0 to disable").defineInRange("Knockback Increase", Config.CommonConfig.knockbackIncrease, 0, Double.MAX_VALUE);
            this.knockbackMax = builder.comment("Maximum increase in knockback").defineInRange("Max Knockback", Config.CommonConfig.knockbackMax, 0, 1);
            this.magicResIncrease = builder.comment("Magic resistance will be increased by difficulty*0.0016*x. Set to 0 to disable").defineInRange("Magic Resistance Increase", Config.CommonConfig.magicResIncrease, 0, Double.MAX_VALUE);
            this.magicResMax = builder.comment("Maximum increase in magic resistance. Magic reduction is percentage").defineInRange("Max Magic Resistance", Config.CommonConfig.magicResMax, 0, 1);
            this.projectileIncrease = builder.comment("Projectile Damage will be multiplied by 1 + difficulty*0.008*x. Set to 0 to disable").defineInRange("Projectile Damage Increase", Config.CommonConfig.projectileIncrease, 0, Double.MAX_VALUE);
            this.projectileMax = builder.comment("Projectile damage will be multiplied by maximum of this").defineInRange("Max Projectile Damage", Config.CommonConfig.projectileMax, 0, Double.MAX_VALUE);
            this.explosionIncrease = builder.comment("Explosion Damage will be multiplied by 1 + difficulty*0.003*x. Set to 0 to disable").defineInRange("Explosion Damage Increase", Config.CommonConfig.explosionIncrease, 0, Double.MAX_VALUE);
            this.explosionMax = builder.comment("Explosion damage will be multiplied by maximum of this").defineInRange("Max Explosion Damage", Config.CommonConfig.explosionMax, 0, Double.MAX_VALUE);
            builder.pop();
        }
    }

    private static Predicate<Object> stringList() {
        return p -> p instanceof List<?> list && list.stream().allMatch(e -> e instanceof String);
    }

    static {
        Pair<ClientConfigVals, ModConfigSpec> specPair1 = new ModConfigSpec.Builder().configure(ClientConfigVals::new);
        CLIENT_SPEC = specPair1.getRight();
        CLIENT_CONF = specPair1.getLeft();

        Pair<CommonConfigVals, ModConfigSpec> specPair2 = new ModConfigSpec.Builder().configure(CommonConfigVals::new);
        COMMON_SPEC = specPair2.getRight();
        COMMON_CONF = specPair2.getLeft();
    }
}
