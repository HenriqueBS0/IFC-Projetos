package Interface;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import Entidades.Nota;
import Entidades.Rotulo;

public class Notas extends Interface{
	public static void imprimir(List<Nota> notas) {
		System.out.println("---{ Notas }---");
		imprimirNotas(notas);
		int[] opcoes = {1,2,3,4};
		int opcao = getOpcao(opcoes, "1 - Cadastrar | 2 - Selecionar | 3 - Filtrar | 4 - voltar");
		
		switch (opcao) {
		case 1:
			cadastrar();
			break;
		case 2:
			selecionar();
			break;
		case 3:
			filtrar();
			break;
		case 4:
			Home.imprimir();
			break;
		}
	}
	
	private static void imprimirNotas(List<Nota> notas) {
		for (Nota nota : notas) {
			System.out.println("Id: " + nota.getId() + " | Titulo: " + nota.getTitulo());
		}
	}
	
	private static int getOpcao(int[] opcoes, String mensagem) {
		int opcao = 0;
		do {
			System.out.println(mensagem);
			opcao = entrada.nextInt();
			entrada.nextLine();
		} while (!opcaoValida(opcoes, opcao));
		
		return opcao;
	}
	
	private static void cadastrar() {
		String titulo = informeTitulo();
		String descricao = informeDescricao();
		List<Rotulo> rotulos = informeRotulos();
		
		Nota nota = new Nota(titulo, descricao, Controller.usuarioLogado);
		nota.rotulos = rotulos;
		Controller.usuarioLogado.notas.add(nota);
		Controller.gravar();
		
		imprimir(Controller.usuarioLogado.notas);
	}
	
	private static String informeTitulo() {
		String titulo = "";
		do {
			System.out.println("Informe o titulo: ");
			titulo = entrada.nextLine();
		} while (titulo.length() <= 0);
		return titulo;
	}
	
	private static String informeDescricao() {
		String descricao = "";
		do {
			System.out.println("Informe a descrição: ");
			descricao = entrada.nextLine();
		} while (descricao.length() <= 0);
		return descricao;
	}
	
	private static List<Rotulo> informeRotulos() {
		List<Rotulo> rotulos = new ArrayList<Rotulo>();
		
		imprimeRotulos(Controller.usuarioLogado.rotulos);
		
		System.out.println("Informe os rotulos separados por ','");
		
		String rotulosInformados = entrada.nextLine();
		String[] rotulosArray = rotulosInformados.split(",");
		
		for (int i = 0; i < rotulosArray.length; i++) {
			int id = 0;
			try{
	            id = Integer.parseInt(rotulosArray[i]);
	        }
	        catch (NumberFormatException e){
	            e.printStackTrace();
	        }
	        
			for (Rotulo rotulo : Controller.usuarioLogado.rotulos) {
				if(rotulo.getId() == id) {
					rotulos.add(rotulo);
				}
			}
		}
		
		return rotulos;
	}
	
	
	private static void imprimeRotulos(List<Rotulo> rotulos) {
		System.out.println("Rotulos: ");
		for (Rotulo rotulo : rotulos) {
			System.out.println(" - Id: " + rotulo.getId() + " | Descricao: " + rotulo.getDescricao());
		}
	}
	
	private static void selecionar() {
		int id = 0;
		do {
			System.out.println("Informe o id: ");
			id = entrada.nextInt();
			entrada.nextLine();
		} while (!Nota.idExiste(Controller.usuarioLogado.notas, id));
		opcoesSelecionar(id);
	}
	
	private static void opcoesSelecionar(int id) {
		int indice = Controller.usuarioLogado.getIndiceNota(id);
		imprimirNota(Controller.usuarioLogado.notas.get(indice));
		int[] opcoes = {1,2,3};
		int opcao = getOpcao(opcoes, "1 - Alterar | 2 - Excluir | 3 - Voltar"); 
		switch (opcao) {
		case 1:
			alterar(indice);
			break;
		case 2:
			excluir(indice);
			break;
		case 3:
			imprimir(Controller.usuarioLogado.notas);
			break;
		}
	}
	
	private static void imprimirNota(Nota nota) {
		System.out.println("-->Detalhamento Nota");
		System.out.println("Id: " + nota.getId() + " | Título: " + nota.getTitulo());
		System.out.println("Descrição: " + nota.getDescricao());
		imprimeRotulos(nota.rotulos);
	}
	
	private static void filtrar() {
		int[] opcoes = {1,2,3};
		int opcao = getOpcao(opcoes, "1 - Por titulo | 2 - Por Rotulo | 3 - Por Data");
		switch (opcao) {
		case 1:
			filtrarPorTitulo();
			break;
		case 2:
			filtrarPorRotulo();
			break;
		case 3:
			filtrarPorData();
			break;

		}
	}
	
	private static void filtrarPorTitulo() {
		List<Nota> notas = Controller.usuarioLogado.getNotasPorTitulo(informeTitulo());
		imprimir(notas);
	}
	
	private static void filtrarPorRotulo() {
		imprimeRotulos(Controller.usuarioLogado.rotulos);
		int id = entrada.nextInt();
		entrada.nextLine();
		List<Nota> notas = Controller.usuarioLogado.getNotasPorRotulos(id);
		imprimir(notas);
	}
	
	
	private static void filtrarPorData() {
		Date dataInicial = informeData("->Data inicial");
		Date dataFinal = informeData("->Data final");
		List<Nota> notas = Controller.usuarioLogado.getNotasEntreDatas(dataInicial, dataFinal);
		imprimir(notas);
	}
	
	private static Date informeData(String mensagem) {
		System.out.println(mensagem);
		Calendar calendario = Calendar.getInstance();
		System.out.println("Informe ano, mês e dia: ");
		calendario.set(entrada.nextInt(), (entrada.nextInt() - 1), entrada.nextInt());
		entrada.nextLine();
		return calendario.getTime();
	}
	
	private static void alterar(int indice) {
		Nota nota = Controller.usuarioLogado.notas.get(indice);
		nota.setTitulo(informeTitulo());
		nota.setDescricao(informeDescricao());
		nota.rotulos = informeRotulos();
		
		Controller.usuarioLogado.notas.set(indice, nota);
		Controller.gravar();
		imprimir(Controller.usuarioLogado.notas);
	}
	
	private static void excluir(int indice) {
		Controller.usuarioLogado.notas.remove(indice);
		Controller.gravar();
		imprimir(Controller.usuarioLogado.notas);
	}
}
