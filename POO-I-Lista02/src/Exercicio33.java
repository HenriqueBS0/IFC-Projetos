import java.util.Scanner;

public class Exercicio33 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		String[] gabarito = {"a", "a", "b", "b", "c", "c", "d", "d", "e", "e"};
		
		for (int i = 0; i < 10; i++) {
			int numQuestao = i + 1;
			System.out.print("Informe a resposta da questão " + numQuestao + ": ");
			
			String resposta = entrada.nextLine(); 
			
			if(resposta.equals(gabarito[i])) {
				System.out.println("Q" + numQuestao + ": " + resposta + " : " + "Correto");
			} else {
				System.out.println("Q" + numQuestao + ": " + resposta + " : " + "Errada, resposta correta (" + gabarito[i] + ")");
			}
			
		}
		
		entrada.close();
	}
}
