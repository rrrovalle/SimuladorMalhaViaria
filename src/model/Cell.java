package model;

import javax.swing.*;

public class Cell extends JButton {

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
