import java.util.Scanner;

public class Exercicio07 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe 3 números: ");
		
		int num1 = entrada.nextInt();
		int num2 = entrada.nextInt();
		int num3 = entrada.nextInt();
		
		if(num1 >= num2 && num1 >= num3) {
			System.out.print(num1 + ", ");
			if(num2 >= num3) {
				System.out.print(num2 + ", " + num3);
			} else {
				System.out.print(num3 + ", " + num2);
			}
		} else if(num2 >= num1 && num2 >= num3) {
			System.out.print(num2 + ", ");
			if(num1 >= num3) {
				System.out.print(num1 + ", " + num3);
			} else {
				System.out.print(num3 + ", " + num1);
			}
		} else {
			System.out.print(num3 + ", ");
			if(num1 >= num2) {
				System.out.print(num1 + ", " + num2);
			} else {
				System.out.print(num2 + ", " + num1);
			}
		}
		
		entrada.close();
	}
}
