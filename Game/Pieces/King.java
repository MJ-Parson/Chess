package Chess.Game.Pieces;

import java.util.ArrayList;
import java.util.List;

import Chess.Game.Gameboard.Board;
import Chess.Game.Gameboard.Space;
import Chess.Game.Move.Move;
import Chess.Game.Resources.PIECE_Configurations;
import Chess.Game.Utilities.BoardUtilities;

public class King extends Piece{
    private boolean castle = false;

    public boolean isCastlingDone() {
        return castle;
    }

    public void setCastlingDone(boolean castle) {
        this.castle = castle;
    }

    public King(Team team) {
        super(team, PieceTypes.KING);
    }

    @Override
    public List<Move> availableMoves(Board board, Coordinate currentCoord) {
        List<Move> possibleMoves = new ArrayList<Move>();
        Space currentSpace = board.getSpace(currentCoord);
        Space endSpace;
        Coordinate endCoordinate;

        for(Coordinate coord : PIECE_Configurations.QUEEN_MOVES) {
            endCoordinate = currentCoord.plus(endCoordinate);
            if(!BoardUtilities.isValidCoordinate(endCoordinate))
            {
                continue;
            }
            endSpace = board.getSpace(endCoordinate);
            if(!endSpace.hasPiece())
            {
                possibleMoves.add(new Move(board, currentSpace, endSpace));
            } else {
                if(endSpace.getPiece().getTeam() != this.getTeam())
                {
                    possibleMoves.add(new Move(board, currentSpace, endSpace));
                }
            }
        }

        return possibleMoves;
    }
    
}
