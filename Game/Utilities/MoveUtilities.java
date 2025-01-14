package Chess.Game.Utilities;

import Chess.Game.Gameboard.Board;
import Chess.Game.Gameboard.Space;
import Chess.Game.Move.Move;
import Chess.Game.Pieces.PieceTypes;
import Chess.Game.Pieces.Team;
import Chess.Game.Resources.PIECE_Configurations;
import Chess.Game.Pieces.Coordinate;

public class MoveUtilities {
    
    public static boolean isValidMove(Board board, Space endSpace) {
        if(!board.hasChosenSpace()) {
            return false;
        } 
        for(Move m : board.getChosenSpace().getPiece().availableMoves(board, board.getChosenSpace().getCoordinate())) {
            
            if(m.getEndSpace().getCoordinate().equals(endSpace.getCoordinate())) {
                return true;
            }
        }
        return false;
    }

    public static boolean controlCheckState(Board board, Team team){
        
        Space endSpace;
        Coordinate currentCoord = board.getCoordTeamPiece(team, PieceTypes.KING);

        //is there a knight as danger
        for(Coordinate coord : PIECE_Configurations.KNIGHT_MOVES) {
            if(!BoardUtilities.isValidCoordinate(currentCoord.plus(coord))) {
                continue;
            }
            endSpace = board.getSpace(currentCoord.plus(coord));

            
        }
    }
}
