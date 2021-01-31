package controller;

import controller.observer.Observer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import model.Car;
import model.Cell;
import model.MoveType;
import utils.MatrixManager;
import view.BaseRoad;

public class FrameController implements Controller {
    private static FrameController instance;
    private MatrixManager matrixManager = MatrixManager.getInstance();
    private List<Car> cars = new ArrayList();
    private Cell[][] cells;
    private List<Observer> observers = new ArrayList();

    private FrameController() {
        try {
            this.matrixManager.print("malhas/malha-exemplo-2.txt");
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

    public void start(int n) {
        matrixManager.loadEntries();
        for(int i = 0; i < n; ++i) {
            Car newCar = new Car();

            Integer[] pos;
            for(boolean checkFirstCell = false; !checkFirstCell; checkFirstCell = newCar.setFirstPosition(pos[0], pos[1])) {
                pos = this.getFirstCell();
            }

            this.cars.add(newCar);
            this.addCarToRoadView(newCar);
        }

    }

    public void stop() {
        System.out.println("Finalizando..");
    }

    public MatrixManager getMatrixManager() {
        return this.matrixManager;
    }

    public Integer[] getFirstCell() {
        Collections.shuffle(this.matrixManager.getEntries());
        return (Integer[])this.matrixManager.getEntries().get(0);
    }

    private void initRoadCells() {
        this.cells = new Cell[this.matrixManager.getRows()][this.matrixManager.getCols()];

        for(int i = 0; i < this.matrixManager.getRows(); ++i) {
            for(int j = 0; j < this.matrixManager.getCols(); ++j) {
                int moveType = this.matrixManager.getValueAtPosition(i, j);
                this.cells[i][j] = new Cell(moveType);
                this.cells[i][j].setIcon(new ImageIcon(BaseRoad.getRoadType(moveType)));
            }
        }
    }

    public Icon renderCell(int row, int col) {
        return this.cells[row][col].getIcon();
    }

    public void addCarToRoadView(Car c) {
        int i = c.getRow();
        int j = c.getColumn();

        int moveType = this.matrixManager.getValueAtPosition(i, j);
        this.cells[i][j].setIcon(new ImageIcon(MoveType.getMoveType(moveType)));
        this.cells[i][j].setCar(c);

        notifyUpdate();
    }

    public void notifyUpdate() {
        for (Observer observer : observers) {
            observer.updateCarPosition();
        }
    }
}

 
