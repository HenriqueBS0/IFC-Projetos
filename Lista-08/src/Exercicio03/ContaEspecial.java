package Exercicio03;

public class ContaEspecial extends Conta{
	private int diasSemJuros;
	private double limite;
	
	public ContaEspecial(String banco, int agencia, int numero, double saldo, int diasSemJuros, double limite) {
		super(banco, agencia, numero, saldo);
		setDiasSemJuros(diasSemJuros);
		setLimite(limite);
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
}
