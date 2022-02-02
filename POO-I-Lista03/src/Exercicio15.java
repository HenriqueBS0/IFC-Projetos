import java.util.Scanner;

public class Exercicio15 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		float resultado = 0;
		int mult1 = 37;
		int mult2 = 38;
		int divisor = 1;
		
		for(int i = 37; i >= 1; i--) {
			resultado+=(mult1 * mult2)/ divisor;
			mult1--;
			mult2--;
			divisor++;
		}
		
		System.out.println("Resultado: " + resultado);
		
		entrada.close();
	}

}
