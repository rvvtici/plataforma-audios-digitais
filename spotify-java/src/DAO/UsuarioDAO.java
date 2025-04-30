
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import Model.Usuario;


public class UsuarioDAO {
    private Connection conn;

    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }
    
    public ResultSet consultar_login(Usuario usuario) throws SQLException{
        String sql = "select usuario, nome, senha from usuario where usuario = ? and senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario.getUsuario());
        statement.setString(2, usuario.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
    public ResultSet consultar_perfil(Usuario usuario) throws SQLException{
        String sql = "select usuario, nome, senha from usuario where usuario = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario.getUsuario());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
    public void inserir_novo_usuario(Usuario usuario) throws SQLException{
        String sql = "insert into usuario (usuario, nome, senha) values ('"
                      + usuario.getUsuario() + "', '"
                      + usuario.getNome()    + "', '"
                      + usuario.getSenha()   + "')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }
    
    public void atualizar_usuario(Usuario usuario, String usuario_antigo) throws SQLException{
        String sql = "update usuario set usuario = ?, nome = ?, senha = ? WHERE usuario = ?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario.getUsuario());
        statement.setString(2, usuario.getNome());
        statement.setString(3, usuario.getSenha());
        statement.setString(4, usuario_antigo);
        statement.execute();
        conn.close();
    }
    
    public void remover_usuario(Usuario usuario) throws SQLException{
        System.out.println(usuario);
        
        String sql = "delete from usuario where usuario = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario.getUsuario());
        
        System.out.println("user" + usuario.getUsuario());
        System.out.println("nome" + usuario.getNome());
        
        statement.execute();
        conn.close();
    }
    
}
