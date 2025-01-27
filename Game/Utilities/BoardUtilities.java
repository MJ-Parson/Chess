package Chess.Game.Utilities;

import Chess.Game.Gameboard.Space;
import Chess.Game.Pieces.Bishop;
import Chess.Game.Pieces.Coordinate;
import Chess.Game.Pieces.King;
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
        tiles[2][0] = new Space(new Coordinate(2, 0), new Bishop(Team.BLACK));
        tiles[3][0] = new Space(new Coordinate(3, 0), new Queen(Team.BLACK));
        tiles[4][0] = new Space(new Coordinate(4,0), new King(Team.BLACK));
        tiles[5][0] = new Space(new Coordinate(5, 0), new Bishop(Team.BLACK));
        tiles[6][0] = new Space(new Coordinate(6, 0), new Knight(Team.BLACK));
        tiles[7][0] = new Space(new Coordinate(7, 0), new Rook(Team.BLACK));

        for(int i=0; i<8; i++)
        {
            tiles[i][1] = new Space(new Coordinate(i, 1), new Pawn(Team.BLACK));
            tiles[i][6] = new Space(new Coordinate(i, 6), new Pawn(Team.WHITE));
        }
        for(int i=2;i<6;i++)
        {
            for(int j=0;j<8;j++)
            {
                tiles[j][i] = new Space(new Coordinate(j, i), null);
            }
        }

        tiles[0][7] = new Space(new Coordinate(0, 7), new Rook(Team.WHITE));
        tiles[1][7] = new Space(new Coordinate(1, 7), new Knight(Team.WHITE));
        tiles[2][7] = new Space(new Coordinate(2, 7), new Bishop(Team.WHITE));
        tiles[3][7] = new Space(new Coordinate(3, 7), new King(Team.WHITE));
        tiles[4][7] = new Space(new Coordinate(4, 7), new Queen(Team.WHITE));
        tiles[5][7] = new Space(new Coordinate(5, 7), new Bishop(Team.WHITE));
        tiles[6][7] = new Space(new Coordinate(6, 7), new Knight(Team.WHITE));
        tiles[7][7] = new Space(new Coordinate(7, 7), new Rook(Team.WHITE));
        


        return tiles;
    }
}
