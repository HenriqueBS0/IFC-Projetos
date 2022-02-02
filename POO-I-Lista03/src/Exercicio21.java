import java.util.Scanner;

public class Exercicio21 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
	
		System.out.print("Informe o número de pessoas: ");
		int pessoas = entrada.nextInt();
		float media = 0;
		
		for(int i = 1; i <= pessoas; i++) {
			System.out.print("Informe a idade: ");
			media+= entrada.nextFloat();
		}
		
		media = media/pessoas;
		
		if(media < 26) {
			System.out.println("Turma Jovem");
		} else if (media < 60) {
			System.out.println("Turma Adulta");
		} else {
			System.out.println("Turma Idosa");
		}
	
		entrada.close();
	}
}
