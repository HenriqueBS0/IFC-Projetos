package Interface;

import Entidades.UsuarioList;

public class Entrar extends Interface {
	public static void imprimir() {
		System.out.println("---{ Entrar }---");
		informeEmail();
		informeSenha();
		encaminhar();
	}
	
	public static void encaminhar() {
		Home.imprimir();
	}
	
	
	private static void informeEmail() {
		String email = "";
		boolean emailExiste = true;
		do {
			if(!emailExiste) {
				System.out.println("Email informado não existe!");
			}
			System.out.println("Informe o email: ");
			email = entrada.nextLine();
			emailExiste = UsuarioList.emailExiste(email);
		} while(!emailExiste || email.length() <= 0);
		
		Controller.usuarioLogado = UsuarioList.getUsuarioPeloEmail(email);
	}
	
	private static void informeSenha() {
		String senha = "";
		boolean senhaValida = true;
		do {
			if(!senhaValida) {
				System.out.println("Senha incorreta!");
			}
			
			System.out.println("Informe a senha: ");
			senha = entrada.nextLine();
			
			senhaValida = senha.length() > 0 && Controller.usuarioLogado.verificarSenha(senha);
		} while (!senhaValida);
	}
}
