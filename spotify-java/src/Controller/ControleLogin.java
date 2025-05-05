
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
        String nome;
        String user = view.getTxt_user().getText();
        String senha = view.getTxt_senha().getText();
        Usuario usuario = new Usuario(user, null, senha);
    
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.consultar_perfil(usuario);
            
            ResultSet res_nome = dao.obter_nome(usuario); // colocar nome do usuairo na tela home                
            
            if(res_nome.next()){
                nome = res_nome.getString(1);
                usuario.setNome(nome);
            }
       
            if(res.next()){
                String user_database = res.getString(1);
                String nome_database = res.getString(2);
                String senha_database = res.getString(3);
                
                if (senha.equals(senha_database)){

                    JOptionPane.showMessageDialog(view, 
                                                  "Login efetuado!", 
                                                  "Aviso",
                                                  JOptionPane.INFORMATION_MESSAGE);
                    view.setVisible(false);
                    Home h = new Home(usuario);
                    h.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(view, 
                                              "Senha incorreta!", 
                                              "Aviso",
                                              JOptionPane.ERROR_MESSAGE);
                }
                
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
