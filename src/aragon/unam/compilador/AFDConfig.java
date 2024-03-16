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
        
        //carga
        for (int c = 2; c < lineas.length; c++) {
            String[] elem = lineas[c].split("\\s+");
            for (int f = 0; f < elem.length; f++) {
                matrix[c - 2][f] = Integer.parseInt(elem[f]);
            }
        }
        
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public String[] getAlfa() {
        return alfa;
    }
}