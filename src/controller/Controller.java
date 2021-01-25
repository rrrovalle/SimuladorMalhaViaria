package controller;
import java.io.IOException;

public interface Controller {

		public void print() throws IOException;
		public void change(String opt);
		public void run();
		public void stop();  
}
