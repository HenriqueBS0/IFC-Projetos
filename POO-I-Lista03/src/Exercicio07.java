import java.util.Scanner;

public class Exercicio07 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe dois números inteiros: ");
		int num1 = entrada.nextInt();
		int num2 = entrada.nextInt();
		
		int maior = num1 > num2 ? num1 : num2;
		int menor = num1 > num2 ? num2 : num1;
		
		for(int i = menor; i <= maior; i++) {
			System.out.print(i + "|");
		}
		
		entrada.close();
	}
}
