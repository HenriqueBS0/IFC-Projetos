import java.util.Random;

public class Exercicio03 {
	public static void main(String[] args) {
		
		Random gerador = new Random();
		
		final int TAM = 3;
		
		int[] numeros = new int[TAM];
		
		int soma = 0, maior = 0, menor = 0;
		int countPares = 0, countImpares = 0; 
		int countAcimaMedia = 0, countAbaixoMedia = 0;
		
		float media;
		
		for(int i = 0; i < TAM; i++ ) {
			numeros[i] = gerador.nextInt(100);
			
			if(i == 0) {
				maior = numeros[i];
				menor = numeros[i];
			} else {
				if(numeros[i] > maior) {
					maior = numeros[i];
				} else if(numeros[i] < menor) {
					menor = numeros[i];
				}
			}
			
			if(numeros[i] % 2 == 0) {
				countPares++;
			} else {
				countImpares++;
			}
			
			soma+=numeros[i];
		}
		
		media = soma / (float) TAM;
		
		int[] pares = new int[countPares];
		int[] impares = new int[countImpares];
		int indicePares = 0;
		int indiceImpares = 0;
		
		for(int i = 0; i < TAM; i++ ) {
			
			if(numeros[i] % 2 == 0) {
				pares[indicePares] = numeros[i];
				indicePares++;
			} else {
				impares[indiceImpares] = numeros[i];
				indiceImpares++;
			}
			
			if(numeros[i] < media) {
				countAbaixoMedia++;
			} else if(numeros[i] > media) {
				countAcimaMedia++;
			}
		}
		
		int[] abaixoMedia = new int[countAbaixoMedia];
		int[] acimaMedia = new int[countAcimaMedia];
		int indiceAbaixoMedia = 0;
		int indiceAcimaMedia = 0;
		
		for(int i = 0; i <= (TAM - 1); i++ ) {
			if(numeros[i] < media) {
				abaixoMedia[indiceAbaixoMedia] = numeros[i];
				indiceAbaixoMedia++;
			} else if(numeros[i] > media) {
				acimaMedia[indiceAcimaMedia] = numeros[i];
				indiceAcimaMedia++;
			}
		}
		
		System.out.println("---{Números}---");
		for(int i = 0; i < TAM; i++ ) {
			System.out.println(numeros[i]);
		}
		System.out.println("---------------");
		System.out.println("Soma: " + soma);
		System.out.println("Média: " + media);
		System.out.println("Menor: " + menor);
		System.out.println("Maior: " + maior);
		System.out.println("---------------");
		System.out.println("");
		System.out.println("---{Números Pares}---");
		for(int i = 0; i < countPares; i++) {
			System.out.println(pares[i]);
		}
		System.out.println("---{Números Impares}---");
		for(int i = 0; i < countImpares; i++) {
			System.out.println(impares[i]);
		}
		System.out.println("---{Números Acima da Média}---");
		for(int i = 0; i < countAcimaMedia; i++) {
			System.out.println(acimaMedia[i]);
		}
		System.out.println("---{Números Abaixo da Média}---");
		for(int i = 0; i < countAbaixoMedia; i++) {
			System.out.println(abaixoMedia[i]);
		}
	}
}
