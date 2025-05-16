package Model;

public class Usuario extends Pessoa{
    private String usuario, senha;

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
    
    public String getUsuario() {
        return usuario;
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
