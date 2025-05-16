package Controller;

import DAO.Conexao;
import DAO.UsuarioDAO;
import Model.Usuario;
import View.MusicasDescurtidas;
import View.Home;
import View.Historico;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControleMusicasDescurtidas {
    private MusicasDescurtidas view;
    private Usuario usuario;

    public ControleMusicasDescurtidas(MusicasDescurtidas view, Usuario usuario) {
        this.view = view;
        this.usuario = usuario;
    }

    public ControleMusicasDescurtidas(MusicasDescurtidas view) {
        this.view = view;
    }

    public void redirectPaginaHome(Usuario usuario) {
        view.setVisible(false);
        Home h = new Home(usuario);
        h.setVisible(true);
    }
    
}
