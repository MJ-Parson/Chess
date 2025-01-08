package Chess.Game.Pieces;

import java.util.ArrayList;
import java.util.List;

import Chess.Game.Move;
import Chess.Game.Gameboard.Board;
import Chess.Game.Gameboard.Space;
import Chess.Game.Utilities.BoardUtilities;

public class Knight extends Piece{
    
    public Knight(Team team) {
        super(team, PieceTypes.KNIGHT);
    }

    @Override
    public List<Move> availableMoves(Board board, Coordinate currentCoord) {
        List<Move> possibleMoves = new ArrayList<Move>();
        
        Space endSpace;

        for(Coordinate coord : PIECE_Configurations.KNIGHT_MOVES){
            if(!BoardUtilities.isValidCoordinate(currentCoord.plus(coord))) {
                continue;
            }
            endSpace = board.getSpace(currentCoord.plus(coord));

            if(!endSpace.hasPiece()) {
                possibleMoves.add(new Move(board,board.getSpace(currentCoord),endSpace));
            } else {
                if(endSpace.getPiece().getTeam() != this.getTeam()) {
                    possibleMoves.add(new Move(board,board.getTile(currentCoord),endSpace));
                }
            }
        }
        return possibleMoves;
    }
}
