import java.util.Arrays;

public class Exercicio05 {
	public static void main(String[] args) {
		final String[] caracteres = {"a", "b", "d", "h", "y", "j", "k", "i", "t", "e"};
		int coutConsoantes = 0;
		
		for (int i = 0; i < caracteres.length; i++) {
			if(isConsoante(caracteres[i])) {
				coutConsoantes++;
			}
		}
		
		int indiceConsoantes = 0;
		String[] consoantes = new String[coutConsoantes];
		
		for (int i = 0; i < caracteres.length; i++) {
			if(isConsoante(caracteres[i])) {
				consoantes[indiceConsoantes] = caracteres[i];
				indiceConsoantes++;
			}
		}
		
		System.out.println("Número de consoantes: " + coutConsoantes);
		
		for (int i = 0; i < coutConsoantes; i++) {
			System.out.println(consoantes[i]);
		}
		
	}
	
	private static boolean isConsoante(String caracter) {
		final String[] vogais = {"a", "e", "i", "o", "u"};
		return !Arrays.asList(vogais).contains(caracter);
	}
}
