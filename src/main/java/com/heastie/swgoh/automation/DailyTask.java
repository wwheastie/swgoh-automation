package com.heastie.swgoh.automation;

import com.heastie.swgoh.automation.simulator.shard.ShardBattlesScript;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DailyTask implements CommandLineRunner {
    private final ShardBattlesScript shardBattlesScript;

    public DailyTask(
        final ShardBattlesScript shardBattlesScript) {
        this.shardBattlesScript = shardBattlesScript;
    }

//    private final BronziumDataCards bronziumDataCards;
//    private final MouseEvent mouseEvent;
//
//    public DailyTask(final DarkSideBattles darkSideBattles,
//        FleetBattles fleetBattles,
//        LightSideBattles lightSideBattles,
//        BattleEnergy battleEnergy,
//        final BronziumDataCards bronziumDataCards,
//        final MouseEvent mouseEvent) {
//        this.darkSideBattles = darkSideBattles;
//        this.fleetBattles = fleetBattles;
//        this.lightSideBattles = lightSideBattles;
//        this.battleEnergy = battleEnergy;
//        this.bronziumDataCards = bronziumDataCards;
//        this.mouseEvent = mouseEvent;
//    }

    @Override
    public void run(final String... args) throws Exception {

    }

//    private void startApplication() throws IOException {
//        Runtime.getRuntime().exec("cmd /c START \"\" \"C:\\Program Files\\BlueStacks_nxt\\HD-Player.exe\" "
//            + "--instance Pie64 --hidden --cmd launchAppWithBsx --package \"com.ea.game.starwarscapital_row\"");
//        mouseEvent.moveCursorLeftClick(new Point(1470, 300), 90000, 30000);
//    }
//
//    private void stopApplication() throws IOException {
//        Runtime.getRuntime().exec("cmd /c taskkill /F /IM \"HD-Player.exe\" /T");
//    }
}
