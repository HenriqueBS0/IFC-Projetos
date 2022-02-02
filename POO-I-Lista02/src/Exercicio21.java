import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Exercicio21 {
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Informe uma data (dd/mm/aaaa): ");
		String data = entrada.nextLine();
		
		boolean dataValida = Exercicio21.isValid(data);
		
		if(dataValida) {
			System.out.println("Data válida");
		} else {
			System.out.println("Data Inválida");
		}
		
		entrada.close();
	}
	

	 public static boolean isValid(String data) {
	      try {
	         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	         LocalDate d = LocalDate.parse(data, formatter);    
	         return true;
	      } catch (DateTimeParseException e) {
	        return false;
	      }   
	   }
}
