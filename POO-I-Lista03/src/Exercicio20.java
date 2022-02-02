import java.util.Scanner;

public class Exercicio20 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
	
		System.out.print("Informe o número de notas: ");
		int notas = entrada.nextInt();
		float media = 0;
		
		for(int i = 1; i <= notas; i++) {
			System.out.print("Informe a nota: ");
			media+= entrada.nextFloat();
		}
		
		media = media/notas;
		
		System.out.println("Média: " + media);
	
		entrada.close();
	}
}
