
package Controller;

import DAO.UsuarioDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Model.Usuario;
import View.Home;
import View.Perfil;
import View.EditarPerfil;
import View.Login;
import java.sql.ResultSet;


public class ControlePerfil {
    private Perfil view;
    private Usuario usuario;
    
    public ControlePerfil(Perfil view, Usuario usuario){
        this.view = view;
        this.usuario = usuario;
    }
    
    public ControlePerfil(Perfil view){
        this.view = view;
    }
     
    
    public void redirectPaginaHome(Usuario usuario){        
        view.setVisible(false);
        Home h = new Home(usuario);
        h.setVisible(true);
        
    }   
    
    public void redirectEditarPerfil(Usuario usuario){
        view.setVisible(false);
        EditarPerfil ep = new EditarPerfil(usuario);
        ep.setVisible(true);
    }   
    
    
    public void redirectLogin(){
        view.setVisible(false);
        Login l = new Login();
        l.setVisible(true);
    }   
    
    
    public void excluirConta(Usuario usuario){
        int option = JOptionPane.showConfirmDialog(view, "Deseja realmente excluir o cadastro?",
                "Aviso", JOptionPane.YES_NO_OPTION);
        if(option != 1){
            Conexao conexao = new Conexao();
            try{
                Connection conn = conexao.getConnection();
                UsuarioDAO dao = new UsuarioDAO(conn);
                dao.remover_usuario(usuario);
                JOptionPane.showMessageDialog(view, "Usuário removido com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                
                redirectLogin();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(view, "Falha de conexão!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }  
    
}
