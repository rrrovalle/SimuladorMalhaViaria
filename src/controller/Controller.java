package controller;

public interface Controller {
	
	public void changeMethodType(String var1);

	public void start(int var1) throws InterruptedException;

	public void stop();

	public void notifyUpdate();
}
