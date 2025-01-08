package Chess.Game.Pieces;

import Chess.Game.Board;
import Chess.Game.Space;

public class King extends Piece{
    private boolean castle = false;

    public King(boolean white)
    {
        super(white);
    }

    public boolean isCastlingDone()
    {
        return this.castle;
    }
    public void setCastlingDonw(boolean castle)
    {
        this.castle = castle;
    }

    @Override
    public boolean canMove(Board board, Space start, Space end)
    {
        //can't take a friendly piece
        if(end.getPiece().isWhite() == this.isWhite()) { 
            return false;
        }

        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        if (x + y ==1) {
            //check if this move puts the king in danger
            if(){
                return false;
            } else {
                return true;
            }
            
        }
        return this.isValidCastling(board,start,end);
    }

    private boolean isValidCastling(Board board, Space start, Space end)
    {
        if (this.isCastlingDone()) {
            return false;
        }
        //logic
        return true;
    }

    public boolean isCastlingMove(Space start, Space end){
        //check if the start and end position are correct
        return false;
    }

    
}
