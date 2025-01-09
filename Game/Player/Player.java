package Chess.Game.Player;

import Chess.Game.Gameboard.Board;
import Chess.Game.Move.Move;
import Chess.Game.Pieces.Team;

public class Player implements java.io.Serializable{
    private Team team;

    public Player(Team team)
    {
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void makeMove(Board board, Move move) 
    {
        board.getSpace(move.getEndSpace().getCoordinate()).setPiece(move.getCurrentSpace().getPiece());
        board.getSpace(move.getCurrentSpace().getCoordinate()).setPiece(null);
    }
}
