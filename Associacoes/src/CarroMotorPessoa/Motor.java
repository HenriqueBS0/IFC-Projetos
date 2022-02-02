package CarroMotorPessoa;

public class Motor {
	private String marca;
	private float potencia;
	private int cilintros;
	private String combustivel;
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		if(marca.length() > 0)
			this.marca = marca;
	}
	public float getPotencia() {
		return potencia;
	}
	public void setPotencia(float potencia) {
		if(potencia > 0)
			this.potencia = potencia;
	}
	public int getCilintros() {
		return cilintros;
	}
	public void setCilintros(int cilintros) {
		if(cilintros > 0)
			this.cilintros = cilintros;
	}
	public String getCombustivel() {
		return combustivel;
	}
	public void setCombustivel(String combustivel) {
		if(combustivel.length() > 0)
			this.combustivel = combustivel;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Motor [marca=");
		builder.append(marca);
		builder.append(", potencia=");
		builder.append(potencia);
		builder.append(", cilintros=");
		builder.append(cilintros);
		builder.append(", combustivel=");
		builder.append(combustivel);
		builder.append("]");
		return builder.toString();
	}
}
