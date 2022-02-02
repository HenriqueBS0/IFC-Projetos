import java.util.Scanner;

public class Exercicio13 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Informe o valor da hora: ");
		float valorHora = entrada.nextFloat();
		
		System.out.print("Informe o número de horas trabalhadas: ");
		int horasTrabalhadas = entrada.nextInt();
		
		float salarioBruto = valorHora * horasTrabalhadas;
		
		float ir;
		
		if(salarioBruto <= 900) {
			ir = 0;
		} else if(salarioBruto <= 1500) {
			ir = 5;
		} else if(salarioBruto <= 2500) {
			ir = 10;
		} else {
			ir = 20;
		}
		
		final float SINDICATO = 3;
		final float FGTS = 11;
		
		final double DESCONTO_IR        = (ir/100) * salarioBruto;
		
		final double DESCONTO_SINDICATO = (SINDICATO/100) * salarioBruto;
		final double VALOR_FGTS         = (FGTS/100) * salarioBruto;
		
		final double DESCONTOS       = DESCONTO_IR + DESCONTO_SINDICATO;
		final double SALARIO_LIQUIDO = salarioBruto - DESCONTOS;
		
		System.out.println("Salário Bruto (" + valorHora + " * " + horasTrabalhadas + ") : R$ " + salarioBruto);
		System.out.println("(-) IR ("+ ir +"%): R$ " + DESCONTO_IR);
		System.out.println("(-) Sindicato ("+ SINDICATO +"%): R$ " + DESCONTO_SINDICATO);
		System.out.println("FGTS ("+ FGTS +"%): R$ " + VALOR_FGTS);
		System.out.println("Total de descontos: R$ " + DESCONTOS);
		System.out.println("Salário Liquido: R$ " + SALARIO_LIQUIDO);
		
		entrada.close();
	}
}
