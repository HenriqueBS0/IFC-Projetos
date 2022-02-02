import java.util.Arrays;
import java.util.Scanner;

public class Exercicio03 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		String nome, sexo, estadoCivil;
		int idade;
		float salario;
		
		boolean dadosValidos;
		
		do {
			System.out.print("Informe o nome: ");
			nome = entrada.nextLine();
			
			if(nome.length() <= 3) {
				System.out.println("Nome inválido!");
				dadosValidos = false;
			} else {
				dadosValidos = true;
			}
			
		} while (!dadosValidos);
		
		do {
			System.out.print("Informe a idade: ");
			idade = entrada.nextInt();
			
			if(idade < 0 || idade > 150) {
				System.out.println("Idade inválida!");
				dadosValidos = false;
			} else {
				dadosValidos = true;
			}
			
		} while (!dadosValidos);
		
		
		do {
			System.out.print("Informe o salário: ");
			salario = entrada.nextFloat();
			
			if(salario < 0) {
				System.out.println("Salario inválido!");
				dadosValidos = false;
			} else {
				dadosValidos = true;
			}
			
		} while (!dadosValidos);
		
		entrada.nextLine();
		
		do {
			System.out.print("Informe a sexo: ");
			sexo = entrada.nextLine();
			
			if(!sexo.equals("f") && !sexo.equals("m")) {
				System.out.println("Sexo inválido!");
				dadosValidos = false;
			} else {
				dadosValidos = true;
			}
			
		} while (!dadosValidos);
		
		do {
			
			System.out.print("Informe o estado cívil: ");
			estadoCivil = entrada.nextLine();
			
			String[] estadosCivis = {"s", "c", "v", "d"};
			
			if(!Arrays.asList(estadosCivis).contains(estadoCivil)) {
				System.out.println("Estado cívil inválido!");
				dadosValidos = false;
			} else {
				dadosValidos = true;
			}
			
		} while (!dadosValidos);
		
		System.out.println("-----------------");
		System.out.println("Nome: "            + nome);
		System.out.println("Idade: "           + idade);
		System.out.println("Salário: "         + salario);
		System.out.println("Sexo: "            + sexo);
		System.out.println("Estado cívil: "    + estadoCivil);
		System.out.println("-----------------");
		
		entrada.close();
	}
}
