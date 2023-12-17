package com.heastie.swgoh.automation.simulator;

import com.heastie.swgoh.automation.mouse.MouseEvent;
import java.awt.Point;
import org.springframework.stereotype.Component;

@Component
public class SharedScript {
    private final MouseEvent mouseEvent;

    public SharedScript(final MouseEvent mouseEvent) {
        this.mouseEvent = mouseEvent;
    }

    public void clickSim() {
        mouseEvent.moveCursorLeftClick(Coordinates.Modal.SIM_BUTTON, 2000);
    }

    public void clickContinue() {
        mouseEvent.moveCursorLeftClick(Coordinates.Modal.CONTINUE_BUTTON);
    }

    public void goToHome() {
        mouseEvent.moveCursorLeftClick(Coordinates.MainScreen.HOME_BUTTON, 5000);
    }

    public void goToHomeFromFleets() {
        goToHome();
        goToHomeClosePopUps();
    }

    public void goToHomeClosePopUps() {
        mouseEvent.moveCursorLeftClick(Coordinates.MainScreen.HOME_BUTTON, 10000);
        closePopUps();
    }

    public void closePopUps() {
        for(final Point popUpCloseButtonPoint : Coordinates.MainScreen.POP_UP_CLOSE_BUTTONS) {
            mouseEvent.moveCursorLeftClick(popUpCloseButtonPoint);
        }
    }
}
