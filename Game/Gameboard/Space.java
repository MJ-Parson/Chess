package Chess.Game.Gameboard;

import Chess.Game.Pieces.Coordinate;
import Chess.Game.Pieces.Piece;

public class Space {
    private Piece piece;
    private Coordinate coordinate;

    public Space(Coordinate coordinate, Piece piece)
    {
        this.setPiece(piece);
        this.setCoordinate(coordinate);
    }

    public Piece getPiece(){
        return this.piece;
    }
    public void setPiece(Piece p){
        this.piece = p;
    }

    public Coordinate getCoordinate(){
        return this.coordinate;
    }
    public void setCoordinates(int x, int y) {
        this.coordinate.setX(x);
        this.coordinate.setY(y);
    }
    public void setCoordinate(Coordinate coordinate){
        this.coordinate = coordinate;
    }

    public boolean hasPiece()
    {
        return this.piece != null;
    }

    @Override
    public String toString() {
        return coordinate.toString()+" Piece "+((hasPiece() ? piece.toString() : "Empty"));
    }
    
}