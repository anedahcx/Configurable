package aragon.unam.compilador;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Lector {
    @SuppressWarnings("null")
	public String[] leerArchivo(String nombreArchivo) {
        File f = new File(System.getProperty("user.dir") + File.separator + nombreArchivo);

        if (f.exists()) {
            try {
            	try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                    List<String> lineas = new ArrayList<>();
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        lineas.add(linea);
                    }
                    return lineas.toArray(new String[0]);
                }
//                try (BufferedReader br = new BufferedReader(new FileReader(f))) {
//                	
//                    StringBuilder sb = new StringBuilder();
//                    String linea;
//                    while ((linea = br.readLine()) != null) { 
////                    	String sb = linea;
////                    	sb.lines();
//                        sb.append(linea + " ");
//                    }
////                    return linea.toString();
//                    return sb.toString();
//                
//                }
            } catch (Exception e) {
                System.out.println("Error al leer el archivo");
            }
        } else {
            System.out.println("El archivo no existe");
        }
        return null;
    }
}