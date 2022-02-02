import java.util.Random;

public class Exercicio06 {
	public static void main(String[] args) {
		Random gerador = new Random();
	
		final int TAM = 5;
		
		int[] numeros = new int[TAM];
		int countPares = 0, countImpares = 0;
		
		
		for(int i = 0; i < TAM; i++ ) {
			numeros[i] = gerador.nextInt(1000);
			if(numeros[i] % 2 == 0) {
				countPares++;
			} else {
				countImpares++;
			}
		}
		
		int indicePares = 0, indiceImpares = 0;
		int pares[] = new int[countPares];
		int impares[] = new int[countImpares];
		
		for(int i = 0; i < TAM; i++ ) {
			if(numeros[i] % 2 == 0) {
				pares[indicePares] = numeros[i];
				indicePares++;
			} else {
				impares[indiceImpares] = numeros[i];
				indiceImpares++;
			}
		}
		
		System.out.println("Números: ");
		for(int i = 0; i < TAM; i++ ) {
			System.out.println(numeros[i]);
		}
		
		System.out.println("Pares: ");
		for(int i = 0; i < countPares; i++ ) {
			System.out.println(pares[i]);
		}
		
		System.out.println("Impares: ");
		for(int i = 0; i < countImpares; i++ ) {
			System.out.println(impares[i]);
		}
	}
}
