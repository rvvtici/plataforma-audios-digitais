package Controller;

import DAO.Conexao;
import DAO.MusicaDAO;
import DAO.UsuarioDAO;
import Model.Musica;
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
    
    public void buscar(Usuario usuario, JTable table){
            DefaultTableModel tabela = (DefaultTableModel) table.getModel();
            tabela.setRowCount(0); // limpa a tabela

            Conexao conexao = new Conexao();
            try{
                Connection conn = conexao.getConnection();
                MusicaDAO dao = new MusicaDAO(conn);

                ResultSet res_musicas = dao.buscar_musicas_curtidas_descurtidas(usuario, "unliked_songs");
                
                while (res_musicas.next()) {;
                    String musica = res_musicas.getString(1);
                    String artista = res_musicas.getString(2);
                    String album = res_musicas.getString(3);
                    String genero = res_musicas.getString(4);
                    String duracao = res_musicas.getString(5);

                    Musica m = new Musica (musica, artista, album, genero, duracao);
                    
                    tabela.addRow(new Object[]{
                        m.getNome_musica(), m.getArtista(), m.getAlbum(), m.getGenero(), m.getDuracao()
                    });

                    }
                } catch(SQLException e){ 
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, 
                                              "Erro de conexão!\n" + e.getMessage(), 
                                              "Aviso",
                                              JOptionPane.ERROR_MESSAGE);
            }
        }
    
}
