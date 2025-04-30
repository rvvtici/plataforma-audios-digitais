package Controller;

import DAO.UsuarioDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Model.Usuario;
import View.Cadastro;

public class ControleCadastro {
    private Cadastro view;
    
    public ControleCadastro(Cadastro view){
        this.view = view;
    }
    
    public void salvarUsuario(){
        Usuario usuario = new Usuario (
                view.getTxt_user().getText(),
                view.getTxt_nome().getText(),
                view.getTxt_senha().getText()
        );
        
        System.out.println(usuario);
        
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            dao.inserir_novo_usuario(usuario);
            JOptionPane.showMessageDialog(view, "Usuario Cadastrado!","Aviso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Usuário não cadastrado!","Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
}
