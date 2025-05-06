
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import Model.Usuario;


public class UsuarioDAO {
    private Connection conn;

    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }
    
    //consultas
    public ResultSet consultar_login(Usuario usuario) throws SQLException{
        String sql = "select usuario, nome, senha from usuario where usuario = ? and senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario.getUsuario());
        statement.setString(2, usuario.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
    public ResultSet consultar_perfil(Usuario usuario) throws SQLException{
        String sql = "select usuario, nome, senha from usuario where usuario = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario.getUsuario());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
    public ResultSet obter_nome(Usuario usuario) throws SQLException{
        String sql = "select nome from usuario where usuario = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario.getUsuario());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }    
    
    public ResultSet buscar_musica(String filtro, String search) throws SQLException{
        
        String coluna = switch(filtro){
            case "musica" -> "m.nome";
            case "album" -> "al.nome";
            case "artista" -> "art.nome";
            case "genero" -> "al.genero";
            //case "duracao" -> "m.duracao";
            default -> "";
        };
        
        String sql = "select m.nome, art.nome, al.nome, al.genero, m.duracao, m.id_musica " +
                     "from musica m " +
                     "inner join album al on al.id_album = m.id_album " +
                     "inner join artista art on art.id_artista = al.id_artista " +
                     "where " + coluna + " ilike ?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, "%" + search.trim() + "%");

        ResultSet resultado = statement.executeQuery();
        return resultado;
    }
    
    
    public ResultSet buscar_curtidas(Usuario usuario) throws SQLException{
        
        String user = usuario.getUsuario();
        
//        select id_musica from liked_songs
//        where usuario = 'ravi'
        
        String sql = "select id_musica from liked_songs " +
                     "where usuario = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, user);
        
        ResultSet resultado = statement.executeQuery();
        return resultado;
    }   
    
    
    
    //inserir
    public void inserir_novo_usuario(Usuario usuario) throws SQLException{
        String sql = "insert into usuario (usuario, nome, senha) values ('"
                      + usuario.getUsuario() + "', '"
                      + usuario.getNome()    + "', '"
                      + usuario.getSenha()   + "')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }
    
    public void curtir_musica(String usuario, int id_musica) throws SQLException {
        String sql = "INSERT INTO liked_songs (usuario, id_musica) VALUES (?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario);
        statement.setInt(2, id_musica);
        statement.executeUpdate();
    }
    
    
    
    
    //atualizar
    public void atualizar_usuario(Usuario usuario, String usuario_antigo) throws SQLException{
        String sql = "update usuario set usuario = ?, nome = ?, senha = ? WHERE usuario = ?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario.getUsuario());
        statement.setString(2, usuario.getNome());
        statement.setString(3, usuario.getSenha());
        statement.setString(4, usuario_antigo);
        statement.execute();
        conn.close();
    }
     
    
    
    //remover
    public void remover_usuario(Usuario usuario) throws SQLException{
        System.out.println(usuario);
        
        String sql = "delete from usuario where usuario = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario.getUsuario());
        
        System.out.println("user" + usuario.getUsuario());
        System.out.println("nome" + usuario.getNome());
        
        statement.execute();
        conn.close();
    }
    
    public void descurtir_musica(String usuario, int id_musica) throws SQLException {
        String sql = "DELETE FROM liked_songs WHERE usuario = ? AND id_musica = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario);
        statement.setInt(2, id_musica);
        statement.executeUpdate();
}
    
}
