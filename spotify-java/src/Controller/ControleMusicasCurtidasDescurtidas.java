package Controller;

import DAO.Conexao;
import DAO.MusicaDAO;
import DAO.UsuarioDAO;
import Model.Artista;
import Model.Musica;
import Model.Usuario;
import View.MusicasCurtidasDescurtidas;
import View.Home;
import View.Historico;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControleMusicasCurtidasDescurtidas {
    private MusicasCurtidasDescurtidas view;
    private Usuario usuario;
    private String liked_unliked;

    public ControleMusicasCurtidasDescurtidas(MusicasCurtidasDescurtidas view, Usuario usuario, String liked_unliked) {
        this.view = view;
        this.usuario = usuario;
        this.liked_unliked = liked_unliked;
    }

    public ControleMusicasCurtidasDescurtidas(MusicasCurtidasDescurtidas view) {
        this.view = view;
    }

    public void redirectPaginaHome(Usuario usuario) {
        view.setVisible(false);
        Home h = new Home(usuario);
        h.setVisible(true);
    }
    
    public void buscar(Usuario usuario, JTable table, String liked_unliked){
            DefaultTableModel tabela = (DefaultTableModel) table.getModel();
            tabela.setRowCount(0); // limpa a tabela

            Conexao conexao = new Conexao();
            try{
                Connection conn = conexao.getConnection();
                MusicaDAO dao = new MusicaDAO(conn);

                //
                ResultSet res_musicas = dao.buscar_musicas_curtidas_descurtidas(usuario, liked_unliked);
                
                while (res_musicas.next()) {;
                    String musica = res_musicas.getString(1);
                    String nomeArtista = res_musicas.getString(2);
                    String album = res_musicas.getString(3);
                    String genero = res_musicas.getString(4);
                    String duracao = res_musicas.getString(5);

                    Artista art = new Artista(nomeArtista);
                    Musica m = new Musica (musica, art, album, genero, duracao);

                    tabela.addRow(new Object[]{
                        m.getNome_musica(), m.getArtista().getNome(), m.getAlbum(), m.getGenero(), m.getDuracao()
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
