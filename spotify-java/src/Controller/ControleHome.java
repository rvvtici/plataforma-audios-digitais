
package Controller;

import DAO.UsuarioDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Model.Usuario;
import View.Login;
import View.Home;
import View.Perfil;
import java.sql.ResultSet;


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
    
    
    
}
