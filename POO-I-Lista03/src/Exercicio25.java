public class Exercicio25 {
	public static void main(String[] args) {
		int reais = 1;
		int centavos = 99;
		
		System.out.println("Lojas Quase Dois - Tabela de preços");
		
		for(int i = 1; i <= 50; i++) {
			System.out.println(i + " - R$ " + reais + "." + centavos);
			reais+= 2;
			centavos = centavos != 0 ? centavos - 1 : 99;
		}
	}
}
