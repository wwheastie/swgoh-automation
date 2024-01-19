package com.heastie.swgoh.automation.simulator.shard;

import com.heastie.swgoh.automation.bean.Position;
import com.heastie.swgoh.automation.bean.ScreenSide;
import com.heastie.swgoh.automation.bean.Shard;
import com.heastie.swgoh.automation.bean.ShardType;
import com.heastie.swgoh.automation.constant.PositionDatabase;
import com.heastie.swgoh.automation.mouse.MouseEvent;
import com.heastie.swgoh.automation.simulator.SharedScript;
import java.awt.Point;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ShardBattlesScript {
    private final SharedScript sharedScript;
    private final MouseEvent mouseEvent;

    public ShardBattlesScript(
        final SharedScript sharedScript,
        final MouseEvent mouseEvent) {
        this.sharedScript = sharedScript;
        this.mouseEvent = mouseEvent;
    }

    public void goToDarkSideBattlesTable() {
        mouseEvent.moveCursorLeftClick(Coordinates.DARK_SIDE_HOLO_TABLE, 3000);
    }

    public void goToLightSideBattlesTable() {
        mouseEvent.moveCursorLeftClick(Coordinates.LIGHT_SIDE_HOLO_TABLE, 3000);
    }

    public void goToFleetBattlesTable() {
        mouseEvent.dragFarRight(Coordinates.MAIN_SCREEN_RIGHT_SIDE_DRAG_POINT);
        mouseEvent.moveCursorLeftClick(Coordinates.SHIPS_HOLO_TABLE, 3000);
        mouseEvent.moveCursorLeftClick(Coordinates.FLEET_BATTLES_HOLO_TABLE, 3000);
    }

    public void simulateShardNodes(final List<Shard> shards, final ShardType shardType) {
        shards.forEach(shard -> simulateShardNode(shard, shardType));
    }

    public void simulateShardNode(final Shard shard, final ShardType shardType) {
        shiftTabs(shard);
        clickTab(shard);
        clickHardButton();
        resetTable(shard, shardType);
        clickCharacterNode(shard, shardType);
        simulateShards();
        reSimulateShards(shard);
        clickContinue();
    }

    private void shiftTabs(final Shard shard) {
        final Position characterNodePosition = getTabCoordinates(shard);

        if (ScreenSide.LEFT.equals(characterNodePosition.getScreenSide())) {
            mouseEvent.dragShortLeft(Coordinates.SHIFT_TABS_BASE_POSITION);
        } else if (ScreenSide.RIGHT.equals(characterNodePosition.getScreenSide())) {
            mouseEvent.dragShortRight(Coordinates.SHIFT_TABS_BASE_POSITION);
        }
    }

    private void clickTab(final Shard shard) {
        final Position tabPosition = getTabCoordinates(shard);
        mouseEvent.moveCursorLeftClick(tabPosition.getCoordinates());
    }

    private void clickHardButton() {
        mouseEvent.moveCursorLeftClick(Coordinates.HARD_BUTTON);
    }

    private void resetTable(final Shard shard, final ShardType shardType) {
        mouseEvent.dragFarLeft(Coordinates.RESET_TABLE_DRAG_POINT_ONE);
        final Point point;
        if (ShardType.CHARACTER.equals(shardType)) {
            point = shard.getNode().equalsIgnoreCase("A") ? new Point(935, 565) :
                Coordinates.RESET_TABLE_FIRST_CHARACTER_NODE_FIRST_CLICK;
        } else {
            point = shard.getNode().equalsIgnoreCase("A") ? new Point(760, 605) :
                new Point(615, 470);
        }
        mouseEvent.moveCursorLeftClick(point);
        mouseEvent.moveCursorLeftClick(point);
        mouseEvent.dragFarLeft(Coordinates.RESET_TABLE_DRAG_POINT_TWO);
        mouseEvent.dragShortRight(Coordinates.CENTER_TABLE_DRAG_POINT);
    }

    private void clickCharacterNode(final Shard shard, final ShardType shardType) {
        final Position position = getNode(shard, shardType);

        if (ScreenSide.RIGHT.equals(position.getScreenSide())) {
            mouseEvent.dragShortRight(Coordinates.RESET_TABLE_DRAG_POINT_TWO);
        }

        mouseEvent.moveCursorLeftClick(position.getCoordinates());
    }

    private void simulateShards() {
        mouseEvent.moveCursorLeftClick(Coordinates.MULTI_SIM_BUTTON);
        mouseEvent.moveCursorLeftClick(Coordinates.SIM_BUTTON, 5000);
    }

    private void reSimulateShards(final Shard shard) {
        for(int i = 0; i < shard.getRefreshes(); i++) {
            mouseEvent.moveCursorLeftClick(Coordinates.MODAL_MULTI_SIM_BUTTON);
            mouseEvent.moveCursorLeftClick(Coordinates.REFRESH_NODE_WITH_CRYSTALS);
            mouseEvent.moveCursorLeftClick(Coordinates.MODAL_MULTI_SIM_BUTTON);
            mouseEvent.moveCursorLeftClick(Coordinates.SIM_BUTTON, 5000);
        }
    }

    private void clickContinue() {
        mouseEvent.moveCursorLeftClick(Coordinates.CONTINUE_BUTTON);
    }

    public void goToHome() {
        sharedScript.goToHomeClosePopUps();
    }

    public void goToHomeFromFleet() {
        sharedScript.goToHome();
        sharedScript.goToHomeClosePopUps();
    }

    public Position getNode(final Shard shard, final ShardType shardType) {
        return ShardType.CHARACTER.equals(shardType) ?
            PositionDatabase.CHARACTER_NODES.get(shard.getNode()) :
            PositionDatabase.SHIP_NODES.get(shard.getNode());
    }

    public Position getTabCoordinates(final Shard shard) {
        return PositionDatabase.TABS.get(shard.getTab());
    }

    private static class Coordinates {
        public static final Point DARK_SIDE_HOLO_TABLE = new Point(1200, 680);
        public static final Point LIGHT_SIDE_HOLO_TABLE = new Point (700, 680);
        // Copied
        public static final Point SHIPS_HOLO_TABLE = new Point (1070, 360);
        public static final Point FLEET_BATTLES_HOLO_TABLE = new Point(960, 720);

        // Copied
        public static final Point MAIN_SCREEN_RIGHT_SIDE_DRAG_POINT = new Point (1700, 530);

        public static final Point SHIFT_TABS_BASE_POSITION = new Point(1095, 200);
        public static final Point HARD_BUTTON = new Point(1400, 980);
        public static final Point RESET_TABLE_DRAG_POINT_ONE = new Point(160, 850);
        public static final Point RESET_TABLE_DRAG_POINT_TWO = new Point(865, 840);
        public static final Point RESET_TABLE_FIRST_CHARACTER_NODE_FIRST_CLICK = new Point(670, 490);
        public static final Point RESET_TABLE_FIRST_CHARACTER_NODE_SECOND_CLICK = new Point(610, 490);
        public static final Point CENTER_TABLE_DRAG_POINT = new Point(865, 840);

        public static final Point MULTI_SIM_BUTTON = new Point(1340, 865);
        // Copied?
        public static final Point SIM_BUTTON = new Point(950, 690);
        public static final Point MODAL_MULTI_SIM_BUTTON = new Point(545, 900);
        public static final Point REFRESH_NODE_WITH_CRYSTALS = new Point(1155, 680);
        // Copied?
        public static final Point CONTINUE_BUTTON = new Point(1100, 900);

        // Copy
        public static final Point HOME_BUTTON = new Point(1770, 85);
    }
}
