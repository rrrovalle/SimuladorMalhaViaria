package utils;

import controller.FrameController;

public class CarsThreadController extends Thread {

    FrameController frameController = FrameController.getInstance();
    int qtdCarros;

    public void setQtdCarros(int qtdCarros) {
        this.qtdCarros = qtdCarros;
    }

    @Override
    public void run(){
        for(int i=0; i < qtdCarros; i++){
            frameController.start();

            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
