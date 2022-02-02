package Computador;

public class Computador extends EquipamentoEletronico {
	private String marca;
	private String modelo;
	
	protected Gabinete gabinete;
	protected Teclado teclado;
	protected Mouse mouse;
	protected Monitor monitor;
	
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
		builder.append("Computador [marca=");
		builder.append(marca);
		builder.append(", modelo=");
		builder.append(modelo);
		builder.append(", gabinete=");
		builder.append(gabinete);
		builder.append(", teclado=");
		builder.append(teclado);
		builder.append(", mouse=");
		builder.append(mouse);
		builder.append(", monitor=");
		builder.append(monitor);
		builder.append(", getTencao()=");
		builder.append(getTencao());
		builder.append(", getConsumo()=");
		builder.append(getConsumo());
		return builder.toString();
	}
}
