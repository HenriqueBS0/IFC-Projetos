import java.util.Scanner;

public class Exercicio01 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe dois números: ");
		
		float num1 = entrada.nextFloat();
		float num2 = entrada.nextFloat();
		
		if(num1 > num2) {
			System.out.println("O número " + num1 + " é maior que o número " + num2);
		} else if(num2 > num1) {
			System.out.println("O número " + num2 + " é maior que o número " + num1);
		} else {
			System.out.println("O número " + num1 + " é igual ao " + num1);
		}
		
		entrada.close();
	}
}
