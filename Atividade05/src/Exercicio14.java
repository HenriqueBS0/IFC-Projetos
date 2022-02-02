
public class Exercicio14 {
	public static void main(String[] args) {
		final int TAM = 10;
		
		String[] vet1 = geraVetor("a", TAM);
		String[] vet2 = geraVetor("b", TAM);
		String[] vetMescla = mesclaVetores(vet1, vet2);
		
		for(int i = 0; i < vetMescla.length; i++) {
			System.out.println(vetMescla[i]);
		}
	}
	
	private static String[] geraVetor(String elemento, int tamanho) {
		String[] vet = new String[tamanho];
		for(int i=0; i < tamanho; i++) {
			vet[i] = elemento;
		}
		return vet;
	}
	
	private static String[] mesclaVetores(String[] vet1, String[] vet2) {
		final int TAM = (vet1.length * 2);
		
		String[] vet = new String[TAM];
		
		int countVetor = 0;
		for(int i=0; i < TAM; i+=2) {
			vet[i] = vet1[countVetor];
			vet[(i+1)] = vet2[countVetor];
			
			countVetor++;
		}
		
		return vet;
	}
}
