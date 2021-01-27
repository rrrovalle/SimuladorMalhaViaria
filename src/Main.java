import java.io.IOException;
import java.awt.EventQueue;
import view.Border;

public class Main { 

    public static void main(String[] args)  {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                Border tela;
                try {
                    tela = new Border();
                    tela.setVisible(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
