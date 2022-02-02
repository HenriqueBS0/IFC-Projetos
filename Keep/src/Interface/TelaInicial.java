package Interface;

public class TelaInicial extends Interface {
	public static void imprimir() {
		int opcao =  0;
		do {
			System.out.println("---{ Tela Inicial }---");
			System.out.println("1 - Entrar");
			System.out.println("2 - Cadastrar");
			opcao = entrada.nextInt();
			entrada.nextLine();
		} while(opcao != 1 && opcao != 2);
	
		encaminhar(opcao);
	}
	
	public static void encaminhar(int opcao) {	
		if(opcao == 1) {
			Entrar.imprimir();
			return;
		}
		
		Cadastrar.imprimir();
	}
}
