package Meta;
import Pieces.*;
import GUI.*;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gamestate {
    Board board;
    Player p1 = new Player(1);
    Player p2 = new Player(2);

    public Gamestate() {
        board = new Board();
    }

    public void executeTurn(int x, int y, Piece piece) {
        // Player must make a valid move
        do{
            Move mv = new Move(piece, x, y);
            piece.getPlayer().addMove(mv);
        }while(!board.makeMove(piece.getPlayer()));
    }

    public void runGame() {
        board.initialize(p1);
        board.initialize(p2);
        
        final ChessGUI mainGUI = new ChessGUI();
        final JFrame f = new JFrame("255-Chess");
        f.add(mainGUI.getGui());
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLocationByPlatform(true);
        // Sets frame to minimum required size for enclosed components
        f.pack();
        // Ensures minimum frame size is set
        f.setMinimumSize(f.getSize());
        f.setVisible(true);

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                System.out.println(board.squares[x][y].getPiece());
                    if (board.squares[x][y].getPiece() != null) {
                        Piece tarPiece = board.squares[x][y].getPiece();
                        try {
                            mainGUI.getChessSquare(x, y).setIcon(new ImageIcon
                            (ImageIO.read(getClass().getResource(tarPiece.getImageString()))));
                        } catch (IOException e) {
                        }
                        
                    }
            }
        }
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                int actionX = x;
                int actionY = y;
                mainGUI.getChessSquare(x, y).addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int clickedX = actionX;
                        int clickedY = actionY;
                        if (board.getSquare(actionX, actionY).getPiece() != null) {
                            Piece clickedPiece = board.getSquare(actionX, actionY).getPiece();
                            Player pieceOwner = clickedPiece.getPlayer();
                            Move mv = new Move(clickedPiece, clickedX, clickedY);

                            if (pieceOwner.getMoveList().size() < 1) {
                                pieceOwner.addMove(mv);

                            } else {
                                pieceOwner.addMove(mv);
                                board.makeMove(pieceOwner);
                                int sourceX = pieceOwner.getMove(0).getDestX();
                                int sourceY = pieceOwner.getMove(0).getDestY();
                                try {
                                    mainGUI.getChessSquare(clickedX, clickedY).setIcon(new ImageIcon(ImageIO.read(getClass().getResource(board.getSquare(clickedX, clickedY).getPiece().getImageString()))));
                                    
                                    System.out.println(sourceX + ", " + sourceY);
                                    mainGUI.getChessSquare(sourceX, sourceY).setIcon(new ImageIcon(new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));

                                } catch (IOException exception) {}
                                

                            }
                        } else {
                            if (p1.getMoveList().size() == 1) {
                                p1.playerMoves.add(new Move(null, clickedX, clickedY));
                                int sourceX = p1.getMove(0).getDestX();
                                int sourceY = p1.getMove(0).getDestY();
                                board.makeMove(p1);
                                try {
                                    mainGUI.getChessSquare(clickedX, clickedY).setIcon(new ImageIcon(ImageIO.read(getClass().getResource(board.getSquare(clickedX, clickedY).getPiece().getImageString()))));
                                    
                                    System.out.println(sourceX + ", " + sourceY);
                                    mainGUI.getChessSquare(sourceX, sourceY).setIcon(new ImageIcon(new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));
                                } catch (IOException exception) {}
                                
            
                            }
                            else if (p2.getMoveList().size() == 1) {
                                p2.playerMoves.add(new Move(null, clickedX, clickedY));
                                int sourceX = p2.getMove(0).getDestX();
                                int sourceY = p2.getMove(0).getDestY();
                                board.makeMove(p2);
                                try {
                                    mainGUI.getChessSquare(clickedX, clickedY).setIcon(new ImageIcon(ImageIO.read(getClass().getResource(board.getSquare(clickedX, clickedY).getPiece().getImageString()))));
                                    
                                    System.out.println(sourceX + ", " + sourceY);
                                    mainGUI.getChessSquare(sourceX, sourceY).setIcon(new ImageIcon(new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));

                                } catch (IOException exception) {}
                                
                                
                            } else {
                                System.out.println("Illegal");
                            }
                        }
                    }
                });
            }
        }
    }
}