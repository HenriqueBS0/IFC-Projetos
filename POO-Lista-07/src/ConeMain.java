import java.util.Scanner;

public class ConeMain {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("-->Cone");
		
		System.out.print("Raio: ");
		float raio = entrada.nextFloat();
		
		System.out.print("Altura: ");
		float altura = entrada.nextFloat();
		
		System.out.print("Nível: ");
		int nivel = entrada.nextInt();
		
		Cone cone = new Cone(altura, raio, nivel);
		
		System.out.println("-------------");
		System.out.println("Geratriz: " + cone.geratriz());
		System.out.println("-------------");
		System.out.println("Área do Fundo: " + cone.areaCirculo());
		System.out.println("Área Lateral Cone: " + cone.areaLateral());
		System.out.println("Área Total: " + cone.areaTotal());
		System.out.println("-------------");
		System.out.println("Litros: " + cone.litros());
		System.out.println("Latas: " + cone.latas());
		System.out.println("-------------");
		System.out.println("Preço Total: " + cone.precoTotal());
		
		entrada.close();
	}
}
