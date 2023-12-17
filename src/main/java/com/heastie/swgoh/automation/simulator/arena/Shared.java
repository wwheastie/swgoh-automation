package com.heastie.swgoh.automation.simulator.arena;

import com.heastie.swgoh.automation.mouse.MouseEvent;
import com.heastie.swgoh.automation.simulator.SharedScript;
import java.awt.Point;
import org.springframework.stereotype.Component;

@Component
class Shared {
    private static final Point ARENA_HOLO_TABLE = new Point(1330, 415);
    private static final Point FLEET_ARENA_ENTER_BUTTON = new Point(940, 885);
    private static final Point SQUAD_ARENA_ENTER_BUTTON = new Point(385, 885);
    private static final Point SELECT_LEFT_MACH_BATTLE_BUTTON = new Point(350, 930);
    private static final Point START_BATTLE_BUTTON = new Point(1600, 965);
    private static final Point BATTLE_OPTIONS = new Point(110, 90);
    private static final Point FORFEIT_OPTION = new Point(930, 870);
    private static final Point CONFIRM_FORFEIT = new Point(715, 675);

    private static final long DELAY_3_SECONDS = 3000;
    private static final long DELAY_5_SECONDS = 5000;
    private static final long DELAY_1_MINUTE_30_SECONDS = 90000;

    private final SharedScript sharedScript;
    private final MouseEvent mouseEvent;

    public Shared(final SharedScript sharedScript,
        final MouseEvent mouseEvent) {
        this.sharedScript = sharedScript;
        this.mouseEvent = mouseEvent;
    }


    public void goToArenaTable() {
        mouseEvent.moveCursorLeftClick(ARENA_HOLO_TABLE, DELAY_5_SECONDS);
    }

    public void clickSquadArenaEnter() {
        mouseEvent.moveCursorLeftClick(SQUAD_ARENA_ENTER_BUTTON, DELAY_5_SECONDS);
    }

    public void clickFleetArenaEnter() {
        mouseEvent.moveCursorLeftClick(FLEET_ARENA_ENTER_BUTTON, DELAY_5_SECONDS);
    }

    public void simBattle() {
        clickBattle();
        startBattle();
        forfeitBattle();
    }

    private void clickBattle() {
        mouseEvent.moveCursorLeftClick(SELECT_LEFT_MACH_BATTLE_BUTTON, DELAY_5_SECONDS);
    }

    private void startBattle() {
        mouseEvent.moveCursorLeftClick(START_BATTLE_BUTTON, DELAY_1_MINUTE_30_SECONDS);
    }

    private void forfeitBattle() {
        mouseEvent.moveCursorLeftClick(BATTLE_OPTIONS);
        mouseEvent.moveCursorLeftClick(FORFEIT_OPTION);
        mouseEvent.moveCursorLeftClick(CONFIRM_FORFEIT, DELAY_5_SECONDS);
    }

    public void goToHome() {
        sharedScript.goToHomeClosePopUps();
    }
}
