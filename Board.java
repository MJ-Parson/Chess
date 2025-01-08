package Chess;

public class Board {
    Space[][] boxes;

    public Board()
    {
        this.resetBoard();
    }

    public Space getBox(int x, int y) throws Exception
    {
        if (x<0 || x>7 || y<0 || y>7){
            throw new Exception("Index out of bound");
        }
        return boxes[x][y];
    }

    public void resetBoard()
    {
        //initialize the white pieces
        //pawns

        //initialize the black pieces
        //pawns

        //remeaining pieces
        for (int i = 2; i<6; i++) {
            for (int j = 0; j<8; j++) {
                boxes[i][j] = new Space(i, j, null);
            }
        }
    }
}
