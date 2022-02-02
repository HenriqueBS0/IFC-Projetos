import java.util.Scanner;

public class Exercicio23 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
	
		System.out.print("Informe o número de turmas: ");
		int turmas = entrada.nextInt();
		int media = 0;
		
		for (int i = 1; i <= turmas; i++) {
			
			System.out.print("Informe o número de alunos: ");
			int alunos = entrada.nextInt();
			
			while(alunos <= 0 || alunos > 40) {
				System.out.print("Valor inválido, informe novamente: ");
				alunos = entrada.nextInt();
			}
			
			media+=alunos;
		}
		
		media = Math.round(media/turmas);
		
		System.out.println("Média de alunos por turma: " + media);
	
		entrada.close();
	}
}
