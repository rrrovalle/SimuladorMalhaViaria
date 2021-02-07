package model;

import controller.FrameController;
import controller.observer.Observer;
import utils.MatrixManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Car extends Thread {

    private int row;
    private int column;
    private int speed;
    private boolean outOfRoad = false;
    private final FrameController frameController;
    private final MatrixManager matrixManager = MatrixManager.getInstance();
    private boolean estaNoCruzamento = false;

    private Cell cell;
    private Cell nextCell = new Cell(0, 0, 0);
    private Cell saidaCruzamento;

    public Car(FrameController frameController) {
        this.frameController = frameController;
        setSpeed();
    }

    @Override
    public void run() {
        super.run();

        while (!outOfRoad) {
            try {
                Thread.currentThread().sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (checkLastCell()) {
                System.out.println("ultima celula");
                outOfRoad = true;
            } else if (nextCell.isStopCell() || estaNoCruzamento) {
                verificaCruzamento();
            } else if (!nextCell.containsCar()) {
                movimenta();
            }
        }
    }

    //O verifica cruzamento é uma região crítica. Não pode acontecer de o carro ver o espaço vazio à sua frente,
    // e aí perder o processador por um instante, e quando o carro for tentar se mover o espaço na verdade não está vazio.
    private void verificaCruzamento() {
        if(saidaCruzamento == null) {
            List<Cell> saidasCruzamento = new ArrayList<>();

            Cell cell = nextCell;

            // For responsável por passar pelas 4 células do cruzamento
            for (int i = 0; i < 4; i++) {
                int moveType = cell.getMoveType();
                cell = getNextCell(cell);

                switch (moveType) {
                    case 9:
                        //adiciona saída na lista
                        break;
                    case 10:
                        //adiciona saída na lista
                        break;
                    case 11:
                        //adiciona saída na lista
                        break;
                    case 12:
                        //adiciona saída na lista
                        break;
                }
            }

            estaNoCruzamento = true;
            Collections.shuffle(saidasCruzamento);
            saidaCruzamento = saidasCruzamento.get(0);
        } else {
//            movimenta();
//            Aqui movimentaremos o carro e procuraremos pela saída quando ele já estiver dentro do cruzamento
        }
    }

    private boolean checkLastCell() {
        return cell.isLastCell();
    }

    private void movimenta() {
        int moveType = MatrixManager.getInstance().getValueAtPosition(this.getRow(), this.getColumn());

        switch (moveType) {
            case 1:
                this.setRow(this.getRow() - 1);
                this.setColumn(this.getColumn());
                this.nextCell = frameController.getCellAtPosition(this.getRow() - 1, this.getColumn());
                break;
            case 2:
                this.setRow(this.getRow());
                this.setColumn(this.getColumn() + 1);
                this.nextCell = frameController.getCellAtPosition(this.getRow(), this.getColumn() + 1);
                break;
            case 3:
                this.setRow(this.getRow() + 1);
                this.setColumn(this.getColumn());
                this.nextCell = frameController.getCellAtPosition(this.getRow() + 1, this.getColumn());
                break;
            case 4:
                this.setRow(this.getRow());
                this.setColumn(this.getColumn() - 1);
                this.nextCell = frameController.getCellAtPosition(this.getRow(), this.getColumn() - 1);
                break;
            default:
                break;
        }
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setSpeed() {
//        Random random = new Random();
        this.speed = 1000;
    }

    public int getSpeed() { //timesleep para a thread
        return speed;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public boolean setFirstPosition(Integer row, Integer col) {
        Cell cell = frameController.getCellAtPosition(row, col);
        this.setCell(cell);
        if (cell.containsCar()) {
            System.out.println("Vaga ocupada");
            return false;

        } else {
            cell.setContainsCar(true);
            setRow(row);
            setColumn(col);
            System.out.println("inserido em:" + row + "," + col);
            return true;
        }
    }

    // Para este método precisaremos colocar as posições nas célular. Ele retorna a próxima célula em relação a uma célula qualquer,
    // e vai ser usado para mapearmos o cruzamento sem precisar mover o carro..
    private Cell getNextCell(Cell cell) {
        int moveType;

        if (cell.getMoveType() > 4 && cell.getMoveType() <= 8) {
            moveType = cell.getMoveType() - 4;
        } else if (cell.getMoveType() > 8) {
            moveType = cell.getMoveType() - 8;
        } else {
            moveType = cell.getMoveType();
        }

        switch (moveType) {
            case 1:
                this.setRow(this.getRow() - 1);
                this.setColumn(this.getColumn());
                this.nextCell = frameController.getCellAtPosition(this.getRow() - 1, this.getColumn());
                break;
            case 2:
                this.setRow(this.getRow());
                this.setColumn(this.getColumn() + 1);
                this.nextCell = frameController.getCellAtPosition(this.getRow(), this.getColumn() + 1);
                break;
            case 3:
                this.setRow(this.getRow() + 1);
                this.setColumn(this.getColumn());
                this.nextCell = frameController.getCellAtPosition(this.getRow() + 1, this.getColumn());
                break;
            case 4:
                this.setRow(this.getRow());
                this.setColumn(this.getColumn() - 1);
                this.nextCell = frameController.getCellAtPosition(this.getRow(), this.getColumn() - 1);
                break;
            default:
                break;
        }

    }
}
