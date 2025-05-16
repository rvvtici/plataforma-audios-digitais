package Model;

public class Artista extends Pessoa{
    private int id;

    public Artista(String nome, int id) {
        super(nome);
        this.id = id;
    }
    
    public Artista(String nome){
        super(nome);
    }

    public Artista() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Artista{" + "nome=" + getNome() + ", id=" + id + '}';
    }
    
    
}
