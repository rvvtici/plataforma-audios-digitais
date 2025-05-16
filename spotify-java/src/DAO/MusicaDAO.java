package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import Model.Usuario;
import java.util.ArrayList;

public class MusicaDAO {
    private Connection conn;
    
    public MusicaDAO(Connection conn){
        this.conn = conn;
    }

    
    public ResultSet buscar_musicas_curtidas_descurtidas(Usuario usuario, String tabela) throws SQLException{      
        String user = usuario.getUsuario();

        String sql = "select m.nome, art.nome, al.nome, al.genero, m.duracao, m.id_musica " +
                     "from musica m " +
                     "inner join album al on al.id_album = m.id_album " +
                     "inner join artista art on art.id_artista = al.id_artista " +
                     "inner join " + tabela + " t on m.id_musica = t.id_musica " +
                     "where t.usuario = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, user);
        
        ResultSet resultado = statement.executeQuery();
        return resultado;
    }
    
    
    public boolean consultar_curtidas_descurtidas(Usuario usuario, String consulta, int id_musica) throws SQLException{
        String user = usuario.getUsuario();
        
        //consulta = tabela (liked_songs / disliked_songs)
        
        String sql = "select id_musica from " + consulta +
                     " where usuario = ? and id_musica = ?";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, user);
        statement.setInt(2, id_musica);
        
        ResultSet res = statement.executeQuery();
        return res.next();        
    }
    
    
    public void adicionar_curtida_descurtida(Usuario usuario, String tabela, int id_musica) throws SQLException {
        // adiciona a curtida/descurtida à tabela liked_songs/unliked_songs
        String user = usuario.getUsuario();
        
        String sql = "INSERT INTO " + tabela + " (usuario, id_musica) VALUES (?, ?)";
        Conexao conexao = new Conexao();
        
        try (Connection conn = conexao.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, user);
            statement.setInt(2, id_musica);
            statement.executeUpdate();
        }
    }
        
    public void remover_curtida_descurtida(Usuario usuario, String tabela, int id_musica) throws SQLException {
        String user = usuario.getUsuario();
        
        String sql = "DELETE FROM " + tabela + " WHERE usuario = ? AND id_musica = ?";
        Conexao conexao = new Conexao();
        
        try (Connection conn = conexao.getConnection();
                PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, user);
            statement.setInt(2, id_musica);
            statement.executeUpdate();
        }
        
    
    }
}
