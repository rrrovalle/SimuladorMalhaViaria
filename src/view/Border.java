package view;

import javax.swing.*;

import controller.Controller;
import controller.FrameController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class Border {

	JFrame f = new JFrame("Trabalho 2");
	
	private Controller controller;
	private Road road;
	Container menu;
	JButton btnStart;
	JButton btnEnd;

	JLabel lbVeiculos;
	JSpinner numeroVeiculos;

	String[] vector = {"Semaforo", "Monitor"};
	JComboBox<String> select;

    public Border() throws IOException {
    	controller = FrameController.getInstance();
        controller.print();
        
        road = new Road();
        f.setSize(1200, 760);
        f.setLayout(new BorderLayout());

        //Menu components
        menu = new Container();

        btnStart = new JButton("START"); 

        btnEnd = new JButton("END"); 

        select = new JComboBox(vector); 

        lbVeiculos = new JLabel("Numero de veículos: ");
        numeroVeiculos = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));

        menu.setLayout(new FlowLayout());

        //Add components to menu
        menu.add(btnStart);
        btnStart.addActionListener((ActionEvent e) -> {
        	String value = numeroVeiculos.getValue() + ""; 
        	int cars = Integer.parseInt(value);
        	controller.run(cars);
        });
        
        menu.add(btnEnd);
        btnEnd.addActionListener((ActionEvent e) -> {
        	controller.stop();
        });
        
        menu.add(select);
        select.addActionListener((ActionEvent e) -> {
        	String resultado = (String) select.getSelectedItem();
        	controller.change(resultado);
        });
        
        menu.add(lbVeiculos);
        menu.add(numeroVeiculos);  

        //Add components to frame layout
        f.add(menu, BorderLayout.NORTH);
        f.add(road, BorderLayout.CENTER);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
