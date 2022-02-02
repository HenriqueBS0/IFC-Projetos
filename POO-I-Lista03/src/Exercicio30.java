import java.util.Scanner;

public class Exercicio30 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int codigo = 0, codigoGordo = 0, codigoMagro = 0, codigoAlto = 0, codigoBaixo = 0, numPessoas = 0;
		float altura, peso, mediaAltura = 0, mediaPeso = 0, maiorPeso = 0, menorPeso = 0, maiorAltura = 0, menorAltura = 0;
		
		do {
			
			boolean primeiraVez = codigo == 0;
			
			System.out.print("Informe o código: ");
			codigo = entrada.nextInt();
			
			System.out.print("Informe a altura: ");
			altura = entrada.nextFloat();
			
			System.out.print("Informe a peso: ");
			peso = entrada.nextFloat();
			
			mediaAltura+=altura;
			mediaPeso+=peso;
			
			if(altura > maiorAltura) {
				maiorAltura = altura;
				codigoAlto = codigo;
			}
			
			if(peso > maiorPeso) {
				maiorPeso = peso;
				codigoGordo = codigo;
			}
			
			if(altura < menorAltura || primeiraVez) {
				menorAltura = altura;
				codigoBaixo = codigo;
			}
			
			if(peso < menorPeso || primeiraVez) {
				menorPeso = peso;
				codigoMagro = codigo;
			}
			
			numPessoas++;
		} while(codigo != 0);
		
		mediaAltura/= numPessoas;
		mediaPeso/= numPessoas;
		
		System.out.println("Mais Alto: " + codigoAlto + " " + maiorAltura);
		System.out.println("Mais Baixo: " + codigoBaixo + " " + menorAltura);
		System.out.println("Mais Gordo: " + codigoGordo + " " + maiorPeso);
		System.out.println("Mais Magro: " + codigoMagro + " " + menorPeso);
		System.out.println("Media altura: " + mediaAltura);
		System.out.println("Media peso: " + mediaPeso);
		
		entrada.close();
	}
}
