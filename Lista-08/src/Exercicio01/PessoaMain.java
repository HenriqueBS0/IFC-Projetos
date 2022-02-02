package Exercicio01;

public class PessoaMain {
	public static void main(String[] args) {
		testePessoaFisica();
		testePessoaJuridica();
	}
	
	private static void testePessoaFisica() {
		PessoaFisica pessoa = new PessoaFisica("Henrique", "Rio do Sul", "123.457.453-32", "Solteiro");
		System.out.println(pessoa);
	}
	
	private static void testePessoaJuridica() {
		PessoaJuridica empresa = new PessoaJuridica("Meta", "EUA", "321.234.234.423-343", "Desenvolvedora de Software");
		System.out.println(empresa);
	}
}
