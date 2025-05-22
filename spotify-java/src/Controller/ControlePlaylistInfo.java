
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
        private PlaylistModel playlist;
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
        
        public void redirectPlaylistEdit(Usuario usuario, PlaylistModel playlist){
            view.setVisible(false);
            PlaylistEdit pe = new PlaylistEdit(usuario, playlist);
            pe.setVisible(true);
        }
        
        public void addMusicasTabela(Usuario usuario, JTable table, PlaylistModel playlist){
            DefaultTableModel tabela = (DefaultTableModel) table.getModel();
            tabela.setRowCount(0);
            
            //System.out.println("playlist no addmusicastabela: " + playlist);
            
            int idPlaylist = playlist.getId_playlist();
            
            Conexao conexao = new Conexao();
            try{
                Connection conn = conexao.getConnection();
                PlaylistDAO dao = new PlaylistDAO(conn);
                
                ResultSet res_musicas = dao.completarTabelaPlaylist(usuario, playlist);
                
                while (res_musicas.next()) {
                    String musica = res_musicas.getString(1);
                    String nomeArtista = res_musicas.getString(2);
                    String album = res_musicas.getString(3);
                    String genero = res_musicas.getString(4);
                    String duracao = res_musicas.getString(5);
                    int id_musica = res_musicas.getInt(6);

                    Artista art = new Artista(nomeArtista);
                    Musica m = new Musica (musica, art, album, genero, duracao, id_musica);
                    PlaylistModel playlist2 = new PlaylistModel(
                            playlist.getId_playlist(), 
                            playlist.getNome_playlist(), 
                            playlist.getDescricao_playlist(), 
                            m);
//                    
//                    
//                    System.out.println(m);
//                    System.out.println(playlist2);
                    tabela.addRow(new Object[]{
                        playlist2.getMusica().getNome_musica(), 
                        playlist2.getMusica().getArtista().getNome(), 
                        playlist2.getMusica().getAlbum(), 
                        playlist2.getMusica().getGenero(), 
                        playlist2.getMusica().getDuracao(), 
                        playlist2.getMusica().getId(),   
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
                System.out.println("playlist no addmusicaplaylist" + playlist);
                dao.inserirMusica(playlist, musica);
//                System.out.println(usuario);
//                System.out.println(table);
//                System.out.println(playlist);
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
                dao.removerPlaylist(playlist, usuario);
                JOptionPane.showMessageDialog(view, "Playlist removida com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                
                redirectPlaylist(usuario);
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(view, "Falha de conexão!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }  
    
        
}