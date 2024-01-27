package Pieces;

import java.util.Objects;

public class King extends Piece {
    boolean hasMoved;
    public King(String name, String file, int rank) {
        super(name, file, rank);
        hasMoved = false;
    }

    public boolean isHasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    @Override
    public boolean move(int newRank, String newFile) {
        super.move(newRank, newFile);
        String[] usedFile = {"a", "b", "c", "d", "e", "f", "g", "h"};
        int[] usedRanks = {1, 2, 3, 4, 5, 6, 7, 8};
        int indexRankNew = 0, indexRankOld = 0, indexFileNew = 0, indexFileOld = 0;

        for (int i = 0; i < usedRanks.length; i++) {
            //Get position 1
            if (usedRanks[i] == newRank) {
                for (int j = 0; j < usedFile.length; j++) {
                    if (usedFile[j].equals(newFile)) {
                        indexRankNew = i;
                        indexFileNew = j;
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
            //Compare movement  Ensure that it is only a movement of 1
                //Check change in rank && same file
            if (indexRankNew - indexRankOld == 1 || indexRankNew - indexRankOld == - 1
                    && indexFileNew == indexFileOld) {
                this.setRank(newRank);
                this.hasMoved =true;
                return true;
                //Check change in file && old rank
            } else if (indexFileNew - indexFileOld == 1 || indexFileNew - indexFileOld == -1
                    && indexRankNew == indexRankOld) {
                this.setFile(newFile);
                this.hasMoved =true;
                return true;
                //Check change in file and rank
            } else if (indexRankNew - indexRankOld == 1 || indexRankNew - indexRankOld == - 1 &&
                    indexFileNew - indexFileOld == 1 || indexFileNew - indexFileOld == -1) {
                this.setRank(newRank);
                this.setFile(newFile);
                this.hasMoved =true;
                return true;
            } else {
                return false;
            }
        }
        return false;
    }


    public void castle(Rook rook){
        if (!rook.isHasMoved() && !this.isHasMoved()){
        }
    }
}
