package Exercicio03;

public class ContaSimples extends Conta {

	private double saldoPoupanca;
	
	public ContaSimples(String banco, int agencia, int numero, double saldo, double saldoPoupanca) {
		super(banco, agencia, numero, saldo);
		setSaldoPoupanca(saldoPoupanca);
	}
	
	public ContaSimples() {
		
	}

	public double getSaldoPoupanca() {
		return saldoPoupanca;
	}

	public void setSaldoPoupanca(double saldoPoupanca) {
		this.saldoPoupanca = saldoPoupanca;
	}
	
	public boolean depositoPoupanca(double valor) {
		if(valor <= 0) {
			return false;
		}
		
		setSaldoPoupanca(getSaldoPoupanca() + valor);
		return true;
	}
	
	public boolean saquePoupanca(double valor) {
		if(valor <= 0 || valor > getSaldoPoupanca()) {
			return false;
		}
		
		setSaldoPoupanca(getSaldoPoupanca() - valor);
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ContaSimples [saldoPoupanca=");
		builder.append(saldoPoupanca);
		builder.append(", getSaldoPoupanca()=");
		builder.append(getSaldoPoupanca());
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
}
