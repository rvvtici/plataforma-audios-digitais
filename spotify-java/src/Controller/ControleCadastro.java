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
        String user = view.getTxt_user().getText();
        String nome = view.getTxt_nome().getText();
        String senha = view.getTxt_senha().getText();
        
        
        Usuario usuario = new Usuario (user, nome, senha);
        
        //System.out.println(usuario);
        
        Conexao conexao = new Conexao();
        if (user.equals("") || nome.equals("") || senha.equals("")){
            JOptionPane.showMessageDialog(view, "Campo de cadastro vazio!","Erro", JOptionPane.ERROR_MESSAGE);
        }
        else{
            try {
                Connection conn = conexao.getConnection();
                UsuarioDAO dao = new UsuarioDAO(conn);
                dao.inserir_novo_usuario(usuario);
                JOptionPane.showMessageDialog(view, "Usuário cadastrado com sucesso!","Aviso", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(view, "Usuário não cadastrado!","Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    
}
