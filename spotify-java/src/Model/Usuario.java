package Model;

public class Usuario extends Pessoa{
    private String usuario, senha;
    private PlaylistModel playlist;

    public Usuario() {
    }

    public Usuario(String usuario, String nome, String senha) {
        super(nome);
        this.usuario = usuario;
        this.senha = senha;
    }
    
    public Usuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public Usuario(String usuario, String senha, PlaylistModel playlist) {
        this.usuario = usuario;
        this.senha = senha;
        this.playlist = playlist;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public PlaylistModel getPlaylist() {
        return playlist;
    }

    public void setPlaylist(PlaylistModel playlist) {
        this.playlist = playlist;
    }

    
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;        
    }

    @Override
    public String toString() {
        return "Usuario{" + "nome=" + getNome() + ", usuario=" + usuario + ", senha=" + senha + '}';
    }
    
    
    
    
}
