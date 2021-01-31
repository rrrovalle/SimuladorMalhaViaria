package model;

import utils.MatrixManager;

import java.util.Random;

public class Car extends Thread{

    private int row;
    private int column;
    private int speed;

    public Car(){
        setSpeed();
    }

    @Override
    public void run() {
        super.run();
//        if (checkCell()){
//            System.out.println("ultima celula");
//        }else {
//            movimenta();
//        }
    }

    private boolean checkCell() {
        return false;
    }

    private void movimenta() {
        System.out.println("Carro: " + toString() + " andou.");
        //se andar H -> row=row e column=column+1
        //se andar V -> row=row+1 e column=column
        //se andar H -> row=row+1 e column=column
        //se andar V -> row=row+1 e column=column

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

    public void setSpeed(){
        Random random = new Random();
        this.speed = random.nextInt((100) + 1) + 10;
    }

    public int getSpeed(){ //timesleep para a thread
        return speed;
    }

    public boolean setFirstPosition(Integer row, Integer col) {
        Cell cell = MatrixManager.getInstance().getCellAtPosition(row, col);
        if(cell.containsCar()){
            System.out.println("Vaga ocupada");
           return false;

        }else{
            cell.setContainsCar(true);
            setRow(row);
            setRow(col);
            System.out.println("inserido");
            return true;
        }
    }
}
