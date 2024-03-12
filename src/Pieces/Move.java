package Pieces;

public class Move {
    private String file;
    private int rank;

    public Move(String file, int rank){
        this.file = file;
        this.rank = rank;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return file + " "+ rank;
    }

}
