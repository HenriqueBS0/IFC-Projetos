import java.util.Random;

public class Exercicio04 {
	public static void main(String[] args) {
		Random gerador = new Random();
		final int TAM = 4;
		float[] notas = new float[TAM];
		
		for(int i = 0; i < TAM; i++ ) {
			notas[i] = gerador.nextFloat() * 10;
			System.out.println("Nota " + (i+1) + ": " + notas[i]);
		}
		
		float soma = 0;
		
		for(int i = 0; i < TAM; i++ ) {
			soma+=notas[i];
		}

		float media = soma/TAM;
		
		System.out.println("Média: " + media);
	}
}
