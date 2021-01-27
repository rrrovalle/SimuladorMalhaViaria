package controller;
import java.io.IOException;

import utils.FileReaderUtils;
 
public class FrameController implements Controller { 

    private static FrameController instance;
    private static FileReaderUtils fileReader = FileReaderUtils.getInstance();

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
//    	FileReaderUtils.print();
        fileReader.print("malhas/malha-exemplo-3.txt");

    }
    
    @Override
    public void run(int cars) {

        System.out.println(cars);
    } 

    @Override
    public void stop() {
    	System.out.println("Finalizando..");
    }


    @Override
    public int getFileRows(){
        return fileReader.getRows();
    }
    @Override
    public int getFileCols(){
        return fileReader.getCols();
    }


}
