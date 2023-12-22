package com.heastie.swgoh.automation.simulator.management;

import com.heastie.swgoh.automation.keyboard.KeyboardEvent;
import com.heastie.swgoh.automation.mouse.MouseEvent;
import java.awt.Point;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import org.springframework.stereotype.Component;

@Component
public class AccountManagement {
    private static final List<String> TAB_NAMES = Arrays.asList("Current Plan", "Farming", "Relics", "Zetas", "Teams to Build",
        "Current Teams", "General", "GAC 5v5", "GAC 3v3", "Conquest", "Territory Wars", "Territory Battles", "Guild Raid",
        "Future Plans", "Phase I", "Farming", "Relics", "Zetas", "Teams to Build");

    private final MouseEvent mouseEvent;
    private final KeyboardEvent keyboardEvent;

    public AccountManagement(final MouseEvent mouseEvent,
        final KeyboardEvent keyboardEvent) {
        this.mouseEvent = mouseEvent;
        this.keyboardEvent = keyboardEvent;
    }

    public void moveFromToTab() {
        // Click rename & arrange
        mouseEvent.moveCursorLeftClick(new Point(600, 210));
        IntStream.range(0, 15).forEach(i -> moveFromToTabAction());
    }

    private void moveFromToTabAction() {
        // Click Send To...
        mouseEvent.moveCursorLeftClick(new Point(1600, 310));
        // Drag down to new General Tab
        IntStream.range(0, 1).forEach(i -> mouseEvent.dragShortDown(new Point(1160, 830)));
        // Click GAC 3v3 Tab
        mouseEvent.moveCursorLeftClick(new Point(640, 570));
        // Click Move to Tab
        mouseEvent.moveCursorLeftClick(new Point(780, 910));
    }

    public void createNewTab() {
//        // Slot 1 start
//        int startYPosition = 170;

        // Slot 4 start
        int startYPosition = 410;

//        // Slot 5 start
//        int startYPosition = 435;
        for(int i = 12; i < TAB_NAMES.size(); i++) {
            createTab(TAB_NAMES.get(i), startYPosition);
            // New tab position shifts down
            startYPosition += 85;
        }

    }

    private void createTab(final String name, final int yPosition) {
        // Click +New Tab (230, 170) + 85 on Y
        mouseEvent.moveCursorLeftClick(new Point(230, yPosition));
        // Click name
        mouseEvent.moveCursorLeftClick(new Point(940, 410));
        // Delete default name
        delete();
        // Enter name
        keyboardEvent.type(name);
        // Click ok
        mouseEvent.moveCursorLeftClick(new Point(1740, 970));
    }

    private void delete() {
        IntStream.range(0, 10).forEach(i -> keyboardEvent.backspace());
    }
}
