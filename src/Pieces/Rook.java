package Pieces;

import java.util.Objects;

public class Rook extends Piece{
    boolean hasMoved;

    public Rook(String name, String file, int rank) {
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
            //moves on the file
        if (Objects.equals(this.getFile(), newFile) && this.getRank() != newRank){
            this.setFile(newFile);
            this.hasMoved =true;
            return true;
            //moves on the rank

        }else if (this.getRank() == newRank && !Objects.equals(this.getFile(), newFile)){
            this.setRank(newRank);
            this.hasMoved = true;
            return true;
        }
        return false;
    }
}
