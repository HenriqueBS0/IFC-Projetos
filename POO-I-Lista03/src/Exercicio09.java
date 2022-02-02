import java.util.Scanner;

public class Exercicio09 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Informe o multiplicador: ");
		int multiplicador = entrada.nextInt();
		
		for(int i = 1; i <= 10; i++) {
			System.out.println(multiplicador + " x " + i + " = " + (multiplicador * i));
		}
		
		entrada.close();
	}
}
