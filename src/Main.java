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
                startGame("white");
                break;
            case "black":
                startGame("black");
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
        int j=0;
        Move move;
        ArrayList<Move> moves = new ArrayList<>();
        boolean playerTurn = false;
        int playercol = 2;
        int aicolor = 3;


        //THIS is the body of the game.
        while(!checkmate) {
            if (Objects.equals(playerColor, "white") && turn%2 == 1) {
                move = playermove();
                moves.add(move);
                playerTurn = true;
                playercol=1;
            } else if (Objects.equals(playerColor, "black") && turn % 2 == 0) {
                move = playermove();
                moves.add(move);
                playerTurn = true;
                playercol=2;
            } else {
                move = MerleMove();
                System.out.println("I play "+ move.getFile()  + "" + move.getRank());
                moves.add(move);
                playerTurn = false;
                if (turn == 1) {
                    aicolor -= playercol;
                }
            }

            if (playerTurn && playercol == 1){
                for (Piece p: white){
                    if (p.getRank() == moves.get(moves.size()-1).getRank() && String.valueOf(p.getFile()).equals(moves.get(moves.size()-1).getFile())){
                        p.setFile(moves.get(moves.size()-1).getFile());
                        p.setRank(moves.get(moves.size()-1).getRank());
                    }
                }
            } else if (playerTurn) {
                for (Piece p: black){
                    if (p.getRank() == moves.get(moves.size()-1).getRank() && String.valueOf(p.getFile()).equals(moves.get(moves.size()-1).getFile())){
                        p.setFile(moves.get(moves.size()-1).getFile());
                        p.setRank(moves.get(moves.size()-1).getRank());
                    }
                }
            } else {
                if (aicolor == 1){
                    for (Piece p: black){
                        if (p.getRank() == moves.get(moves.size()-1).getRank() && String.valueOf(p.getFile()).equals(moves.get(moves.size()-1).getFile())){
                            p.setFile(moves.get(moves.size()-1).getFile());
                            p.setRank(moves.get(moves.size()-1).getRank());
                        }
                    }
                }else{
                    for (Piece p: white){
                        if (p.getRank() == moves.get(moves.size()-1).getRank() && String.valueOf(p.getFile()).equals(moves.get(moves.size()-1).getFile())){
                            p.setFile(moves.get(moves.size()-1).getFile());
                            p.setRank(moves.get(moves.size()-1).getRank());
                        }
                    }
                }
            }
            turn++;

            if (turn > 2 && turn % 2 == 0){
                j++;
                System.out.print(j+")");
                for (int i=0; i < moves.size();) {
                    i++;
                    System.out.print("   " + moves.get(moves.size()-i).getFile() + "-----" + moves.get(moves.size()-i).getRank());
                    if (i==2){
                        break;
                    }
                }
            }
            System.out.print("\n");
        }
    }

    private boolean checkMove(Move move) {

        return true;
    }

    private static Move MerleMove() {
        String file = "a";
        int rank = 4;
        return new Move(file,rank);
    }

    private static Move playermove() {
        Scanner charin = new Scanner(System.in);
        Scanner intIn = new Scanner(System.in);
        System.out.println("Play your move (rank then file)");
        String file = charin.next();
        int rank = intIn.nextInt();
        return new Move(file,rank);
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