import java.util.Random;

public class Exercicio07 {
	public static void main(String[] args) {
		final int numeroDeAlunos = 10;
		final int notas = 4;
		
		int acimaMedia = 0;
		
		float[] medias = new float[numeroDeAlunos];
		
		for(int indiceAluno = 0; indiceAluno < numeroDeAlunos; indiceAluno++) {
			float soma = 0;
			for(int indiceNota = 0; indiceNota < notas; indiceNota++) {
				soma+=nota();
			}
			medias[indiceAluno] = soma/notas;
			
			if(medias[indiceAluno] >= 7) {
				acimaMedia++;
			}
		}
		
		System.out.println("Médias");
		for(int indiceAluno = 0; indiceAluno < numeroDeAlunos; indiceAluno++) {
			System.out.println(medias[indiceAluno]);
		}
		
		System.out.println("Número de alunos com a média >= 7: " + acimaMedia);
		
	}
	
	private static float nota() {
		Random gerador = new Random();
		return gerador.nextFloat() *10;
	}
}
