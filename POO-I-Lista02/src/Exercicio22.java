import java.util.Scanner;

public class Exercicio22 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe um número menor que 1000: ");
		
		int numero = entrada.nextInt();
		
		double centenas = Math.floor((numero/100));
		double dezenas  = Math.floor((numero - (centenas * 100))/10);
		double unidades = Math.floor((numero - ((centenas * 100) + (dezenas * 10))));
		
		System.out.println("Centenas: " + centenas);
		System.out.println("Dezenas: " + dezenas);
		System.out.println("Unidades: " + unidades);
		
		entrada.close();
	}
}
