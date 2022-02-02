import java.util.Scanner;

public class Exercicio18 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe os três lados do triângulo: ");
		
		float lado1 = entrada.nextFloat();
		float lado2 = entrada.nextFloat();
		float lado3 = entrada.nextFloat();
		
		boolean triangulo = lado1 < (lado2 + lado3) && lado2 < (lado1 + lado3) && lado3 < (lado1 + lado2);
		
		if(!triangulo) {
			System.out.println("Não é um triângulo");
		} else {
			System.out.println("É um triângulo");
			if(lado1 == lado2 && lado2 == lado3) {
				System.out.println("Triângulo Equilátero");
			} else if(lado1 != lado2 && lado2 != lado3) {
				System.out.println("Triângulo Escaleno");
			} else {
				System.out.println("Triângulo Isósceles");
			}
		}
		
		entrada.close();
	}

}
