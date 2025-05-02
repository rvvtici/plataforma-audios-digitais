
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
        Conexao conexao = new Conexao();
        try{
            //confirma existencia do usuário com banco de dados
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.consultar_perfil(usuario); 
            
//            if(res.next()){                
//                view.setVisible(false);
//                Playlist p = new Playlist(usuario);
//                p.setVisible(true);
//            }
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(view,
                    "Erro: " + e.getMessage(),
                    "Erro ao redirecionar a playlist",
                    JOptionPane.ERROR_MESSAGE);
        }
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

            Conexao conexao = new Conexao();
            try{
                Connection conn = conexao.getConnection();
                UsuarioDAO dao = new UsuarioDAO(conn);
                ResultSet res = dao.buscar_musica(filtro, search);
                while(res.next()){
                //if(res.next()){
                    String nomeMusica = res.getString(1);
                    String nomeAlbum = res.getString(2);
                    String nomeArtista = res.getString(3);
                    String duracao = res.getString(4);

                    System.out.println(nomeMusica + " - " + nomeAlbum + " - " + nomeArtista + " - " + duracao);
                }
} catch(SQLException e){    
    e.printStackTrace(); // mostra o erro completo no console
    JOptionPane.showMessageDialog(view, 
        "Erro de busca!\n" + e.getMessage(), 
        "Aviso",
        JOptionPane.ERROR_MESSAGE);
}

            
            
            //resultado_busca.addRow(rowData);
        }
    
}
