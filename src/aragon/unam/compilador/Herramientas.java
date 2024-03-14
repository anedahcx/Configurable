package aragon.unam.compilador;

public class Herramientas {
	
	public static boolean letra(char c) {
		boolean letra = false;
		
		if((c >= 97 && c <= 122) || (c >= 65 && c <= 90)) {
			letra = true;
		}
		return letra;
		
	}
	
	public static boolean digito(char c) {
		boolean digito = false;
		
		if(c >= 48 && c <= 57) {
			digito = true;
		}
		return digito;
		
	}
	
	public static boolean finCadena(char c) {
		boolean finCadena = false;
		
		if(c == 32) {
			finCadena = true;
		}
		return finCadena;
		
	}
	
}
