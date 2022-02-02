package Exercicio03;

public class ContaMain {
	public static void main(String[] args) {
		testeClasseContaEspecial();
	}
	
	public static void testeClasseConta() {
		Conta conta = new Conta("Banco do Brasil", 123, 321, 0);
		
		if(conta.deposito(1000))
			System.out.println("Deposito OK");
		
		if(!conta.deposito(-1000))
			System.out.println("Deposito Erro");
		
		if(conta.saque(100))
			System.out.println("Saque OK");
		
		if(!conta.saque(901))
			System.out.println("Saque Erro");
		
		System.out.println(conta);
	}
	
	public static void testeClasseContaSimples() {
		ContaSimples conta = new ContaSimples("Caixa", 456, 654, 100, 0);
		if(conta.depositoPoupanca(1000))
			System.out.println("Deposito P OK");
		
		if(!conta.depositoPoupanca(-1000))
			System.out.println("Deposito P Erro");
		
		if(conta.saquePoupanca(100))
			System.out.println("Saque P OK");
		
		if(!conta.saquePoupanca(901))
			System.out.println("Saque P Erro");
		System.out.println(conta);
	}
	
	public static void testeClasseContaEspecial() {
		ContaEspecial conta = new ContaEspecial("Bradesco", 653, 432, 1000, 5, 1000);
		if(!conta.saque(2001))
			System.out.println("Saque P Erro");
		
		if(conta.saque(2000))
			System.out.println("Saque P Ok");
		
		System.out.println(conta);
	}
}
