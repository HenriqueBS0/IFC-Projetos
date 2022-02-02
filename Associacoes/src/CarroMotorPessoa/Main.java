package CarroMotorPessoa;

public class Main {
	public static void main(String[] args) {
		Carro carro = new Carro();
		
		carro.setFabricante("Fiat");
		carro.setModelo("Uno");
		carro.setCor("Vermelho");
		carro.setAno(2010);
		
		carro.dono.setNome("Henrique Borges dos Santos");
		carro.dono.setEndereco("Brasil, SC - Rio do Sul, Canoas - Joinville nº 155");
		
		carro.motor.setMarca("Fiat");
		carro.motor.setPotencia(1.0f);
		carro.motor.setCilintros(150);
		carro.motor.setCombustivel("Gasosa");
		
		System.out.println(carro);
	}
}
