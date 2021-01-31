package model;

import javax.swing.*;

public class Cell {

    private boolean containsCar;
    private int moveType;
    private Icon icon;
    private Car c;
//    private boolean lastCell;
    // referencia do carro
    // referencia de celula final

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

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }
}
