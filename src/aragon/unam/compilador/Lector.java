package aragon.unam.compilador;

import java.io.*;
import java.util.ArrayList;

public class Lector {
    public String leerArchivo(String nombreArchivo) {
        File f = new File(System.getProperty("user.dir") + File.separator + nombreArchivo);

        if (f.exists()) {
            try {
                try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                    StringBuilder sb = new StringBuilder();
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        sb.append(linea);
                    }
                    return sb.toString();
                }
            } catch (Exception e) {
                System.out.println("Error al leer el archivo");
            }
        } else {
            System.out.println("El archivo no existe");
        }
        return null;
    }
}