
package DAO;

import Model.Musica;
import Model.PlaylistModel;
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
        
       
        int linhasRetornadas = statement.executeUpdate();
        conn.close();
        
        // identifica se o nome ja existe no database. se já existir, nao cria a playlist.
        boolean modificado = linhasRetornadas > 0;
        return modificado;
    }
    
    public ResultSet completarTabelaPlaylist(Usuario usuario, PlaylistModel playlist) throws SQLException {
        String nomePlaylist = playlist.getNome_playlist();
        
        String sql = "SELECT m.nome, art.nome, al.nome, al.genero, m.duracao, m.id_musica " +
                     "from musica m " +
                     "inner join album al on al.id_album = m.id_album " +
                     "inner join artista art on art.id_artista = al.id_artista " +
                     "inner join playlist_songs ps on ps.id_musica = m.id_musica " +
                     "inner join playlist p on p.id_playlist = ps.id_playlist " +
                     "where p.usuario = ? and p.nome = ?";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        String user = usuario.getUsuario();
        statement.setString(1, user);
        statement.setString(2, nomePlaylist);
        
        ResultSet resultado = statement.executeQuery();
        return resultado;        
    }
    
    public void removerPlaylist(PlaylistModel playlist, Usuario usuario) throws SQLException{
        //System.out.println(playlist);
        
        String sql = "DELETE from playlist where nome = ? and usuario = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, playlist.getNome_playlist());
        statement.setString(2, usuario.getUsuario());
        
//        System.out.println("user" + usuario.getUsuario());
//        System.out.println("nome" + usuario.getNome());
        
        statement.executeUpdate();
        conn.close();
    }
    
        public void inserirMusica(PlaylistModel playlist, Musica musica) throws SQLException{            
            int idPlaylist = playlist.getId_playlist();
            //System.out.println(idPlaylist + "inserirMusica");
            int idMusica = musica.getId();
            
            String sql = "insert into playlist_songs(id_playlist, id_musica) VALUES (?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, idPlaylist);
            statement.setInt(2, idMusica);
            statement.executeUpdate();
            conn.close();
    }
    
        
        public ResultSet getIdPlaylist(Usuario usuario, PlaylistModel playlist) throws SQLException {
            String sql = "select id_playlist from playlist where usuario = ? and nome = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            String user = usuario.getUsuario();
            String nomePlaylist = playlist.getNome_playlist();
            statement.setString(1, user);
            statement.setString(2, nomePlaylist);

            ResultSet resultado = statement.executeQuery();
            return resultado;   

        }


        public void atualizarPlaylist(Usuario usuario, PlaylistModel playlistAtualizada, PlaylistModel playlistAntiga) throws SQLException{
            String sql = "UPDATE playlist SET nome = ?, descricao = ? " +
                    "WHERE id_playlist = ? and "
                    + "nome = ? and "
                    + "descricao = ? and "
                    + "usuario = ?";
                    
            String nomeAntigo = playlistAntiga.getNome_playlist();
            String descricaoAntiga = playlistAntiga.getDescricao_playlist();
            
            int idPlaylist = playlistAtualizada.getId_playlist();
            String nomeNovo = playlistAtualizada.getNome_playlist();
            String descricaoNova = playlistAtualizada.getDescricao_playlist();
            String user = usuario.getUsuario();
            
            
            
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nomeNovo);
            statement.setString(2, descricaoNova);
            statement.setInt(3, idPlaylist);
            statement.setString(4, nomeAntigo);
            statement.setString(5, descricaoAntiga);
            statement.setString(6, user);
            
            statement.executeUpdate();
            conn.close();
        }
}
