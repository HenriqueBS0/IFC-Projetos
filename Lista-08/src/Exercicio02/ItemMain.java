package Exercicio02;

public class ItemMain {
	public static void main(String[] args) {
		testeLivro();
		testeCD();
		VHS();
	}
	
	private static void testeLivro() {
		System.out.println("-->Livro");
		Livro livro = new Livro(123, "teste testado", "Andréia");
		System.out.println(livro);
	}
	
	private static void testeCD() {
		System.out.println("-->CD");
		CD cd = new CD(43, "teste testando", "apple", 21.3f, 8, "Fernando", "Livre");
		System.out.println(cd);
	}
	
	private static void VHS() {
		System.out.println("-->VHS");
		VHS vhs = new VHS(543, "teste teste teste", "apple", 2.3f, "Teste");
		System.out.println(vhs);
	}
}
