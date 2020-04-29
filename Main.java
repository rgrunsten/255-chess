import GUI.*;
import Meta.*;
import Pieces.*;

public class Main implements Runnable {
    public void run() {
        Gamestate game = new Gamestate();
        game.runGame();
    }
}