package com.heastie.swgoh.automation;

import com.heastie.swgoh.automation.bean.Position;
import com.heastie.swgoh.automation.bean.ScreenSide;
import com.heastie.swgoh.automation.bean.Shard;
import com.heastie.swgoh.automation.bean.ShardType;
import com.heastie.swgoh.automation.constant.PositionDatabase;
import com.heastie.swgoh.automation.mouse.MouseEvent;
import java.awt.Point;
import org.springframework.stereotype.Component;

@Component
public class DarkSideBattleSimulator {
    private final MouseEvent mouseEvent;

    public DarkSideBattleSimulator(final MouseEvent mouseEvent) {
        this.mouseEvent = mouseEvent;
    }

    public void run() {
        goToTable();
//        farmCharacterNode(new Shard(5, "E", 0));
        farmCharacterNode(new Shard(3, "D", 1));
        clickHomeButton();
    }

    // Go to dark side table
    // Sim every selected character
    // Click on home button
    // Close pop up script

    public void goToTable() {
        mouseEvent.moveCursorLeftClick(new Point(1200, 680), 3000);
    }

    private void farmCharacterNode(final Shard shard) {
        moveTabs(shard);
        clickOnTab(shard);
        clickOnHardTab();
        getResetTableScript(ShardType.CHARACTER);
        clickOnCharacterNode(shard);
        simCharacter();
        reSimCharacter(shard);
        clickContinueButton();
    }

    private void clickContinueButton() {
        mouseEvent.moveCursorLeftClick(new Point(1100, 900));
    }

    public void reSimCharacter(final Shard shard) {
        for(int i = 0; i < shard.getRefreshes(); i++) {
            mouseEvent.moveCursorLeftClick(new Point(545, 900)); // modal multi-sim button
            mouseEvent.moveCursorLeftClick(new Point(1155, 680)); // purchase crystals
            mouseEvent.moveCursorLeftClick(new Point(545, 900)); // modal multi-sim button
            mouseEvent.moveCursorLeftClick(new Point(950, 690)); // sim button
        }
    }

    public void getResetTableScript(final ShardType shardType) {
        // Drag far left
        mouseEvent.dragFarLeft(new Point(160, 850));
        // Click on 1-A once
        mouseEvent.moveCursorLeftClick(new Point(670, 490));
        // Click on 1-A again
        mouseEvent.moveCursorLeftClick(new Point(610, 490));
        // Drag far left
        mouseEvent.dragFarLeft(new Point(865, 840));
        // Center screen
        mouseEvent.dragShortRight(new Point(865, 840));
    }

    private void simCharacter() {
        // 1340, 870
        mouseEvent.moveCursorLeftClick(new Point(1340, 840)); // multi-sim button
        mouseEvent.moveCursorLeftClick(new Point(950, 690)); // sim button
    }

    private void clickOnCharacterNode(final Shard shard) {
        final Position position = getNode(shard, ShardType.CHARACTER);
        mouseEvent.moveCursorLeftClick(position.getCoordinates());
    }

    private void getTableMoveScript(final Shard shard, final ShardType type) {
        if (ShardType.CHARACTER.equals(type)) {
            getMoveCharacterTableScreenScript(shard);
        } else if (ShardType.SHIP.equals(type)) {
//            return getMoveShipTableScreenScript(shard);
        } else {
            throw new RuntimeException("Invalid character type");
        }
    }

    private void getMoveCharacterTableScreenScript(final Shard shard) {
        final Position position = getCharacterNodeLocation(shard);

        if (position.getScreenSide().equals(ScreenSide.LEFT)) {
            mouseEvent.dragFarLeft(position.getCoordinates());
        } else {
            mouseEvent.dragFarRight(position.getCoordinates());
        }
    }

    private Position getCharacterNodeLocation(final Shard shard) {
        return PositionDatabase.CHARACTER_NODES.get(shard.getNode());
    }

    private void clickOnHardTab() {
        mouseEvent.moveCursorLeftClick(new Point(1400, 980));
    }

    public void moveTabs(final Shard shard) {
        final Position characterNodePosition = getTabPosition(shard);

        if (ScreenSide.LEFT.equals(characterNodePosition.getScreenSide())) {
            mouseEvent.dragShortLeft(new Point(1095, 200));
        } else if (ScreenSide.RIGHT.equals(characterNodePosition.getScreenSide())) {
            mouseEvent.dragFarRight(new Point(1095, 200));
        }
    }

    private void clickOnTab(final Shard shard) {
        final Position tabPosition = getTabPosition(shard);
        mouseEvent.moveCursorLeftClick(tabPosition.getCoordinates());
    }

    private Position getTabPosition(final Shard shard) {
        return PositionDatabase.TABS.get(shard.getTab());
    }

    private Position getNode(final Shard shard, final ShardType shardType) {
        return ShardType.CHARACTER.equals(shardType) ?
            PositionDatabase.CHARACTER_NODES.get(shard.getNode()) :
            PositionDatabase.SHIP_NODES.get(shard.getNode());
    }

    private void clickHomeButton() {
        mouseEvent.moveCursorLeftClick(new Point(1770, 85));
    }
}
