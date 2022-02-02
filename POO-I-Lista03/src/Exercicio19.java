import java.util.Scanner;


public class Exercicio19 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Informe um número: ");
		int numero = entrada.nextInt();
		int divisoes = 0;
		
		System.out.println("-->Primos");
		
		for(int y = 1; y <= numero; y++) {
			boolean primo = true;
			
			for(int i = 2; i < y; i++) {
				if(y % i == 0) {
					primo = false;
				}
				divisoes++;
			}
			
			if(primo) {
				System.out.println(y);
			}
		}
		
		System.out.println("----------");
		System.out.println("Divisões: " + divisoes);

		entrada.close();
		
	}

}
