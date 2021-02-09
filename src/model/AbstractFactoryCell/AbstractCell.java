package model.AbstractFactoryCell;

import model.BaseRoad;
import model.Car;

import javax.swing.*;

public abstract class AbstractCell {

    protected boolean stopCell;
    protected boolean lastCell;

    protected int row;
    protected int column;

    protected int moveType;
    protected Icon icon;
    protected Car car;

    public abstract int getMoveType();

    public abstract Car getCar();

    public abstract boolean setCarToIntersection(Car c);

    public abstract void setCar(Car c);

    public abstract void reset();

    public abstract int getRow();

    public abstract void setRow(int row);

    public abstract int getColumn();

    public abstract void setColumn(int column);

    public abstract Icon getIcon();

    public abstract void setIcon(ImageIcon icon);

    public abstract boolean isStopCell();

    public abstract void setStopCell(boolean stopCell);

    public abstract boolean isLastCell();

    public abstract void setLastCell(boolean lastCell);

}
