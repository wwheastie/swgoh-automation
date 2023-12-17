package com.heastie.swgoh.automation.mouse;

import com.heastie.swgoh.automation.Delay;
import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import org.springframework.stereotype.Component;

@Component
class MouseAction {
    private final Robot robot;

    public MouseAction() throws AWTException {
        this.robot = createRobot();
    }

    public void moveCursor(final Point position) {
        robot.mouseMove(position.x, position.y);
    }

    public void moveCursor(final Point position, final long delayAfter) {
        robot.mouseMove(position.x, position.y);
        Delay.of(delayAfter);
    }

    public void leftClick(final long delayAfter) {
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Delay.of(delayAfter);
    }

    public void pressLeftButton(final long delayAfter) {
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Delay.of(delayAfter);
    }

    public void releaseLeftButton(final long delayAfter) {
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Delay.of(delayAfter);
    }

    private Robot createRobot() throws AWTException {
        System.setProperty("java.awt.headless", "false");
        return new Robot();
    }
}
