package ContaAvancada;

abstract public class ContaBancaria {
	private int agencia;
	private int numeroDaConta;
	private double saldo;
	
	protected Banco banco;
	protected Pessoa correntista;
	
	public ContaBancaria(int agencia, int numero, double saldo) {
		setAgencia(agencia);
		setNumeroConta(numero);
		setSaldo(saldo);
		
		this.banco = new Banco();
		this.correntista = new Pessoa();
	}
	
	public int getAgencia() {
		return agencia;
	}
	
	public void setAgencia(int agencia) {
		if(agencia > 0)
			this.agencia = agencia;
	}
	
	public int getNumeroDaConta() {
		return numeroDaConta;
	}
	
	public void setNumeroConta(int numeroConta) {
		if(numeroDaConta > 0)
			this.numeroDaConta = numeroConta;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public boolean deposito(double valor) {
		if(valor <= 0) {
			return false;
		}
		
		setSaldo(getSaldo() + valor);
		return true;
	}
	
	public boolean saque(double valor) {
		if(valor <= 0 || valor > getSaldo()) {
			return false;
		}
		
		setSaldo(getSaldo() - valor);
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ContaBancaria [agencia=");
		builder.append(agencia);
		builder.append(", numeroDaConta=");
		builder.append(numeroDaConta);
		builder.append(", saldo=");
		builder.append(saldo);
		builder.append(", banco=");
		builder.append(banco);
		builder.append(", correntista=");
		builder.append(correntista);
		builder.append("]");
		return builder.toString();
	}
}
