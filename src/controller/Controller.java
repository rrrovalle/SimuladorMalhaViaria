package controller;

import controller.observer.Observer;
import utils.MatrixManager;
import view.Road;

import javax.swing.*;

public interface Controller {
	
	public void changeThreadMethodType(String var1);

	public void start() ;

	public void stop();

	public void notifyUpdate();

	public void attach(Observer obs);

	public MatrixManager getMatrixManager();

	public Icon renderCell(int row, int col);
}
