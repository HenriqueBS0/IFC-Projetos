import java.util.Scanner;

public class Exercicio16 {
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		String continuar = null;
		
		int maior = 0; 
		int menor = 0; 
		int soma = 0;
		
		do {
			System.out.print("Informe um número: ");
			int numero = entrada.nextInt();
			
			if(numero > maior) {
				maior = numero;
			}
			
			if(numero < menor || continuar == null) {
				menor = numero;
			}
			
			soma+=numero;
			
			entrada.nextLine();
			System.out.print("Continuar informando(S|N): ");
			continuar = entrada.nextLine();
		} while(continuar.equals("S"));
		
		System.out.println("Maior: " + maior);
		System.out.println("Menor: " + menor);
		System.out.println("Soma: "  + soma);
		
		entrada.close();
	}
}
