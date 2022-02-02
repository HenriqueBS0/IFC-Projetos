import java.util.Scanner;

public class Exercicio09 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Informe a altura: ");
		float altura = entrada.nextFloat();
		
		System.out.print("Informe o peso: ");
		float peso = entrada.nextFloat();
		
		System.out.print("Informe o sexo: ");
		entrada.nextLine();
		String sexo = entrada.nextLine();

		float pesoIdeal = 0;
		
		switch (sexo) {
			case "F":
				sexo = "Feminino";
				pesoIdeal = (62.1f*altura) - 44.7f;
				break;
			case "M":
				sexo = "Masculino";
				pesoIdeal = (72.7f*altura) - 58;
				break;
		} 
		
		System.out.println("Altura: " + altura + "m");
		System.out.println("Peso: " + peso + "kg");
		System.out.println("Sexo: " + sexo);
		System.out.println("Peso Ideal: " + pesoIdeal + "kg");
		
		if(peso > pesoIdeal) {
			System.out.println("Acima do peso ideal");
		} else if (peso < pesoIdeal) {
			System.out.println("Abaixo do peso ideal");
		} else {
			System.out.println("No peso ideal");
		}
		
		entrada.close();
	}
}