package com.heastie.swgoh.automation.simulator.challenge;

import org.springframework.stereotype.Component;

@Component
public class RegularChallenges {
    private final ChallengesScript challengesScript;

    public RegularChallenges(final ChallengesScript challengesScript) {
        this.challengesScript = challengesScript;
    }

    public void automate() {
        challengesScript.goToRegularChallenges();
        challengesScript.simulate();
        challengesScript.goToHome();
    }
}
