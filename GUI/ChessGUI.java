package GUI;

import java.awt.*;
import Meta.*;
import javax.swing.*;
import Pieces.*;
import java.awt.image.BufferedImage;

public class ChessGUI {

    ChessGUI() { guiInit() ;}

    private final JPanel gui = new JPanel(new BorderLayout(3, 3));
    private JPanel chessBoard;
    private final JButton[][] chessSquares = new JButton[8][8];
    
    JMenu menu, submenu;  
    JMenuItem i1, i2;

    public void guiInit() { 

        // Creates GUI Menu
        final JMenuBar menubar = new JMenuBar();
        gui.add(menubar, BorderLayout.NORTH);
        menu = new JMenu("Menu");  
        i1 = new JMenuItem("New Game");  
        i2 = new JMenuItem("Quit");    
        menu.add(i1); menu.add(i2); 
        menubar.add(menu);

        // Generates grid for chess squares
        chessBoard = new JPanel(new GridLayout(0, 9));
        gui.add(chessBoard);

        // Creates empty margin to keep squares sized to image
        final Insets bMargin = new Insets(0,0,0,0);

        // Iterates through board array and generates a black or white button
        // for each spawned JButton object, and assigns object to board array
        for (int i = 0; i < chessSquares.length; i++) {
            for (int j = 0; j < chessSquares[i].length; j++) {
                final JButton squareButton = new JButton();
                squareButton.setMargin(bMargin);

                // Fills button with a transparent 64x64 image
                final ImageIcon icon = new ImageIcon(
                new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
                
                squareButton.setIcon(icon);
                
                //Creates "checker" pattern using modulo
                if ((j % 2 == 1 && i % 2 == 1) || (j % 2 == 0 && i % 2 == 0)) {
                    squareButton.setBackground(Color.WHITE);
                } else {
                    squareButton.setBackground(Color.BLACK);
                }
                chessSquares[j][i] = squareButton;
            }
        }

        // Places an empty square in top left grid square
        chessBoard.add(new JLabel(""));

        // Populates top row with the column letters
        for (int i = 0; i < 8; i++) {
            chessBoard.add(
                    new JLabel("ABCDEFGH".substring(i, i + 1),
                    SwingConstants.CENTER));
        }

        // Populates the chess board JPanel with the JButtons
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (j == 0) {
                    chessBoard.add(new JLabel("" + (i + 1), SwingConstants.CENTER));
                }
                chessBoard.add(chessSquares[j][i]);
            }
        }
    }
    public JComponent getChessBoard() { return chessBoard ;}
    public JComponent getGui() { return gui ;}

    // This main method is only for testing purposes and was not produced by us
    public static void main(final String[] args) {
        final Runnable r = new Runnable() {

            @Override
            public void run() {
                final ChessGUI cb = new ChessGUI();
                final JFrame f = new JFrame("255-Chess");

                f.add(cb.getGui());
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                // Sets frame to minimum required size for enclosed components
                f.pack();
                
                // Ensures minimum frame size is set
                f.setMinimumSize(f.getSize());
                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}