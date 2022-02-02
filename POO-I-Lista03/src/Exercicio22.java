import java.util.Scanner;

public class Exercicio22 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
	
		System.out.print("Informe o número de votantes: ");
		int votantes = entrada.nextInt();
		int votosA = 0;
		int votosB = 0;
		int votosC = 0;
		
		entrada.nextLine();
		
		for(int i = 1; i <= votantes; i++) {
			System.out.print("Informe o voto (A|B|C): ");
			String voto = entrada.nextLine();
			
			switch (voto) {
			case "A":
				votosA++;
				break;
			case "B":
				votosB++;
				break;
			case "C":
				votosC++;
				break;
			}
		}
		
		System.out.println("Votos A: " + votosA);
		System.out.println("Votos B: " + votosB);
		System.out.println("Votos C: " + votosC);
	
		entrada.close();
	}
}
