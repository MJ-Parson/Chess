package Chess.Game.Utilities;

import Chess.Game.Gameboard.Space;
import Chess.Game.Pieces.Coordinate;

public class BoardUtilities {
    public static boolean isValidCoordinate(Coordinate coord) {
        return (coord.getX() >= BOARD_Configurations.BOARD_LOWER_BOUND && coord.getX() <= BOARD_Configurations.BOARD_UPPER_BOUND && coord.getY() >= BOARD_Configurations.BOARD_LOWER_BOUND && coord.getY() <= BOARD_Configurations.BOARD_UPPER_BOUND);
    }

    public static Space[][] createStandardBoardTiles(){
        
    }
}
