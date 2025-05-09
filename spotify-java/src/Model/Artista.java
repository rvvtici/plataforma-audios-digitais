package Model;

public class Artista {
    private String nome;
    private int id;

    public Artista(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public Artista() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Artista{" + "nome=" + nome + ", id=" + id + '}';
    }
    
    
}
