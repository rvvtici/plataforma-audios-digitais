
package Controller;

import DAO.UsuarioDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Model.Usuario;
import View.Login;
import View.Home;
import java.sql.ResultSet;

public class ControleLogin {
    private Login view;
    
    public ControleLogin(Login view){
        this.view = view;
    }
    
public void loginUsuario(){
        Usuario usuario = new Usuario(null, 
                                view.getTxt_user().getText(),
                                view.getTxt_senha().getText());
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.consultar(usuario);
            if(res.next()){
                JOptionPane.showMessageDialog(view, 
                                              "Login efetuado!", 
                                              "Aviso",
                                              JOptionPane.INFORMATION_MESSAGE);
                Usuario aluno2 = new Usuario(res.getString("nome"), 
                                       res.getString("usuario"), 
                                     res.getString("senha"));
                //Home h = new Home(aluno2);
                Home h = new Home();
                h.setVisible(true);
            } else{
                JOptionPane.showMessageDialog(view, 
                                              "Login NÃO efetuado!", 
                                              "Aviso",
                                              JOptionPane.ERROR_MESSAGE);
            }
        } catch(SQLException e){    
            JOptionPane.showMessageDialog(view, 
                                              "Erro de conexão!", 
                                              "Aviso",
                                              JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
}
