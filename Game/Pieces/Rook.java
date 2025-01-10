package Chess.Game.Pieces;

import java.util.ArrayList;
import java.util.List;

import Chess.Game.Gameboard.Board;
import Chess.Game.Gameboard.Space;
import Chess.Game.Move.Move;
import Chess.Game.Resources.PIECE_Configurations;
import Chess.Game.Utilities.BoardUtilities;

public class Rook extends Piece{
    
    public Rook(Team team) {
        super(team,PieceTypes.ROOK);
    }

    @Override
    public List<Move> availableMoves(Board board, Coordinate currentCoord) {
        
        List<Move> possibleMoves = new ArrayList<Move>();
        Space currentSpace = board.getSpace(currentCoord);
        Space endSpace;
        Coordinate endCoordinate;

        for(Coordinate coord : PIECE_Configurations.ROOK_MOVES) {
            endCoordinate = currentCoord;

            while(BoardUtilities.isValidCoordinate(endCoordinate.plus(coord))) 
            {
                endCoordinate = endCoordinate.plus(coord);
                endSpace = board.getSpace(endCoordinate);
                if(!endSpace.hasPiece()) 
                {
                    possibleMoves.add(new Move(board, currentSpace, endSpace));
                } else {
                    if(endSpace.getPiece().getTeam() != this.getTeam())
                    {
                        possibleMoves.add(new Move(board, currentSpace, endSpace));
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        return possibleMoves;
    }
}
