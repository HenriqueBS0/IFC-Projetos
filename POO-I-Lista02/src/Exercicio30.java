import java.util.Scanner;

public class Exercicio30 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Informe a quatidade de litro: ");
		
		float litros = entrada.nextFloat();
		
		System.out.print("Informe o tipo de combutível: ");
		
		entrada.nextLine();
		
		String tipoCombustivel = entrada.nextLine();
		
		float desconto = 0;
		float precoLitro = 0;
		
		switch (tipoCombustivel) {
		case "A":
			precoLitro = 1.9f;
			if(litros <= 20) {
				desconto = 3;
			} else {
				desconto = 5;
			}
			break;
		case "G":
			precoLitro = 2.5f;
			if(litros <= 20) {
				desconto = 4;
			} else {
				desconto = 6;
			}
			break;
		}
		
		float valorFinal = (precoLitro * litros) * (1 - (desconto/100));
		
		System.out.println("Valor: " + valorFinal);
		
		entrada.close();
	}
}
