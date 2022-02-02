package Interface;
import Entidades.*;

public class Cadastrar extends Interface {
	public static void imprimir() {
		System.out.println("---{ Cadastrar }---");
		String nome = informeNome();
		String email = informeEmail();
		String senha = informeSenha();
		String pais = informePais();
		String estado = informeEstado();
		String cidade = informeCidade();
		String rua = informeRua();
		String bairro = informeBairro();
		int numero = informeNumero();
		
		Endereco endereco = new Endereco(pais, estado, cidade, rua, bairro, numero);
		Usuario usuario = new Usuario(nome, email, senha, endereco);

		UsuarioList.usuarios.add(usuario);
		UsuarioList.gravar();
		encaminhar();
	}
	
	public static void encaminhar() {	
		Entrar.imprimir();
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
			emailExiste = UsuarioList.emailExiste(email);
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
