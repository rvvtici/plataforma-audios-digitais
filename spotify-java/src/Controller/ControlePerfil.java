
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
     
    
    public void excluirConta(Usuario usuario){
        int option = JOptionPane.showConfirmDialog(view, "Deseja realmente excluir o cadastro?",
                "Aviso", JOptionPane.YES_NO_OPTION);
        if(option != 1){
            Conexao conexao = new Conexao();
            try{
                
                Connection conn = conexao.getConnection();
                UsuarioDAO dao = new UsuarioDAO(conn);
                dao.remover_usuario(usuario);
                JOptionPane.showMessageDialog(view, "Usuario removido com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                

                Login l = new Login();
                l.setVisible(true);
                view.setVisible(false);
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(view, "Falha de conexão!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
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
    
    public void redirectEditarPerfil(Usuario usuario){
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.consultar_perfil(usuario);
            
            if(res.next()){                
                view.setVisible(false);
                EditarPerfil ep = new EditarPerfil(usuario);
                ep.setVisible(true);
            }
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(view,
                    "Erro: " + e.getMessage(),
                    "Erro ao redirecionar a editar perfil",
                    JOptionPane.ERROR_MESSAGE);
        }

    }   
    
    
    
    
}
