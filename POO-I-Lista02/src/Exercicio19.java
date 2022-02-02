import java.util.Scanner;

public class Exercicio19 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Informe a: ");
		float a = entrada.nextFloat();
		
		if(a == 0) {
			System.out.println("Não é uma equação do segundo grau");
		}
		else {
			System.out.print("Informe b: ");
			float b = entrada.nextFloat();
			
			System.out.print("Informe c: ");
			float c = entrada.nextFloat();
			
			double delta = Math.pow(b, 2) - 4 * a *c;
			
			if(delta < 0) {
				System.out.println("A equação não possui raizes reais");
			} else if(delta == 0) {
				double raiz = -b / (2 * a);
				System.out.println("Raiz da equação: " + raiz);
			} else {
				double raiz1 = (-b + Math.sqrt(delta)) / (2 * a);
				double raiz2 = (-b - Math.sqrt(delta)) / (2 * a);
				System.out.println("Raiz 1 da equação: " + raiz1);
				System.out.println("Raiz 2 da equação: " + raiz2);
			}
		}
		
		entrada.close();
	}
}
