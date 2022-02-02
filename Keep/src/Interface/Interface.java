package Interface;

import java.util.Scanner;

abstract public class Interface {
	
	public static final Scanner entrada = new Scanner(System.in);
	
	public static void imprimir() {	
	
	}
	
	public static void encaminhar(int opcao) {	
		
	}
	
	public static boolean opcaoValida(int[] opcoes, int opcaoEscolhida) {
		for (int opcao : opcoes) {
			if(opcaoEscolhida == opcao) {
				return true;
			}
		}
		
		return false;
	}
}
