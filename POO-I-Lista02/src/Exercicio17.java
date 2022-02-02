import java.util.Scanner;

public class Exercicio17 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe duas notas: ");
		
		float nota1 = entrada.nextFloat();
		float nota2 = entrada.nextFloat();
		
		float media = (nota1 + nota2) / 2;
		
		System.out.println("Média: " + media);
		
		String conceito = "";
		
		if(media >= 9) {
			conceito = "A";
		} else if(media >= 7.5) {
			conceito = "B";
		} else if(media >= 6) {
			conceito = "C";
		} else if(media >= 4) {
			conceito = "D";
		} else {
			conceito = "E";
		}
		
		String situacao = "";
		
		switch (conceito) {
		case "A":
		case "B":
		case "C":
			situacao = "APROVADO";
			break;
		case "D":
		case "E":
			situacao = "REPROVADO";
			break;
		}
		
		System.out.println("Nota 1: " + nota1);
		System.out.println("Nota 2: " + nota2);
		System.out.println("Média: "  + media);
		System.out.println("Conceito: " + conceito);
		System.out.println("Situação: " + situacao);
		
		entrada.close();
	}
}
