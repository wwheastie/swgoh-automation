package com.heastie.swgoh.automation.simulator.mods;

import static com.heastie.swgoh.automation.simulator.mods.ModFiltersEnum.TIER.BLUE;
import static com.heastie.swgoh.automation.simulator.mods.ModFiltersEnum.TIER.GOLD;
import static com.heastie.swgoh.automation.simulator.mods.ModFiltersEnum.TIER.GREEN;
import static com.heastie.swgoh.automation.simulator.mods.ModFiltersEnum.TIER.GREY;
import static com.heastie.swgoh.automation.simulator.mods.ModFiltersEnum.TIER.PURPLE;

import com.heastie.swgoh.automation.simulator.mods.ModFiltersEnum.PRIMARY_STAT;
import com.heastie.swgoh.automation.simulator.mods.ModFiltersEnum.RARITY;
import com.heastie.swgoh.automation.simulator.mods.ModFiltersEnum.SECONDARY_STAT;
import com.heastie.swgoh.automation.simulator.mods.ModFiltersEnum.SET;
import com.heastie.swgoh.automation.simulator.mods.ModFiltersEnum.SLOT;
import com.heastie.swgoh.automation.simulator.mods.ModFiltersEnum.TIER;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class FilterOptionsDatabase {
    public static final Map<SLOT, Point> MOD_SLOTS = new HashMap<>();
    public static final Map<SET, Point> MOD_SETS = new HashMap<>();
    public static final Map<PRIMARY_STAT, Point> PRIMARY_STATS = new HashMap<>();
    public static final Map<SECONDARY_STAT, Point> SECONDARY_STATS = new HashMap<>();
    public static final Map<Integer, Point> LEVEL_MAP = new HashMap<>();
////    public static final Map<Level>
    public static final Map<RARITY, Point> RARITY_MAP = new HashMap<>();
    public static final Map<TIER, Point> TIER_MAP = new HashMap<>();
//    public static final Map<SORT, Point>

    public FilterOptionsDatabase() {
        initModSlots();
        initModSets();
        initPrimaryStat();
        initSecondaryStat();
        initLevel();
        initRarity();
        initTier();
    }

    private void initModSlots() {
        MOD_SLOTS.put(SLOT.SQUARE, new Point(770, 375));
        MOD_SLOTS.put(SLOT.ARROW, new Point(870, 375));
        MOD_SLOTS.put(SLOT.DIAMOND, new Point(970, 375));
        MOD_SLOTS.put(SLOT.TRIANGLE, new Point(1070, 375));
        MOD_SLOTS.put(SLOT.CIRCLE, new Point(1170, 375));
        MOD_SLOTS.put(SLOT.CROSS, new Point(1270, 375));
    }

    private void initModSets() {
        MOD_SETS.put(SET.HEALTH, new Point(770, 550));
        MOD_SETS.put(SET.DEFENSE, new Point(870, 550));
        MOD_SETS.put(SET.CRITICAL_DAMAGE, new Point(970, 550));
        MOD_SETS.put(SET.CRITICAL_CHANCE, new Point(1070, 550));
        MOD_SETS.put(SET.TENACITY, new Point(1170, 550));
        MOD_SETS.put(SET.OFFENSE, new Point(1270, 550));
        MOD_SETS.put(SET.POTENCY, new Point(1370, 550));
        MOD_SETS.put(SET.SPEED, new Point(1470, 550));
    }

    private void initPrimaryStat() {
        PRIMARY_STATS.put(PRIMARY_STAT.ACCURACY, new Point(810, 710));
        PRIMARY_STATS.put(PRIMARY_STAT.CRIT_AVOIDANCE, new Point(1020, 710));
        PRIMARY_STATS.put(PRIMARY_STAT.CRIT_CHANCE, new Point(1230, 710));
        PRIMARY_STATS.put(PRIMARY_STAT.CRIT_DAMAGE, new Point(1440, 710));
        PRIMARY_STATS.put(PRIMARY_STAT.DEFENSE, new Point(1650, 710));

        PRIMARY_STATS.put(PRIMARY_STAT.HEALTH, new Point(610, 790));
        PRIMARY_STATS.put(PRIMARY_STAT.OFFENSE, new Point(830, 790));
        PRIMARY_STATS.put(PRIMARY_STAT.POTENCY, new Point(1040, 790));
        PRIMARY_STATS.put(PRIMARY_STAT.PROTECTION, new Point(1250, 790));
        PRIMARY_STATS.put(PRIMARY_STAT.SPEED, new Point(1460, 790));
        PRIMARY_STATS.put(PRIMARY_STAT.TENACITY, new Point(1670, 790));
    }

    private void initSecondaryStat() {
        SECONDARY_STATS.put(SECONDARY_STAT.CRIT_CHANCE, new Point(820, 345));
        SECONDARY_STATS.put(SECONDARY_STAT.DEFENSE_FLAT, new Point(1020, 345));
        SECONDARY_STATS.put(SECONDARY_STAT.DEFENSE, new Point(1220, 345));
        SECONDARY_STATS.put(SECONDARY_STAT.HEALTH_FLAT, new Point(1420, 345));
//        SECONDARY_STATS.put(SECONDARY_STAT.HEALTH, new Point(1620, 345));
//
//        SECONDARY_STATS.put(SECONDARY_STAT.OFFENSE_FLAT, new Point(620, 420));
//        SECONDARY_STATS.put(SECONDARY_STAT.OFFENSE, new Point(820, 420));
//        SECONDARY_STATS.put(SECONDARY_STAT.POTENCY, new Point(1020, 420));
//        SECONDARY_STATS.put(SECONDARY_STAT.PROTECTION_FLAT, new Point(1220, 420));
//        SECONDARY_STATS.put(SECONDARY_STAT.PROTECTION, new Point(1420, 420));
//        SECONDARY_STATS.put(SECONDARY_STAT.SPEED, new Point(1620, 420));
//
//        SECONDARY_STATS.put(SECONDARY_STAT.TENACITY, new Point(620, 490));
    }

    private void initLevel() {
        LEVEL_MAP.put(1, new Point(580, 340));
        LEVEL_MAP.put(3, new Point(700, 340));
        LEVEL_MAP.put(6, new Point(810, 340));
        LEVEL_MAP.put(9, new Point(920, 340));
        LEVEL_MAP.put(12, new Point(1030, 340));
        LEVEL_MAP.put(15, new Point(1140, 340));
    }

    private void initRarity() {
        RARITY_MAP.put(RARITY.MK_I_MK_IV, new Point(810, 480));
        RARITY_MAP.put(RARITY.MK_V, new Point(1030, 480));
        RARITY_MAP.put(RARITY.MK_VI, new Point(1250, 480));
    }

    private void initTier() {
        TIER_MAP.put(GREY, new Point(760, 640));
        TIER_MAP.put(GREEN, new Point(860, 640));
        TIER_MAP.put(BLUE, new Point(960, 640));
        TIER_MAP.put(PURPLE, new Point(1060, 640));
        TIER_MAP.put(GOLD, new Point(1160, 640));
    }
}
