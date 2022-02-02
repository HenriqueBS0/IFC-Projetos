import java.util.Scanner;

public class Exercicio08 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe dois números inteiros: ");
		int num1 = entrada.nextInt();
		int num2 = entrada.nextInt();
		
		int maior = num1 > num2 ? num1 : num2;
		int menor = num1 > num2 ? num2 : num1;
		
		int soma = 0;
		
		for(int i = menor; i <= maior; i++) {
			System.out.print(i + "|");
			soma+=i;
		}
		
		System.out.println("Soma: " + soma);
		
		entrada.close();
	}
}
