package aragon.unam.compilador;

public class AFDConfig {
    private int[][] matrix;
    private String[] alfa;

    public AFDConfig(String[] lineas) {
        String[] dim = lineas[0].split("\\s+");
        int filas = Integer.parseInt(dim[0]);
        int columnas = Integer.parseInt(dim[1]);
        matrix = new int[filas][columnas];

        if (lineas.length > 1) {
            alfa = lineas[1].split("\\s+");
        } else {
            alfa = new String[0];
        }

        for (int i = 2; i < lineas.length; i++) { // Cambiado a < en lugar de <=
            String[] elem = lineas[i].split("\\s+");
            int fila = Integer.parseInt(elem[0]);
            int columna = Integer.parseInt(elem[1]);
            int valor = Integer.parseInt(elem[2]);
            matrix[fila][columna] = valor;
        }
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public String[] getAlfa() {
        return alfa;
    }
}