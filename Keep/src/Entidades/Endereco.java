package Entidades;

public class Endereco extends Entidade {
	private String pais;
	private String estado;
	private String cidade;
	private String rua;
	private String bairro;
	private int numero;
	
	public Endereco(String pais, String estado, String cidade, String rua, String bairro, int numero) {
		super(1);
		setPais(pais);
		setEstado(estado);
		setCidade(cidade);
		setRua(rua);
		setBairro(bairro);
		setNumero(numero);
	}
	
	public String getPais() {
		return pais;
	}
	
	public void setPais(String pais) {
		if(pais.length() > 0)
			this.pais = pais;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		if(estado.length() > 0)
			this.estado = estado;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		if(cidade.length() > 0)
			this.cidade = cidade;
	}
	
	public String getRua() {
		return rua;
	}
	
	public void setRua(String rua) {
		if(rua.length() > 0)
			this.rua = rua;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		if(bairro.length() > 0)
			this.bairro = bairro;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		if(numero > 0)
			this.numero = numero;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Endereco [pais=");
		builder.append(pais);
		builder.append(", estado=");
		builder.append(estado);
		builder.append(", cidade=");
		builder.append(cidade);
		builder.append(", rua=");
		builder.append(rua);
		builder.append(", bairro=");
		builder.append(bairro);
		builder.append(", numero=");
		builder.append(numero);
		builder.append("]");
		return builder.toString();
	}
}