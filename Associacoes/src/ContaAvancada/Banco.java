package ContaAvancada;

public class Banco {
	private int codigo;
	private String nome;
	private int numeroDeAgencias;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNumeroDeAgencias() {
		return numeroDeAgencias;
	}
	public void setNumeroDeAgencias(int numeroDeAgencias) {
		this.numeroDeAgencias = numeroDeAgencias;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Banco [codigo=");
		builder.append(codigo);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", numeroDeAgencias=");
		builder.append(numeroDeAgencias);
		builder.append("]");
		return builder.toString();
	}
}
