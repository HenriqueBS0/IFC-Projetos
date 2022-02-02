package Entidades;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract public class Entidade {
	private int id;
	
	public Entidade(int id) {
		setId(id);
	}
	
	public int getId() {
		return id;
	}
	
	private void setId(int id) {
		this.id = id;
	}
	
	public static int getProximoId(List<? extends Entidade> entidades) {
		int maiorId = 0;
		for (Entidade entidade : entidades) {
			if(entidade.getId() > maiorId) {
				maiorId = entidade.getId();
			}
		}
		
		return maiorId + 1;
	}

	public static int getIndicePeloId(List<? extends Entidade> entidades, int id) {
		int indice = 0;
		
		for (Entidade entidade : entidades) {
			if(entidade.getId() == id) {
				return indice;
			}
			indice++;
		}
		
		return indice;
	}

	public static boolean idExiste(List<? extends Entidade> entidades, int id) {
		for (Entidade entidade : entidades) {
			if(entidade.getId() == id) {
				return true;
			}
		}
		
		return false;
	}
	
	static boolean contem(String string, String valor) {
		Pattern pattern = Pattern.compile(valor, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(string);
		return matcher.find();
	}
}
