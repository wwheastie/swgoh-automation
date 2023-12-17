package com.heastie.swgoh.automation.simulator.arena;

import org.springframework.stereotype.Component;

@Component
public class SquadArenaBattle {
    private final Shared shared;

    public SquadArenaBattle(final Shared shared) {
        this.shared = shared;
    }

    public void automate() {
        shared.goToArenaTable();
        shared.clickSquadArenaEnter();
        shared.simBattle();
        shared.goToHome();
    }
}
