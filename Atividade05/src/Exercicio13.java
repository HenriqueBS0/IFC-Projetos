import java.util.Random;

public class Exercicio13 {
	public static void main(String[] args) {
		Random gerador = new Random();
		
		final int TAM = 5;
		int[] idades = new int[TAM];
		float[] alturas = new float[TAM];
		
		int novo = 0, velho = 0;
		float alto = 0, baixo = 0;
		
		for(int i=0; i < TAM; i++) {
			idades[i] = gerador.nextInt(100);
			alturas[i] = gerador.nextFloat() * 2.2f;
			
			if(i == 0) {
				novo  = idades[i];
				velho = idades[i];
				alto  = alturas[i];
				baixo = alturas[i];
			} else {
				if(velho < idades[i])
					velho = idades[i];
				if(novo > idades[i])
					novo = idades[i];
				
				if(alto < alturas[i])
					alto = alturas[i];
				if(baixo > alturas[i])
					baixo = alturas[i];
			}
		}
		
		System.out.println("Mains velho: " + velho);
		System.out.println("Mains novo: " + novo);
		System.out.println("Mains alto: " + alto);
		System.out.println("Mains baixo: " + baixo);
		
		System.out.println("Idades e Alturas Invertidas: ");
		for(int i=(TAM-1); i >= 0; i--) {
			System.out.println("Idade: " + idades[i]);
			System.out.println("Alturas: " + alturas[i]);
		}
		
	}
}
