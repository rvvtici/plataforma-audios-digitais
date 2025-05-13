package Model;

public class Musica {
    private int id, duracao;
    private String nome;
    private String album;   

    public Musica(int id, int duracao, String nome, String album) {
        this.id = id;
        this.duracao = duracao;
        this.nome = nome;
        this.album = album;
    }
}
