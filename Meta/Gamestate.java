package Meta;
import Pieces.*;

public class Gamestate {
    static Board board;
    Player p1;
    Player p2;

    public Gamestate() {
        board = new Board();
    }

    public void executeTurn(Player pla) {
        // Player must make a valid move
        do{
            //Move mv = new Move(/**input */);
           //pla.addMove(mv);
        }while(!board.makeMove(pla));
    }

    public void runGame() {
        board.initialize(p1);
        board.initialize(p2);

        while (true) {
            executeTurn(p1);
            executeTurn(p2);
        }
    }
}