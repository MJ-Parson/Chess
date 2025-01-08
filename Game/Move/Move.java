package Chess.Game.Move;

import Chess.Game.Gameboard.Board;
import Chess.Game.Gameboard.Space;
import Chess.Game.Pieces.Piece;

public class Move implements java.io.Serializable{
    Board board;
    Space currentSpace;
    Space endSpace;
    Piece movedPiece;
    Piece killedPiece;

    public Move(Board board, Space currentSpace,Space endSpace){
        this.board = board;
        this.currentSpace = currentSpace;
        this.endSpace = endSpace;
        this.movedPiece = currentSpace.getPiece();
        if(endSpace.hasPiece()) {
            killedPiece = endSpace.getPiece();
        }
    }

    public Board getBoard() {
        return board;
    }
    public void setBoard(Board board) {
        this.board = board;
    }

    public Space getCurrentSpace(){
        return currentSpace;
    }
    public void setCurrentSpace(Space currentSpace){
        this.currentSpace = currentSpace;
    }

    public Space getEndSpace() {
        return endSpace;
    }
    public void setEndSpace(Space endSpace){
        this.endSpace = endSpace;
    }

    public Piece getMovedPiece() {
        return movedPiece;
    }
    public void setMovedPiece(Piece movedPiece) {
        this.movedPiece = movedPiece;
    }

    public Piece getKilledPiece() {
        return killedPiece;
    }
    public void setKilledPiece(Piece killedPiece){
        this.killedPiece = killedPiece;
    }
    public boolean hasKilledPiece()
    {
        return this.killedPiece != null;
    }

}
