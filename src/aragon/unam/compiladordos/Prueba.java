package aragon.unam.compiladordos;

import aragon.unam.compilador.Herramientas;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] tabla = {{2,1,-1},{1,1,-1},{2,2,1}}; //{{3,1,-1},{3,2,-1},{3,3,1}}; 
		
		char[] columnas = {'0', '1', 'L', 'D', ';'};
//		char[] columnas = {'L', 'D', ';'};
		char c = '0';
		int entrada = -1; //1 o -1
		int estado = 0; //2 o 0
		
		if(Herramientas.letra(c)) {
			c = 'L';
		} else if(Herramientas.digito(c)) {
			c = 'D';
		}
		
		for (int i = tabla.length-1; i < tabla.length; i++) {
			
			estado = tabla[tabla.length-1][tabla.length-1];
		}
		
		for(int indice = 0; indice < columnas.length; indice++) {
			
			if( c == columnas[indice]) {
				entrada = indice;
				break;
			}
		}
		
		System.out.println(estado + " " + entrada);
		estado =  tabla[estado][entrada-1];
		System.out.println(estado);
		
		
		
	}

}
