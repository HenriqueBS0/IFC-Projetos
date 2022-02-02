import java.util.Scanner;

public class Exercicio32 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Informe os (kg) de carne: ");
		float kgCarne = entrada.nextFloat();
		
		System.out.print("Informe o tipo de carne (1-File duplo 2-Alcatra 3-Picanha): ");
		int tipoCarne = entrada.nextInt();
		
		boolean cartao;
		System.out.print("Compra feita no cartão tabajara (S|N): ");
		entrada.nextLine();
		if(entrada.nextLine().equals("S"))
			cartao = true;
		else
			cartao = false;
		
		float desconto = 0;
		if(cartao)
			desconto = 5;
		
		String tipoCarneDescritivo = "";
		float precoCarne = 0;
		switch (tipoCarne) {
		case 1:
			tipoCarneDescritivo = "File Duplo";
			if(kgCarne <= 5) {
				precoCarne = 4.9f;
			} else {
				precoCarne = 5.8f;
			}
			break;
		case 2:
			tipoCarneDescritivo = "Alcatra";
			if(kgCarne <= 5) {
				precoCarne = 5.9f;
			} else {
				precoCarne = 6.8f;
			}
			break;
		case 3:
			tipoCarneDescritivo = "Pricanha";
			if(kgCarne <= 5) {
				precoCarne = 6.9f;
			} else {
				precoCarne = 7.8f;
			}
			break;
		}
		
		float precoTotal = precoCarne * kgCarne;
		String tipoPagamento = cartao ? "Sim" : "Não";
		
		float valorDesconto = (desconto == 0) ? 0 : precoTotal * (desconto/100);
		float valorAPagar = precoTotal - valorDesconto;
		
		System.out.println("Tipo de Carne: " + tipoCarneDescritivo);
		System.out.println("Quantidade de carne (kg): " + kgCarne);
		System.out.println("Preço total: " + precoTotal);
		System.out.println("Cartão Tabajara: " + tipoPagamento);
		System.out.println("Valor desconto (R$): " + valorDesconto);
		System.out.println("Valor a pagar (R$): " + valorAPagar);
		
		entrada.close();
	}
}
