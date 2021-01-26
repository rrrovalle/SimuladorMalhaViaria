package controller;
import java.io.IOException;

import utils.FileReaderUtils;
 
public class FrameController implements Controller { 

    private static FrameController instance;
	
    public static FrameController getInstance() {
    	if (instance == null) {
			instance = new FrameController();
		}
		return instance;
    }  
    
    @Override
    public void change(String opt) {
    	if(opt.equals("Semaforos")) { 
        	System.out.println("Trocando m�todo para sem�foros..");
    	} else if(opt.equals("Monitores")) {
    		System.out.println("Trocando m�todo para monitores..");
    	}
    }
    
    @Override
    public void print() throws IOException {
    	FileReaderUtils.print("malhas/malha-exemplo-3.txt");
    }
    
    @Override
    public void run(int cars) { 
    	System.out.println(cars);
    } 

    @Override
    public void stop() {
    	System.out.println("Finalizando..");
    }
}