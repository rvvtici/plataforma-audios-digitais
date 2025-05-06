/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.UsuarioDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Model.Usuario;
import View.EditarPerfil;
import View.Perfil;
import View.Home;
import View.Perfil;
import View.Login;
import java.sql.ResultSet;

public class ControleEditarPerfil {  
    private EditarPerfil view;
    private Usuario usuario;
    private String novo_usuario, novo_nome, nova_senha;
    private String usuario_antigo, nome_antigo, senha_antiga;
    private String senha_inserida;
    
    public ControleEditarPerfil(EditarPerfil view, Usuario usuario) {
        this.view = view;
        this.usuario = usuario;
    }

    public ControleEditarPerfil(EditarPerfil view) {
        this.view = view;

    }
    
    public void redirectPerfil(Usuario usuario){
                view.setVisible(false);
                Perfil p = new Perfil(usuario);
                p.setVisible(true);

    }
    
    
    public void editarPerfil(Usuario usuario){
        usuario_antigo = usuario.getUsuario();
        nome_antigo = usuario.getNome();
        senha_antiga = usuario.getSenha();
        
        novo_usuario = view.getTxt_novo_user().getText();
        novo_nome = view.getTxt_novo_nome().getText();
        nova_senha = view.getTxt_nova_senha().getText();
        senha_inserida = view.getTxt_senha_antiga().getText();
        
        if (novo_usuario.isEmpty()){
            novo_usuario = usuario_antigo;
        } if (novo_nome.isEmpty()){
            novo_nome = nome_antigo;
        } if (nova_senha.isEmpty()){
            nova_senha = senha_antiga;
        }
        
        //verificar outros usuarios

        if(senha_antiga.equals(senha_inserida)){
            Usuario usuario_atualizado = new Usuario(novo_usuario, novo_nome, nova_senha);
            Conexao conexao = new Conexao();
            
            try{
                Connection conn = conexao.getConnection();
                UsuarioDAO dao = new UsuarioDAO(conn);
                dao.atualizar_usuario(usuario_atualizado, usuario_antigo);  
                
                JOptionPane.showMessageDialog(view, "Dados atualizados com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);

                Perfil p = new Perfil(usuario_atualizado);
                p.setVisible(true);
                view.setVisible(false);

//            } catch(SQLException e){
//                JOptionPane.showMessageDialog(view, "Falha de conexão!", "Erro", JOptionPane.ERROR_MESSAGE);
//            }
            }catch(SQLException e){
                e.printStackTrace(); // Mostra o erro no console
                JOptionPane.showMessageDialog(view, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }

            
            
        } else {
            JOptionPane.showMessageDialog(view, "Senha incorreta!", "Erro", JOptionPane.ERROR_MESSAGE);

        }
    }
}
