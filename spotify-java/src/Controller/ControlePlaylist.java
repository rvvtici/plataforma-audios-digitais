
package Controller;

import DAO.Conexao;
import DAO.PlaylistDAO;
import Model.PlaylistModel;
import Model.Usuario;
import Model.Musica;
import View.Home;
import View.PlaylistInfo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import View.Playlist;
import java.sql.PreparedStatement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControlePlaylist {
        private Playlist view;
        private Usuario usuario;
        private JTable tabela;
//        private

        public ControlePlaylist(Playlist view, Usuario usuario){
            this.view = view;
            this.usuario = usuario;
        }

        public ControlePlaylist(Playlist view){
            this.view = view;
        }
    
        public void redirectPaginaHome(Usuario usuario){  
            view.setVisible(false);
            Home h = new Home(usuario);
            h.setVisible(true);
        }

        public void redirectPlaylistInfo(Usuario usuario, PlaylistModel playlist){
            view.setVisible(false);
            PlaylistInfo pi = new PlaylistInfo(usuario, playlist);
            pi.setVisible(true);
        }
        
        
        public void addLinhasPlaylist(Usuario usuario, JTable tabela){
            DefaultTableModel resultado_busca = (DefaultTableModel) tabela.getModel();
            resultado_busca.setRowCount(0); // limpa a tabela

            Conexao conexao = new Conexao();
            try{
                Connection conn = conexao.getConnection();
                PlaylistDAO dao = new PlaylistDAO(conn);
                ResultSet res = dao.consultar_playlists(usuario);

                int cont = 0;
                while(res.next()){
                    String nomePlaylist = res.getString(1);
                    String descricao = res.getString(2);
                    
                    resultado_busca.addRow(new Object[] {
                        nomePlaylist, descricao
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
        
        public int adquirirIdPlaylist(Usuario usuario, PlaylistModel playlist){
            Conexao conexao = new Conexao();
            int idPlaylist = -1;
            try{
                Connection conn = conexao.getConnection();
                PlaylistDAO dao = new PlaylistDAO(conn);
                ResultSet res = dao.getIdPlaylist(usuario, playlist);
                
                if(res.next()){
                    idPlaylist = res.getInt(1);
//                    String descricao = res.getString(2);
                    
                }
            } catch(SQLException e){ 
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, 
                                              "Erro de conexão!\n" + e.getMessage(), 
                                              "Aviso",
                                              JOptionPane.ERROR_MESSAGE);
            }
            return idPlaylist;
        }
        
        
        
        
        public void novaPlaylist(Usuario usuario) {
            Conexao conexao = new Conexao();
            String nomePlaylist = view.getTxt_nome_playlist().getText();
            String descricao = view.getTxt_descricao().getText();
            
            if (nomePlaylist.isEmpty()){
                JOptionPane.showMessageDialog(view, "Nome da playlist vazio!","Erro", JOptionPane.ERROR_MESSAGE);
            }
            else{
                try {
                    Connection conn = conexao.getConnection();
                    PlaylistDAO dao = new PlaylistDAO(conn);
                    boolean modificado = dao.nova_playlist(usuario, nomePlaylist, descricao);
                    
                    if (modificado) {
                        JOptionPane.showMessageDialog(view, "Nova playlist criada com sucesso!","Aviso", JOptionPane.INFORMATION_MESSAGE);
                        addLinhasPlaylist(usuario, view.getTabela());
                    } else {
                        JOptionPane.showMessageDialog(view, "Nome de playlist já utilizado!", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(view, "Erro ao criar nova playlist!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
          
        
        
        
        
    } 

