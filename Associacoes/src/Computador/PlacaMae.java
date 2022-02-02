package Computador;

public class PlacaMae {
	private String marca;
	private String modelo;
	
	protected Processador processador;
	protected HD hd;
	protected Memoria memoria;
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PlacaMae [marca=");
		builder.append(marca);
		builder.append(", modelo=");
		builder.append(modelo);
		builder.append(", processador=");
		builder.append(processador);
		builder.append(", hd=");
		builder.append(hd);
		builder.append(", memoria=");
		builder.append(memoria);
		builder.append("]");
		return builder.toString();
	}
}
