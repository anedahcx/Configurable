package aragon.unam.compilador;

public class AFDConfig {
    private int[][] matrix;
    private String[] alfa;

    // recibe una cadena con la configuración y la procesa
    public AFDConfig(String config) {

   	String[] lineas = config.split("\n");
        
        // obtiene las dimensiones de la matriz
        String[] dim = lineas[0].split("\\s+");
        int filas = Integer.parseInt(dim[0]);
        int columnas = Integer.parseInt(dim[1]);
        matrix = new int[filas][columnas];

        // prrocesar la segunda línea para obtener el alfabeto
        if(dim.length > 1) {
        	alfa = lineas[1].split("\\s+");
        } else {
        	alfa = new String[0];
        }
        

        // para procesa las líneas restantes para llenar la matriz de transición
        for (int i = 2; i <= lineas.length; i++) {
            String[] elem = lineas[i].split("\\s+");
            int fila = Integer.parseInt(elem[0]);
            int columna = Integer.parseInt(elem[1]);
            int valor = Integer.parseInt(elem[2]);
            matrix[fila][columna] = valor;
        }
    }

    // matriz de transición
    public int[][] getMatrix() {
        return matrix;
    }

    // alfabeto
    public String[] getAlfa() {
        return alfa;
    }
}