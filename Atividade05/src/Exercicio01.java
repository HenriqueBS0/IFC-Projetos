import java.util.Random;

public class Exercicio01 {
	public static void main(String[] args) {
		Random gerador = new Random();
		final int TAM = 5;
		int[] numeros = new int[TAM];
		
		for(int i = 0; i < TAM; i++ ) {
			numeros[i] = gerador.nextInt(100);
		}
		
		for(int i = 0; i < TAM; i++ ) {
			System.out.println(numeros[i]);
		}
	}
}
