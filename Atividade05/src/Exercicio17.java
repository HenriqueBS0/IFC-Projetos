import java.util.Scanner;

public class Exercicio17 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		final int TAM = 1;
		
		String[] nomes = new String[TAM];
		int[] telefones = new int[TAM];
		int[] celular = new int[TAM];
		String[] email = new String[TAM];
		String[] dataNasc = new String[TAM];
	
		for(int i = 0; i < TAM; i++) {
			System.out.println("Informe: ");
			
			System.out.print("Nome: ");
			nomes[i] = entrada.nextLine();
			
			System.out.print("Email: ");
			email[i] = entrada.nextLine();
			
			System.out.print("Data Nascimento: ");
			dataNasc[i] = entrada.nextLine();
			
			System.out.print("Telefone: ");
			telefones[i] = entrada.nextInt();
		
			System.out.print("Celular: ");
			celular[i] = entrada.nextInt();
			entrada.nextLine();
		}
		
		relatorio(nomes, telefones, celular, email, dataNasc, TAM);
	}
	
	private static void relatorio(String[] nomes, int[] telefones, int[] celular, String[] email, String[] dataNasc, int tam) {
		for(int i = 0; i < tam; i++) {
			System.out.println("Nome: " + nomes[i]);
			System.out.println("Telefone: " + telefones[i]);
			System.out.println("Celular: " + celular[i]);
			System.out.println("Email: " + email[i]);
			System.out.println("Data de Nascimento: " + dataNasc[i]);
		}
	}
}
