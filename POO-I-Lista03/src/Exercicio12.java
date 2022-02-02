import java.util.Scanner;

public class Exercicio12 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Informe o n: ");
		int n = entrada.nextInt();
		
		int anterior  = 0;
		int resultado = 1;
		
		for(int i = 2; i <= n; i++) {
			int auxAnterior = resultado;
			resultado+= anterior;
			anterior = auxAnterior;
		}
		
		System.out.println("N-ésimo termo: " + resultado);
		
		entrada.close();
	}
}
