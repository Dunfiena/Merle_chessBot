package GUI;

import Pieces.Piece;

import javax.swing.*;
import java.util.ArrayList;

public class Board extends JFrame {
    public Board(ArrayList<Piece> white, ArrayList<Piece> black, String playerColor){
        this.setSize(800,600);
        this.setTitle("Merle chess bot");
        this.setVisible(true);
        this.setLayout(null);
        this.setResizable(false);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        chessBoard chessboard = new chessBoard(white, black, playerColor);
        chessboard.setSize(800,600);
        chessboard.setVisible(true);
        add(chessboard);

    }


}
