package ContaAvancada;

public class ContaEspecial extends ContaBancaria{
	private int diasSemJuros;
	private double limite;
	
	protected CartaoDeCredito cartao;
	
	public ContaEspecial(int agencia, int numero, double saldo, int diasSemJuros, double limite) {
		super(agencia, numero, saldo);
		setDiasSemJuros(diasSemJuros);
		setLimite(limite);
		
		this.cartao = new CartaoDeCredito();
	}

	public int getDiasSemJuros() {
		return diasSemJuros;
	}

	public void setDiasSemJuros(int diasSemJuros) {
		if(diasSemJuros > 0)
			this.diasSemJuros = diasSemJuros;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		if(limite > 0)
			this.limite = limite;
	}
	
	public boolean saque(double valor) {
		if(valor > (getSaldo() + limite)) {
			return false;
		}
		
		setSaldo(getSaldo() - valor);
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ContaEspecial [diasSemJuros=");
		builder.append(diasSemJuros);
		builder.append(", limite=");
		builder.append(limite);
		builder.append(", cartao=");
		builder.append(cartao);
		builder.append("]");
		return builder.toString();
	}
}
