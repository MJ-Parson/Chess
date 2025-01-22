package Chess.Game.Utilities;

import Chess.Game.Gameboard.Space;
import Chess.Game.Pieces.Bishop;
import Chess.Game.Pieces.Coordinate;
import Chess.Game.Pieces.Knight;
import Chess.Game.Pieces.Queen;
import Chess.Game.Pieces.Rook;
import Chess.Game.Pieces.Team;

public class BoardUtilities {
    
    public static boolean isValidCoordinate(Coordinate coord) 
    {
        return(coord.getX() >= 0 && coord.getX() <= 7 && coord.getY() >= 0 && coord.getY() <= 7);
    }

    public static Space[][] createStandardBoardTiles()
    {
        Space[][] tiles = new Space[7][7];
        tiles[0][0] = new Space(new Coordinate(0, 0), new Rook(Team.BLACK));
        tiles[1][0] = new Space(new Coordinate(1, 0), new Knight(Team.BLACK));
        tiles[2][0] = new Space(new Coordinate(3, 0), new Bishop(Team.BLACK));
        tiles[3][0] = new Space(new Coordinate(3, 0), new Queen(Team.BLACK));



        return tiles;
    }
}
