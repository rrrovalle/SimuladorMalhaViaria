package model;
 
public class Car extends Thread{

    private int row;
    private int column;

    public Car(){

    }

    @Override
    public void run() {
        super.run();
        movimenta();
    }

    private void movimenta() {
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
}
