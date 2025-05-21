
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import Model.Usuario;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.sql.SQLException;

import java.time.LocalDateTime;



public class UsuarioDAO {
    private Connection conn;

    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }
    
    
    // cadastro
    public void inserirNovoUsuario(Usuario usuario) throws SQLException{
        String sql = "INSERT INTO usuario (usuario, nome, senha) VALUES"
                + "(?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        
        String user = usuario.getUsuario();
        String nome = usuario.getNome();
        String senha = usuario.getSenha();
        statement.setString(1, user);
        statement.setString(2, nome);
        statement.setString(3, senha);
        
        statement.execute();
        conn.close();
    }
    
    //login → autenticacaoDAO
    
    //home: 
    
    
    
    
    //perfil
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
    
    //editar perfil
    public void atualizarUsuario(Usuario usuario, String usuario_antigo) throws SQLException{
        String sql = "update usuario set usuario = ?, nome = ?, senha = ? WHERE usuario = ?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario.getUsuario());
        statement.setString(2, usuario.getNome());
        statement.setString(3, usuario.getSenha());
        statement.setString(4, usuario_antigo);
        statement.execute();
        conn.close();
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
    
//    public ResultSet consultar_perfil(Usuario usuario) throws SQLException{
//        String sql = "select usuario, nome, senha from usuario where usuario = ?";
//        PreparedStatement statement = conn.prepareStatement(sql);
//        statement.setString(1, usuario.getUsuario());
//        statement.execute();
//        ResultSet resultado = statement.getResultSet();
//        return resultado;
//    }
//    ;
        
    public ResultSet consultar_historico(Usuario usuario) throws SQLException{
        String sql = "select search, filtro from historico where usuario = ? " +
                    "ORDER BY data DESC " +
                    "LIMIT 10";
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
        System.out.println(resultado);
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
    
    public void curtir_musica(String usuario, int id_musica) throws SQLException {
        String sql = "INSERT INTO liked_songs (usuario, id_musica) VALUES (?, ?)";

        Conexao conexao = new Conexao();
        try (Connection conn = conexao.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)){
            
            statement.setString(1, usuario);
            statement.setInt(2, id_musica);
            statement.executeUpdate();
        }    
    }
    
    public void nova_busca_historico(String usuario, String search, String filtro, LocalDateTime data) throws SQLException {
        String sql = "INSERT INTO historico (usuario, search, filtro, data) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario);
        statement.setString(2, search);
        statement.setString(3, filtro);
        
        Timestamp timestamp = Timestamp.valueOf(data);
        statement.setTimestamp(4, timestamp);

        statement.execute();
        conn.close();


    }
    
    
    
    public void descurtir_musica(String usuario, int id_musica) throws SQLException {
        String sql = "DELETE FROM liked_songs WHERE usuario = ? AND id_musica = ?";
        
        Conexao conexao = new Conexao();
        try (Connection conn = conexao.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)){
                statement.setString(1, usuario);
                statement.setInt(2, id_musica);
                statement.executeUpdate();
        }
    }
    
}
