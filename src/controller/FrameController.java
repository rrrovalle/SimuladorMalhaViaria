package controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import model.Car;
import model.Cell;
import utils.MatrixManager;
 
public class FrameController implements Controller { 

    private static FrameController instance;
    private static MatrixManager matrixManager = MatrixManager.getInstance();
    private List<Car> cars = new ArrayList<>();


    private FrameController() { }

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
//    	matrixManagerUtils.print();
        matrixManager.print("malhas/malha-exemplo-3.txt");

    }
    
    @Override
    public void start(int n) {
        final int THREAD_NUM = n;

        matrixManager.findRowsEntries();
        matrixManager.findColumnsEntries();

        Integer[] pos;

        for (int i = 0; i < n; i++) {
            Car c = new Car();
            boolean test = false;
            while (!test){
                pos = getFirstCell();
                test = c.setFirstPosition(pos[0], pos[1]);

            }
            cars.add(c);
        }

        boolean terminou = true;

//        while (terminou){
//
//        }

    } 

    @Override
    public void stop() {
    	System.out.println("Finalizando..");
    }
    
    @Override
    public int getFileRows(){
        return matrixManager.getRows();
    }
    @Override
    public int getFileCols(){
        return matrixManager.getCols();
    }
    
    public Integer[] getFirstCell(){
        Collections.shuffle(matrixManager.getEntries());
        return matrixManager.getEntries().get(0);
    }



}
