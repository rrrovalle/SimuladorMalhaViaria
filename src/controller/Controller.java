package controller;
import java.io.IOException;

public interface Controller {

		public void print() throws IOException;
		public void change(String opt); 
		public void run(int cars);
		public void stop();  
}
