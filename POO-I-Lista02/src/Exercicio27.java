import java.util.Scanner;

public class Exercicio27 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Informe um número: ");
		
		float num = entrada.nextFloat();
		
		if(Math.floor(num) == num) {
			System.out.println("Inteiro");
		} else {
			System.out.println("Decimal");
		}
		
		entrada.close();
	}
	
}
