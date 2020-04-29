package Meta;
import Pieces.*;
import GUI.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gamestate {
    static Board board;
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

        ChessGUI mainGUI = new ChessGUI();

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                int actionX = x;
                int actionY = y;
                mainGUI.getChessSquare(x, y).addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int clickedX = actionX;
                        int clickedY = actionY;
                        Piece clickedPiece = board.getSquare(actionX, actionY).getPiece();
                        Player pieceOwner = clickedPiece.getPlayer();
                        Move mv = new Move(clickedPiece, clickedX, clickedY);
                        if (pieceOwner.getMoveList().size() < 2) {
                            pieceOwner.addMove(mv);
                        } else {
                            pieceOwner.addMove(mv);
                            board.makeMove(pieceOwner);
                        }
                    }
                });
            }
        }
    }
}