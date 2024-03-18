package aragon.unam.compilador;

public class Lexico {
    private int indice = 0;
    private int entrada = -1;
    private int estado = 0;
    private int espacio = 0;
    private int error = -1;
    private int aceptacion = -1;

    private int[][] matrix;
    private String[] columnas;

    private String token;

    public Lexico(int[][] matrix, String[] columnas) {
        this.matrix = matrix;
        this.columnas = columnas;
    }

    public int inicio() throws Exception {
        char c = ' ';
        do {
        	estado = 0;
            c = siguienteCaracter();
            int entrada;

            // Verificar si el caracter es una letra o un dígito
            if (Herramientas.letra(c)) {
                entrada = encontrarEntrada('L');
            } else if (Herramientas.digito(c)) {
                entrada = encontrarEntrada('D');
            } else if (Herramientas.finCadena(c)) {
                entrada = 2; // Fin de cadena
                espacio++;
                if (espacio >= 0) {
                    error = 0;
                }
            } else {
                error = 0;
                throw new Exception("Caracter no válido: " + c);
            }
            
            if(entrada >= matrix[0].length) {
            	entrada--;
            } else if(entrada <= matrix[0].length) {
            	entrada++;
            }

            // Actualizar el estado basado en la matriz de transición
            estado = matrix[estado][entrada];

        } while (indice < token.length());

        // Verificar si el estado final es de aceptación (1)
        if (estado == 1) {
            aceptacion = 1;
        } else {
            aceptacion = -1;
        }
        return aceptacion;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private char siguienteCaracter() {
        char c = ' ';
        if (indice < token.length()) {
            c = token.charAt(indice);
            indice++;
        }
        return c;
    }

    private int encontrarEntrada(char caracter) {
        for (int i = 0; i < columnas.length; i++) {
            if (columnas[i].charAt(0) == caracter) {
                return i;
            }
        }
        return -1; // Caracter no encontrado en las columnas
    }
}