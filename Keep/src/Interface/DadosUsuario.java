package Interface;

import Entidades.UsuarioList;

public class DadosUsuario extends Interface {
	private static final int[] opcoes = {1,2,3};
	
	public static void imprimir() {
		System.out.println("---{ Dados }---");
		imprimirDados();
		int opcao = 0;
		do {
			System.out.println("1 - Alterar | 2 - Excluir | 3 - Voltar");
			opcao = entrada.nextInt();
			entrada.nextLine();
		} while (!opcaoValida(opcoes, opcao));
		encaminhar(opcao);
	}
	
	public static void encaminhar(int opcao) {
		switch (opcao) {
		case 1:
			alterar();
			break;
		case 2:
			excluir();
			break;
		case 3:
			voltar();
			break;
		}
	}
	
	private static void alterar() {
		Controller.usuarioLogado.setNome(informeNome());
		Controller.usuarioLogado.setEmail(informeEmail());
		Controller.usuarioLogado.setSenha(informeSenha());
		Controller.usuarioLogado.getEndereco().setPais(informePais());
		Controller.usuarioLogado.getEndereco().setEstado(informeEstado());
		Controller.usuarioLogado.getEndereco().setCidade(informeCidade());
		Controller.usuarioLogado.getEndereco().setRua(informeRua());
		Controller.usuarioLogado.getEndereco().setBairro(informeBairro());
		Controller.usuarioLogado.getEndereco().setNumero(informeNumero());
		Controller.gravar();
		
		imprimir();
	}
	
	private static void voltar() {
		Home.imprimir();
	}
	
	private static void excluir() {
		Controller.excluirUsuario();
		TelaInicial.imprimir();
	}
	
	public static void imprimirDados() {
		System.out.println("Nome: " + Controller.usuarioLogado.getNome());
		System.out.println("Email: " + Controller.usuarioLogado.getEmail());
		System.out.println("Pais: " + Controller.usuarioLogado.getEndereco().getPais());
		System.out.println("Estado: " + Controller.usuarioLogado.getEndereco().getEstado());
		System.out.println("Cidade: " + Controller.usuarioLogado.getEndereco().getCidade());
		System.out.println("Rua: " + Controller.usuarioLogado.getEndereco().getRua());
		System.out.println("Bairro: " + Controller.usuarioLogado.getEndereco().getBairro());
		System.out.println("Número: " + Controller.usuarioLogado.getEndereco().getNumero());
	}
	
	private static String informeNome() {
		String nome = "";
		do {
			System.out.println("Informe o Nome: ");
			nome = entrada.nextLine();
		} while (nome.length() <= 0);
		return nome;
	}
	
	private static String informeEmail() {
		String email = "";
		boolean emailExiste = false;
		do {
			if(emailExiste) {
				System.out.println("Email informado já foi cadastrado");
			}
			System.out.println("Informe o email: ");
			email = entrada.nextLine();
			emailExiste = UsuarioList.emailExiste(email) && !email.equals( Controller.usuarioLogado.getEmail());
		} while(emailExiste || email.length() <= 0);
		return email;
	}
	
	private static String informeSenha() {
		String senha = "";
		do {
			System.out.println("Informe a senha: ");
			senha = entrada.nextLine();
		} while (senha.length() <= 0);
		return senha;
	}
	
	private static String informePais() {
		String pais = "";
		do {
			System.out.println("Informe o pais: ");
			pais = entrada.nextLine();
		} while (pais.length() <= 0);
		return pais;
	}
	
	private static String informeEstado() {
		String estado = "";
		do {
			System.out.println("Informe o estado: ");
			estado = entrada.nextLine();
		} while (estado.length() <= 0);
		return estado;
	}
	
	private static String informeCidade() {
		String cidade = "";
		do {
			System.out.println("Informe a cidade: ");
			cidade = entrada.nextLine();
		} while (cidade.length() <= 0);
		return cidade;
	}
	
	private static String informeRua() {
		String rua = "";
		do {
			System.out.println("Informe a rua: ");
			rua = entrada.nextLine();
		} while (rua.length() <= 0);
		return rua;
	}
	
	private static String informeBairro() {
		String bairro = "";
		do {
			System.out.println("Informe o bairro: ");
			bairro = entrada.nextLine();
		} while (bairro.length() <= 0);
		return bairro;
	}
	
	private static int informeNumero() {
		int numero = 0;
		do {
			System.out.println("Informe o número: ");
			numero = entrada.nextInt();
			entrada.nextLine();
		} while (numero <= 0);
		return numero;
	}
}
