
public class Exercicio10 {
	public static void main(String[] args) {
		String palavra = "Teste";
		char[] letrasPalavra = new char[palavra.length()];
		
		for(int i = 0; i < palavra.length(); i++) {
			letrasPalavra[i] = palavra.charAt(i);
		}
		
		System.out.println("Letras: ");
		
		for(int i = 0; i < palavra.length(); i++) {
			System.out.println(letrasPalavra[i]);
		}
	}
}
