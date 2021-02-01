package model;

import javax.swing.*;

public class Cell {

    private boolean containsCar;
    private boolean stopCell;
    private boolean lastCell;
    private int moveType;
    private Icon icon;
    private Car car;
<<<<<<< Updated upstream
//    private boolean lastCell;
    // referencia do carro
    // referencia de celula final
=======

>>>>>>> Stashed changes

    public Cell(int moveType){
        this.containsCar = false;
        this.stopCell = false;
        this.lastCell = false;
        this.moveType = moveType;
    }

    public boolean containsCar() {
        return containsCar;
    }

    public void setContainsCar(boolean containsCar) {
        this.containsCar = containsCar;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car c) {
        this.setContainsCar(true);
        this.car = c;
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

    public boolean isStopCell() {
        return stopCell;
    }

    public void setStopCell(boolean stopCell) {
        this.stopCell = stopCell;
    }

    public boolean isLastCell() {
        return lastCell;
    }

    public void setLastCell(boolean lastCell) {
        this.lastCell = lastCell;
    }
}
