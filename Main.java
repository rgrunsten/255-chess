import GUI.*;
import Meta.*;
import Pieces.*;
import javax.swing.*;

/**public class Main implements Runnable {
    public void run() {
        Gamestate game = new Gamestate();
        game.runGame();
    }
}*/
public class Main {
    public static void main(final String[] args) {
        //final Runnable r = new Runnable() {

            //@Override
            //public void run() {
                /*final ChessGUI cb = new ChessGUI();
                final JFrame f = new JFrame("255-Chess");

                f.add(cb.getGui());
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                // Sets frame to minimum required size for enclosed components
                f.pack();
                
                // Ensures minimum frame size is set
                f.setMinimumSize(f.getSize());
                f.setVisible(true);*/
                Gamestate game = new Gamestate();
               
                game.runGame();
            //}
        //};
       // SwingUtilities.invokeLater(r);
    }
}
