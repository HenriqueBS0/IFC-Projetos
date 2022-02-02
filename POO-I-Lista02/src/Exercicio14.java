import java.util.Scanner;

public class Exercicio14 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		final String[] diasSemana = {
			"Segunda-feira",
			"Terça-feira",
			"Quarta-feira",
			"Quinta-feira",
			"Sexta-feira",
			"Sábado",
			"Domingo"
		};
		
		System.out.print("Informe o dia da semana(1-Segunda-Feira,...,7-Domingo): ");
		int diaSemana = entrada.nextInt();
		
		if(diaSemana > 7 || diaSemana < 1) {
			System.out.println("Valor inválido");
		} else {
			System.out.println("Dia: " + diasSemana[diaSemana - 1]);
		}
		
		entrada.close();
	}
}
