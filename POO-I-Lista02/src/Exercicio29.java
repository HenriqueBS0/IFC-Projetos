import java.util.Scanner;

public class Exercicio29 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		int contador = 0;
		String res = "";
		
		System.out.print("Telefonou para a vítima?: ");
		res = entrada.nextLine();
		if(res.equals("S"))
			contador++;
		
		System.out.print("Esteve no local do crime?: ");
		res = entrada.nextLine();
		if(res.equals("S"))
			contador++;
		
		System.out.print("Mora perto da vítima?: ");
		res = entrada.nextLine();
		if(res.equals("S"))
			contador++;
		
		System.out.print("Devia para a vítima?: ");
		res = entrada.nextLine();
		if(res.equals("S"))
			contador++;
		
		System.out.print("Já trabalhou com a vítima?: ");
		res = entrada.nextLine();
		if(res.equals("S"))
			contador++;
		
		if(contador == 2)
			System.out.println("Suspeita");
		else if(contador == 3 || contador == 4)
			System.out.println("Cumplice");
		else if(contador == 5)
			System.out.println("Culpado");
		else
			System.out.println("Inocente");
		entrada.close();
	}

}
