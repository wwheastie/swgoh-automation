package com.heastie.swgoh.automation;

import com.heastie.swgoh.automation.bean.Shard;
import com.heastie.swgoh.automation.mouse.MouseEvent;
import com.heastie.swgoh.automation.simulator.SharedScript;
import com.heastie.swgoh.automation.simulator.arena.FleetArenaBattle;
import com.heastie.swgoh.automation.simulator.arena.SquadArenaBattle;
import com.heastie.swgoh.automation.simulator.challenge.FleetChallenges;
import com.heastie.swgoh.automation.simulator.challenge.RegularChallenges;
import com.heastie.swgoh.automation.simulator.galactic.GalacticWar;
import com.heastie.swgoh.automation.simulator.mods.Mods;
import com.heastie.swgoh.automation.simulator.shard.DarkSideBattles;
import com.heastie.swgoh.automation.simulator.shard.FleetBattles;
import com.heastie.swgoh.automation.simulator.shard.LightSideBattles;
import com.heastie.swgoh.automation.simulator.shard.ShardBattlesScript;
import com.heastie.swgoh.automation.simulator.store.BattleEnergy;
import java.awt.Point;
import java.io.IOException;
import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestAccount implements CommandLineRunner {
    private static final String EVERY_DAY_6_30_CRON_JOB = "0 30 06 ? * *";
    private static final String EVERY_DAY_01_00_CRON_JOB = "0 00 01 ? * *";
    private static final String CENTRAL_TIME_ZONE = "America/Chicago";

    private final MouseEvent mouseEvent;
    private final ShardBattlesScript shardBattlesScript;
    private final DarkSideBattles darkSideBattles;
    private final FleetBattles fleetBattles;
    private final LightSideBattles lightSideBattles;
    private final BattleEnergy battleEnergy;
    private final FleetChallenges fleetChallenges;
    private final RegularChallenges regularChallenges;
    private final SharedScript sharedScript;
    private final GalacticWar galacticWar;
    private final FleetArenaBattle fleetArenaBattle;
    private final SquadArenaBattle squadArenaBattle;
    private final Mods mods;

    public TestAccount(final MouseEvent mouseEvent, final ShardBattlesScript shardBattlesScript,
        final DarkSideBattles darkSideBattles, final FleetBattles fleetBattles,
        final LightSideBattles lightSideBattles, final BattleEnergy battleEnergy,
        final FleetChallenges fleetChallenges,
        final RegularChallenges regularChallenges,
        final SharedScript sharedScript,
        final GalacticWar galacticWar,
        final FleetArenaBattle fleetArenaBattle,
        final SquadArenaBattle squadArenaBattle,
        final Mods mods) {
        this.mouseEvent = mouseEvent;
        this.shardBattlesScript = shardBattlesScript;
        this.darkSideBattles = darkSideBattles;
        this.fleetBattles = fleetBattles;
        this.lightSideBattles = lightSideBattles;
        this.battleEnergy = battleEnergy;
        this.fleetChallenges = fleetChallenges;
        this.regularChallenges = regularChallenges;
        this.sharedScript = sharedScript;
        this.galacticWar = galacticWar;
        this.fleetArenaBattle = fleetArenaBattle;
        this.squadArenaBattle = squadArenaBattle;
        this.mods = mods;
    }

    @Override
    public void run(final String... args) throws Exception {
    }

    private void fullAutomation() throws Exception {
        System.out.println("Daily objectives run started!");
        restartApplication();
        simulateRegularBattles();
        simulateFleetBattles();
        fleetChallenges.automate();
        regularChallenges.automate();
        galacticWar.automate();
        stopApplication();
        System.out.println("Daily objectives run complete");
    }

    private void simulateRegularBattles() {
        battleEnergy.purchaseRegularEnergy(3);

        lightSideBattles.automate(Arrays.asList(
//            // Skiff Guard
//            new Shard(3, "B", 0),
//            // Wrecker
//            new Shard(7, "C", 0),
//            // Cere Junda
//            new Shard(3, "A", 0),
            // Saw Gerrera
            new Shard(2, "C", 0)
        ));

        darkSideBattles.automate(Arrays.asList(
//            // Jawa
//            new Shard(4, "F", 0),
//            // Embo
//            new Shard(8, "C", 0),
            // Tarfful
            new Shard(6, "D", 0)
        ));
    }

    private void simulateFleetBattles() {
        battleEnergy.purchaseShipEnergy(3);
        fleetBattles.automate(Arrays.asList(
//            // Outrider
//            new Shard(3, "C", 1),
//            // Rebel Y-Wing
//            new Shard(4, "C", 1),
            // Bistan's U-Wing
            new Shard(1, "C", 1)
        ));
    }

    private void restartApplication() throws IOException {
        stopApplication();
        Delay.of(10000);
        startApplication();
    }

    private void startApplication() throws IOException {
        Runtime.getRuntime().exec("cmd /c START \"\" \"C:\\Program Files\\BlueStacks_nxt\\HD-Player.exe\" "
            + "--instance Pie64_2 --hidden --cmd launchAppWithBsx --package \"com.ea.game.starwarscapital_row\"");
        mouseEvent.moveCursorLeftClick(new Point(1695, 65), 90000, 30000);
        sharedScript.closePopUps();
    }

    private void stopApplication() throws IOException {
        Runtime.getRuntime().exec("cmd /c taskkill /F /IM \"HD-Player.exe\" /T");
    }
}
