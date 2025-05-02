
package Controller;

import DAO.Conexao;
import DAO.UsuarioDAO;
import Model.Usuario;
import View.Home;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import View.Playlist;

public class ControlePlaylist {
        private Playlist view;
        private Usuario usuario;

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

//            Conexao conexao = new Conexao();
//            try{
//                Connection conn = conexao.getConnection();
//                UsuarioDAO dao = new UsuarioDAO(conn);
//                ResultSet res = dao.consultar_perfil(usuario);
//
//                if(res.next()){
//                    view.setVisible(false);
//                    Home h = new Home(usuario);
//                    h.setVisible(true);
//                    
//                    //aq
//                    
//                    System.out.println();
//                    
//                }
//            } catch (SQLException e) {
//                    JOptionPane.showMessageDialog(view,
//                        "Erro: " + e.getMessage(),
//                        "Erro ao redirecionar a home",
//                        JOptionPane.ERROR_MESSAGE);
//        }
    } 
}
