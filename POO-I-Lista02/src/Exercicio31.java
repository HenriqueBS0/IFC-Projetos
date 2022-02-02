import java.util.Scanner;

public class Exercicio31 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Informe os (kg) de morango: ");
		float kgMorango = entrada.nextFloat();
		
		float precoMorango;
		if(kgMorango <= 5) {
			precoMorango = 2.5f;
		} else {
			precoMorango = 2.2f;
		}
		
		System.out.print("Informe os (kg) de maçã: ");
		float kgMaca = entrada.nextFloat();
		
		float precoMaca;
		if(kgMaca <= 5) {
			precoMaca = 1.8f;
		} else {
			precoMaca = 1.5f;
		}
		
		float precoTotal = (kgMorango * precoMorango) + (kgMaca * precoMaca);
		
		if((kgMorango + kgMaca) > 8 || precoMaca > 25) {
			precoTotal*= 0.9f;
		}
		
		System.out.println("Preço total: " + precoTotal);
		
		entrada.close();
	}
}
