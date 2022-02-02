import java.util.Random;

public class Exercicio16 {
	public static void main(String[] args) {
		Random gerador = new Random();
		
		final int TAM = 5;
		
		int[] numeros = new int[TAM];
		
		for(int i=0; i < TAM; i++) {
			numeros[i] = gerador.nextInt(20);
		}
		
		for(int indiceNumero = 0; indiceNumero < TAM; indiceNumero++) {
			System.out.print(numeros[indiceNumero]+": ");
			for(int velha = 0; velha < numeros[indiceNumero]; velha++) {
				System.out.print("#");
			}
			System.out.println();
		}
				
	}
}
