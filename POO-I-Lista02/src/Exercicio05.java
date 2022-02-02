import java.util.Arrays;
import java.util.Scanner;

public class Exercicio05 {
	public static void main(String[] args) {
		String[] vogais = {"A", "a", "E", "e", "I", "i", "O", "o", "U", "u"};
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Informe uma letra: ");
		
		String letra = entrada.nextLine();
		
		boolean vogal = Arrays.asList(vogais).contains(letra);
		
		if(vogal) {
			System.out.println("Vogal");
		} else {
			System.out.println("Consoante");
		}
		
		entrada.close();
	}
}