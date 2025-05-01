/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.Conexao;
import DAO.UsuarioDAO;
import Model.Usuario;
import View.Historico;
import View.Home;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import View.Playlist;

/**
 *
 * @author ravi
 */
public class ControlePlaylist {
        private Playlist view;
        private Usuario usuario;

        public ControlePlaylist(Playlist view, Usuario usuario){
            this.view = view;
            this.usuario = usuario;
        }

        public ControlePlaylist(Playlist view){
            this.view = view;
        }
    
    
        public void redirectPaginaHome(Usuario usuario){        
            Conexao conexao = new Conexao();
            try{
                Connection conn = conexao.getConnection();
                UsuarioDAO dao = new UsuarioDAO(conn);
                ResultSet res = dao.consultar_perfil(usuario);

                System.out.println("");
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
}
