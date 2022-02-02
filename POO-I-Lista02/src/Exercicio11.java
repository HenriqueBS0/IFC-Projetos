import java.util.Scanner;

public class Exercicio11 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe seu turno digitar M-\n" + 
				"Matutino, V-Vespertino ou N-Noturno.");
		
		String turno = entrada.nextLine();
		
		switch (turno) {
		case "M":
			System.out.println("Bom dia!");
			break;
		case "V":
			System.out.println("Boa tarde!");			
			break;
		case "N":
			System.out.println("Boa noite!");			
			break;
		}
		
		entrada.close();
	}
}
