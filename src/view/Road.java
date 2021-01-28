package view;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import controller.FrameController;
import model.Cell;
import utils.MatrixManager;

import java.awt.*;

public class Road extends JPanel {

    private int rows;
    private int cols;

    private FrameController fc;


    public Road() {
        super();

        fc = FrameController.getInstance();

        this.rows = fc.getMatrixManager().getRows();
        this.cols = fc.getMatrixManager().getCols();

        setLayout(new GridLayout(rows, cols));

        paintRoad();
    }

    private void paintRoad() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (fc.getMatrixManager().checkRoadPosition(i, j)) {
//                    createRoad(i, j);
                    add(fc.renderRoad(i, j));
                } else {
//                    createBackground(i, j);
                    add(fc.renderBackground(i, j));
                }
            }
        }
    }

//    private void createBackground(int i, int j) {
//        int x = fc.getMatrixManager().getValueAtPosition(i, j);
//        cells[i][j] = new Cell(x);
//        cells[i][j].setBackground(Color.black);
//        cells[i][j].setEnabled(false);
//        cells[i][j].setBorderPainted(false);
//        add(cells[i][j]);
//    }
//
//    private void createRoad(int i, int j) {
//        int x = fc.getMatrixManager().getValueAtPosition(i, j);
//        ImageIcon photo = new ImageIcon(BaseRoad.getRoadType(x));
//        cells[i][j] = new Cell(x);
//        cells[i][j].setIcon(photo);
////        cells[i][j].setEnabled(false);
////        cells[i][j].setBorderPainted(false);
//        add(cells[i][j]);
//    }
}
