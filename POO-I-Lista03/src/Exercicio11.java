import java.util.Scanner;

public class Exercicio11 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		int pares   = 0;
		int impares = 0;
		
		for(int i = 1; i <= 10; i++) {
			System.out.print("Informe um número: ");
			int numero = entrada.nextInt();
			
			if(numero % 2 == 0) {
				pares++;
			}
			else {
				impares++;
			}
		}
		
		System.out.println("Pares: "   + pares);
		System.out.println("Impares: " + impares);
		
		entrada.close();
	}
}
