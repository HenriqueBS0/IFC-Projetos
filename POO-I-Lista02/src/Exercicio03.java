import java.util.Scanner;

public class Exercicio03 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Informe ('F'|'M'): ");
		
		String letra = entrada.nextLine();
		
		switch (letra) {
		case "F":
			System.out.println("Feminino");
			break;
		case "M":
			System.out.println("Masculino");
			break;
		default:
			System.out.println("Valor inválido");
			break;
		}
		
		entrada.close();
	}
}
