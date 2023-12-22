package com.heastie.swgoh.automation.simulator.mods;

public enum ModFiltersEnum {
    ;
    public enum SLOT {
        SQUARE,
        ARROW,
        DIAMOND,
        TRIANGLE,
        CIRCLE,
        CROSS
    }

    public enum SET {
        HEALTH,
        DEFENSE,
        CRITICAL_DAMAGE,
        CRITICAL_CHANCE,
        TENACITY,
        OFFENSE,
        POTENCY,
        SPEED
    }

    public enum PRIMARY_STAT {
        ACCURACY,
        CRIT_AVOIDANCE,
        CRIT_CHANCE,
        CRIT_DAMAGE,
        DEFENSE,
        HEALTH,
        OFFENSE,
        POTENCY,
        PROTECTION,
        SPEED,
        TENACITY
    }

    public enum SECONDARY_STAT {
        CRIT_CHANCE,
        DEFENSE_FLAT,
        DEFENSE,
        HEALTH_FLAT,
        HEALTH,
        OFFENSE_FLAT,
        OFFENSE,
        POTENCY,
        PROTECTION_FLAT,
        PROTECTION,
        SPEED,
        TENACITY
    }

    public enum RARITY {
        MK_I_MK_IV,
        MK_V,
        MK_VI
    }

    public enum TIER {
        GREY,
        GREEN,
        BLUE,
        PURPLE,
        GOLD
    }
}
