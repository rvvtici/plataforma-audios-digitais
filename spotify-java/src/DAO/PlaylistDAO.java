
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
public class PlaylistDAO {
    private Connection conn;
    
    public PlaylistDAO(Connection conn){
        this.conn = conn;
    }
    
    public ResultSet consultar_playlists(Usuario usuario) throws SQLException {
        String sql = "select nome, descricao from playlist where usuario = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario.getUsuario());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
    public void nova_playlist(Usuario usuario, String nomePlaylist, String descricao) throws SQLException {
        String sql = "INSERT INTO playlist (nome, descricao, usuario) VALUES " +
                    "(?,?,?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        
        statement.setString(1, nomePlaylist);
        statement.setString(2, descricao);
        statement.setString(3, usuario.getUsuario());
        
        
        statement.execute();
        conn.close();
    }
    
    
}
