import java.util.Scanner;

public class Exercicio25 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Informe o valor do saque: ");
		
		int valor = entrada.nextInt();
		
		if(valor < 10 || valor > 600) {
			System.out.println("Valor inválido");
		} else {
			double notas100 = Math.floor((valor / 100));
			double resto = valor - (notas100 * 100);
			
			double notas50 = Math.floor((resto / 50));
			resto = resto - (notas50 * 50);
			
			double notas10 = Math.floor((resto / 10));
			resto = resto - (notas10 * 10);
			
			double notas5 = Math.floor((resto / 5));
			resto = resto - (notas5 * 5);
			
			double notas1 = resto;
			
			System.out.println("Notas de 100: " + notas100);
			System.out.println("Notas de 50: "  + notas50);
			System.out.println("Notas de 10: "  + notas10);
			System.out.println("Notas de 5: "   + notas5);
			System.out.println("Notas de 1: "   + notas1);
		}
		
		entrada.close();
	}
}
