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

    public ResultSet buscar_musicas_curtidas(Usuario usuario) throws SQLException{      
        String user = usuario.getUsuario();

        String sql = "select m.nome, art.nome, al.nome, al.genero, m.duracao, m.id_musica " +
                     "from musica m " +
                     "inner join album al on al.id_album = m.id_album " +
                     "inner join artista art on art.id_artista = al.id_artista " +
                     "inner join liked_songs ls on m.id_musica = ls.id_musica " +
                     "where ls.usuario = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, user);
        
        ResultSet resultado = statement.executeQuery();
        return resultado;
    }   
}
