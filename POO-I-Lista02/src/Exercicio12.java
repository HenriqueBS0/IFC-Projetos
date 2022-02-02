import java.util.Scanner;

public class Exercicio12 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Informe o salário: ");
		
		float salario = entrada.nextFloat();
		
		float reajuste;
		
		if(salario <= 280) {
			reajuste = 20;
		} else if(salario <= 700) {
			reajuste = 15;
		} else if(salario <= 1500) {
			reajuste = 10;
		} else {
			reajuste = 5;
		}
		
		float aumento = (reajuste/100) * salario; 
		float novoSalario = salario + aumento;
		
		System.out.println("Salário antigo: R$ " + salario);
		System.out.println("Percentual de aumento aplicado: " + reajuste + "%");
		System.out.println("Valor do aumento: R$ " + aumento);
		System.out.println("Novo salario: R$ " + novoSalario);
		
		entrada.close();
	}
}
