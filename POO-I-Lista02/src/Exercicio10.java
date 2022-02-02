import java.util.Scanner;

public class Exercicio10 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe 3 números: ");
		
		int num1 = entrada.nextInt();
		int num2 = entrada.nextInt();
		int num3 = entrada.nextInt();
		
		int maior;
		int menor;
		
		if(num1 > num2 && num1 > num3) {
			maior = num1;
		} else if(num2 > num3) {
			maior = num2;
		} else {
			maior = num3;
		}
		
		if(num1 < num2 && num1 < num3) {
			menor = num1;
		} else if(num2 < num3) {
			menor = num2;
		} else {
			menor = num3;
		}
		
		System.out.println("Maior: " + maior);
		System.out.println("Menor: " + menor);
		
		entrada.close();
	}
}
