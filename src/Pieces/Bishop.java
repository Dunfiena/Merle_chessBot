package Pieces;

import java.util.ArrayList;
import java.util.Objects;

public class Bishop extends Piece{
    public Bishop(String name, String file, int rank) {
        super(name, file, rank);
    }

    @Override
    public boolean move(int newRank, String newFile) {
        super.move(newRank, newFile);
        String[] usedFile = {"a", "b", "c", "d", "e", "f", "g", "h"};
        int[] usedRanks = {1,2,3,4,5,6,7,8};
        int indexRankNew = 0, indexRankOld = 0, indexFileNew = 0, indexFileOld = 0;
        //nested for loop to check bishop position-> if on a1, a3, a5 OR b2, b4, b6, c1, c3 etc
        //it can make a certain amount of valid moves based on those sqares.
        for (String userfile : usedFile) {
            for (int usedrank : usedRanks) {
                //Dark square bishop moves
                if (Objects.equals(this.getFile(), userfile) && this.getRank() == usedrank) {
                    //Check files odd ranks
                    if (Objects.equals(this.getFile(), "a") || Objects.equals(this.getFile(), "c") ||
                            Objects.equals(this.getFile(), "e") || Objects.equals(this.getFile(), "g")) {
                        if (this.getRank() == 1 || this.getRank() == 3 || this.getRank() == 5 || this.getRank() == 7) {
                            for (int i = 0; i < usedRanks.length; i++) {
                                //Get position 1
                                if (usedRanks[i] == newRank) {
                                    for (int j = 0; j < usedFile.length; j++) {
                                        if (usedFile[j].equals(newFile)) {
                                            indexRankNew = i;
                                            indexFileNew = j;
                                        }
                                    }
                                }
                                //Get position 2
                                if (usedRanks[i] == this.getRank()) {
                                    for (int j = 0; j < usedFile.length; j++) {
                                        if (usedFile[j].equals(newFile)) {
                                            indexRankOld = i;
                                            indexFileOld = j;
                                        }
                                    }
                                }
                            }
                            //Compare movement.
                            if (indexRankNew - indexRankOld == indexFileNew - indexFileOld) {
                                this.setRank(newRank);
                                this.setFile(newFile);
                            }
                        }
                        //Check files even ranks
                    }else if(Objects.equals(this.getFile(), "b") || Objects.equals(this.getFile(), "d") ||
                            Objects.equals(this.getFile(), "f") || Objects.equals(this.getFile(), "h")){
                        if (this.getRank() == 2 || this.getRank() == 4 || this.getRank() == 6 || this.getRank() == 8) {
                            for (int i = 0; i < usedRanks.length; i++) {
                                //Get position 1
                                if (usedRanks[i] == newRank) {
                                    for (int j = 0; j < usedFile.length; j++) {
                                        if (usedFile[j].equals(newFile)) {
                                            indexRankNew = i;
                                            indexFileNew = j;
                                        }
                                    }
                                }
                                //Get position 2
                                if (usedRanks[i] == this.getRank()) {
                                    for (int j = 0; j < usedFile.length; j++) {
                                        if (usedFile[j].equals(newFile)) {
                                            indexRankOld = i;
                                            indexFileOld = j;
                                        }
                                    }
                                }
                            }
                            //Compare movement.
                            if (indexRankNew - indexRankOld == indexFileNew - indexFileOld) {
                                this.setRank(newRank);
                                this.setFile(newFile);
                            }
                        }
                    }else if(Objects.equals(this.getFile(), "a") || Objects.equals(this.getFile(), "c") ||
                            Objects.equals(this.getFile(), "e") || Objects.equals(this.getFile(), "f")) {
                        if (this.getRank() == 2 || this.getRank() == 4 || this.getRank() == 6 || this.getRank() == 8) {
                            for (int i = 0; i < usedRanks.length; i++) {
                                //Get position 1
                                if (usedRanks[i] == newRank) {
                                    for (int j = 0; j < usedFile.length; j++) {
                                        if (usedFile[j].equals(newFile)) {
                                            indexRankNew = i;
                                            indexFileNew = j;
                                        }
                                    }
                                }
                                //Get position 2
                                if (usedRanks[i] == this.getRank()) {
                                    for (int j = 0; j < usedFile.length; j++) {
                                        if (usedFile[j].equals(newFile)) {
                                            indexRankOld = i;
                                            indexFileOld = j;
                                        }
                                    }
                                }
                            }
                            //Compare movement.
                            if (indexRankNew - indexRankOld == indexFileNew - indexFileOld) {
                                this.setRank(newRank);
                                this.setFile(newFile);
                            }
                        }
                    }else if(Objects.equals(this.getFile(), "b") || Objects.equals(this.getFile(), "d") ||
                            Objects.equals(this.getFile(), "g") || Objects.equals(this.getFile(), "h")) {
                        if (this.getRank() == 1 || this.getRank() == 3 || this.getRank() == 5 || this.getRank() == 7) {
                            for (int i = 0; i < usedRanks.length; i++) {
                                //Get position 1
                                if (usedRanks[i] == newRank) {
                                    for (int j = 0; j < usedFile.length; j++) {
                                        if (usedFile[j].equals(newFile)) {
                                            indexRankNew = i;
                                            indexFileNew = j;
                                        }
                                    }
                                }
                                //Get position 2
                                if (usedRanks[i] == this.getRank()) {
                                    for (int j = 0; j < usedFile.length; j++) {
                                        if (usedFile[j].equals(newFile)) {
                                            indexRankOld = i;
                                            indexFileOld = j;
                                        }
                                    }
                                }
                            }
                            //Compare movement.
                            int indexChangeRank = indexRankNew - indexRankOld;
                            int indexChangeFile = indexFileNew - indexFileOld;
                            if (indexChangeRank < 0){
                                indexChangeRank *=-1;
                            }
                            if (indexChangeFile < 0){
                                indexChangeRank *=-1;
                            }
                            if (indexChangeRank == indexChangeFile) {
                                this.setRank(newRank);
                                this.setFile(newFile);
                                return true;
                            }else{
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
