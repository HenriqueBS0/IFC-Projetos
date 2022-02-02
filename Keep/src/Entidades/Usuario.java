package Entidades;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Usuario extends Entidade {
	transient final String salt = "[B@4ca8195f";
	
	private String nome;
	private String email;
	private String senha;
	
	private Endereco endereco;
	
	public List<Nota> notas = new ArrayList<Nota>();
	public List<Rotulo> rotulos = new ArrayList<Rotulo>();
	
	public Usuario(String nome, String email, String senha, Endereco endereco) {
		super(getProximoId(UsuarioList.usuarios));
		setNome(nome);
		setEmail(email);
		setSenha(senha);
		setEndereco(endereco);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(nome.length() > 0)
			this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if(email.length() > 0)
			this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		if(senha.length() > 0)
			this.senha = getSecurePassword(senha, salt);
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public List<Nota> getNotasPorTitulo(String titulo) {
		List<Nota> notasFiltradas = new ArrayList<Nota>();
		for (Nota nota : notas) {
			if(Entidade.contem(nota.getTitulo(), titulo)) {
				notasFiltradas.add(nota);
			}
		}
		
		return notasFiltradas;
	}

	public List<Nota> getNotasEntreDatas(Date dataInicial, Date dataFinal) {
		List<Nota> notasFiltradas = new ArrayList<Nota>();
		for (Nota nota : notas) {
			boolean apos = 
					nota.getDataHoraCriacao().after(dataInicial) || 
					nota.getDaraHoraAlteracao().after(dataInicial);
			boolean antes =
					nota.getDataHoraCriacao().before(dataFinal) || 
					nota.getDaraHoraAlteracao().after(dataFinal);
			
			if(apos && antes) {
				notasFiltradas.add(nota);
			}
		}
		
		return notasFiltradas;
	}
	
	public List<Nota> getNotasPorRotulos(int id) {
		List<Nota> notasFiltradas = new ArrayList<Nota>();
		
		for (Nota nota : notas) {
			for (Rotulo rotulo : nota.rotulos) {
				if(rotulo.getId() == id) {
					notasFiltradas.add(nota);
				}
			}
		}
		
		return notasFiltradas;
	}
	
	public int getIndiceNota(Nota nota) {
		return getIndicePeloId(notas, nota.getId());
	}
	
	public int getIndiceNota(int id) {
		return getIndicePeloId(notas, id);
	}
	
	public List<Rotulo> getRotulosPorDescricao(String descricao) {
		List<Rotulo> rotulosFiltados = new ArrayList<Rotulo>();
		for (Rotulo rotulo : rotulos) {
			if(contem(rotulo.getDescricao(), descricao)) {
				rotulosFiltados.add(rotulo);
			}
		}
		
		return rotulosFiltados;
	}
	
	public int getIndiceRotulo(Rotulo rotulo) {
		return getIndicePeloId(rotulos, rotulo.getId());
	}
	
	public int getIndiceRotulo(int id) {
		return getIndicePeloId(rotulos, id);
	}

	private static String getSecurePassword(String passwordToHash, String salt) {
		String generatedPassword = null;
		try {
			// Create MessageDigest instance for MD5
	        MessageDigest md = MessageDigest.getInstance("MD5");
	            
	        // Add password bytes to digest
	        md.update(salt.getBytes());
	            
            // Get the hash's bytes
            byte[] bytes = md.digest(passwordToHash.getBytes());
            
            // This bytes[] has bytes in decimal format;
            // Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
                        .substring(1));
            }
            
            // Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
	
	public boolean verificarSenha(String senhaInformada) {
		senhaInformada = getSecurePassword(senhaInformada, salt);
		return senha.equals(senhaInformada);
	}
	
}