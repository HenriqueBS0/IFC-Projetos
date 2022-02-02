import java.util.Random;

public class Exercicio09 {
	public static void main(String[] args) {
		final int TAM = 10;
		
		String senha = "";
		
		for(int i = 0; i < TAM; i++) {
			if(i % 2 == 0) {
				senha+=consoante();
			} else {
				senha+=vogal();
			}
		}
		
		System.out.println("Senha: " + senha);
	}
	
	public static String consoante() {
		String[] consoantes = {"b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v", "w", "x", "y", "z"};
		return consoantes[aleatorio(21)];
	}
	
	public static String vogal() {
		String[] vogais = {"a", "e", "i", "o", "u"};
		return vogais[aleatorio(5)];
	}
	
	public static int aleatorio(int maximo) {
		Random gerador = new Random();
		return gerador.nextInt(maximo);
	}
}
