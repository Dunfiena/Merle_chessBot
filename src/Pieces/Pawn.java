package Pieces;

public class Pawn extends Piece{
    boolean hasMoved;

    public Pawn(String name, String file, int rank) {
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
    public boolean move(int newRank, String newFile){
        if (!this.hasMoved){
            if(newRank <= this.getRank()+2 || newRank <= this.getRank()-2 ){
                this.setRank(newRank);
                this.setHasMoved(true);
                return true;
            }
        }else{
            if (newRank == this.getRank() + 1 || newRank <= this.getRank() -1){
                this.setRank(newRank);
                return true;
            }
        }
        return false;
    }
}
