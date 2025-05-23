package DAO;

import Model.Musica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import Model.Usuario;

public class MusicaDAO {
    private Connection conn;
    
    public MusicaDAO(Connection conn){
        this.conn = conn;
    }

    public ResultSet buscarMusica(String filtro, String search) throws SQLException{
        
        String coluna = switch(filtro){
            case "Musica" -> "m.nome";
            case "Album" -> "al.nome";
            case "Artista" -> "art.nome";
            case "Genero" -> "al.genero";
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
        //System.out.println(resultado);
        return resultado;
    }
    
    
    //musicasCurtidasDescurtidas
    public ResultSet buscarMusicasCurtidasDescurtidas(Usuario usuario, String tabela) throws SQLException{      
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
    
    //
    public boolean consultar_curtidas_descurtidas(Usuario usuario, String consulta, Musica musica) throws SQLException{
        String user = usuario.getUsuario();
        int id_musica = musica.getId();
        
        
        String sql = "select id_musica from " + consulta +
                     " where usuario = ? and id_musica = ?";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, user);
        statement.setInt(2, id_musica);
        
        ResultSet res = statement.executeQuery();
        return res.next();        
    }
    
    
    public void adicionar_curtida_descurtida(Usuario usuario, String tabela, Musica musica) throws SQLException {
        // adiciona a curtida/descurtida à tabela liked_songs/unliked_songs
        String user = usuario.getUsuario();
        int id_musica = musica.getId();
                
        String sql = "INSERT INTO " + tabela + " (usuario, id_musica) VALUES (?, ?)";
        Conexao conexao = new Conexao();
        
        try (Connection conn = conexao.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, user);
            statement.setInt(2, id_musica);
            statement.executeUpdate();
        }
    }
        
    public void remover_curtida_descurtida(Usuario usuario, String tabela, Musica musica) throws SQLException {
        String user = usuario.getUsuario(); 
        int id_musica = musica.getId();
        
        String sql = "DELETE FROM " + tabela + " WHERE usuario = ? AND id_musica = ?";
        Conexao conexao = new Conexao();
        
        try (Connection conn = conexao.getConnection();
                PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, user);
            statement.setInt(2, id_musica);
            statement.executeUpdate();
        }
        
    
    }
    
    
    public boolean musicaExiste(Musica musica) throws SQLException{
        int id_musica = musica.getId();
        
        String sql = "SELECT id_musica FROM musica WHERE id_musica = ?";
        //Conexao conexao = new Conexao();

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id_musica);
        
        ResultSet res = statement.executeQuery();
        return res.next();   
    }
    
    
}
