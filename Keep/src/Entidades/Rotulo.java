package Entidades;

public class Rotulo extends Entidade {
	private String descricao;
	
	public String getDescricao() {
		return descricao;
	}
	
	public Rotulo(String descricao, Usuario usuario) {
		super(getProximoId(usuario.rotulos));
		setDescricao(descricao);
	}

	public void setDescricao(String descricao) {
		if(descricao.length() > 0)
			this.descricao = descricao;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Rotulo [descricao=");
		builder.append(descricao);
		builder.append("]");
		return builder.toString();
	}
}
