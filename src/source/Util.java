package source;

public class Util {
	/*  Classe apra abstratir a operação  
	 * de transformar a strin g do teste 
	 * em um vetor de objetos
	 * 
	 * 
	 */
	
	public static Character charToCharater(char letra){
		return new Character(letra);
	}
	
	public static Character[] charListToCharaterlist(char[] listLetra){
		Character[] lista = new Character[listLetra.length];
		
		for(int i = 0 ; i < listLetra.length;i++){
			lista[i] = Util.charToCharater(listLetra[i]);
		}
		
		return lista;
	}
	
	public static Character[] stringToCharaterlist(String texto){
		return Util.charListToCharaterlist(texto.toCharArray());
	}
	
}
