import java.util.Scanner;

public class Exercicio02 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe dois números: ");
		
		float num = entrada.nextFloat();
		
		if(num > 0) {
			System.out.println("Positivo");
		} else if(num < 0) {
			System.out.println("Negativo");
		} if(num == 0) {
			System.out.println("Zero");
		}
		
		entrada.close();
	}
}
