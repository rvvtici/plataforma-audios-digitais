
package Controller;

import DAO.Conexao;
import DAO.UsuarioDAO;
import Model.Usuario;
import View.Home;
import View.Historico;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ControleHistorico {
        private Historico view;
        private Usuario usuario;

        public ControleHistorico(Historico view, Usuario usuario){
            this.view = view;
            this.usuario = usuario;
        }

        public ControleHistorico(Historico view){
            this.view = view;
        }
    
    
    
        public void redirectPaginaHome(Usuario usuario){        
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.consultar_perfil(usuario);

            if(res.next()){
                view.setVisible(false);
                Home h = new Home(usuario);
                h.setVisible(true);
            }
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(view,
                    "Erro: " + e.getMessage(),
                    "Erro ao redirecionar a home",
                    JOptionPane.ERROR_MESSAGE);
        }
    } 
}
