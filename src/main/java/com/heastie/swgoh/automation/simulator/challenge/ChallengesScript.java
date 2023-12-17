package com.heastie.swgoh.automation.simulator.challenge;

import com.heastie.swgoh.automation.mouse.MouseEvent;
import com.heastie.swgoh.automation.simulator.Coordinates;
import com.heastie.swgoh.automation.simulator.Coordinates.MainScreen;
import com.heastie.swgoh.automation.simulator.Coordinates.ShipsMainScreen;
import com.heastie.swgoh.automation.simulator.SharedScript;
import org.springframework.stereotype.Component;

@Component
public class ChallengesScript {
    private final SharedScript sharedScript;
    private final MouseEvent mouseEvent;

    public ChallengesScript(final SharedScript sharedScript,
        final MouseEvent mouseEvent) {
        this.sharedScript = sharedScript;
        this.mouseEvent = mouseEvent;
    }

    public void goToRegularChallenges() {
        mouseEvent.dragShortLeft(Coordinates.MainScreen.MAIN_SCREEN_LEFT_SIDE_DRAG_POINT);
        mouseEvent.moveCursorLeftClick(MainScreen.REGULAR_CHALLENGES_HOLO_TABLE, 3000);
    }

    public void goToFleetChallenges() {
        mouseEvent.dragFarRight(Coordinates.MainScreen.MAIN_SCREEN_RIGHT_SIDE_DRAG_POINT);
        mouseEvent.moveCursorLeftClick(Coordinates.MainScreen.SHIPS_HOLO_TABLE, 3000);
        mouseEvent.moveCursorLeftClick(ShipsMainScreen.FLEET_CHALLENGES_HOLO_TABLE, 3000);
    }

    public void simulate() {
        clickMultiSim();
        sharedScript.clickSim();
        sharedScript.clickContinue();

    }

    private void clickMultiSim() {
        mouseEvent.moveCursorLeftClick(Coordinates.Challenges.TOP_MULTI_SIM_BUTTON);
    }

    public void goToHome() {
        sharedScript.goToHomeClosePopUps();
    }

    public void goToHomeFromFleets() {
        sharedScript.goToHome();
        sharedScript.goToHomeClosePopUps();
    }
}
