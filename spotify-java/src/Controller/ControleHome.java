
package Controller;

import DAO.UsuarioDAO;
import DAO.MusicaDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Model.Usuario;
import View.MusicasCurtidasDescurtidas;
import View.Historico;
import View.Playlist;
import View.Home;
import View.Perfil;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class


//botao de curtir/descurtir
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.AbstractCellEditor;
import javax.swing.JOptionPane;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;






public class ControleHome {
    private Home view;
    
    public ControleHome(Home view){
        this.view = view;
    }
    
    public void redirectPerfil(Usuario usuario){
        view.setVisible(false);
        Perfil p = new Perfil(usuario);
        p.setVisible(true);
    }
    
    public void redirectPlaylist(Usuario usuario){
        view.setVisible(false);
        Playlist p = new Playlist(usuario);
        p.setVisible(true);
   }
        
    public void redirectHistorico(Usuario usuario){
        view.setVisible(false);
        Historico h = new Historico(usuario);
        h.setVisible(true);
    }

    public void redirectMusicasCurtidas(Usuario usuario){
        view.setVisible(false);
        MusicasCurtidasDescurtidas mc = new MusicasCurtidasDescurtidas(usuario, "Músicas curtidas", "liked_songs");
        mc.setVisible(true);
    }
    
    public void redirectMusicasDescurtidas(Usuario usuario){
        view.setVisible(false);
        MusicasCurtidasDescurtidas md = new MusicasCurtidasDescurtidas(usuario, "Músicas descurtidas", "unliked_songs");
        md.setVisible(true);
    }
    


    
    //buscar musica, pega no database todas as musicas e as musicas curtidas pelo user logado.
    public void buscar(Usuario usuario) {
        String search = view.getTxt_busca().getText();
        String filtro = view.getCombobox_filtro().getSelectedItem().toString();

        JTable tabela = view.getTabela();
        DefaultTableModel resultado_busca = (DefaultTableModel) tabela.getModel();
        resultado_busca.setRowCount(0); // limpa a tabela

        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            Connection conn2 = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            MusicaDAO musica_dao = new MusicaDAO(conn2);

            
            ResultSet res = dao.buscar_musica(filtro, search);

            //pegar musicas curtidas pelo usuario
            ResultSet res_curtida_usuario = dao.buscar_curtidas(usuario);
            ArrayList<Integer> ids_musicas_curtidas = new ArrayList<Integer>();

            while(res_curtida_usuario.next()){
                ids_musicas_curtidas.add(res_curtida_usuario.getInt(1));
            }

            System.out.println(ids_musicas_curtidas);





            //mostrar resultado da busca na tabela
            while (res.next()) {
                String nome_musica = res.getString(1);
                String nome_album = res.getString(2);
                String nome_artista = res.getString(3);
                String genero = res.getString(4);
                String duracao = res.getString(5);
                int id_musica = res.getInt(6);

                String curtida;

                if (ids_musicas_curtidas.contains(id_musica)){
                    curtida = "♥";
                } else{
                    curtida = "♡";
                }

                resultado_busca.addRow(new Object[] {
                    nome_musica, nome_album, nome_artista, genero, duracao, curtida, id_musica
                });
            }

            //adicionar busca no histórico do usuario
            // usuario, search, filtro, max 10 resultados do historico. botao do lado pra ir pra home e procurar a mesma coisa.
            LocalDateTime data = LocalDateTime.now();
            dao.nova_busca_historico(usuario.getUsuario(), search, filtro, data);
            
            
            
            

            // interação com usuário: botão para curtir/descurtir
            tabela.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
            tabela.getColumnModel().getColumn(5).setCellEditor(
                new ButtonEditor(new JCheckBox(), tabela, dao, musica_dao, usuario)
            );

            
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view,
                "Erro de busca!\n" + e.getMessage(),
                "Aviso",
                JOptionPane.ERROR_MESSAGE);
        }
    }


    // visual botao: sem fundo 
    class ButtonRenderer extends JButton implements TableCellRenderer {
    public ButtonRenderer() {
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
    }
    
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        setText((value == null) ? "♡" : value.toString());
        return this;
    }
}
    class ButtonEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {
        private JButton button;
        private String label;
        private boolean clicked;
        private JTable tabela;
        private int row;
        private UsuarioDAO dao;
        private MusicaDAO musica_dao;

        private Usuario usuario;
        
    

        public ButtonEditor(JCheckBox checkBox, JTable tabela, UsuarioDAO dao, MusicaDAO musica_dao, Usuario usuario) {
            this.tabela = tabela;
            this.dao = dao;
            this.musica_dao = musica_dao;
            this.usuario = usuario;

            button = new JButton();
            button.setOpaque(false);
            button.setContentAreaFilled(false);
            button.setBorderPainted(false);
            button.setFocusPainted(false);

            button.addActionListener(this);
        }



        @Override
        public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int column) {
            this.row = row;
            label = (value == null) ? "♡" : value.toString();
            button.setText(label);
            clicked = true;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            return label;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (clicked) {
                int id_musica = (int) tabela.getValueAt(row, 6); // coluna "oculta" com id_musica

                if (label.equals("♥")) {
                    // descurtir
                    label = "♡";
                    try {
                        musica_dao.adicionar_curtida_descurtida(usuario, "unliked_songs", id_musica);
                        //se tiver na liked_songs, consulta = true
                        boolean consulta = musica_dao.consultar_curtidas_descurtidas(usuario, "liked_songs", id_musica);
                        if (consulta) {
                            musica_dao.remover_curtida_descurtida(usuario, "liked_songs", id_musica);
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    // curtir
                    label = "♥";
                    try {
                        musica_dao.adicionar_curtida_descurtida(usuario, "liked_songs", id_musica);
                        //se tiver na liked_songs, consulta = true
                        boolean consulta = musica_dao.consultar_curtidas_descurtidas(usuario, "unliked_songs", id_musica);
                        if (consulta) {
                            musica_dao.remover_curtida_descurtida(usuario, "unliked_songs", id_musica);
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
                tabela.setValueAt(label, row, 5); // atualiza coração
            }
            clicked = false;
            fireEditingStopped();
        }

    }
}
