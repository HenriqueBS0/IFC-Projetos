
public class Exercicio12 {
	public static void main(String[] args) {
		String palavras = "henrique;fernando;paula;susana";
		String[] arrayPalavras = palavras.split(";");
		
		for(int i = 0; i < arrayPalavras.length; i++) {
			System.out.println("Palavra " + (i+1) + ": " + arrayPalavras[i]);
		}
	}
}
