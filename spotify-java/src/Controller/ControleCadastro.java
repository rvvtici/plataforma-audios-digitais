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
        String nome = view.getTxt_nome().getText();
        String user = view.getTxt_user().getText();
        String senha = view.getTxt_senha().getText();
        Usuario usuario = new Usuario(nome, user, senha);
        
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            dao.inserir(usuario);
            JOptionPane.showMessageDialog(view, "Usuario Cadastrado!","Aviso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Usuário não cadastrado!","Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
}
