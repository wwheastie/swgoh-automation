package com.heastie.swgoh.automation.simulator.store;

import com.heastie.swgoh.automation.mouse.MouseEvent;
import java.awt.Point;
import java.util.stream.IntStream;
import org.springframework.stereotype.Component;

@Component
public class BronziumDataCards {
    private static final int BRONZIUM_PACK_COST = 250;

    private final MouseEvent mouseEvent;

    public BronziumDataCards(final MouseEvent mouseEvent) {
        this.mouseEvent = mouseEvent;
    }

    public void automate(final int allyPoints) {
        final int iterations = allyPoints / BRONZIUM_PACK_COST;
        IntStream.range(0, iterations).forEach(this::purchase);
    }

    private void purchase(int i) {
        System.out.println("Current purchase = " + i);
        mouseEvent.moveCursorLeftClick(Coordinates.PURCHASE_BUTTON, 2750);
        mouseEvent.moveCursorLeftClick(Coordinates.SKIP, 50);
        mouseEvent.moveCursorLeftClick(Coordinates.FINISH, 1500);
    }

    private static class Coordinates {
        public static final Point PURCHASE_BUTTON = new Point(1590, 950);
        public static final Point SKIP = new Point(1605, 980);
        public static final Point FINISH = new Point(1605, 980);
    }

}
