import java.util.Scanner;

public class Exercicio04 {
	
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String resposta;
		
		do {
			String maiorPopulacao, menorPopulacao;
			int populacaoA, populacaoB, anos;
			float taxaA, taxaB;
			boolean populacaoValida, taxaValida;
			
			do {
				System.out.print("Informe a população A: ");
				populacaoA = entrada.nextInt();
				
				if(populacaoA > 0) {
					populacaoValida = true;
				}
				else {
					System.out.println("População inválida!");
					populacaoValida = false;
				}
				
			} while(!populacaoValida);
			
			do {
				System.out.print("Informe a taxa de crescimento da população (%) A: ");
				taxaA = entrada.nextFloat();
				
				if(taxaA > 0) {
					taxaValida = true;
				}
				else {
					System.out.println("Taxa inválida!");
					taxaValida = false;
				}
				
			} while(!taxaValida);
			
			do {
				System.out.print("Informe a população B: ");
				populacaoB = entrada.nextInt();
				
				if(populacaoB > 0) {
					populacaoValida = true;
				}
				else {
					System.out.println("População inválida!");
					populacaoValida = false;
				}
				
			} while(!populacaoValida);
			
			do {
				System.out.print("Informe a taxa de crescimento da população (%) B: ");
				taxaB = entrada.nextFloat();
				
				if(taxaB > 0) {
					taxaValida = true;
				}
				else {
					System.out.println("Taxa inválida!");
					taxaValida = false;
				}
				
			} while(!taxaValida);
			
			anos = 0;
			
			if(populacaoA >= populacaoB) {
				maiorPopulacao = "A";
				menorPopulacao = "B";
				while(populacaoA >= populacaoB) {
					populacaoA += Math.round(populacaoA * (taxaA/100));
					populacaoB += Math.round(populacaoB * (taxaB/100));
					anos++;
				}
			} else {
				maiorPopulacao = "B";
				menorPopulacao = "A";
				while(populacaoB >= populacaoA) {
					populacaoA += Math.round(populacaoA * (taxaA/100));
					populacaoB += Math.round(populacaoB * (taxaB/100));
					anos++;
				}
			}
			
			System.out.println("A população " + menorPopulacao + " demorou " + anos + " anos para ultrapassar a população " + maiorPopulacao);
			entrada.nextLine();
			System.out.print("Fazer outra conta (S|N)?: ");
			resposta = entrada.nextLine();
		} while(resposta.equals("s") || resposta.equals("S"));
		
		System.out.println("FIM.");
		
		entrada.close();
	}
}
