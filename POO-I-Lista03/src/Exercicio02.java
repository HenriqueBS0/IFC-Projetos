import java.util.Scanner;

public class Exercicio02 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Informe o nome: ");
		String nome = entrada.nextLine();
		
		System.out.print("Informe o senha: ");
		String senha = entrada.nextLine();
		
		while(nome.equals(senha)) {
			System.out.println("Nome não pode ser igual a senha");
			
			System.out.print("Informe o nome: ");
			nome = entrada.nextLine();
			
			System.out.print("Informe o senha: ");
			senha = entrada.nextLine();
		}
		
		System.out.println("Valores válidos!");
		
		entrada.close();
	}

}
