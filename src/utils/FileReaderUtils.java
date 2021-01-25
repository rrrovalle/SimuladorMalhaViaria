package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileReaderUtils {

    private static FileReaderUtils instance;

    private static String[] tamanho = new String[2];
    private static String[][] matriz;

    private FileReaderUtils() {
    }

    public static FileReaderUtils getInstance() {
    	if (instance == null) {
			instance = new FileReaderUtils();
		}
		return instance;
    }
    

    public static int getCols() {
        return Integer.parseInt(tamanho[1]);
    }

    public static int getRows() {
        return Integer.parseInt(tamanho[0]);
    }

    public static int getValueAtPosition(int row, int col) {
        return Integer.parseInt(matriz[row][col]);
    }

    public static boolean checkRoadPosition(int row, int col) {  
        return Integer.parseInt(matriz[row][col]) != 0;
    }

    public static void print(String file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));

        try {
            String line = br.readLine();
            tamanho[0] = line.split("\t")[0];
            line = br.readLine();
            tamanho[1] = line.split("\t")[0];

            matriz = new String[getRows()][getCols()];

            for (int i = 0; i < (Integer.parseInt(tamanho[0])); i++) {
                line = br.readLine();
                String[] colunas = line.split("\t");
                System.arraycopy(colunas, 0, matriz[i], 0, colunas.length);
            }

        } finally {
            br.close();
        }
    }

}
