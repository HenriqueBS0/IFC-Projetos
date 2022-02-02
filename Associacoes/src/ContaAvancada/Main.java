package ContaAvancada;

public class Main {
	public static void main(String[] args) {
		Pessoa henrique = new Pessoa();
		henrique.setNome("Henrique Borges dos Santos");
		henrique.setEndereco("Rio do Sul, Canoas");
		
		Banco bb = new Banco();
		bb.setCodigo(123);
		bb.setNome("Banco do Brasil");
		bb.setNumeroDeAgencias(3211);
		
		CartaoDeCredito cartao = new CartaoDeCredito();
		cartao.setNumero(111333444);
		cartao.setOperadora("Vivo");
		cartao.setLimite(1000);
		cartao.setTipoDeCartao("Black");
		
		ContaSimples contaSimples = new ContaSimples(123, 432, 5000, 5000);
		contaSimples.banco = bb;
		contaSimples.correntista = henrique;
		
		ContaEspecial contaEspecial = new ContaEspecial(456, 6546, 10000, 5, 1000);
		contaEspecial.banco = bb;
		contaEspecial.correntista = henrique;
		contaEspecial.cartao = cartao;
		
		System.out.println("-->Conta Simples");
		System.out.println(contaSimples);
		
		System.out.println("-->Conta Especial");
		System.out.println(contaEspecial);
	}
}
