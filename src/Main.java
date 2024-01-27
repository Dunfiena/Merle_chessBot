import GUI.Board;
import Pieces.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n        Welcome to the Chess bot,");
        System.out.println("        My name is Marle, how about we play a game\n\n");
        System.out.println("Would you like white or black, or shall we let fate decide?");

        Scanner in = new Scanner(System.in);
        switch (in.nextLine().toLowerCase()){
            case "white":
                startGame("black");
                break;
            case "black":
                startGame("white");
                break;
            case "fate":
                String fate = coinToss();
                startGame(fate);
                break;
            default:
                System.out.println("Sorry, please enter 'white', 'black' or 'fate'");
        }

    }


    private static String coinToss() {
        Random rand = new Random();
        int coin = rand.nextInt(0,2);
        if (coin == 1){
            return "white";
        }else{
            return "black";
        }
    }

    public static void startGame(String color){
        ArrayList<Piece> white =  populateBoard();
        ArrayList<Piece> black =  populateBoard();
        new Board(white, black, color);

        String playerColor = color;
        boolean checkmate=false;
        int turn = 1;
        String move[];
        boolean playerTurn;
        int playercol = 1;
        int aicolor = 2;


        //THIS is the body of the game.
        while(!checkmate) {

            if (Objects.equals(playerColor, "white") && turn % 2 != 0) {
                move = playermove();
                playerTurn = true;
                playercol=1;
            } else if (Objects.equals(playerColor, "black") && turn % 2 == 0) {
                move = playermove();
                playerTurn = true;
                playercol=2;
            } else {
                move = MerleMove();
                playerTurn = false;
                aicolor -=playercol;
            }

            if (playerTurn && playercol == 1){
                for (Piece p: white){
                    if (String.valueOf(p.getRank()).equals(move[0]) && String.valueOf(p.getFile()).equals(move[1])){
                        p.setFile(move[1]);
                        p.setRank(Integer.parseInt(move[0]));
                    }
                }
            } else if (playerTurn) {
                for (Piece p: black){
                    if (String.valueOf(p.getRank()).equals(move[0]) && String.valueOf(p.getFile()).equals(move[1])){
                        p.setFile(move[1]);
                        p.setRank(Integer.parseInt(move[0]));
                    }
                }
            } else {
                if (aicolor == 1){
                    for (Piece p: black){
                        if (String.valueOf(p.getRank()).equals(move[0]) && String.valueOf(p.getFile()).equals(move[1])){
                            p.setFile(move[1]);
                            p.setRank(Integer.parseInt(move[0]));
                        }
                    }
                }else{
                    for (Piece p: white){
                        if (String.valueOf(p.getRank()).equals(move[0]) && String.valueOf(p.getFile()).equals(move[1])){
                            p.setFile(move[1]);
                            p.setRank(Integer.parseInt(move[0]));
                        }
                    }
                }
            }
            turn++;
        }
    }

    private static String[] MerleMove() {
        String ret[] = null;
        return ret;
    }

    private static String[] playermove() {
        Scanner charin = new Scanner(System.in);
        Scanner intIn = new Scanner(System.in);
        System.out.println("Play your move (rank then file)");
        String file = charin.next();
        int rank = intIn.nextInt();
        return new String[]{String.valueOf(rank), file};
    }


    // Populate the pieces for side of the board and return arraylist
    private static ArrayList<Piece> populateBoard() {
        String[] usedFile = {"a", "b", "c", "d", "e", "f", "g", "h"};
        ArrayList<Piece> pieces = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Pawn pawn = new Pawn("pawn", usedFile[i], 2);
            pieces.add(pawn);
        }
        Rook qRook = new Rook("Queen-Rook", usedFile[0], 1);
        Rook kRook = new Rook("King-Rook", usedFile[7], 1);
        Knight qKnight = new Knight("Queen-Knight", usedFile[1], 1);
        Knight KKnight = new Knight("King-Knight", usedFile[6], 1);
        Bishop qBishop = new Bishop("Queen-Bishop", usedFile[2],1);
        Bishop kBishop = new Bishop("King-Bishop", usedFile[5],1);
        Queen queen = new Queen("Queen", usedFile[4], 1);
        King king = new King("King", usedFile[3], 1);
        pieces.add(qRook);
        pieces.add(kRook);
        pieces.add(qKnight);
        pieces.add(KKnight);
        pieces.add(qBishop);
        pieces.add(kBishop);
        pieces.add(queen);
        pieces.add(king);

        return pieces;
    }
}