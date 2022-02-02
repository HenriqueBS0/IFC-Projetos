import java.util.Scanner;

public class Exercicio23 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Informe a idade de 3 alunos:");
		
		int idade1 = entrada.nextInt();
		int idade2 = entrada.nextInt();
		int idade3 = entrada.nextInt();
		
		float media = (idade1 + idade2 + idade3) / 3;
		
		if(media < 25) {
			System.out.println("Turma jovem");
		} else if(media < 40) {
			System.out.println("Turma adulta");
		} else {
			System.out.println("Turma idosa");
		}
		
		entrada.close();
	}
}
