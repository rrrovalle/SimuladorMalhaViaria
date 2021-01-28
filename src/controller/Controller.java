package controller;
import java.io.IOException;

public interface Controller {

		public void print() throws IOException;
		public int getFileRows();
		public int getFileCols();
		public void changeMethodType(String opt);
		public void start(int i);
		public void stop();  
}
