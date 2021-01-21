import javafx.scene.image.Image;

import javax.swing.*;
import java.awt.*;

public class Road extends JPanel {

    private ImageIcon roadV = new ImageIcon("roadv.jpg");
    private ImageIcon roadH = new ImageIcon("roadh.jpg");
    private int rows = FileReaderUtils.getRows();
    private int cols = FileReaderUtils.getCols();
    private JButton[][] cells = new JButton[rows][cols];

    public Road() {
        super();
        setLayout(new GridLayout(rows, cols));

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j] = new JButton();
                cells[i][j].setBackground(Color.black);
//                cells[i][j].setBorder(null);
                add(cells[i][j]);
            }

        }
//        for (int i = 0; i < 24; i++) {
//            cells[5][i].setIcon(roadV);
//            cells[4][i].setIcon(roadV);
//        }
//        for (int i = 0; i < 24; i++) {
//            cells[i][8].setIcon(roadH);
//            cells[i][9].setIcon(roadH);
//        }

    }

//    @Override
//    public void paint(Graphics g) {
//        super.paint(g);
//
//        g.setColor(Color.gray);
//        g.fillRect(0,480,getWidth(),50);
//        g.fillRect(0,520,getWidth(),50);
//        g.fillRect(480,0,50,getHeight());
//        g.fillRect(520,0,50,getHeight());
//
//
//    }
}
