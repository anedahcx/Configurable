package aragon.unam.compilador;

import javax.swing.*;

public class Inicio {
    public static void main(String[] args) {
        Lector lector = new Lector();
        String[] config = lector.leerArchivo("fuente.txt");
        
        if (config != null) {
        	AFDConfig configurable = new AFDConfig(config);
            int[][] matrix = configurable.getMatrix();
            String[] columnasAlfa = configurable.getAlfa();
            
//        	// almacenar la configuración
//            AFDConfig configurable = new AFDConfig(config);
//            // obtiene la matriz
//            int[][] matrix = configurable.getMatrix();
            
            Lexico app = new Lexico(matrix, columnasAlfa);
            app.setToken(JOptionPane.showInputDialog("INGRESE LA PALABRA A ACEPTAR"));
            
            try {
                int verifica = app.inicio();
                if (verifica == 1) {
                    System.out.println("valido");
                } else {
                    System.out.println("No valido");
                }
            } catch (Exception e) {
                System.out.println("No valido --> Caracter Invalido ");
            }
        } else {
            System.out.println("No se pudo cargar la configuración del AFD.");
        }
    }
}