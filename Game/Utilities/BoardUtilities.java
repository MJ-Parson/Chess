package Chess.Game.Utilities;

import Chess.Game.Pieces.Coordinate;

public class BoardUtilities {
    
    public static boolean isValidCoordinate(Coordinate coord) 
    {
        return(coord.getX() >= 0 && coord.getX() <= 7 && coord.getY() >= 0 && coord.getY() <= 7);
    }

 
}
