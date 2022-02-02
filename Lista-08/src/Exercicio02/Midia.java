package Exercicio02;

public class Midia extends Item{
	private String gravadora;
	private float duracao;
	
	public Midia(int codigo, String descricao, String gravadora, float duracao) {
		super(codigo, descricao);
		setGravadora(gravadora);
		setDuracao(duracao);
	}

	public String getGravadora() {
		return gravadora;
	}

	public void setGravadora(String gravadora) {
		if(gravadora.length() > 0)
			this.gravadora = gravadora;
	}

	public float getDuracao() {
		return duracao;
	}

	public void setDuracao(float duracao) {
		if(duracao > 0)
			this.duracao = duracao;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Midia [gravadora=");
		builder.append(gravadora);
		builder.append(", duracao=");
		builder.append(duracao);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
}
