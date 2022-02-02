import java.util.Scanner;

public class Exercicio26 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
	
		System.out.print("Informe o preço do pão: ");
		float precoPao = entrada.nextFloat();
		double preco = precoPao;
		
		System.out.println("Panificadora Pão de Ontem - Tabela de preços");
		for(int i = 1; i <= 50; i++) {
			preco = Math.round(preco * 100);
			preco = preco/100;
			
			System.out.println(i + " - R$ " + preco);
			preco+=precoPao;
		}
	
		entrada.close();
	}
}
