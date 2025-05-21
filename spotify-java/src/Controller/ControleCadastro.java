package Controller;

import DAO.UsuarioDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Model.Usuario;
import View.Cadastro;
import View.Login;

public class ControleCadastro {
    private Cadastro view;
    
    public ControleCadastro(Cadastro view){
        this.view = view;
    }
        
    public void redirectLogin(){
        view.setVisible(false);
        Login l = new Login();
        l.setVisible(true);
    }
    
    public void salvarUsuario(){
        String user = view.getTxt_user().getText();
        String nome = view.getTxt_nome().getText();
        String senha = view.getTxt_senha().getText();
        
        Usuario usuario = new Usuario (user, nome, senha);
        
        Conexao conexao = new Conexao();
        if (user.isEmpty() || nome.isEmpty() || senha.isEmpty()){
            JOptionPane.showMessageDialog(view, "Campo de cadastro vazio!","Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            
            try {
                Connection conn = conexao.getConnection();
                UsuarioDAO dao = new UsuarioDAO(conn);
                dao.inserirNovoUsuario(usuario);
                JOptionPane.showMessageDialog(view, "Usuário cadastrado com sucesso!","Aviso", JOptionPane.INFORMATION_MESSAGE);
                
                redirectLogin();
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(view, "Usuário não cadastrado!","Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    
}
