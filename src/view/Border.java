package view;

import javax.swing.*;

import controller.Controller;
import controller.FrameController;
import utils.CarsThreadController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class Border extends JFrame {

    private Controller controller;
    private CarsThreadController carsThreadController = new CarsThreadController();
    private Road road;
    Container menu;
    JButton btnStart;
    JButton btnEnd;

    JLabel lbVeiculos;
    JSpinner numeroVeiculos;

    String[] vector = {"","Semaforo", "Monitor"};
    JComboBox<String> select;

    public Border() throws IOException {

        controller = FrameController.getInstance();

        this.setSize(1200, 960);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        road = new Road();

        //Menu components
        menu = new Container();

        btnStart = new JButton("START");
        btnStart.addActionListener((ActionEvent e) -> {
            String value = numeroVeiculos.getValue() + "";
            int cars = Integer.parseInt(value);
            carsThreadController.setQtdCarros(cars);
            carsThreadController.start();
        });

        btnEnd = new JButton("END");
        btnEnd.addActionListener((ActionEvent e) -> {
            controller.stop();
        });

        select = new JComboBox(vector);
        select.addActionListener((ActionEvent e) -> {
            String resultado = (String) select.getSelectedItem();
            controller.changeThreadMethodType(resultado);
        });

        lbVeiculos = new JLabel("Numero de veículos: ");
        numeroVeiculos = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));

        menu.setLayout(new FlowLayout());

        //Add components to menu
        menu.add(btnStart);
        menu.add(btnEnd);
        menu.add(select);
        menu.add(lbVeiculos);
        menu.add(numeroVeiculos);

        //Add components to frame layout
        this.add(menu, BorderLayout.NORTH);
        this.add(road, BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

//        this.pack();
    }

}
