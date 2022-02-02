import java.util.Arrays;

public class Cone {
	private float Z;
	private float R;
	private int tipoTinta;
	private final float[] precosTipoTinta = {238.9f, 467.98f, 758.34f};
	private final float rendimento = 3.45f;
	private final float litrosPorLata = 18;
	
	Cone(float Z, float R, int tipoTinta) {
		setZ(Z);
		setR(R);
		setTipoTinta(tipoTinta);
	}
	
	Cone(float Z, float R) {
		setZ(Z);
		setR(R);
		setTipoTinta(1);
	}
	
	Cone(float Z, int tipoTinta) {
		setZ(Z);
		setTipoTinta(tipoTinta);
	}
	
	Cone(int tipoTinta, float R) {
		setR(R);
		setTipoTinta(tipoTinta);
	}
	
	Cone(float Z) {
		setZ(Z);
	}
	
	Cone(int tipoTinta) {
		setTipoTinta(tipoTinta);
	}
	
	Cone() {
		
	}
	
	public float getZ() {
		return Z;
	}
	
	public void setZ(float Z) {
		if(Z > 0) {
			this.Z = Z;
		}
	}
	
	public float getR() {
		return R;
	}
	
	public void setR(float R) {
		if(R > 0) {
			this.R = R;
		}
	}
	
	public void setTipoTinta(int tipoTinta) {
		if(tipoTinta >= 1 && tipoTinta <=3) {
			this.tipoTinta = tipoTinta;
		}
	}
	
	public int getTipoTinta() {
		return tipoTinta;
	}
	
	private float getPrecoTipoTinta(int tipo) {
		if(tipo > 0 && tipo <= 3) {
			return precosTipoTinta[tipo-1];
		}
		return 0;
	}
	
	public float getPrecoLitroTinta() {
		return getPrecoTipoTinta(getTipoTinta());
	}
	
	private float getRendimento() {
		return rendimento;
	}
	
	private float getLitrosPorLata() {
		return litrosPorLata;
	}
	
	public double areaCirculo() {
		return 3.14f * getR() * getR();
	}
	
	public double geratriz() {
		return Math.sqrt((getR() * getR()) + (getZ() * getZ()));
	}
	
	public double areaLateral() {
		return 3.14f * getR() * geratriz();
	}
	
	public double areaTotal() {
		return areaCirculo() + areaLateral();
	}
	
	public double litros() {
		return areaTotal() * getRendimento();
	}
	
	public double latas() {
		return Math.ceil(litros() / getLitrosPorLata());
	}
	
	public double precoTotal() {
		return latas() * getPrecoLitroTinta();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cone [Z=");
		builder.append(Z);
		builder.append(", R=");
		builder.append(R);
		builder.append(", tipoTinta=");
		builder.append(tipoTinta);
		builder.append(", precosTipoTinta=");
		builder.append(Arrays.toString(precosTipoTinta));
		builder.append(", rendimento=");
		builder.append(rendimento);
		builder.append(", litrosPorLata=");
		builder.append(litrosPorLata);
		builder.append(", getZ()=");
		builder.append(getZ());
		builder.append(", getR()=");
		builder.append(getR());
		builder.append(", getTipoTinta()=");
		builder.append(getTipoTinta());
		builder.append(", getPrecoLitroTinta()=");
		builder.append(getPrecoLitroTinta());
		builder.append(", getRendimento()=");
		builder.append(getRendimento());
		builder.append(", getLitrosPorLata()=");
		builder.append(getLitrosPorLata());
		builder.append(", areaCirculo()=");
		builder.append(areaCirculo());
		builder.append(", geratriz()=");
		builder.append(geratriz());
		builder.append(", areaLateral()=");
		builder.append(areaLateral());
		builder.append(", areaTotal()=");
		builder.append(areaTotal());
		builder.append(", litros()=");
		builder.append(litros());
		builder.append(", latas()=");
		builder.append(latas());
		builder.append(", precoTotal()=");
		builder.append(precoTotal());
		builder.append("]");
		return builder.toString();
	}
	
	
}
