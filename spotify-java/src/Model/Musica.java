package Model;

import Model.Artista;

public class Musica {
    private int id;
    private String nome_musica, genero, album, duracao;
    private Artista artista;
    
    public Musica (String nome_musica, Artista artista, String album, String genero, String duracao){
        this.nome_musica = nome_musica;
        this.artista = artista;
        this.album = album;
        this.genero = genero;
        this.duracao = duracao;
    }

    public Musica (String nome_musica, Artista artista, String album, String genero, String duracao, int id){
        this.nome_musica = nome_musica;
        this.artista = artista;
        this.album = album;
        this.genero = genero;
        this.duracao = duracao;
        this.id = id;
    }

    public Musica(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_musica() {
        return nome_musica;
    }

    public void setNome_musica(String nome_musica) {
        this.nome_musica = nome_musica;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return "Musica{" + 
            "id=" + id + 
            ", nome_musica=" + nome_musica + 
            ", genero=" + genero + 
            ", album=" + album + 
            ", duracao=" + duracao + 
            ", artista=" + (artista != null ? artista.getNome() : "Sem artista") + 
            '}';
    }

    
    
    
}
