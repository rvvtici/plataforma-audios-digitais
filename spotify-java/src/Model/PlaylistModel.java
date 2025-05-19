
package Model;

import Model.Musica;

public class PlaylistModel {
    private int id_playlist;
    private String nome_playlist, descricao_playlist;
    private Musica musica;
    
    public PlaylistModel (int id_playlist, String nome_playlist, String descricao_playlist, Musica musica){
        this.id_playlist = id_playlist;
        this.descricao_playlist = descricao_playlist;
        this.nome_playlist = nome_playlist;
        this.musica = musica;
    }
    
    public PlaylistModel (int id_playlist, String nome_playlist, String descricao_playlist){
        this.id_playlist = id_playlist;
        this.descricao_playlist = descricao_playlist;
        this.nome_playlist = nome_playlist;
    }
    
    
    public PlaylistModel (String nome_playlist, String descricao_playlist){
        this.descricao_playlist = descricao_playlist;
        this.nome_playlist = nome_playlist;
    }

    public PlaylistModel(int id_playlist) {
        this.id_playlist = id_playlist;
    }
    
    

    public int getId_playlist() {
        return id_playlist;
    }

    public void setId_playlist(int id_playlist) {
        this.id_playlist = id_playlist;
    }

    public String getNome_playlist() {
        return nome_playlist;
    }

    public void setNome_playlist(String nome_playlist) {
        this.nome_playlist = nome_playlist;
    }

    public String getDescricao_playlist() {
        return descricao_playlist;
    }

    public void setDescricao_playlist(String descricao_playlist) {
        this.descricao_playlist = descricao_playlist;
    }

    public Musica getMusica() {
        return musica;
    }

    public void setMusica(Musica musica) {
        this.musica = musica;
    }

    @Override
    public String toString() {
        return "Playlist{" + "id_playlist=" + id_playlist + ", nome_playlist=" + nome_playlist + ", descricao_playlist=" + descricao_playlist + ", musica=" + musica + '}';
    }
    
}
