package model.AbstractFactoryCell;

import model.BaseRoad;
import model.Car;

import javax.swing.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcreteCellMonitor extends AbstractCell {

    private final Lock lockCell = new ReentrantLock();

    public ConcreteCellMonitor(int moveType, int row, int column) {
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
            if (lockCell.tryLock(c.getSpeed(), TimeUnit.MILLISECONDS)) {
                this.car = c;
                return true;
            }
            return false;
        } catch (InterruptedException e) {
            return false;
        }
    }

    public void setCar(Car c) {
        lockCell.lock();
        this.car = c;
    }

    public void reset() {
        this.setIcon(new ImageIcon(BaseRoad.getRoadType(moveType)));
        this.car = null;
        lockCell.unlock();
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
