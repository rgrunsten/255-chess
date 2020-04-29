package Meta;
import Pieces.*;

public class Gamestate {
    static Board board;
    Player p1 = new Player(1);
    Player p2 = new Player(2);

    public Gamestate() {
        board = new Board();
    }

    public void executeTurn(Player pla) {
        // Player must make a valid move
        do{
            //Move mv = new Move( [MOVE INPUT COMES FROM GUI] );
            //pla.addMove(mv);
        }while(!board.makeMove(pla));
    }

    public void runGame() {
        board.initialize(p1);
        board.initialize(p2);

        // in below while loop, insert a check for if a player has lost
        // checkmate detection is difficult, might just make it...
        // so you capture king itself in order to win (king.isAlive() == false)
        while (true) {
            executeTurn(p1);
            executeTurn(p2);
        }
    }
}