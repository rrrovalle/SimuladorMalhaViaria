
import javax.swing.*;
import java.awt.*;

public class Road extends JPanel {

    private int rows = FileReaderUtils.getRows();
    private int cols = FileReaderUtils.getCols();
    private JButton[][] cells = new JButton[rows][cols];

    public Road() {
        super();
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
        cells[i][j] = new JButton();
        cells[i][j].setBackground(Color.black); 
        add(cells[i][j]);
    }

    private void createRoad(int i, int j) { 
        ImageIcon photo = new ImageIcon(BaseRoad.getRoadType(FileReaderUtils.getValueAtPosition(i, j)));
        cells[i][j] = new JButton();
        cells[i][j].setIcon(photo);
        add(cells[i][j]);
    }
}
