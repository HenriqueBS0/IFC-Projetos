package Entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Nota extends Entidade {
	
	private String titulo;
	private String descricao;
	private Date dataHoraCriacao;
	private Date daraHoraAlteracao;
	
	public List<Rotulo> rotulos = new ArrayList<Rotulo>();
	
	public Nota(String titulo, String descricao, Usuario usuario) {
		super(getProximoId(usuario.notas));
		setDataHoraCriacao();
		setTitulo(titulo);
		setDescricao(descricao);
	}
	
	private void atualizarDataAtualizacao() {
		setDaraHoraAlteracao(new Date());
	}

	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		if(titulo.length() > 0) {
			this.titulo = titulo;
			atualizarDataAtualizacao();
		}
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		if(descricao.length() > 0) {
			this.descricao = descricao;
			atualizarDataAtualizacao();
		}
	}
	
	public Date getDataHoraCriacao() {
		return dataHoraCriacao;
	}
	
	public void setDataHoraCriacao() {
		this.dataHoraCriacao = new Date();
	}
	
	public Date getDaraHoraAlteracao() {
		return daraHoraAlteracao;
	}
	
	public void setDaraHoraAlteracao(Date daraHoraAlteracao) {
		this.daraHoraAlteracao = daraHoraAlteracao;
	}
	
	public int getIndiceRotulo(int id) {
		return getIndicePeloId(rotulos, id);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Nota [titulo=");
		builder.append(titulo);
		builder.append(", descricao=");
		builder.append(descricao);
		builder.append(", dataHoraCriacao=");
		builder.append(dataHoraCriacao);
		builder.append(", daraHoraAlteracao=");
		builder.append(daraHoraAlteracao);
		builder.append("]");
		return builder.toString();
	}
}