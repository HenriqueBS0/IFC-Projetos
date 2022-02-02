import java.util.Scanner;

public class Exercicio31 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int codigo = 0,  codigoAlto = 0, codigoBaixo = 0;
		float altura, maiorAltura = 0, menorAltura = 0;
		
		do {
			
			boolean primeiraVez = codigo == 0;
			
			System.out.print("Informe o código do Aluno: ");
			codigo = entrada.nextInt();
			
			System.out.print("Informe a altura: ");
			altura = entrada.nextFloat();
			
			if(altura > maiorAltura) {
				maiorAltura = altura;
				codigoAlto = codigo;
			}
			
			if(altura < menorAltura || primeiraVez) {
				menorAltura = altura;
				codigoBaixo = codigo;
			}
			
		} while(codigo != 0);
		
		System.out.println("Mais Alto: " + codigoAlto + " " + maiorAltura);
		System.out.println("Mais Baixo: " + codigoBaixo + " " + menorAltura);
		
		entrada.close();
	}
}
