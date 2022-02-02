
public class Exercicio11 {
	public static void main(String[] args) {
		String data = "29/02/2021";
		if(!dataValida(data)) {
			System.out.println("Data inválida");
		} else {
			int[] arrayData = dataExplode(data);
			System.out.println("arrayData=[" + arrayData[0] + "," + arrayData[1] + "," + arrayData[2] + "]");
		}
	}
	
	private static int[] dataExplode(String data) {
		String[] dataSplit = data.split("/");
		int[] dataInt = {Integer.parseInt(dataSplit[0]), Integer.parseInt(dataSplit[1]), Integer.parseInt(dataSplit[2])};
		return dataInt;
	}
	
	private static boolean dataValida(String dataString) {
		int[] data = dataExplode(dataString);
		
		int dia = data[0];
		int mes = data[1];
		int ano = data[2];
		return anoValido(ano) && mesValido(mes) && diaValido(dia, mes, ano);
	}
	
	private static boolean mesValido(int mes) {
		if(mes >= 1 && mes <= 12)
			return true;
		return false;
	}
	
	private static boolean diaValido(int dia, int mes, int ano) {
		if(dia < 0 || dia > 31) {
			return false;
		}
		
		int maximoDiasFevereiro = ano % 4 == 0 ? 29 : 28;
		
		
		int[] maximoDiasMeses = {31, maximoDiasFevereiro, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		return dia <= maximoDiasMeses[mes - 1];
	}
	
	private static boolean anoValido(int ano) {
		if(ano >= 0 && ano <= 9999)
			return true;
		return false;
	}
}
