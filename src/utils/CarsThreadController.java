package utils;

import controller.FrameController;

public class CarsThreadController extends Thread {

    FrameController frameController = FrameController.getInstance();
    private int qtdCarros;
    private int timer;

    public void setQtdCarros(int qtdCarros) {
        this.qtdCarros = qtdCarros;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public int getTimer() {
        return timer * 1000;
    }

    @Override
    public void run() {
        for (int i = 0; i < qtdCarros; i++) {
            if (frameController.isStopped()) {
                break;
            }
            frameController.start();
            try {
                Thread.currentThread().sleep(getTimer());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
