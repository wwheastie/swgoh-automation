package com.heastie.swgoh.automation.constant;

import com.heastie.swgoh.automation.bean.Position;
import com.heastie.swgoh.automation.bean.ScreenSide;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class PositionDatabase {
    public static final Map<Integer, Position> TABS = new HashMap<>();
    public static final Map<String, Position> CHARACTER_NODES = new HashMap<>();
    public static final Map<String, Position> SHIP_NODES = new HashMap<>();

    public PositionDatabase() {
        initializeTabPositionsMap();
        initializeCharacterNodePositionsMap();
        initializeShipNodePositionsMap();
    }

    private void initializeTabPositionsMap() {
        TABS.put(1, new Position(new Point(200, 200), ScreenSide.LEFT));
        TABS.put(2, new Position(new Point(420, 200), ScreenSide.LEFT));
        TABS.put(3, new Position(new Point(640, 200), ScreenSide.LEFT));
        TABS.put(4, new Position(new Point(860, 200), ScreenSide.LEFT));
        TABS.put(5, new Position(new Point(1090, 200), ScreenSide.LEFT));
        TABS.put(6, new Position(new Point(1000, 200), ScreenSide.RIGHT));
        TABS.put(7, new Position(new Point(1230, 200), ScreenSide.RIGHT));
        TABS.put(8, new Position(new Point(1460, 200), ScreenSide.RIGHT));
        TABS.put(9, new Position(new Point(1690, 200), ScreenSide.RIGHT));
    }

    private void initializeCharacterNodePositionsMap() {
        CHARACTER_NODES.put("A", new Position(new Point(70, 490), ScreenSide.LEFT));
        CHARACTER_NODES.put("B", new Position(new Point(225, 615), ScreenSide.LEFT));
        CHARACTER_NODES.put("C", new Position(new Point(525, 490), ScreenSide.LEFT));
        CHARACTER_NODES.put("D", new Position(new Point(720, 625), ScreenSide.LEFT));
        CHARACTER_NODES.put("E", new Position(new Point(990, 485), ScreenSide.LEFT));
        CHARACTER_NODES.put("F", new Position(new Point(665, 635), ScreenSide.RIGHT));
    }

    private void initializeShipNodePositionsMap() {
        SHIP_NODES.put("A", new Position(new Point(105, 470), ScreenSide.LEFT));
        SHIP_NODES.put("B", new Position(new Point(300, 650), ScreenSide.LEFT));
        SHIP_NODES.put("C", new Position(new Point(590, 460), ScreenSide.LEFT));
        SHIP_NODES.put("D", new Position(new Point(820, 625), ScreenSide.LEFT));
        SHIP_NODES.put("E", new Position(new Point(540, 630), ScreenSide.RIGHT));
        SHIP_NODES.put("F", null);
    }
}
