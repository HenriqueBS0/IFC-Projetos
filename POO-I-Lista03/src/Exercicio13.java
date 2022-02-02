import java.util.Scanner;

public class Exercicio13 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Informe um número: ");
		int numero = entrada.nextInt();
		
		int fatorial = 1;
		
		for(int i = numero; i >= 1; i--) {
			fatorial*=i;
		}
		
		System.out.println("Resultado: " + fatorial);
		
		entrada.close();
	}

}
