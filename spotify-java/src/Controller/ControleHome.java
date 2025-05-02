
package Controller;

import DAO.UsuarioDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Model.Usuario;
import View.Login;
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
    
    
    public void paginaPerfilUser(){
        
        Usuario usuario = new Usuario(
                                       view.getLbl_user().getText(),
                                        null,
                                       null);
        Conexao conexao = new Conexao();
        
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.consultar_perfil(usuario);
            if(res.next()){
                String user = res.getString("usuario"); // coluna no sql chama "usuario"
                String nome = res.getString("nome");
                String senha = res.getString("senha");
            
                Usuario usuario2 = new Usuario(user, nome, senha);
                
                view.setVisible(false);
                Perfil p = new Perfil(usuario2);
                p.setVisible(true);
            }    
            //Usuario usuario = new Usuario();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(view,
                    "Erro: " + e.getMessage(),
                    "Erro ao redirecionar ao perfil",
                    JOptionPane.ERROR_MESSAGE);
            }

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
        
        
        
        public void buscar(){
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
                    String duracao = res.getString(4);

                    //System.out.println(nome_musica + " - " + nome_album + " - " + nome_artista + " - " + duracao);
                    
                    resultado_busca.addRow(add_dados_tabela(nome_musica, nome_album, nome_artista, duracao));
                    
                    //System.out.println(add_dados_tabela(nome_musica, nome_album, nome_artista, duracao));
                    //Object objeto = new Object[] {nomeMusica, nomeAlbum, nomeArtista, duracao};
                    //resultado_busca.addRow(objeto);
                }
            } catch(SQLException e){    
                e.printStackTrace(); // mostra o erro completo no console
                JOptionPane.showMessageDialog(view, 
                    "Erro de busca!\n" + e.getMessage(), 
                    "Aviso",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
        
        public Object[] add_dados_tabela(String musica, String album, String artista, String duracao){
            return new Object[] {musica, album, artista, duracao};
        }
    
}
