import java.util.Random;

public class Exercicio02 {
	public static void main(String[] args) {
		Random gerador = new Random();
		final int TAM = 10;
		int[] numeros = new int[TAM];
		
		for(int i = 0; i < TAM; i++ ) {			
			numeros[i] = gerador.nextInt(100);
			System.out.println(numeros[i]);
		}
		
		System.out.println("Inverso");
		
		for(int i = (TAM - 1); i >= 0 ; i-- ) {
			System.out.println(numeros[i]);
		}
	}
}