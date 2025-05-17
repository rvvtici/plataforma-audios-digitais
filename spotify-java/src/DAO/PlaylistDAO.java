
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
    
    public boolean nova_playlist(Usuario usuario, String nomePlaylist, String descricao) throws SQLException {
//        String sql = "INSERT INTO playlist (nome, descricao, usuario) VALUES " +
//                    "(?,?,?) ";

        String sql = "INSERT INTO playlist (nome, descricao, usuario) " +
                    "SELECT ?, ?, ? "+
                    "WHERE NOT EXISTS ( " +
                        "SELECT 1 FROM playlist " +
                        "WHERE nome = ? AND usuario = ?)";

        PreparedStatement statement = conn.prepareStatement(sql);
        
        statement.setString(1, nomePlaylist);
        statement.setString(2, descricao);
        statement.setString(3, usuario.getUsuario());
        statement.setString(4, nomePlaylist);
        statement.setString(5, usuario.getUsuario());
        
        
//        statement.setString(4, nomePlaylist);
//        statement.setString(5, descricao);
//        statement.setString(6, usuario.getUsuario());
//        
//        
//        statement.setString(7, usuario.getUsuario());
//        statement.setString(8, nomePlaylist);
//        statement.setString(9, usuario.getUsuario());
//        
        int linhasRetornadas = statement.executeUpdate();
        conn.close();
        boolean modificado= linhasRetornadas > 0;
        return modificado;
    }
    
    
}
