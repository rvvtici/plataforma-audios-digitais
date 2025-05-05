
package Controller;

import DAO.UsuarioDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Model.Usuario;
import View.Login;
import View.MusicasCurtidas;
import View.Historico;
import View.Playlist;
import View.Home;
import View.Perfil;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ControleHome {
    private Home view;
    
    public ControleHome(Home view){
        this.view = view;
    }
    
    
    public void redirectPerfil(Usuario usuario){
        
                view.setVisible(false);
                Perfil p = new Perfil(usuario);
                p.setVisible(true);

    }
    
    public void redirectPlaylist(Usuario usuario){
                view.setVisible(false);
                Playlist p = new Playlist(usuario);
                p.setVisible(true);
   }
        
    public void redirectHistorico(Usuario usuario){
                view.setVisible(false);
                Historico h = new Historico(usuario);
                h.setVisible(true);
    }

        
    public void redirectMusicasCurtidas(Usuario usuario){
                view.setVisible(false);
                MusicasCurtidas mc = new MusicasCurtidas(usuario);
                mc.setVisible(true);
    }        
        
        public void buscar(Usuario usuario){
            String search = view.getTxt_busca().getText();
            String filtro = view.getCombobox_filtro().getSelectedItem().toString();
           
            JTable tabela = view.getTabela();    
            DefaultTableModel resultado_busca = (DefaultTableModel) tabela.getModel();

            resultado_busca.setRowCount(0); //remove todas as linhas antes de colcoar novas linhas na tabela
            Conexao conexao = new Conexao();
            try{
                Connection conn = conexao.getConnection();
                UsuarioDAO dao = new UsuarioDAO(conn);
                ResultSet res = dao.buscar_musica(filtro, search);
                while(res.next()){
                    String nome_musica = res.getString(1);
                    String nome_album = res.getString(2);
                    String nome_artista = res.getString(3);
                    String genero = res.getString(4);
                    String duracao = res.getString(5);
                    String curtida = "Curtir";

                    //System.out.println(nome_musica + " - " + nome_album + " - " + nome_artista + " - " + duracao);
                    
                    resultado_busca.addRow(add_dados_tabela(nome_musica, nome_album, nome_artista, genero, duracao, curtida));
                }
            } catch(SQLException e){    
                e.printStackTrace(); // mostra o erro completo no console
                JOptionPane.showMessageDialog(view, 
                    "Erro de busca!\n" + e.getMessage(), 
                    "Aviso",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
        
        public Object[] add_dados_tabela(String musica, String album, String artista, String genero, String duracao, String curtida){
            return new Object[] {musica, album, artista, genero, duracao, curtida};
        }
    
}
