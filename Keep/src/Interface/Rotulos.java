package Interface;

import java.util.List;

import Entidades.Rotulo;

public class Rotulos extends Interface {
	
	private static final int[] opcoes = {1,2,3,4,5};
	
	public static void imprimir(List<Rotulo> rotulos) {
		System.out.println("---{ Rotulos }---");
		imprimirRotulos(rotulos);
		int opcao = 0;
		do {
			System.out.println("1 - Cadastrar | 2 - Filtrar por descricao | 3 - Selecionar Rotulo | 4 - Voltar");
			opcao = entrada.nextInt();
			entrada.nextLine();
		} while (!opcaoValida(opcoes, opcao));
		encaminhar(opcao);
	}
	
	public static void encaminhar(int opcao) {
		switch (opcao) {
		case 1:
			cadastrar();
			break;
		case 2:
			filtrarPorDescricao();
			break;
		case 3:
			selecionarRotulo();
			break;
		case 4:
			Home.imprimir();
			break;
		}
	}
	
	private static void imprimirRotulos(List<Rotulo> rotulos) {
		for (Rotulo rotulo : rotulos) {
			System.out.println("Id: " + rotulo.getId() + " | Descricao: " + rotulo.getDescricao());
		}
	}
	
	private static void filtrarPorDescricao() {
		String descricao = informeDescricao();
		imprimir(Controller.usuarioLogado.getRotulosPorDescricao(descricao));
	}
	
	private static void selecionarRotulo() {
		int id = informeIdRotulos();
		int[] opcoes = {1,2,3};
		int opcao = 0;
		do {
			System.out.println("1 - Alterar | 2 - Excluir | 3 - Voltar");
			opcao = entrada.nextInt();
			entrada.nextLine();
		} while (!opcaoValida(opcoes, opcao));
		
		if(opcao == 3) {
			imprimir(Controller.usuarioLogado.rotulos);
			return;
		}
		
		if(opcao == 2) {
			excluir(id);
		}
		
		alterar(id);
	}
	
	public static String informeDescricao() {
		String descricao = "";
		do {
			System.out.println("Informe uma descrição: ");
			descricao = entrada.nextLine();
		} while (descricao.length() <= 0);
		return descricao;
	}
	
	public static int informeIdRotulos() {
		int rotuloSelecionado;
		do {
			System.out.println("Informe o id do rotulo");
			rotuloSelecionado = entrada.nextInt();
			entrada.nextLine();
		} while(!Rotulo.idExiste(Controller.usuarioLogado.rotulos, rotuloSelecionado));
		return rotuloSelecionado;
	}
	
	public static void cadastrar() {
		Controller.usuarioLogado.rotulos.add(new Rotulo(informeDescricao(), Controller.usuarioLogado));
		Controller.gravar();
		imprimir(Controller.usuarioLogado.rotulos);
	}
	
	public static void excluir(int id) {
		Controller.usuarioLogado.rotulos.remove(Controller.usuarioLogado.getIndiceRotulo(id));
		Controller.excluirRotuloNotas(id);
		Controller.gravar();
		imprimir(Controller.usuarioLogado.rotulos);
	}
	
	public static void alterar(int id) {	
		int indice = Controller.usuarioLogado.getIndiceRotulo(id);
		Rotulo rotulo = Controller.usuarioLogado.rotulos.get(indice);
		rotulo.setDescricao(informeDescricao());
		Controller.usuarioLogado.rotulos.set(indice, rotulo);
		Controller.atualizarRotuloNotas(rotulo);
		Controller.gravar();
		imprimir(Controller.usuarioLogado.rotulos);
	}
}
