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
    private final MatrixManager matrixManager = MatrixManager.getInstance();
    private List<Car> cars = new ArrayList();
    private Cell[][] cells;
    private List<Observer> observers = new ArrayList();
    private String threadMethodType;

    private FrameController() {
        try {
            this.matrixManager.print("malhas/malha-exemplo-1.txt");
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

    public void changeThreadMethodType(String opt) {
        this.threadMethodType = opt;
    }

    public String getThreadMethodType(){
        return threadMethodType;
    }

    public void start() {
        Car newCar = new Car(this);

        Integer[] pos;
        for (boolean checkFirstCell = false; !checkFirstCell; checkFirstCell = newCar.setFirstPosition(pos[0], pos[1])) {
            pos = this.getFirstCell();
        }

        this.cars.add(newCar);
        this.updateRoadView(newCar);
        newCar.start();
    }

    @Override
    public void stop() {

    }

    public void stopSimulation() {
        System.out.println("Finalizando..");
    }

    public MatrixManager getMatrixManager() {
        return this.matrixManager;
    }

    private void initRoadCells() {
        this.cells = matrixManager.getMatriz();
        List<Integer> stopCells = BaseRoad.getStopCells();

        int row = this.matrixManager.getRows();
        int col = this.matrixManager.getCols();

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (setLastCell(new Integer[]{i, j})) {
                    this.cells[i][j].setLastCell(true);
                }

                if (stopCells.contains(cells[i][j].getMoveType())) {
                    cells[i][j].setStopCell(true);
                }
            }
        }
    }

    private boolean setLastCell(Integer[] array) {
        for (Integer[] aValue :
                this.matrixManager.getExits()) {
            if (Arrays.equals(aValue, array)) {
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
        return this.matrixManager.getEntries().get(0);
    }

    public void updateRoadView(Car c) {
        int i = c.getRow();
        int j = c.getColumn();

        int moveType = this.matrixManager.getValueAtPosition(i, j);
        this.cells[i][j].setIcon(new ImageIcon(MoveType.getMoveType(moveType)));
        this.cells[i][j].setCar(c);

        notifyUpdate();
    }

    public void resetCarCell(Car c) {
        Cell cell = c.getCell();
        cell.reset();
    }

    public void notifyUpdate() {
        for (Observer observer : observers) {
            observer.updateCarPosition();
        }
    }

    public Cell getCellAtPosition(int row, int col) {
        return cells[row][col];
    }
}

 
