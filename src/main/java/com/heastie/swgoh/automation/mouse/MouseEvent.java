package com.heastie.swgoh.automation.mouse;

import com.heastie.swgoh.automation.Delay;
import java.awt.Point;
import org.springframework.stereotype.Component;

@Component
public class MouseEvent {
    private static final long INSTANT_DELAY = 10;
    private static final long VERY_SHORT_DELAY = 100;
    private static final long SHORT_DELAY = 500;
    private static final long MEDIUM_DELAY = 2000;
    private static final long LONG_DELAY = 1500;
    private static final long VERY_LONG_DELAY= 2000;

    private final MouseAction mouseAction;

    public MouseEvent(final MouseAction mouseAction) {
        this.mouseAction = mouseAction;
    }

    public void dragFarRight(final Point currentPosition) {
        mouseAction.moveCursor(currentPosition, LONG_DELAY);
        mouseAction.pressLeftButton(VERY_SHORT_DELAY);
        decrementFarRight(currentPosition);
        mouseAction.releaseLeftButton(MEDIUM_DELAY);
    }

    public void dragShortRight(final Point currentPosition) {
        mouseAction.moveCursor(currentPosition, LONG_DELAY);
        mouseAction.pressLeftButton(VERY_SHORT_DELAY);
        decrementShortRight(currentPosition);
        mouseAction.releaseLeftButton(MEDIUM_DELAY);
    }

    public void dragFarLeft(final Point currentPosition) {
        mouseAction.moveCursor(currentPosition, LONG_DELAY);
        mouseAction.pressLeftButton(VERY_SHORT_DELAY);
        decrementFarLeft(currentPosition);
        mouseAction.releaseLeftButton(MEDIUM_DELAY);
    }

    public void dragShortLeft(final Point currentPosition) {
        mouseAction.moveCursor(currentPosition, LONG_DELAY);
        mouseAction.pressLeftButton(VERY_SHORT_DELAY);
        decrementShortLeft(currentPosition);
        mouseAction.releaseLeftButton(MEDIUM_DELAY);
    }

    public void dragShortUp(final Point currentPosition) {
        mouseAction.moveCursor(currentPosition, LONG_DELAY);
        mouseAction.pressLeftButton(VERY_SHORT_DELAY);
        decrementShortUp(currentPosition);
        mouseAction.releaseLeftButton(MEDIUM_DELAY);
    }

    public void dragShortDown(final Point currentPosition) {
        mouseAction.moveCursor(currentPosition, LONG_DELAY);
        mouseAction.pressLeftButton(VERY_SHORT_DELAY);
        decrementShortDown(currentPosition);
        mouseAction.releaseLeftButton(MEDIUM_DELAY);
    }


    public void moveCursorLeftClick(final Point position) {
        mouseAction.moveCursor(position, SHORT_DELAY);
        mouseAction.leftClick(VERY_LONG_DELAY);
    }

    public void moveCursorLeftClick(final Point position, final long delayAfter) {
        mouseAction.moveCursor(position, SHORT_DELAY);
        mouseAction.leftClick(delayAfter);
    }

    public void moveCursorLeftClick(final Point position, final long delayBefore, final long delayAfter) {
        Delay.of(delayBefore);
        mouseAction.moveCursor(position, SHORT_DELAY);
        mouseAction.leftClick(delayAfter);
    }

    private void decrementFarLeft(final Point currentPosition) {
        int x = currentPosition.x;
        int y = currentPosition.y;
        int counter = 0;
        while(x < 1920) {
            if (counter < 20) {
                x += 5;
                counter++;
            } else {
                x = (int) (x * 1.5);
            }
            mouseAction.moveCursor(new Point(x, y), INSTANT_DELAY);
        }
    }

    private void decrementShortRight(final Point currentPosition) {
        int x = currentPosition.x;
        int y = currentPosition.y;
        int stop = x - 1000;
        while(x > stop) {
            x -= 5;
            mouseAction.moveCursor(new Point(x, y), INSTANT_DELAY);
        }
    }

    private void decrementShortLeft(final Point currentPosition) {
        int x = currentPosition.x;
        int y = currentPosition.y;
        int stop = x + 1000;
        while(x < stop) {
            x += 5;
            mouseAction.moveCursor(new Point(x, y), INSTANT_DELAY);
        }
    }

    private void decrementFarRight(final Point currentPosition) {
        int x = currentPosition.x;
        int y = currentPosition.y;
        int counter = 0;
        while(x > 0) {
            if (counter < 20) {
                x -= 5;
                counter++;
            } else {
                x = x / 2;
            }
            mouseAction.moveCursor(new Point(x, y), INSTANT_DELAY);
        }
    }

    private void decrementShortUp(final Point currentPosition) {
        int x = currentPosition.x;
        int y = currentPosition.y;
        int stop = y + 700;
        while(y < stop) {
            y += 5;
            mouseAction.moveCursor(new Point(x, y), INSTANT_DELAY);
        }
    }

    private void decrementShortDown(final Point currentPosition) {
        int x = currentPosition.x;
        int y = currentPosition.y;
        int stop = y - 700;
        while(y > stop) {
            y -= 5;
            mouseAction.moveCursor(new Point(x, y), INSTANT_DELAY);
        }
    }
}
