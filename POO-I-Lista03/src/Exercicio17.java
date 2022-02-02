import java.util.Scanner;


public class Exercicio17 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Informe um número: ");
		int numero = entrada.nextInt();
		
		boolean primo = true;
		
		for(int i = 2; i < numero; i++) {
			if(numero % i == 0) {
				primo = false;
			}
		}
		
		System.out.println("O número" + (primo ? "" : " não") + " é primo");
		
		
		entrada.close();
		
	}

}
