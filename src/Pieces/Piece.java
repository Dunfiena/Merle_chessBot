package Pieces;

public abstract class Piece {
    private String Name;
    private String file;
    private int rank;

    public Piece(String name, String file, int rank) {
        this.Name = name;
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

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
    public boolean move(int newRank, String newFile){

        return true;
    }
}
