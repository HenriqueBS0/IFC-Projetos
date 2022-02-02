package Exercicio02;

public class CD extends Midia {
	private int faixas;
	private String artista;
	private String album;
	
	public CD(int codigo, String descricao, String gravadora, float duracao, int faixas, String artista, String album) {
		super(codigo, descricao, gravadora, duracao);
		setFaixas(faixas);
		setArtista(artista);
		setAlbum(album);
	}

	public int getFaixas() {
		return faixas;
	}

	public void setFaixas(int faixas) {
		if(faixas > 0)
			this.faixas = faixas;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		if(artista.length() > 0)
			this.artista = artista;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		if(album.length() > 0)
		this.album = album;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CD [faixas=");
		builder.append(faixas);
		builder.append(", artista=");
		builder.append(artista);
		builder.append(", album=");
		builder.append(album);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
}
