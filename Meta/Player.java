package Meta;
import Pieces.*;
import java.util.ArrayList;
import java.util.List;

public class Player {
    public int color;
    private List<Piece> playerPieces = new ArrayList<>();
    public List<Move> playerMoves = new ArrayList<>();
    
    public Player(int color) {
        super();
        this.color = color;
    }

    public int getColor() { return color ;}
    public List<Piece> getPlayerPieces() { return playerPieces ;}

    public List<Move> getMoveList() { return playerMoves ;}

    //make this use a counter of moves? otherwise this may be inelegant
    public Move getMove(int i) { return playerMoves.get(i) ;}
    public void removeMove(int i) { playerMoves.remove(i) ;}
    public void clearMove() { playerMoves.clear() ;}
    
    public void addMove(Move mv) {
        playerMoves.add(new Move(mv.getPiece(), mv.getDestX(), mv.getDestY()));
    }

    public void initializePieces(){
        if(this.color == 1){
            for(int i=0; i<8; i++){
                playerPieces.add(new Pawn(i, 1, this, true));
            }
            playerPieces.add(new Rook(0, 0, this, true));
            playerPieces.add(new Knight(1, 0, this, true));
            playerPieces.add(new Bishop(2, 0, this, true));
            playerPieces.add(new Queen(3, 0, this, true));
            playerPieces.add(new King(4, 0, this, true));
            playerPieces.add(new Bishop(5, 0, this, true));
            playerPieces.add(new Knight(6, 0, this, true));
            playerPieces.add(new Rook(7, 0, this, true));
        }
        else{
            for(int i=0; i<8; i++){
                playerPieces.add(new Pawn(i, 6, this, true));
            }
            playerPieces.add(new Rook(0, 7, this, true));
            playerPieces.add(new Knight(1, 7, this, true));
            playerPieces.add(new Bishop(2, 7, this, true));
            playerPieces.add(new Queen(3, 7, this, true));
            playerPieces.add(new King(4, 7, this, true));
            playerPieces.add(new Bishop(5, 7, this, true));
            playerPieces.add(new Knight(6, 7, this, true));
            playerPieces.add(new Rook(7, 7, this, true));
        }
    }
}