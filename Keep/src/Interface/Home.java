package Interface;

public class Home extends Interface {
	private final static int[] opcoes = {1,2,3,4};
	
	public static void imprimir() {
		System.out.println("---{ Home }---");
		int opcao = 0;
		do {
			System.out.println("1 - Dados Usuario");
			System.out.println("2 - Notas");
			System.out.println("3 - Rotulos");
			System.out.println("4 - Sair");
			opcao = entrada.nextInt();
			entrada.nextLine();
		} while(!opcaoValida(opcoes, opcao));
		encaminhar(opcao);
	}
	
	public static void encaminhar(int opcao) {
		switch (opcao) {
		case 1:
			DadosUsuario.imprimir();
			break;
		case 2:
			Notas.imprimir(Controller.usuarioLogado.notas);
			break;
		case 3:
			Rotulos.imprimir(Controller.usuarioLogado.rotulos);
			break;
		case 4:
			TelaInicial.imprimir();
			break;
		}
	}
}