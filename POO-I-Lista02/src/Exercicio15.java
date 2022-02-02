import java.util.Scanner;

public class Exercicio15 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("-->Produto");
		
		System.out.print("Preço de custo: ");
		float preco = entrada.nextFloat();
		
		System.out.print("Código de origem: ");
		int codigo = entrada.nextInt();
		
		String origem;
		
		switch (codigo) {
		case 1:
			origem = "Sul";
			break;
		case 2:
			origem = "Norte";
			break;
		case 3:
			origem = "Leste";
			break;
		case 4:
			origem = "Oeste";
			break;
		case 5:
		case 6:
			origem = "Nordeste";
			break;
		case 7:
		case 8:
			origem = "Centro-oeste";
			break;
		default:
			origem = "Importado";
			break;
		}
		
		System.out.println("Preço: " + preco);
		System.out.println("Procedencia: " + origem);
		
		entrada.close();
	}
}
