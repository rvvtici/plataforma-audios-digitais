
package Model;

public class Autenticacao {
    private String usuario, nome, senha;

    public Autenticacao() {
    }

    public Autenticacao(String usuario, String nome, String senha) {
        this.usuario = usuario;
        this.nome = nome;
        this.senha = senha;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Autenticacao{" + "usuario=" + usuario + ", nome=" + nome + ", senha=" + senha + '}';
    }
    
}
