import java.util.Scanner;

public class Exercicio32 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int codigo = 0;
		float veiculos = 0, acidentes = 0;
		int cidadeMaiorIndiceAcidentes = 0, cidadeMenorIndiceAcidentes = 0; 
		int mediaVeiculos = 0, cidadesComMenosDe2000Veiculos = 0, mediaAcidentesMenos2000Veiculos = 0;
		double maiorIndice = 0, menorIndice = 0;
		
		
		for(int i = 1; i <= 2; i++) {
			System.out.print("Informe o código da cidade: ");
			codigo = entrada.nextInt();
			
			System.out.print("Informe o número de veículos de passeio: ");
			veiculos = entrada.nextInt();
			
			System.out.print("Informe o número de acidentes: ");
			acidentes = entrada.nextInt();
			
			double indice = acidentes/veiculos;
			
			if(indice > maiorIndice) {
				maiorIndice = indice;
				cidadeMaiorIndiceAcidentes = codigo;
			}
			
			if(indice < menorIndice || i == 1) {
				menorIndice = indice;
				cidadeMenorIndiceAcidentes = codigo;
			}
			
			if(veiculos < 2000) {
				cidadesComMenosDe2000Veiculos++;
				mediaAcidentesMenos2000Veiculos+= acidentes;
			}
			
			mediaVeiculos+=veiculos;
		}
		
		mediaVeiculos/=5;
		mediaAcidentesMenos2000Veiculos/=cidadesComMenosDe2000Veiculos;
		
		System.out.println("Maior índice de acidentes: " + maiorIndice);
		System.out.println("Cidade com maior índice de acidentes: " + cidadeMaiorIndiceAcidentes);
		System.out.println("Menor índice de acidentes: " + menorIndice);
		System.out.println("Cidade com menor índice de acidentes: " + cidadeMenorIndiceAcidentes);
		System.out.println("Média de veículos: " + mediaVeiculos);
		System.out.println("Média de acidentes em cidades com menos de 2000 veículos: " + mediaAcidentesMenos2000Veiculos);
		
		entrada.close();
	}
}
