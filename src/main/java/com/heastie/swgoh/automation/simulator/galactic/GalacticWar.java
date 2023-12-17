package com.heastie.swgoh.automation.simulator.galactic;

import com.heastie.swgoh.automation.mouse.MouseEvent;
import com.heastie.swgoh.automation.simulator.SharedScript;
import java.awt.Point;
import org.springframework.stereotype.Component;

@Component
public class GalacticWar {
    private static final Point GALACTIC_BATTLE_HOLO_TABLE = new Point(1620, 360);
    private static final Point GALACTIC_WAR_ENTER_BUTTON = new Point(635, 900);
    private static final Point RESTART_BUTTON = new Point(410, 990);
    private static final Point MULTI_SIM_BUTTON = new Point(945, 990);
    private static final Point SIM_BUTTON = new Point(945, 690);
    private static final Point CONTINUE_BUTTON = new Point(950, 910);

    private static final long DELAY_3_SECONDS = 3000;

    private final SharedScript sharedScript;
    private final MouseEvent mouseEvent;

    public GalacticWar(final SharedScript sharedScript,
        final MouseEvent mouseEvent) {
        this.sharedScript = sharedScript;
        this.mouseEvent = mouseEvent;
    }

    public void automate() {
        goToGalacticBattlesTable();
        clickGalacticWarEnter();
        clickRestart();
        clickMultiSim();
        clickSim();
        clickContinue();
        goToHome();
    }

    private void goToGalacticBattlesTable() {
        mouseEvent.moveCursorLeftClick(GALACTIC_BATTLE_HOLO_TABLE, DELAY_3_SECONDS);
    }

    private void clickGalacticWarEnter() {
        mouseEvent.moveCursorLeftClick(GALACTIC_WAR_ENTER_BUTTON);
    }

    private void clickRestart() {
        mouseEvent.moveCursorLeftClick(RESTART_BUTTON);
    }

    private void clickMultiSim() {
        mouseEvent.moveCursorLeftClick(MULTI_SIM_BUTTON);
    }

    private void clickSim() {
        mouseEvent.moveCursorLeftClick(SIM_BUTTON, DELAY_3_SECONDS);
    }

    private void clickContinue() {
        mouseEvent.moveCursorLeftClick(CONTINUE_BUTTON);
    }

    private void goToHome() {
        sharedScript.goToHomeClosePopUps();
    }
}
