package model;

public class Cell {

    private boolean containsCar;
    private int moveType;

    public Cell(int moveType){
        containsCar = false;
        this.moveType = moveType;
    }

    public boolean containsCar() {
        return containsCar;
    }

    public void setContainsCar(boolean containsCar) {
        this.containsCar = containsCar;
    }

    public int getMoveType() {
        return moveType;
    }
}
