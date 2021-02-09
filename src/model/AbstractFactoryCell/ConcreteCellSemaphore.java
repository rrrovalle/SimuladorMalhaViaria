package model.AbstractFactoryCell;

import model.BaseRoad;
import model.Car;

import javax.swing.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class ConcreteCellSemaphore extends AbstractCell {

    Semaphore mutex = new Semaphore(1);

    public ConcreteCellSemaphore(int moveType, int row, int column) {
        this.stopCell = false;
        this.lastCell = false;
        this.row = row;
        this.column = column;
        this.moveType = moveType;
        this.icon = new ImageIcon(BaseRoad.getRoadType(moveType));
    }

    public int getMoveType() {
        return moveType;
    }

    public Car getCar() {
        return car;
    }

    public boolean setCarToIntersection(Car c) {
        try {
            if (mutex.tryAcquire(c.getSpeed(), TimeUnit.MILLISECONDS)) {
                this.car = c;
                return true;
            }
            return false;
        } catch (InterruptedException e) {
            return false;
        }
    }

    public void setCar(Car c) {
        try {
            mutex.acquire();
            this.car = c;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void reset() {
        this.setIcon(new ImageIcon(BaseRoad.getRoadType(moveType)));
        this.car = null;
        mutex.release();
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
