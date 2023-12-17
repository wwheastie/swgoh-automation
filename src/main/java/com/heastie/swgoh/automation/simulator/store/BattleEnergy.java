package com.heastie.swgoh.automation.simulator.store;

import com.heastie.swgoh.automation.mouse.MouseEvent;
import com.heastie.swgoh.automation.simulator.SharedScript;
import java.awt.Point;
import java.util.stream.IntStream;
import org.springframework.stereotype.Component;

@Component
public class BattleEnergy {
    private final MouseEvent mouseEvent;
    private final SharedScript sharedScript;

    public BattleEnergy(final MouseEvent mouseEvent,
        final SharedScript sharedScript) {
        this.mouseEvent = mouseEvent;
        this.sharedScript = sharedScript;
    }

    public void claimFreeEnergy() {
        mouseEvent.moveCursorLeftClick(Coordinates.OBJECTIVE_BUTTON);
        mouseEvent.moveCursorLeftClick(Coordinates.TOP_ITEM_DAILY_ACTIVITIES);
        mouseEvent.moveCursorLeftClick(Coordinates.CLAIM_BUTTON);
        sharedScript.goToHomeClosePopUps();
    }

    public void purchaseRegularEnergy(final int times) {
        IntStream.range(0, times).forEach(i -> purchase(Coordinates.REGULAR_ENERGY));
    }

    public void purchaseCantinaEnergy(final int times) {
        IntStream.range(0, times).forEach(i -> purchase(Coordinates.CANTINA_ENERGY));
    }

    public void purchaseModEnergy(final int times) {
        IntStream.range(0, times).forEach(i -> purchase(Coordinates.MOD_ENERGY));
    }

    public void purchaseShipEnergy(final int times) {
        IntStream.range(0, times).forEach(i -> purchase(Coordinates.SHIP_ENERGY));
    }

    private void purchase(final Point position) {
        mouseEvent.moveCursorLeftClick(position);
        mouseEvent.moveCursorLeftClick(Coordinates.PURCHASE_BUTTON);
    }

    private static class Coordinates {
        public static final Point REGULAR_ENERGY = new Point(1465, 85);
        public static final Point CANTINA_ENERGY = new Point(1265, 85);
        public static final Point MOD_ENERGY = new Point(1065, 85);
        public static final Point SHIP_ENERGY = new Point(865, 85);
        public static final Point PURCHASE_BUTTON = new Point(1160, 670);

        public static final Point OBJECTIVE_BUTTON = new Point(1605, 970);
        public static final Point TOP_ITEM_DAILY_ACTIVITIES = new Point(760, 500);
        public static final Point CLAIM_BUTTON = new Point(1605, 950);
    }
}
