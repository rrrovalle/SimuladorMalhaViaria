package controller;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import controller.observer.Observer;
import model.Car;
import model.Cell;
import utils.MatrixManager;
import view.BaseRoad;

import javax.swing.*;

public class FrameController implements Controller { 

    private static FrameController instance;

    private MatrixManager matrixManager;
    private List<Car> cars = new ArrayList<>();
    private Cell[][] cells;

    private List<Observer> observers = new ArrayList<>();

    private FrameController() {
        matrixManager = MatrixManager.getInstance();
        try {
            matrixManager.print("malhas/malha-exemplo-3.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        initRoadCells();
    }

    public static FrameController getInstance() {
    	if (instance == null) {
			instance = new FrameController();
		}
		return instance;
    }

    public void attach(Observer obs) {
        observers.add(obs);
    }

    public void detach(Observer obs) {
        observers.remove(obs);
    }

    @Override //talvez adicionar uma logica usando strategy
    public void changeMethodType(String opt) {
    	if(opt.equals("Semaforos")) { 
        	System.out.println("Trocando metodo para semaforos..");
    	} else if(opt.equals("Monitores")) {
    		System.out.println("Trocando metodo para monitores..");
    	}
    }

    @Override
    public void start(int n) {

        matrixManager.findRowsEntries();
        matrixManager.findColumnsEntries();

        Integer[] pos;

        for (int i = 0; i < n; i++) {
            Car newCar = new Car();
            boolean checkFirstCell = false;
            while (!checkFirstCell){
                pos = getFirstCell();
                checkFirstCell = newCar.setFirstPosition(pos[0], pos[1]);

            }
            cars.add(newCar);
            for (Car c :
                    cars) {
                System.out.println(c.getRow() + " - " + c.getColumn());

            }
        }


    } 

    @Override
    public void stop() {
    	System.out.println("Finalizando..");
    }

    public MatrixManager getMatrixManager() {
        return matrixManager;
    }

    public Integer[] getFirstCell(){
        Collections.shuffle(matrixManager.getEntries());
        return matrixManager.getEntries().get(0);
    }

    private void initRoadCells() {
        cells = new Cell[matrixManager.getRows()][matrixManager.getCols()];

        for (int i = 0; i < matrixManager.getRows(); i++) {
            for (int j = 0; j < matrixManager.getCols(); j++) {
                int moveType = matrixManager.getValueAtPosition(i, j);
                cells[i][j] = new Cell(moveType);
                cells[i][j].setIcon(new ImageIcon(BaseRoad.getRoadType(moveType)));
            }
        }
    }

    public Icon renderCell(int row, int col){
        return cells[row][col].getIcon();
    }


}
