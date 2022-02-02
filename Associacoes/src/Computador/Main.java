package Computador;

public class Main {
	public static void main(String[] args) {
		Processador p = new Processador();
		p.setMarca("Intel");
		p.setModelo("Processador Bom");
		p.setClock(2.3f);
		p.setCache(500);
		
		Memoria m = new Memoria();
		m.setMarca("Sandisk");
		m.setModelo("ddr3");
		m.setCapacidade(4);
		m.setVelocidade(500);
		
		HD hd = new HD();
		hd.setMarca("Sandisk");
		hd.setModelo("Bem Grande");
		hd.setCapacidade(500);
		hd.setRpm(500);
		
		PlacaMae placaMae = new PlacaMae();
		placaMae.setMarca("DELL");
		placaMae.setModelo("MS233-4");
		placaMae.processador = p;
		placaMae.hd = hd;
		placaMae.memoria = m;
		
		Gabinete g = new Gabinete();
		g.setModelo("Caixote");
		g.setTipo("Du Grande");
		g.setBaias(4);
		g.placaMae = placaMae;
		
		Mouse mouse = new Mouse();
		mouse.setMarca("Multilaser");
		mouse.setTipo("Gamer");
		
		Teclado teclado = new Teclado();
		teclado.setMarca("Lenovo");
		teclado.setTipo("Mecanico");
		
		Monitor monitor = new Monitor();
		monitor.setMarca("Lg");
		monitor.setTipo("HD");
		monitor.setResolucao("4K");
		
		Computador computador = new Computador();
		computador.setConsumo(2.3f);
		computador.setTencao(220);
		computador.setMarca("Dell");
		computador.setModelo("Computador du forte");
		computador.gabinete = g;
		computador.monitor = monitor;
		computador.mouse = mouse;
		computador.teclado = teclado;
		
		System.out.println(computador);
	}
}
