import java.util.Scanner;

public class Exercicio24 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Informe a 3 notas:");
		
		float nota1 = entrada.nextFloat();
		float nota2 = entrada.nextFloat();
		float nota3 = entrada.nextFloat();
		
		float media = (nota1 + nota2 + nota3) / 3;
		
		if(media < 7) {
			System.out.println("Reprovado");
		} else if(media == 10) {
			System.out.println("Aprovado com distinção");
		} else {
			System.out.println("Aprovado");
		}
		
		entrada.close();
	}
}
