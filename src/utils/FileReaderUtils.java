package utils;

import model.Cell;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileReaderUtils {

    private static FileReaderUtils instance;

    private static final String[] tamanho = new String[2];
    private static Cell[][] matriz;

    private FileReaderUtils() {
    }

    public static FileReaderUtils getInstance() {
        if (instance == null) {
            instance = new FileReaderUtils();
        }
        return instance;
    }

    public int getCols() {
        return Integer.parseInt(tamanho[1]);
    }

    public int getRows() {
        return Integer.parseInt(tamanho[0]);
    }

    public static int getValueAtPosition(int row, int col) {
        return matriz[row][col].getMoveType();
    }

    public static Cell getCellAtPosition(int row, int col) {
        return matriz[row][col];
    }

    public static boolean checkRoadPosition(int row, int col) {
        return matriz[row][col].getMoveType() != 0;
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

}
