package view;

import javax.swing.*;

import model.Cell;
import utils.FileReaderUtils;

import java.awt.*;

public class Road extends JPanel {

//    private int rows = FileReaderUtils.getRows();
//    private int cols = FileReaderUtils.getCols();
//    private JButton[][] cells = new JButton[rows][cols];

    private int rows;
    private int cols;
    private Cell[][] cells;
//    private List<Vehicle> vehiclesList;

    public Road(int rows, int cols) {
        super();
        this.rows = rows;
        this.cols = cols;
        this.cells = new Cell[rows][cols];
        setLayout(new GridLayout(rows, cols));

        initializeComponents();
    }

    private void initializeComponents() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (FileReaderUtils.checkRoadPosition(i, j)) {
                    createRoad(i, j);
                } else {
                    createBackground(i, j);
                }
            }
        }
    }

    private void createBackground(int i, int j) {
        int x = FileReaderUtils.getValueAtPosition(i, j);
        cells[i][j] = new Cell(x);
        cells[i][j].setBackground(Color.black); 
        add(cells[i][j]);
    }

    private void createRoad(int i, int j) {
        int x = FileReaderUtils.getValueAtPosition(i, j);
        ImageIcon photo = new ImageIcon(BaseRoad.getRoadType(x));
        cells[i][j] = new Cell(x);
        cells[i][j].setIcon(photo);
        add(cells[i][j]);
    }
}
