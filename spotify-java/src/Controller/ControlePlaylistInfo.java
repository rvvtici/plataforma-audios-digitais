
package Controller;

import DAO.Conexao;
import DAO.MusicaDAO;
import DAO.PlaylistDAO;
import Model.Artista;
import Model.Musica;
import Model.Usuario;
import Model.PlaylistModel;
import View.Home;
import View.PlaylistInfo;
import View.Playlist;
import View.PlaylistEdit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControlePlaylistInfo {
        private PlaylistInfo view;
        private Usuario usuario;
        private JTable tabela;

        public ControlePlaylistInfo(PlaylistInfo view, Usuario usuario){
            this.view = view;
            this.usuario = usuario;
        }

        public ControlePlaylistInfo(PlaylistInfo view){
            this.view = view;
        }
    
        public void redirectPlaylist(Usuario usuario){  
            view.setVisible(false);
            Playlist p = new Playlist(usuario);
            p.setVisible(true);
        }
        
        public void redirectPlaylistEdit(Usuario usuario){
            view.setVisible(false);
            PlaylistEdit pe = new PlaylistEdit(usuario);
            pe.setVisible(true);
        }
        
        public void addMusicasTabela(Usuario usuario, JTable table, PlaylistModel playlist){
            DefaultTableModel tabela = (DefaultTableModel) table.getModel();
            
            int idPlaylist = playlist.getId_playlist();
            System.out.println(idPlaylist + "addMusicasTabela");

            Conexao conexao = new Conexao();
            try{
                Connection conn = conexao.getConnection();
                PlaylistDAO dao = new PlaylistDAO(conn);
                
                ResultSet res_musicas = dao.completarTabelaPlaylist(usuario, playlist);
                
                System.out.println("nome usuario: " + usuario.getNome());
                System.out.println("id playlist: " + playlist.getId_playlist());
                
                while (res_musicas.next()) {
                    String musica = res_musicas.getString(1);
                    String nomeArtista = res_musicas.getString(2);
                    String album = res_musicas.getString(3);
                    String genero = res_musicas.getString(4);
                    String duracao = res_musicas.getString(5);
                    int id_musica = res_musicas.getInt(6);

                    Artista art = new Artista(nomeArtista);
                    Musica m = new Musica (musica, art, album, genero, duracao, id_musica);

                    //Playlist p = new Playlist();
                    
                    tabela.addRow(new Object[]{
                        m.getNome_musica(), m.getArtista().getNome(), m.getAlbum(), m.getGenero(), m.getDuracao(), m.getId()
                    });

                    }
                } catch(SQLException e){ 
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, 
                                              "Erro de conexão!\n" + e.getMessage(), 
                                              "Aviso",
                                              JOptionPane.ERROR_MESSAGE);
            }
        }
        
        public void addMusicaPlaylist(Usuario usuario, JTable table, PlaylistModel playlist, Musica musica){
//            DefaultTableModel tabela = (DefaultTableModel) table.getModel();
            
            Conexao conexao = new Conexao();
            try{
                Connection conn = conexao.getConnection();
                PlaylistDAO dao = new PlaylistDAO(conn);
                
                int idPlaylist = playlist.getId_playlist();
                System.out.println(idPlaylist + "addMusicaPlaylist");
                dao.inserirMusica(playlist, musica);
                
                addMusicasTabela(usuario, table, playlist);
                
                } catch(SQLException e){ 
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, 
                                              "Erro de conexão!\n" + e.getMessage(), 
                                              "Aviso",
                                              JOptionPane.ERROR_MESSAGE);
            }
        }
        
        
    public void excluirPlaylist(Usuario usuario, PlaylistModel playlist){
        int option = JOptionPane.showConfirmDialog(view, "Deseja realmente excluir a playlist?",
                "Aviso", JOptionPane.YES_NO_OPTION);
        if(option != 1){
            Conexao conexao = new Conexao();
            try{
                
                Connection conn = conexao.getConnection();
                PlaylistDAO dao = new PlaylistDAO(conn);
                dao.removerPlaylist(playlist);
                JOptionPane.showMessageDialog(view, "Playlist removida com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                

                Playlist p = new Playlist();
                p.setVisible(true);
                view.setVisible(false);
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(view, "Falha de conexão!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }  
    
        
}