package com.heastie.swgoh.automation.simulator.arena;

import org.springframework.stereotype.Component;

@Component
public class FleetArenaBattle {
    private final Shared shared;

    public FleetArenaBattle(final Shared shared) {
        this.shared = shared;
    }

    public void automate() {
        shared.goToArenaTable();
        shared.clickFleetArenaEnter();
        shared.simBattle();
        shared.goToHome();
    }
}
