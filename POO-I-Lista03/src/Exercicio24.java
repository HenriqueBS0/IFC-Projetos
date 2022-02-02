import java.util.Scanner;

public class Exercicio24 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
	
		System.out.print("Informe o número de CD's: ");
		int cds = entrada.nextInt();
		float media = 0;
		float total = 0;
		
		for(int i = 1; i <= cds; i++) {
			System.out.print("Informe o preço: ");
			total+= entrada.nextFloat();
		}
		
		media = total/cds;
		
		System.out.println("Média preço (R$): " + media);
		System.out.println("Valor total investido (R$): " + total);
	
		entrada.close();
	}
}
