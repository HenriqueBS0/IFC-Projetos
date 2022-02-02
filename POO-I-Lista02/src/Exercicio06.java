import java.util.Scanner;

public class Exercicio06 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Informe um número: ");
		
		int numero = entrada.nextInt();
		
		numero++;
		
		System.out.println("Número alterado: " + numero);
		
		entrada.close();
	}
}
