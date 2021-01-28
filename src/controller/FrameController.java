package controller;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    private FrameController() {
        matrixManager = MatrixManager.getInstance();
        try {
            matrixManager.print("malhas/malha-exemplo-3.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        cells = new Cell[matrixManager.getRows()][matrixManager.getCols()];
    }

    public static FrameController getInstance() {
    	if (instance == null) {
			instance = new FrameController();
		}
		return instance;
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
    public void print() throws IOException {
        matrixManager.print("malhas/malha-exemplo-3.txt");

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


    public JButton renderBackground(int i, int j) {
        int x = matrixManager.getValueAtPosition(i, j);
        cells[i][j] = new Cell(x);
        cells[i][j].setBackground(Color.black);
        cells[i][j].setEnabled(false);
        cells[i][j].setBorderPainted(false);
        return cells[i][j];
    }

    public JButton renderRoad(int i, int j) {
        int x = matrixManager.getValueAtPosition(i, j);
        ImageIcon photo = new ImageIcon(BaseRoad.getRoadType(x));
        cells[i][j] = new Cell(x);
        cells[i][j].setIcon(photo);
        cells[i][j].setBorderPainted(false);
        return cells[i][j];
    }

}
