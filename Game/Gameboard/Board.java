package Chess.Game.Gameboard;

import Chess.Game.Pieces.Coordinate;
import Chess.Game.Pieces.PieceTypes;
import Chess.Game.Pieces.Team;
import Chess.Game.Utilities.BoardUtilities;

public class Board implements java.io.Serializable{
    
    private final Space[][] spaces;
    private Player whitePlayer;
    private player blackPlayer;
    private Player currentPlayer;
    private Space chosenSpace = null;

    public Player getWhitePlayer() {
        return whitePlayer;
    }
    public Player getBlackPlayer() {
        return blackPlayer;
    }
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Space getChosenSpace() {
        return chosenSpace;
    }

    public boolean hasChosenSpace() {
        boolean hasChosen = false;
        if(chosenSpace == null)
        {
            return false;
        }
        if(chosenSpace.getPiece() == null)
        {
            return false;
        }
        return true;
    }

    public void setChosenSpace(Space chosenSpace) {
        if(!chosenSpace.hasPiece()) {
            this.chosenSpace = null;
        } else {
            this.chosenSpace = chosenSpace;
        }
    }

    public Space getSpace(Coordinate coordinate) {
        return getSpace(coordinate.getX(),coordinate.getY());
    }

    public Board() {
        whitePlayer = new Player(Team.WHITE);
        blackPlayer = new Player(Team.BLACK);
        currentPlayer = whitePlayer;
        spaces = BoardUtilities.createStandardBoardTiles();
    }

    public Space getSpace(int x, int y) {
        if(x<0 || x>7 || y<0 || y>7) {
            System.out.println("Get Tile Index Bound of Array");
            return null;
        }
        return spaces[x][y];
    }

    public Coordinate getCoordTeamPiece(Team team, PieceTypes pieceType) {
        for(int i = 0; i< BOARD_Configurations.ROW_COUNT; i++) {
            for(int j=0;j<BOARD_Configurations.ROW_SPACE_COUNT;j++){
                if(!spaces[i][j].hasPiece()) {
                    continue;
                }
                if(spaces[i][j].getPiece().getTeam() == team && spaces[i][j].getPiece().getType() == pieceType){
                    return spaces[i][j].getCoordinate();
                }
            }
        }
        return null;
    }

    public void changeCurrentPlayer() {
        if(currentPlayer==whitePlayer) {
            currentPlayer = blackPlayer;
        } else {
            currentPlayer = whitePlayer;
        }
    }

    public Space getSpaceOfGivenTeamPiece(Team team, PieceTypes pieceType) {
        for(int i=0; i<BOARD_Configurations.ROW_COUNT;i++) {
            for(int j=0; j<BOARD_Configurations.ROW_SPACE_COUNT;j++){
                if(!spaces[i][j].hasPiece()){
                    continue;
                }
                if(spaces[i][j].getPiece().getTeam() == team && spaces[i][j].getPiece().getType() == pieceType) {
                    return spaces[i][j];
                }
            }
        }
        return null;
    }
}
