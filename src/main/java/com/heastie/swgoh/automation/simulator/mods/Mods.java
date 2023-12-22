package com.heastie.swgoh.automation.simulator.mods;

import com.heastie.swgoh.automation.Delay;
import com.heastie.swgoh.automation.keyboard.KeyboardEvent;
import com.heastie.swgoh.automation.mouse.MouseEvent;
import com.heastie.swgoh.automation.simulator.mods.ModFiltersEnum.PRIMARY_STAT;
import com.heastie.swgoh.automation.simulator.mods.ModFiltersEnum.RARITY;
import com.heastie.swgoh.automation.simulator.mods.ModFiltersEnum.SECONDARY_STAT;
import com.heastie.swgoh.automation.simulator.mods.ModFiltersEnum.SET;
import com.heastie.swgoh.automation.simulator.mods.ModFiltersEnum.SLOT;
import com.heastie.swgoh.automation.simulator.mods.ModFiltersEnum.TIER;
import java.awt.Point;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

@Component
public class Mods {
    private final MouseEvent mouseEvent;
    private final KeyboardEvent keyboardEvent;

    public Mods(final MouseEvent mouseEvent,
        final KeyboardEvent keyboardEvent) {
        this.mouseEvent = mouseEvent;
        this.keyboardEvent = keyboardEvent;
    }

    public void createEmptyFilters() {
        for(int i = 0; i < 200; i++) {
            createEmptyFilters("Filter " + i);
        }
    }

    public void createFilter(final List<FilterOptions> filterOptionsList) {
        for (final FilterOptions filterOptions : filterOptionsList) {
            // Reset to Default
            resetToDefault();
            // Choose Mods Slots
            selectModSlots(filterOptions.getModSlots());
            // Choose Mods Sets
            selectModSets(filterOptions.getModSets());
            // Choose Primary Stats
            selectModPrimaryStats(filterOptions.getPrimaryStats());
            // Go all the way down
            goToBottom();
            // Choose Level
            selectLevel(filterOptions.getLevelOption());
            // Choose Rarity
            selectRarity(filterOptions.getRarity());
            // Choose Tier
            selectTiers(filterOptions.getTiers());
            // Go up to Secondary Stats
            goToSecondaryStatsFromBottom();
            // Choose Secondary Stats
            selectModPrimaryStats(filterOptions.getPrimaryStats());
            // Save Filter
            saveFilter("Filter");
        }

        for(Map.Entry<SECONDARY_STAT, Point> entry : FilterOptionsDatabase.SECONDARY_STATS.entrySet()) {
            System.out.println(entry.getKey());
            Delay.of(1000);
            mouseEvent.moveCursorLeftClick(entry.getValue());
        }
    }

    private void selectModSlots(final List<SLOT> slots) {
        if (CollectionUtils.isNotEmpty(slots)) {
            slots.forEach(slot ->  mouseEvent.moveCursorLeftClick(FilterOptionsDatabase.MOD_SLOTS.get(slot)));
        }
    }

    private void selectModSets(final List<SET> sets) {
        if (CollectionUtils.isNotEmpty(sets)) {
            sets.forEach(set -> mouseEvent.moveCursorLeftClick(FilterOptionsDatabase.MOD_SETS.get(set)));
        }
    }

    private void selectModPrimaryStats(final List<PRIMARY_STAT> primaryStats) {
        if (CollectionUtils.isNotEmpty(primaryStats)) {
            primaryStats.forEach(primaryStat ->  mouseEvent.moveCursorLeftClick(FilterOptionsDatabase.PRIMARY_STATS.get(primaryStat)));
        }
    }

    private void goToBottom() {
        mouseEvent.dragShortDown(new Point(1580, 850));
        mouseEvent.dragShortDown(new Point(1580, 850));
    }

    private void goToSecondaryStatsFromBottom() {
        mouseEvent.dragShortUp(new Point(1600, 190), 380);
    }

    private void selectLevel(final LevelOption levelOption) {
        if (levelOption != null) {
            if (levelOption.getComparator().equals(LevelEnum.EQUALS)) {
                mouseEvent.moveCursorLeftClick(new Point(890, 265));
            }

            if (levelOption.getComparator().equals(LevelEnum.LESS_THAN)) {
                mouseEvent.moveCursorLeftClick(new Point(890, 265));
                mouseEvent.moveCursorLeftClick(new Point(890, 265));
            }

            mouseEvent.moveCursorLeftClick(FilterOptionsDatabase.LEVEL_MAP.get(levelOption.getLevel()));
        }
    }

    private void selectRarity(final RARITY rarity) {
        if (rarity != null) {
            mouseEvent.moveCursorLeftClick(FilterOptionsDatabase.RARITY_MAP.get(rarity));
        }
    }

    private void selectTiers(final List<TIER> tiers) {
        if (CollectionUtils.isNotEmpty(tiers)) {
            tiers.forEach(tier -> mouseEvent.moveCursorLeftClick(FilterOptionsDatabase.TIER_MAP.get(tier)));
        }
    }

    private void selectModSecondaryStats(final List<SECONDARY_STAT> secondaryStats) {
        if (CollectionUtils.isNotEmpty(secondaryStats)) {
            secondaryStats.forEach(secondaryStat -> mouseEvent.moveCursorLeftClick(FilterOptionsDatabase.SECONDARY_STATS.get(secondaryStat)));
        }
    }

    public void deleteFilters() {
        for(int i = 0; i < 6; i++) {
            // Click on filter
            mouseEvent.moveCursorLeftClick(new Point(300, 290));
            // Click delete button
            mouseEvent.moveCursorLeftClick(new Point(480, 290));
            // Click confirm
            mouseEvent.moveCursorLeftClick(new Point(1160, 670));
        }
    }

    private void createEmptyFilters(final String input) {
        // Click Reset to Default
        resetToDefault();
        // Click Square in Mod Slot
        mouseEvent.moveCursorLeftClick(new Point(770, 370));
        // Save Filter
        saveFilter(input);
    }

    private void resetToDefault() {
        mouseEvent.moveCursorLeftClick(new Point(710, 920));
    }

    private void saveFilter(final String name) {
        // Click Save Filter
        mouseEvent.moveCursorLeftClick(new Point(1130, 930));
        // Click Filter Name Box
        mouseEvent.moveCursorLeftClick(new Point(960, 420));
        // Enter name
        keyboardEvent.type(name);
        // Click OK
        mouseEvent.moveCursorLeftClick(new Point(1745, 975));
    }
}
