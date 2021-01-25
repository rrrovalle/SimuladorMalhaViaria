import java.io.IOException;
 
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
        	System.out.println("Trocando método para semáforos..");
    	} else if(opt.equals("Monitores")) {
    		System.out.println("Trocando método para monitores..");
    	}
    }
    
    @Override
    public void print() throws IOException {
    	FileReaderUtils.print("malhas/malha-exemplo-2.txt");
    }
    
    @Override
    public void run() { 
    	System.out.println("Iniciando..");
    } 

    @Override
    public void stop() {
    	System.out.println("Finalizando..");
    }
}
