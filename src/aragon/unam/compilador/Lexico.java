package aragon.unam.compilador;

public class Lexico {

    private int indice = 0;
    private int error = -1;
    private int aceptar = 1;

    private int estado = 0;
    private int entrada = 0;

    private int[][] matrix;

    private String token;

    public Lexico(int[][] matrix) {
        this.matrix = matrix;
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

    public int inicio() throws Exception {
        char c = ' ';
        do {
            c = siguienteCaracter();
            if (Herramientas.letra(c)) {
                entrada = 0;
            } else if (Herramientas.digito(c)) {
                entrada = 1;
            } else if (Herramientas.finCadena(c)) {
                entrada = 2;
            } else {
                error = 0;
            }
            if (error != 0) {
                estado = matrix[estado][entrada];
            } else {
                throw new Exception("Palabra no valida");
            }
        } while (!Herramientas.finCadena(c));
        return estado;
    }
}