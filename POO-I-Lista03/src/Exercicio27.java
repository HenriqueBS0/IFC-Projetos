import java.util.Scanner;

public class Exercicio27 {
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		while(true) {
			System.out.println("---{Lojas tabajara}---");
			int countMercadoria = 1;
			float total = 0;
			
			String continuar;
			
			do {
				System.out.print("Produto " + countMercadoria + ": ");
				total+= entrada.nextFloat();
		
				entrada.nextLine();
				System.out.print("Continuar compra (S|N): ");
				continuar = entrada.nextLine();
				countMercadoria++;
			} while(continuar.equals("S") || continuar.equals("s"));
			
			System.out.print("Dinheiro: ");
			float valor = entrada.nextFloat();
			
			total = Math.round(total * 100);
			total/=100;
			
			valor = Math.round(valor * 100);
			valor/=100;
			
			float troco = valor - total;
			
			System.out.println("Troco: " + troco);
		}
	}
}
