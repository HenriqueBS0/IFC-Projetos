import java.util.Scanner;

public class Exercicio10 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Informe a base: ");
		int base = entrada.nextInt();
		
		System.out.print("Informe o expoente: ");
		int expoente = entrada.nextInt();
		
		int resultado = base;
		
		for(int i = 1; i < expoente; i++ ) {
			resultado*=base;
		}
		
		System.out.println(base + " ^ " + expoente + " = " + resultado);
		
		entrada.close();
	}
}
