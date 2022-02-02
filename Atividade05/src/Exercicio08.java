import java.util.Random;

public class Exercicio08 {
	public static void main(String[] args) {
		Random gerador = new Random();
		final int TAM = 5;
		int[] numeros = new int[TAM];
		
		int soma = 0;
		int mult = 1;
		
		for(int i = 0; i < TAM; i++) {
			numeros[i] = gerador.nextInt(2);
			soma+=numeros[i];
			mult*=numeros[i];
		}
		
		System.out.println("Números");
		for(int i = 0; i < TAM; i++) {
			System.out.println(numeros[i]);
		}
		
		System.out.println("Soma: " + soma);
		System.out.println("Multiplicacao: " + mult);
	}
	
	
}
