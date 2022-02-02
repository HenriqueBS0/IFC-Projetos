package Exercicio02;

public class VHS extends Midia{
	private String titulo;
	
	public VHS(int codigo, String descricao, String gravadora, float duracao, String titulo) {
		super(codigo, descricao, gravadora, duracao);
		setTitulo(titulo);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		if(titulo.length() > 0)
			this.titulo = titulo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VHS [titulo=");
		builder.append(titulo);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
}
