
package Controller;

import DAO.Conexao;
import DAO.UsuarioDAO;
import Model.Usuario;
import View.MusicasCurtidas;
import View.Home;
import View.Historico;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ControleMusicasCurtidas {
        private MusicasCurtidas view;
        private Usuario usuario;

        public ControleMusicasCurtidas(MusicasCurtidas view, Usuario usuario){
            this.view = view;
            this.usuario = usuario;
        }

        public ControleMusicasCurtidas(MusicasCurtidas view){
            this.view = view;
        }
    
    
    
        public void redirectPaginaHome(Usuario usuario){     
            view.setVisible(false);
            Home h = new Home(usuario);
            h.setVisible(true);
        }
        
        //juntar buscar_musica com buscar_curtidas
        
        public void buscar(Usuario usuario, JTable table){
            DefaultTableModel tabela = (DefaultTableModel) table.getModel();
            tabela.setRowCount(0); // limpa a tabela

            Conexao conexao = new Conexao();
            try{
                Connection conn = conexao.getConnection();
                UsuarioDAO dao = new UsuarioDAO(conn);
                
                ResultSet res_curtidas = dao.buscar_curtidas(usuario);
                ArrayList<Integer> ids_musicas_curtidas = new ArrayList<Integer>();

                while(res_curtidas.next()){
                    ids_musicas_curtidas.add(res_curtidas.getInt(1));
                } System.out.println(ids_musicas_curtidas);

             
                
                int qtde_curtidas = ids_musicas_curtidas.size();
                int idx = 0;
                ResultSet res_musicas = dao.buscar_musicas_curtidas(ids_musicas_curtidas, idx);
                
                while (res_musicas.next()) {
                    String musica = res_musicas.getString(1);
                    String artista = res_musicas.getString(2);
                    String album = res_musicas.getString(3);
                    String genero = res_musicas.getString(4);
                    String duracao = res_musicas.getString(5);

                        tabela.addRow(new Object[] {
                            musica, artista, album, genero, duracao
                        });    
                        
                    idx += 1;
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
