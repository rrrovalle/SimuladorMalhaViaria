package utils;

import model.Cell;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatrixManager {

    private static MatrixManager instance;

    private final String[] tamanho = new String[2];
    private Cell[][] matriz;

    private static List<Integer[]> entries = new ArrayList<>();
    private static List<Integer[]> exits = new ArrayList<>();


    private MatrixManager() { }

    public static MatrixManager getInstance() {
        if (instance == null) {
            instance = new MatrixManager();
        }
        return instance;
    }

    public int getCols() {
        return Integer.parseInt(tamanho[1]);
    }

    public int getRows() {
        return Integer.parseInt(tamanho[0]);
    }

    public int getValueAtPosition(int row, int col) {
        return matriz[row][col].getMoveType();
    }

    public void print(String file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));

        try {
            String line = br.readLine();
            tamanho[0] = line.split("\t")[0];
            line = br.readLine();
            tamanho[1] = line.split("\t")[0];

            matriz = new Cell[getRows()][getCols()];

            for (int i = 0; i < getRows(); i++) {
                line = br.readLine();
                String[] colunas = line.split("\t");

                for(int j = 0; j < getCols(); j++){
                    matriz[i][j] = new Cell(Integer.parseInt(colunas[j]));
                }
            }

        } finally {
            br.close();
        }
    }

    public void findRowsEntriesAndExits() {
        for(int i = 0; i < this.getRows() - 1; ++i) {

            if (getValueAtPosition(i, 0) == 2) {
                entries.add(new Integer[]{i, 0});
            }else if(getValueAtPosition(i, 0) == 4) {
                exits.add(new Integer[]{i, 0});
            }

            if (getValueAtPosition(i, this.getCols() - 1) == 4) {
                entries.add(new Integer[]{i, this.getCols() - 1});
            }else if(getValueAtPosition(i, this.getCols() - 1) == 2){
                exits.add(new Integer[]{i, this.getCols() - 1});
            }
        }

    }

    public void findColumnsEntriesAndExits() {
        for(int i = 0; i < this.getCols(); ++i) {

            if (getValueAtPosition(0, i) == 3) {
                entries.add(new Integer[]{0, i});
            }else if(getValueAtPosition(0, i) == 1){
                exits.add(new Integer[]{0, i});
            }

            if (getValueAtPosition(this.getRows() - 1, i) == 1) {
                entries.add(new Integer[]{this.getRows() - 1, i});
            }else if(getValueAtPosition(this.getRows() - 1, i) == 3){
                exits.add(new Integer[]{this.getRows() - 1, i});
            }
        }
    }

    public void loadEntriesAndExits(){
        findRowsEntriesAndExits();
        findColumnsEntriesAndExits();
    }

    public Cell[][] getMatriz(){
        return matriz;
    }

    public List<Integer[]> getEntries() {
        return entries;
    }

    public List<Integer[]> getExits() {
        return exits;
    }

//    public void printEntries() {
//        for (Integer[] cord:
//                entries) {
//            for (int j = 0; j < cord.length; j++) {
//                System.out.print(cord[j] +  " ");
//
//            }
//            System.out.print(" , ");
//        }
//        System.out.println();
//    }
//
//    public void printExits() {
//        for (Integer[] cord:
//                exits) {
//            for (int j = 0; j < cord.length; j++) {
//                System.out.print(cord[j] +  " ");
//
//            }
//            System.out.print(" , ");
//        }
//        System.out.println();
//    }
}
