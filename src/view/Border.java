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
    Container menu = new Container();
    JButton btnStart = new JButton("START");
    JButton btnEnd = new JButton("END");

    String[] vector = {"Semaforos", "Monitores"}; 
	JComboBox select = new JComboBox(vector); 

    public Border() throws IOException {
    	controller = FrameController.getInstance();
        controller.print();

        Road road = new Road();
        f.setSize(1200, 760);
        f.setLayout(new BorderLayout());

        menu.setLayout(new GridLayout(1, 4));
        menu.add(btnStart);
        
        btnStart.addActionListener((ActionEvent e) -> {
        	controller.run();
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
        
        f.add(menu, BorderLayout.NORTH); 
        f.add(road, BorderLayout.CENTER);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);  
    }
}
