package controller;

import controller.observer.Observer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import model.Car;
import model.Cell;
import model.MoveType;
import utils.MatrixManager;
import model.BaseRoad;

public class FrameController implements Controller {

    private static FrameController instance;
    private MatrixManager matrixManager = MatrixManager.getInstance();
    private List<Car> cars = new ArrayList();
    private Cell[][] cells;
    private List<Observer> observers = new ArrayList();


    private FrameController() {
        try {
            this.matrixManager.print("malhas/malha-exemplo-2.txt");
            this.matrixManager.loadEntriesAndExits();
        } catch (IOException var2) {
            var2.printStackTrace();
        }

        this.initRoadCells();
    }

    public static FrameController getInstance() {
        if (instance == null) {
            instance = new FrameController();
        }

        return instance;
    }

    public void attach(Observer obs) {
        this.observers.add(obs);
    }

    public void detach(Observer obs) {
        this.observers.remove(obs);
    }

    public void changeMethodType(String opt) {
        if (opt.equals("Semaforos")) {
            System.out.println("Trocando metodo para semaforos..");
        } else if (opt.equals("Monitores")) {
            System.out.println("Trocando metodo para monitores..");
        }

    }

    public void start(int n) throws InterruptedException {

//        matrixManager.printEntries();
//        System.out.println("======================================================================");
//        matrixManager.printExits();

        for(int i = 0; i < n; ++i) {
            Car newCar = new Car();

            Integer[] pos;
            for(boolean checkFirstCell = false; !checkFirstCell; checkFirstCell = newCar.setFirstPosition(pos[0], pos[1])) {
                pos = this.getFirstCell();
            }

            this.cars.add(newCar);
            this.addCarToRoadView(newCar);
        }

        for (Car c :
                cars) {
            resetCarCell(c);
            c.run();
            addCarToRoadView(c);
        }

    }

    public void stop() {
        System.out.println("Finalizando..");
    }

    public MatrixManager getMatrixManager() {
        return this.matrixManager;
    }

    private void initRoadCells() {
        this.cells = new Cell[this.matrixManager.getRows()][this.matrixManager.getCols()];
        List<Integer> stopCells = BaseRoad.getStopCells();

        int row = this.matrixManager.getRows();
        int col = this.matrixManager.getCols();

        for(int i = 0; i < row; ++i) {
            for(int j = 0; j < col; ++j) {
                int moveType = this.matrixManager.getValueAtPosition(i, j);
                this.cells[i][j] = new Cell(moveType);
                this.cells[i][j].setIcon(new ImageIcon(BaseRoad.getRoadType(moveType)));
                if(setLastCell(new Integer[]{i,j})){
                    this.cells[i][j].setLastCell(true);
                }
                // compara o valor da celula com os valores de uma lista de celulas do tipo cruzamento.
                for (int value: stopCells) {
                    if(cells[i][j].getMoveType() == value){
                        cells[i][j].setStopCell(true);
                    }
                }
            }
        }
    }

    private boolean setLastCell(Integer[] array) {
        for (Integer[] a :
                this.matrixManager.getExits()) {
            if(Arrays.equals(a, array)){
                return true;
            }
        }
        return false;
    }

    public Icon renderCell(int row, int col) {
        return this.cells[row][col].getIcon();
    }

    private Integer[] getFirstCell() {
        Collections.shuffle(this.matrixManager.getEntries());
        return (Integer[])this.matrixManager.getEntries().get(0);
    }

    private void addCarToRoadView(Car c) {
        int i = c.getRow();
        int j = c.getColumn();

        int moveType = this.matrixManager.getValueAtPosition(i, j);
//        this.cells[i][j] = new Cell(moveType); //acho que não é necessario recriar as cell, so referenciar o carro e automaticamente ele atualzia que containsCar = true
        this.cells[i][j].setIcon(new ImageIcon(MoveType.getMoveType(moveType)));
        this.cells[i][j].setCar(c);

        notifyUpdate();
    }

    public void resetCarCell(Car c){
        System.out.println(c.getRow()+","+c.getColumn());
        int moveType = this.matrixManager.getValueAtPosition(c.getRow(), c.getColumn());
        this.cells[c.getRow()][c.getColumn()].reset();
        this.cells[c.getRow()][c.getColumn()].setIcon(new ImageIcon(BaseRoad.getRoadType(moveType)));
    }

    public void notifyUpdate() {
        for (Observer observer : observers) {
            observer.updateCarPosition();
        }
    }
}

 
