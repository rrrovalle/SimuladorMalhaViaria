package controller;
import java.io.IOException;

public interface Controller {

		public void print() throws IOException;
		public int getFileRows();
		public int getFileCols();
		public void changeMethodType(String opt);
		public void run(int cars);
		public void stop();  
}
