package GUI;

import Pieces.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class chessBoard extends JPanel {
    ArrayList<JButton> tiles;
    String[] usedFile = {"a", "b", "c", "d", "e", "f", "g", "h"};
    String[] usedRanks = {"1","2","3","4","5","6","7","8"};
    Icon blank = new ImageIcon("src/GUI/Assets/blank.png");
    boolean validmove;
    public chessBoard(ArrayList<Piece> white, ArrayList<Piece> black, String playerColor){

        Icon BBishop_uS_R = new ImageIcon("src/GUI/Assets/B_bis_us_r.png");
        Icon WBishop_uS_R = new ImageIcon("src/GUI/Assets/W_bis_us_r.png");
        Icon BKnight_uS_R = new ImageIcon("src/GUI/Assets/B_Kni_us_r.png");
        Icon WKnight_uS_R = new ImageIcon("src/GUI/Assets/W_Kni_us_r.png");
        Icon BRook_uS_R = new ImageIcon("src/GUI/Assets/B_rook_us_r.png");
        Icon WRook_uS_R = new ImageIcon("src/GUI/Assets/W_rook_us_r.png");
        Icon BPawn_uS_R = new ImageIcon("src/GUI/Assets/B_pawn_us_r.png");
        Icon WPawn_uS_R = new ImageIcon("src/GUI/Assets/W_pawn_us_r.png");
        Icon BQueen_uS_R = new ImageIcon("src/GUI/Assets/B_queen_us_r.png");
        Icon WQueen_uS_R = new ImageIcon("src/GUI/Assets/W_queen_us_r.png");
        Icon BKing_uS_R = new ImageIcon("src/GUI/Assets/B_king_us_r.png");
        Icon WKing_uS_R = new ImageIcon("src/GUI/Assets/W_king_us_r.png");

        ArrayList<Icon> unSelectedIcon = new ArrayList<>();
        unSelectedIcon.add(WKing_uS_R);
        unSelectedIcon.add(WQueen_uS_R);
        unSelectedIcon.add(WRook_uS_R);
        unSelectedIcon.add(WKnight_uS_R);
        unSelectedIcon.add(WBishop_uS_R);
        unSelectedIcon.add(WPawn_uS_R);

        unSelectedIcon.add(BKing_uS_R);
        unSelectedIcon.add(BPawn_uS_R);
        unSelectedIcon.add(BBishop_uS_R);
        unSelectedIcon.add(BQueen_uS_R);
        unSelectedIcon.add(BRook_uS_R);
        unSelectedIcon.add(BKnight_uS_R);

        Icon BBishop_S_R = new ImageIcon("src/GUI/Assets/B_bis_s_r.png");
        Icon WBishop_S_R = new ImageIcon("src/GUI/Assets/W_bis_s_r.png");
        Icon BKnight_S_R = new ImageIcon("src/GUI/Assets/B_Kni_s_r.png");
        Icon WKnight_S_R = new ImageIcon("src/GUI/Assets/W_Kni_s_r.png");
        Icon BRook_S_R = new ImageIcon("src/GUI/Assets/B_rook_s_r.png");
        Icon WRook_S_R = new ImageIcon("src/GUI/Assets/W_rook_s_r.png");
        Icon BPawn_S_R = new ImageIcon("src/GUI/Assets/B_pawn_s_r.png");
        Icon WPawn_S_R = new ImageIcon("src/GUI/Assets/W_pawn_s_r.png");
        Icon BQueen_S_R = new ImageIcon("src/GUI/Assets/B_queen_s_r.png");
        Icon WQueen_S_R = new ImageIcon("src/GUI/Assets/W_queen_s_r.png");
        Icon BKing_S_R = new ImageIcon("src/GUI/Assets/B_king_s_r.png");
        Icon WKing_S_R = new ImageIcon("src/GUI/Assets/W_king_s_r.png");

        ArrayList<Icon> SelectedIcon = new ArrayList<>();
        SelectedIcon.add(WKing_S_R);
        SelectedIcon.add(WQueen_S_R);
        SelectedIcon.add(WRook_S_R);
        SelectedIcon.add(WKnight_S_R);
        SelectedIcon.add(WBishop_S_R);
        SelectedIcon.add(WPawn_S_R);

        SelectedIcon.add(BKing_S_R);
        SelectedIcon.add(BPawn_S_R);
        SelectedIcon.add(BBishop_S_R);
        SelectedIcon.add(BQueen_S_R);
        SelectedIcon.add(BRook_S_R);
        SelectedIcon.add(BKnight_S_R);

        tiles  = new ArrayList<>();


        if(Objects.equals(playerColor, "black")){
            for (String u: usedRanks) {
                for (String r : usedFile) {
                    JButton tile = new JButton();
                    if (u.equals("1") && r.equals("c") || u.equals("1") && r.equals("f")) {
                        tile.setIcon(BBishop_uS_R);
                    } else if (u.equals("8") && r.equals("c") || u.equals("8") && r.equals("f")) {
                        tile.setIcon(WBishop_uS_R);
                    } else if (u.equals("1") && r.equals("b") || u.equals("1") && r.equals("g")) {
                        tile.setIcon(BKnight_uS_R);
                    } else if (u.equals("8") && r.equals("b") || u.equals("8") && r.equals("g")) {
                        tile.setIcon(WKnight_uS_R);
                    } else if (u.equals("1") && r.equals("a") || u.equals("1") && r.equals("h")) {
                        tile.setIcon(BRook_uS_R);
                    } else if (u.equals("8") && r.equals("a") || u.equals("8") && r.equals("h")) {
                        tile.setIcon(WRook_uS_R);
                    } else if (u.equals("1") && r.equals("d")) {
                        tile.setIcon(BQueen_uS_R);
                    } else if (u.equals("8") && r.equals("d")) {
                        tile.setIcon(WQueen_uS_R);
                    } else if (u.equals("1") && r.equals("e")) {
                        tile.setIcon(BKing_uS_R);
                    } else if (u.equals("8") && r.equals("e")) {
                        tile.setIcon(WKing_uS_R);
                    } else if (u.equals("2")) {
                        tile.setIcon(BPawn_uS_R);
                    } else if (u.equals("7")) {
                        tile.setIcon(WPawn_uS_R);
                    }
                    tiles.add(tile);
                }
            }
        } else {
            for (String u: usedRanks) {
                for (String r : usedFile) {
                    JButton tile = new JButton();
                    if (u.equals("8") && r.equals("c") || u.equals("8") && r.equals("f")) {
                        tile.setIcon(BBishop_uS_R);
                    } else if (u.equals("1") && r.equals("c") || u.equals("1") && r.equals("f")) {
                        tile.setIcon(WBishop_uS_R);
                    } else if (u.equals("8") && r.equals("b") || u.equals("8") && r.equals("g")) {
                        tile.setIcon(BKnight_uS_R);
                    } else if (u.equals("1") && r.equals("b") || u.equals("1") && r.equals("g")) {
                        tile.setIcon(WKnight_uS_R);
                    } else if (u.equals("8") && r.equals("a") || u.equals("8") && r.equals("h")) {
                        tile.setIcon(BRook_uS_R);
                    } else if (u.equals("1") && r.equals("a") || u.equals("1") && r.equals("h")) {
                        tile.setIcon(WRook_uS_R);
                    } else if (u.equals("8") && r.equals("d")) {
                        tile.setIcon(BQueen_uS_R);
                    } else if (u.equals("1") && r.equals("d")) {
                        tile.setIcon(WQueen_uS_R);
                    } else if (u.equals("8") && r.equals("e")) {
                        tile.setIcon(BKing_uS_R);
                    } else if (u.equals("1") && r.equals("e")) {
                        tile.setIcon(WKing_uS_R);
                    } else if (u.equals("7")) {
                        tile.setIcon(BPawn_uS_R);
                    } else if (u.equals("2")) {
                        tile.setIcon(WPawn_uS_R);
                    }else{
                        tile.setIcon(blank);
                    }
                    tiles.add(tile);
                }
            }
        }
        int x =0;
        int y = 0;
        int i = 0;
        int j=0;
        for (JButton t: tiles){
            t.setBounds(x,y, 50, 50);
            if (j % 2 == 0) {
                if (i == 0) {
                    t.setBackground(Color.GRAY);
                    i = 1;
                } else {
                    i = 0;
                }
            }else {
                if (i == 0) {
                    i = 1;
                } else {
                    t.setBackground(Color.GRAY);
                    i = 0;
                }
            }
            add(t);
            if (x==350){
                x=0;
                y+=50;
                j+=1;
            }else {
                x += 50;
            }
        }
        for (JButton jb: tiles) {
            jb.addActionListener(e ->{
                //remove selected icon for previously selected tiles
                for (int t = 0; t < tiles.size(); t++) {
                    for (int pos2 = 0; pos2 < SelectedIcon.size(); pos2++) {
                        if (tiles.get(t).getIcon() == SelectedIcon.get(pos2)) {
                            if (checkMove(t, pos2, playerColor, white, black)) {
                                jb.setIcon(tiles.get(t).getIcon());
                                tiles.get(t).setIcon(blank);
                            } else {
                                tiles.get(t).setIcon(unSelectedIcon.get(pos2));
                                //Set selected icon
                                for (int pos = 0; pos < unSelectedIcon.size(); pos++) {
                                    if (jb.getIcon() == unSelectedIcon.get(pos)) {
                                        jb.setIcon(SelectedIcon.get(pos));
                                    }
                                }
                            }
                        }
                    }
                }
                for (int pos = 0; pos < unSelectedIcon.size(); pos++) {
                    if (jb.getIcon() == unSelectedIcon.get(pos)) {
                        jb.setIcon(SelectedIcon.get(pos));
                    }
                }
            });
        }
    }

    private boolean checkMove(int tile, int icon, String playerColor, ArrayList<Piece> white, ArrayList<Piece> black) {
        float rank1 = ((float) tile / 8);
        int rank = (int) rank1;
        int file = tile - (rank * 8);
        boolean valid;
        System.out.println(rank + " " + file + " " + usedFile[file]);
        if (Objects.equals(playerColor, "white")) {
            switch (icon) {
                case 0:
                    //King Move
                    King king = (King) white.get(15);
                    System.out.println(Integer.parseInt(usedRanks[rank]) + " " + usedFile[file]);
                    valid = king.move(Integer.parseInt(usedRanks[rank]), usedFile[file]);
                    System.out.println(valid);
                    return valid;
                case 1:
                    //Queen move
                    Queen queen = (Queen) white.get(14);
                    System.out.println(Integer.parseInt(usedRanks[rank]) + " " + usedFile[file]);
                    valid = queen.move(Integer.parseInt(usedRanks[rank]), usedFile[file]);
                    System.out.println(valid);
                    return valid;
                case 2:
                    //Bishop move
                    if (white.get(13).getRank() == rank && Objects.equals(white.get(13).getFile(), usedFile[file])) {
                        Bishop bishop = (Bishop) white.get(13);
                        System.out.println(Integer.parseInt(usedRanks[rank]) + " " + usedFile[file]);
                        valid = bishop.move(Integer.parseInt(usedRanks[rank]), usedFile[file]);
                        System.out.println(valid);
                        return valid;
                    } else {
                        Bishop bishop = (Bishop) white.get(12);
                        System.out.println(Integer.parseInt(usedRanks[rank]) + " " + usedFile[file]);
                        valid = bishop.move(Integer.parseInt(usedRanks[rank]), usedFile[file]);
                        System.out.println(valid);
                        return valid;
                    }
                case 3:
                    //Knight move
                    if (white.get(11).getRank() == rank && Objects.equals(white.get(11).getFile(), usedFile[file])) {
                        Knight knight = (Knight) white.get(11);
                        System.out.println(Integer.parseInt(usedRanks[rank]) + " " + usedFile[file]);
                        valid = knight.move(Integer.parseInt(usedRanks[rank]), usedFile[file]);
                        System.out.println(valid);
                        return valid;
                    } else {
                        Knight knight = (Knight) white.get(10);
                        System.out.println(Integer.parseInt(usedRanks[rank]) + " " + usedFile[file]);
                        valid = knight.move(Integer.parseInt(usedRanks[rank]), usedFile[file]);
                        System.out.println(valid);
                        return valid;
                    }
                case 4:
                    //Rook move
                    if (white.get(9).getRank() == rank && Objects.equals(white.get(9).getFile(), usedFile[file])) {
                        Rook rook = (Rook) white.get(9);
                        System.out.println(Integer.parseInt(usedRanks[rank]) + " " + usedFile[file]);
                        valid = rook.move(Integer.parseInt(usedRanks[rank]), usedFile[file]);
                        System.out.println(valid);
                        return valid;
                    } else {
                        Rook rook = (Rook) white.get(8);
                        System.out.println(Integer.parseInt(usedRanks[rank]) + " " + usedFile[file]);
                        valid = rook.move(Integer.parseInt(usedRanks[rank]), usedFile[file]);
                        System.out.println(valid);
                        return valid;
                    }
                case 5:
                    //Pawn move
                    for (int pn = 0; pn < 8; pn++) {
                        if (white.get(pn).getRank() == rank && Objects.equals(white.get(pn).getFile(), usedFile[file])) {
                            Pawn pawn = (Pawn) white.get(pn);
                            System.out.println(pawn.getFile() + " " + pawn.getRank());
                            System.out.println(Integer.parseInt(usedRanks[rank]) + " " + usedFile[file]);
                            valid = pawn.move(Integer.parseInt(usedRanks[rank]), usedFile[file]);
                            System.out.println(valid);
                            return valid;
                        }
                    }
            }
        }
            return false;
    }
}
