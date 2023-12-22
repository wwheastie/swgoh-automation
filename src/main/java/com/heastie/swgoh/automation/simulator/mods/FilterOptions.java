package com.heastie.swgoh.automation.simulator.mods;

import com.heastie.swgoh.automation.simulator.mods.ModFiltersEnum.PRIMARY_STAT;
import com.heastie.swgoh.automation.simulator.mods.ModFiltersEnum.RARITY;
import com.heastie.swgoh.automation.simulator.mods.ModFiltersEnum.SECONDARY_STAT;
import com.heastie.swgoh.automation.simulator.mods.ModFiltersEnum.SET;
import com.heastie.swgoh.automation.simulator.mods.ModFiltersEnum.SLOT;
import com.heastie.swgoh.automation.simulator.mods.ModFiltersEnum.TIER;
import java.util.List;

public class FilterOptions {
    private boolean onlyUnassignedMods;
    private boolean onlyModsNotInLoadouts;
    private List<SLOT> modSlots;
    private List<SET> modSets;
    private List<PRIMARY_STAT> primaryStats;
    private List<SECONDARY_STAT> secondaryStats;
    private LevelOption levelOption;
    private RARITY rarity;
    private List<TIER> tiers;

    public boolean isOnlyUnassignedMods() {
        return onlyUnassignedMods;
    }

    public void setOnlyUnassignedMods(final boolean onlyUnassignedMods) {
        this.onlyUnassignedMods = onlyUnassignedMods;
    }

    public boolean isOnlyModsNotInLoadouts() {
        return onlyModsNotInLoadouts;
    }

    public void setOnlyModsNotInLoadouts(final boolean onlyModsNotInLoadouts) {
        this.onlyModsNotInLoadouts = onlyModsNotInLoadouts;
    }

    public List<SLOT> getModSlots() {
        return modSlots;
    }

    public void setModSlots(
        final List<SLOT> modSlots) {
        this.modSlots = modSlots;
    }

    public List<SET> getModSets() {
        return modSets;
    }

    public void setModSets(
        final List<SET> modSets) {
        this.modSets = modSets;
    }

    public List<PRIMARY_STAT> getPrimaryStats() {
        return primaryStats;
    }

    public void setPrimaryStats(
        final List<PRIMARY_STAT> primaryStats) {
        this.primaryStats = primaryStats;
    }

    public List<SECONDARY_STAT> getSecondaryStats() {
        return secondaryStats;
    }

    public void setSecondaryStats(
        final List<SECONDARY_STAT> secondaryStats) {
        this.secondaryStats = secondaryStats;
    }

    public LevelOption getLevelOption() {
        return levelOption;
    }

    public void setLevelOption(final LevelOption levelOption) {
        this.levelOption = levelOption;
    }

    public RARITY getRarity() {
        return rarity;
    }

    public void setRarity(final RARITY rarity) {
        this.rarity = rarity;
    }

    public List<TIER> getTiers() {
        return tiers;
    }

    public void setTiers(
        final List<TIER> tiers) {
        this.tiers = tiers;
    }
}
