import java.util.Scanner;

public class Exercicio01 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Informe uma nota: ");
		float nota = entrada.nextFloat();
		
		while(nota < 0 || nota > 10) {
			System.out.println("Nota inválida!");
			System.out.print("Informe outra nota: ");
			nota = entrada.nextFloat();
		}
		
		System.out.println("Nota: " + nota);
		
		entrada.close();
	}
}
