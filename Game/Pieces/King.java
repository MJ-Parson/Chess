package Chess.Game.Pieces;

import Chess.Game.Board;
import Chess.Game.Space;

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
        
    }
    
}
