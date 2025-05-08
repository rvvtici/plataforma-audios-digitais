
package Controller;

import DAO.Conexao;
import DAO.UsuarioDAO;
import Model.Usuario;
import View.Home;
import View.Historico;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ControleHistorico {
        private Historico view;
        private Usuario usuario;

        public ControleHistorico(Historico view, Usuario usuario){
            this.view = view;
            this.usuario = usuario;
        }

        public ControleHistorico(Historico view){
            this.view = view;
        }
    
    
    
        public void redirectPaginaHome(Usuario usuario){     
            view.setVisible(false);
            Home h = new Home(usuario);
            h.setVisible(true);
    }
        
        public String addLinhasHistorico(Usuario usuario){
            String user = usuario.getNome();
            ArrayList<String> linhas = new ArrayList<>();
            
            Conexao conexao = new Conexao();
            try{
                Connection conn = conexao.getConnection();
                UsuarioDAO dao = new UsuarioDAO(conn);
                ResultSet res = dao.consultar_historico(usuario);

                int cont = 0;
                while(res.next()){
                        String search = res.getString("search");
                        String filtro = res.getString("filtro");
                        if (search.equals("")){
                            search = " ";
                        } 
                        linhas.add(search + " " + filtro);
                        cont += 1;

                        //if historico > 10 ??
                }
            } catch(SQLException e){ 
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, 
                                              "Erro de conexão!\n" + e.getMessage(), 
                                              "Aviso",
                                              JOptionPane.ERROR_MESSAGE);
                return "erro";
            }
        
        return String.join("\n", linhas);
        }

        }