import java.util.Scanner;

public class Exercicio14 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Informe o n: ");
		int n = entrada.nextInt();
		
		int dividendo  = 1;
		int divisor = 1;
		
		for(int i = 1; i <= n; i++) {
			System.out.print(dividendo + "/" + divisor);
			if(i != n) {
				System.out.print(" + ");
			}
			dividendo++;
			divisor+=2;
		}
		
		entrada.close();
	}
}
