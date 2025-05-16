
package Controller;

import DAO.AutenticacaoDAO;
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
        String user = view.getTxt_user().getText();
        String senha = view.getTxt_senha().getText();
        Usuario usuario = new Usuario(user, null, senha);
    
        if (user.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(view, 
                                            "Campo de usuário e/ou senha vazio(s)!", 
                                            "Erro",
                                            JOptionPane.ERROR_MESSAGE);
            return;
        }   
        
        Conexao conexao = new Conexao();
        
        try{
            Connection conn = conexao.getConnection();
            AutenticacaoDAO auth_dao = new AutenticacaoDAO(conn);
            ResultSet res = auth_dao.login(usuario);        
            if(res.next()){
                JOptionPane.showMessageDialog(view, 
                                            "Login efetuado!", 
                                            "Aviso",
                                            JOptionPane.INFORMATION_MESSAGE);


                String user_db = res.getString(1);
                String nome_db = res.getString(2);
                String senha_db = res.getString(3);

                Usuario usuario_db = new Usuario (user_db, nome_db, senha_db);
                
                view.setVisible(false);
                Home h = new Home(usuario_db);
                h.setVisible(true);
                
            } else {
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
