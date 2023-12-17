package com.heastie.swgoh.automation.simulator;

import java.awt.Point;
import java.util.Arrays;
import java.util.List;

public class Coordinates {
    public static class MainScreen {
        public static final Point REGULAR_CHALLENGES_HOLO_TABLE = new Point(900, 660);
        public static final Point SHIPS_HOLO_TABLE = new Point (1070, 360);
        public static final Point HOME_BUTTON = new Point(1770, 85);
        public static final Point MAIN_SCREEN_RIGHT_SIDE_DRAG_POINT = new Point (1700, 530);
        public static final Point MAIN_SCREEN_LEFT_SIDE_DRAG_POINT = new Point (190, 530);

        public static final Point POP_UP_CLOSE_BUTTON_1 = new Point(1360, 160);
        public static final Point POP_UP_CLOSE_BUTTON_2 = new Point(1780, 160);
        public static final Point POP_UP_CLOSE_BUTTON_3 = new Point(1470, 160);
        public static final Point POP_UP_CLOSE_BUTTON_4 = new Point(1825, 40);
        public static final Point POP_UP_CLOSE_BUTTON_5 = new Point (1780, 195);
        public static final Point POP_UP_CLOSE_BUTTON_6 = new Point(1225, 245);
        public static final List<Point> POP_UP_CLOSE_BUTTONS = Arrays
            .asList(POP_UP_CLOSE_BUTTON_1, POP_UP_CLOSE_BUTTON_2,
            POP_UP_CLOSE_BUTTON_3, POP_UP_CLOSE_BUTTON_4, POP_UP_CLOSE_BUTTON_5, POP_UP_CLOSE_BUTTON_6);
    }

    public static class ShipsMainScreen {
        public static final Point FLEET_CHALLENGES_HOLO_TABLE = new Point(510, 560);
    }

    public static class Challenges {
        public static final Point TOP_MULTI_SIM_BUTTON = new Point(1500, 230);

    }

    public static class Modal {
        public static final Point SIM_BUTTON = new Point(950, 690);
        public static final Point CONTINUE_BUTTON = new Point(1100, 900);
    }
}
