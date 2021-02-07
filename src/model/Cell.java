package model;

import javax.swing.*;

public class Cell {

    private boolean containsCar;
    private boolean stopCell;
    private boolean lastCell;

    private int row;
    private int column;

    private int moveType;
    private Icon icon;
    private Car car;


    public Cell(int moveType, int row, int column){
        this.containsCar = false;
        this.stopCell = false;
        this.lastCell = false;
        this.row = row;
        this.column = column;
        this.moveType = moveType;
        this.icon = new ImageIcon(BaseRoad.getRoadType(moveType));
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

    public Car getCar() {
        return car;
    }

    public void setCar(Car c) {
        this.setContainsCar(true);
        this.car = c;
    }

    public void reset(){
        this.setIcon(new ImageIcon(BaseRoad.getRoadType(moveType)));
        this.setContainsCar(false);
        this.car = null;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
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
