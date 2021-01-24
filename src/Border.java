import javax.swing.*;
import java.awt.*; 
import java.io.IOException;

public class Border {

    JFrame f = new JFrame("Trabalho 2");

    Container menu = new Container();
    JButton btnStart = new JButton("START");
    JButton btnEnd = new JButton("END");

    String[] vector = {"Type 1", "Type 2"};
    JComboBox select = new JComboBox(vector);


    public Border() throws IOException {

        FileReaderUtils.print("malhas/malha-exemplo-2.txt");

        Road road = new Road();
        f.setSize(1200, 760);
        f.setLayout(new BorderLayout());

        menu.setLayout(new GridLayout(1, 4));
        menu.add(btnStart);
        menu.add(btnEnd);
        menu.add(select);
        f.add(menu, BorderLayout.NORTH);

        f.add(road, BorderLayout.CENTER);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true); 

    }

    public static void main(String[] args) throws IOException { 
        new Border();
    }
}
