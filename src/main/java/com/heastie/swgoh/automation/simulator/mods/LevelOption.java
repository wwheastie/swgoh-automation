package com.heastie.swgoh.automation.simulator.mods;

public class LevelOption {
    private final LevelEnum comparator;
    private final int level;

    public LevelOption(final LevelEnum comparator, final int level) {
        this.comparator = comparator;
        this.level = level;
    }

    public LevelEnum getComparator() {
        return comparator;
    }

    public int getLevel() {
        return level;
    }
}
