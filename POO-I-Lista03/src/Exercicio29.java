import java.util.Scanner;

public class Exercicio29 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
	
		System.out.print("Informe o multiplicador: ");
		int multiplicador = entrada.nextInt();
		
		System.out.print("Informe o inicio: ");
		int inicio = entrada.nextInt();
		
		System.out.print("Informe o fim: ");
		int fim = entrada.nextInt();
		
		for(int i = inicio; i <= fim; i++) {
			System.out.println(multiplicador + " * " + i + " = " + (multiplicador*i));
		}
		
		entrada.close();
	}
}
