package Exercicio03;

public class Conta {
	
	private String banco;
	private int agencia;
	private int numeroConta;
	private double saldo;
	
	public Conta(String banco, int agencia, int numero, double saldo) {
		setBanco(banco);
		setAgencia(agencia);
		setNumeroConta(numero);
		setSaldo(saldo);
	}
	
	public Conta() {
		
	}
	
	public String getBanco() {
		return banco;
	}
	
	public void setBanco(String banco) {
		if(banco.length() > 0)
			this.banco = banco;
	}
	
	public int getAgencia() {
		return agencia;
	}
	
	public void setAgencia(int agencia) {
		if(agencia > 0)
			this.agencia = agencia;
	}
	
	public int getNumeroConta() {
		return numeroConta;
	}
	
	public void setNumeroConta(int numeroConta) {
		if(numeroConta > 0)
			this.numeroConta = numeroConta;
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
		builder.append("Conta [banco=");
		builder.append(banco);
		builder.append(", agencia=");
		builder.append(agencia);
		builder.append(", numeroConta=");
		builder.append(numeroConta);
		builder.append(", saldo=");
		builder.append(saldo);
		builder.append("]");
		return builder.toString();
	}
}
