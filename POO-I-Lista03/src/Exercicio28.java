import java.util.Scanner;

public class Exercicio28 {
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		String continuar = null;
		
		float maior = 0; 
		float menor = 0; 
		float media = 0;
		int count = 0;
		
		do {
			System.out.print("Informe uma temperatura: ");
			float temperatura = entrada.nextInt();
			
			if(temperatura > maior) {
				maior = temperatura;
			}
			
			if(temperatura < menor || continuar == null) {
				menor = temperatura;
			}
			
			media+=temperatura;
			
			entrada.nextLine();
			System.out.print("Continuar informando(S|N): ");
			continuar = entrada.nextLine();
			count++;
		} while(continuar.equals("S"));
		
		media/=count;
		
		System.out.println("Maior: " + maior);
		System.out.println("Menor: " + menor);
		System.out.println("Média: "  + media);
		
		entrada.close();
	}
}
