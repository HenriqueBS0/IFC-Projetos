package Computador;

public class EquipamentoEletronico {
	private float tencao;
	private float consumo;
	
	public float getTencao() {
		return tencao;
	}
	
	public void setTencao(float tencao) {
		this.tencao = tencao;
	}
	
	public float getConsumo() {
		return consumo;
	}
	
	public void setConsumo(float consumo) {
		this.consumo = consumo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EquipamentoEletronico [tencao=");
		builder.append(tencao);
		builder.append(", consumo=");
		builder.append(consumo);
		builder.append("]");
		return builder.toString();
	}
}
