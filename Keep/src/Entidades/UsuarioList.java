package Entidades;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class UsuarioList {
	
	public static List<Usuario> usuarios = ler();
	
	public static void gravar() {
		GsonBuilder builder = new GsonBuilder();
	    Gson gson = builder.create();
	    FileWriter writer;
		try {
			writer = new FileWriter("json/usuarios.json");
			writer.write(gson.toJson(usuarios));
		    writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static List<Usuario> ler() {
	    BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(
							 new FileReader("json/usuarios.json"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	    Type listType = new TypeToken<ArrayList<Usuario>>(){}.getType();
	    usuarios = new ArrayList<Usuario>();
	    usuarios = new Gson().fromJson(bufferedReader, listType);
	    return usuarios;
	}
	
	public static boolean emailExiste(String email) {
		for (Usuario usuario : usuarios) {
			if(usuario.getEmail().equals(email)) {
				return true;
			}
		}
		
		return false;
	}
	
	public static Usuario getUsuarioPeloEmail(String email) {
		for (Usuario usuario : usuarios) {
			if(usuario.getEmail().equals(email)) {
				return usuario;
			}
		}
		Usuario usuario = new Usuario("", "", "", (new Endereco("", "", "", "", "", 0)));
		return usuario;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UsuarioList [usuarios=");
		builder.append(usuarios);
		builder.append("]");
		return builder.toString();
	}
}
