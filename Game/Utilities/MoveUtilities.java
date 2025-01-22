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

            if(!endSpace.hasPiece())
            {
                continue;
            } else {
                if (endSpace.getPiece().getTeam() != team && endSpace.getPiece().getType() == PieceTypes.KNIGHT)
                {
                    return true;
                }
            }
        }

        //is there a danger on a straightaway?

        
        Coordinate endCoordinate;
        for(Coordinate coord : PIECE_Configurations.ROOK_MOVES) 
        {
            endCoordinate = currentCoord;
            while(BoardUtilities.isValidCoordinate(endCoordinate.plus(coord)))
            {
                endCoordinate = endCoordinate.plus(coord);
                endSpace = board.getSpace(endCoordinate);
                if(!endSpace.hasPiece())
                {
                    continue;
                } else {
                    if(endSpace.getPiece().getTeam() == team)
                    {
                        break;
                    }
                    if(endSpace.getPiece().getTeam() != team && (endSpace.getPiece().getType() == PieceTypes.ROOK || endSpace.getPiece().getType() == PieceTypes.QUEEN)) {
                        return true;
                    } else {
                        break;
                    }
                }
            }
        }

        //danger from diagonals
        for(Coordinate coord : PIECE_Configurations.BISHOP_MOVES)
        {
            endCoordinate = currentCoord;
            while(BoardUtilities.isValidCoordinate(endCoordinate.plus(coord)))
            {
                endCoordinate = endCoordinate.plus(coord);
                endSpace = board.getSpace(endCoordinate);
                if(!endSpace.hasPiece())
                {
                    continue;
                } else {
                    if(endSpace.getPiece().getTeam() == team) {
                        break;
                    }
                    if(endSpace.getPiece().getTeam() != team && (endSpace.getPiece().getType() == PieceTypes.BISHOP || endSpace.getPiece().getType() == PieceTypes.QUEEN))
                    {
                        return true;
                    } else {
                        break;
                    }
                }
            }
        }

        //pawn attacks
        for(Coordinate coord : (Coordinate[])PIECE_Configurations.PAWN_MOVES.get(team).get("Attack"))
        {
            if(!BoardUtilities.isValidCoordinate(currentCoord.plus(coord)))
            {
                continue;
            }
            endSpace = board.getSpace(currentCoord.plus(coord));

            if(!endSpace.hasPiece())
            {
                continue;
            } else {
                if(endSpace.getPiece().getTeam() != team && endSpace.getPiece().getType() == PieceTypes.PAWN)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
