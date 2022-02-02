import java.util.Scanner;

public class Exercicio28 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe dois número: ");
		
		float num1 = entrada.nextFloat();
		float num2 = entrada.nextFloat();
		
		System.out.print("Informe a operação (+|-|*|/): ");
		
		entrada.nextLine();
		String operacao = entrada.nextLine();
		
		float resultado = 0;
		
		switch (operacao) {
		case "+":
			resultado = num1 + num2;
			break;
		case "-":
			resultado = num1 - num2;
			break;
		case "*":
			resultado = num1 * num2;
			break;
		case "/":
			resultado = num1 / num2;
			break;
		}
		
		System.out.println("Resultado: " + resultado);
		
		if(resultado % 2 == 0) {
			System.out.println("Par");
		} else {
			System.out.println("Impar");
		}
		
		if(resultado > 2) {
			System.out.println("Positivo");
		} else if(resultado < 2){
			System.out.println("Negativo");
		} else {
			System.out.println("Zero");
		}
		
		if(Math.floor(resultado) == resultado) {
			System.out.println("Inteiro");
		} else {
			System.out.println("Decimal");
		}
		
		entrada.close();
	}
	
}
