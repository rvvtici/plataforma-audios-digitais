package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import Model.Usuario;
import java.sql.SQLException;


public class AutenticacaoDAO {
    private Connection conn;
    
    public AutenticacaoDAO(Connection conn) {
        this.conn = conn;
    }      
    
    // login + nome de usuário
    public ResultSet login(Usuario usuario) throws SQLException{
        String sql = "select usuario, nome, senha from usuario where usuario = ? and senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario.getUsuario());
        statement.setString(2, usuario.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
}
