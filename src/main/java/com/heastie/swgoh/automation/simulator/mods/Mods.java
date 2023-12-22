package com.heastie.swgoh.automation.simulator.mods;

import com.heastie.swgoh.automation.keyboard.KeyboardEvent;
import com.heastie.swgoh.automation.mouse.MouseEvent;
import java.awt.Point;
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

    public void createFilter() {
        for(int i = 0; i < 200; i++) {
            createFilter("Filter " + i);
        }
    }

    private void createFilter(final String input) {
        // Click Reset to Default
        mouseEvent.moveCursorLeftClick(new Point(710, 920));
        // Click Square in Mod Slot
        mouseEvent.moveCursorLeftClick(new Point(770, 370));
        // Click Save Filter
        mouseEvent.moveCursorLeftClick(new Point(1130, 930));
        // Click Filter Name Box
        mouseEvent.moveCursorLeftClick(new Point(960, 420));
        // Enter name
        keyboardEvent.type(input);
        // Click OK
        mouseEvent.moveCursorLeftClick(new Point(1745, 975));
    }
}
