package com.heastie.swgoh.automation.bean;

import java.awt.Point;

public class Position {
    private final Point coordinates;
    private final ScreenSide screenSide;

    public Position(final Point coordinates, final ScreenSide screenSide) {
        this.coordinates = coordinates;
        this.screenSide = screenSide;
    }

    public Point getCoordinates() {
        return coordinates;
    }

    public ScreenSide getScreenSide() {
        return screenSide;
    }
}
