package com.heastie.swgoh.automation.simulator.challenge;

import org.springframework.stereotype.Component;

@Component
public class FleetChallenges {
    private final ChallengesScript challengesScript;

    public FleetChallenges(final ChallengesScript challengesScript) {
        this.challengesScript = challengesScript;
    }

    public void automate() {
        challengesScript.goToFleetChallenges();
        challengesScript.simulate();
        challengesScript.goToHomeFromFleets();
    }
}
