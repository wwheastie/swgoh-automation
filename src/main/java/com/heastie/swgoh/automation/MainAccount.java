package com.heastie.swgoh.automation;

import com.heastie.swgoh.automation.bean.Shard;
import com.heastie.swgoh.automation.mouse.MouseEvent;
import com.heastie.swgoh.automation.simulator.SharedScript;
import com.heastie.swgoh.automation.simulator.arena.FleetArenaBattle;
import com.heastie.swgoh.automation.simulator.arena.SquadArenaBattle;
import com.heastie.swgoh.automation.simulator.challenge.FleetChallenges;
import com.heastie.swgoh.automation.simulator.challenge.RegularChallenges;
import com.heastie.swgoh.automation.simulator.galactic.GalacticWar;
import com.heastie.swgoh.automation.simulator.management.AccountManagement;
import com.heastie.swgoh.automation.simulator.mods.FilterOptions;
import com.heastie.swgoh.automation.simulator.mods.LevelEnum;
import com.heastie.swgoh.automation.simulator.mods.LevelOption;
import com.heastie.swgoh.automation.simulator.mods.ModFiltersEnum.PRIMARY_STAT;
import com.heastie.swgoh.automation.simulator.mods.ModFiltersEnum.RARITY;
import com.heastie.swgoh.automation.simulator.mods.ModFiltersEnum.SET;
import com.heastie.swgoh.automation.simulator.mods.ModFiltersEnum.SLOT;
import com.heastie.swgoh.automation.simulator.mods.ModFiltersEnum.TIER;
import com.heastie.swgoh.automation.simulator.mods.Mods;
import com.heastie.swgoh.automation.simulator.shard.DarkSideBattles;
import com.heastie.swgoh.automation.simulator.shard.FleetBattles;
import com.heastie.swgoh.automation.simulator.shard.LightSideBattles;
import com.heastie.swgoh.automation.simulator.shard.ShardBattlesScript;
import com.heastie.swgoh.automation.simulator.store.BattleEnergy;
import java.awt.Point;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MainAccount implements CommandLineRunner {
    private static final String EVERY_DAY_6_30_CRON_JOB = "0 30 06 ? * *";
    private static final String EVERY_DAY_01_45_CRON_JOB = "0 45 01 ? * *";
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
    private final AccountManagement accountManagement;
    private final Mods mods;

    public MainAccount(final MouseEvent mouseEvent, final ShardBattlesScript shardBattlesScript,
        final DarkSideBattles darkSideBattles, final FleetBattles fleetBattles,
        final LightSideBattles lightSideBattles, final BattleEnergy battleEnergy,
        final FleetChallenges fleetChallenges,
        final RegularChallenges regularChallenges,
        final SharedScript sharedScript,
        final GalacticWar galacticWar,
        final FleetArenaBattle fleetArenaBattle,
        final SquadArenaBattle squadArenaBattle,
        final AccountManagement accountManagement,
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
        this.accountManagement = accountManagement;
        this.mods = mods;
    }

    @Override
    public void run(final String... args) throws Exception {
        FilterOptions filterOptions = new FilterOptions();
        filterOptions.setModSlots(Arrays.asList(SLOT.SQUARE, SLOT.TRIANGLE, SLOT.DIAMOND));
        filterOptions.setModSets(Arrays.asList(SET.HEALTH, SET.SPEED, SET.OFFENSE));
        filterOptions.setPrimaryStats(Arrays.asList(PRIMARY_STAT.ACCURACY, PRIMARY_STAT.CRIT_CHANCE, PRIMARY_STAT.SPEED, PRIMARY_STAT.TENACITY));
        filterOptions.setLevelOption(new LevelOption(LevelEnum.LESS_THAN, 15));
        filterOptions.setRarity(RARITY.MK_V);
        filterOptions.setTiers(Arrays.asList(TIER.GREY, TIER.BLUE, TIER.PURPLE, TIER.GOLD));
        mods.createFilter(Collections.singletonList(filterOptions));
    }

    @Scheduled(cron = EVERY_DAY_6_30_CRON_JOB, zone = CENTRAL_TIME_ZONE)
    public void run() throws Exception {
        System.out.println("Daily objectives run started!");
        restartApplication();
        simulateRegularBattles();
        simulateFleetBattles();
        fleetChallenges.automate();
        regularChallenges.automate();
        galacticWar.automate();
        squadArenaBattle.automate();
        fleetArenaBattle.automate();
        stopApplication();
        System.out.println("Daily objectives run complete");
    }

    @Scheduled(cron = EVERY_DAY_01_45_CRON_JOB, zone = CENTRAL_TIME_ZONE)
    public void energy() throws Exception {
        System.out.println("Free energy claim started!");
        restartApplication();
        battleEnergy.claimFreeEnergy();
        stopApplication();
        System.out.println("Free energy claim complete");
    }

    private void simulateRegularBattles() {
        battleEnergy.purchaseRegularEnergy(2);

        lightSideBattles.automate(Arrays.asList(
            // Zorii Bliss
            new Shard(5, "E", 0),
            // Cere Junda
            new Shard(3, "A", 0),
            // Saw Gerrera
            new Shard(4, "B", 0)
        ));

        darkSideBattles.automate(Arrays.asList(
            // Captain Rex
            new Shard(3, "F", 0),
            // Tarfful
            new Shard(4, "D", 0)
        ));
    }

    private void simulateFleetBattles() {
        battleEnergy.purchaseShipEnergy(2);
        fleetBattles.automate(Arrays.asList(
            // Outrider
            new Shard(3, "C", 0),
            // Rebel Y-Wing
            new Shard(4, "C", 0),
            // Bistan's U-Wing
            new Shard(2, "C", 0)
        ));
    }

    private void restartApplication() throws IOException {
        stopApplication();
        Delay.of(30000);
        startApplication();
    }

    private void startApplication() throws IOException {
        Runtime.getRuntime().exec("cmd /c START \"\" \"C:\\Program Files\\BlueStacks_nxt\\HD-Player.exe\" "
            + "--instance Pie64 --hidden --cmd launchAppWithBsx --package \"com.ea.game.starwarscapital_row\"");
        mouseEvent.moveCursorLeftClick(new Point(1255, 260), 90000, 60000);
        sharedScript.closePopUps();
    }

    private void stopApplication() throws IOException {
        Runtime.getRuntime().exec("cmd /c taskkill /F /IM \"HD-Player.exe\" /T");
    }
}
