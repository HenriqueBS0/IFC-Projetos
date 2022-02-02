import java.util.Scanner;

public class Exercicio16 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe duas notas: ");
		
		float nota1 = entrada.nextFloat();
		float nota2 = entrada.nextFloat();
		
		float media = (nota1 + nota2) / 2;
		
		System.out.println("Média: " + media);
		
		if(media <= 3) {
			System.out.println("Reprovado");
		} else if(media < 7) {
			System.out.println("Em exame");
		} else {
			System.out.println("Aprovado");
		}
		
		entrada.close();
	}
}
