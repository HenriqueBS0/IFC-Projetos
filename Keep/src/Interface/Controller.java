package Interface;

import Entidades.Nota;
import Entidades.Rotulo;
import Entidades.Usuario;
import Entidades.UsuarioList;

public class Controller {
	public static Usuario usuarioLogado;
	
	public static void gravar() {
		UsuarioList.usuarios.set(getIndiceUsuario(), usuarioLogado);
		UsuarioList.gravar();
	}
	
	public static void excluirUsuario() {
		UsuarioList.usuarios.remove(getIndiceUsuario());
		UsuarioList.gravar();
	}
	
	public static int getIndiceUsuario() {
		return Usuario.getIndicePeloId(UsuarioList.usuarios, usuarioLogado.getId());
	}
	
	public static void excluirRotuloNotas(int id) {
		for (int i = 0; i < usuarioLogado.notas.size(); i++) {
			if(Nota.idExiste(usuarioLogado.notas.get(i).rotulos, id)) {
				usuarioLogado.notas.get(i).rotulos.remove(usuarioLogado.notas.get(i).getIndiceRotulo(id));
			}
		}
		gravar();
	}
	
	public static void atualizarRotuloNotas(Rotulo rotulo) {
		for (int i = 0; i < usuarioLogado.notas.size(); i++) {
			if(Nota.idExiste(usuarioLogado.notas.get(i).rotulos, rotulo.getId())) {
				usuarioLogado.notas.get(i)
					.rotulos.set(usuarioLogado.notas.get(i).getIndiceRotulo(rotulo.getId()), rotulo);
			}
		}
		gravar();
	}
}
