package View;

import Model.Usuario;
import Model.PlaylistModel;
import Controller.ControlePlaylistInfo;
import Model.Musica;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class PlaylistInfo extends javax.swing.JFrame {

    private String user, nome, senha;
    private int idPlaylist;
    private String nomePlaylist, descricaoPlaylist;
    private PlaylistModel playlist;
    
    public PlaylistInfo(){
        initComponents();
        c = new ControlePlaylistInfo(this);
    }
    
    public PlaylistInfo(Usuario usuario, PlaylistModel playlist) {
        initComponents();
        user = usuario.getUsuario();
        nome = usuario.getNome();
        senha = usuario.getSenha();
        
        idPlaylist = playlist.getId_playlist();
        
        nomePlaylist = playlist.getNome_playlist();
        lbl_nome_playlist.setText(nomePlaylist);
        descricaoPlaylist = playlist.getDescricao_playlist();
        txt_descricao.setText(descricaoPlaylist);
        
        c = new ControlePlaylistInfo(this);
        JTable tabela = getTabela();
        c.addMusicasTabela(usuario, tabela, playlist);
    }

    public JButton getBt_adicionar() {
        return bt_adicionar;
    }

    public void setBt_adicionar(JButton bt_adicionar) {
        this.bt_adicionar = bt_adicionar;
    }

    public JLabel getLbl_adicionar_musica() {
        return lbl_adicionar_musica;
    }

    public void setLbl_adicionar_musica(JLabel lbl_adicionar_musica) {
        this.lbl_adicionar_musica = lbl_adicionar_musica;
    }

    public JLabel getLbl_alterar_playlist() {
        return lbl_alterar_playlist;
    }

    public void setLbl_alterar_playlist(JLabel lbl_alterar_playlist) {
        this.lbl_alterar_playlist = lbl_alterar_playlist;
    }

    public JLabel getLbl_descricao_playlist() {
        return lbl_descricao_playlist;
    }

    public void setLbl_descricao_playlist(JLabel lbl_descricao_playlist) {
        this.lbl_descricao_playlist = lbl_descricao_playlist;
    }

    public JTextArea getTxt_descricao() {
        return txt_descricao;
    }

    public void setTxt_descricao(JTextArea txt_descricao) {
        this.txt_descricao = txt_descricao;
    }

    
    public JLabel getLbl_excluir_playlist() {
        return lbl_excluir_playlist;
    }

    public void setLbl_excluir_playlist(JLabel lbl_excluir_playlist) {
        this.lbl_excluir_playlist = lbl_excluir_playlist;
    }

    public JLabel getLbl_nome_playlist() {
        return lbl_nome_playlist;
    }

    public void setLbl_nome_playlist(JLabel lbl_nome_playlist) {
        this.lbl_nome_playlist = lbl_nome_playlist;
    }

    public JLabel getLbl_voltar() {
        return lbl_voltar;
    }

    public void setLbl_voltar(JLabel lbl_voltar) {
        this.lbl_voltar = lbl_voltar;
    }

    public JTable getTabela() {
        return tabela;
    }

    public void setTabela(JTable tabela) {
        this.tabela = tabela;
    }

    public JLabel getLbl_id_musica() {
        return lbl_id_musica;
    }

    public void setLbl_id_musica(JLabel lbl_id_musica) {
        this.lbl_id_musica = lbl_id_musica;
    }
    
    public JTextField getTxt_id_musica() {
        return txt_id_musica;
    }

    public void setTxt_id_musica(JTextField txt_id_musica) {
        this.txt_id_musica = txt_id_musica;
    }
    
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        lbl_nome_playlist = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        lbl_voltar = new javax.swing.JLabel();
        lbl_excluir_playlist = new javax.swing.JLabel();
        lbl_descricao_playlist = new javax.swing.JLabel();
        lbl_alterar_playlist = new javax.swing.JLabel();
        lbl_adicionar_musica = new javax.swing.JLabel();
        lbl_id_musica = new javax.swing.JLabel();
        txt_id_musica = new javax.swing.JTextField();
        bt_adicionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_descricao = new javax.swing.JTextArea();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_nome_playlist.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        lbl_nome_playlist.setText("nomedaplaylist");

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Música", "Artista", "Álbum", "Gênero", "Duração", "ID da música"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabela);

        lbl_voltar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        lbl_voltar.setText("←");
        lbl_voltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_voltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_voltarMouseClicked(evt);
            }
        });

        lbl_excluir_playlist.setForeground(new java.awt.Color(248, 37, 37));
        lbl_excluir_playlist.setText("excluir playlist");
        lbl_excluir_playlist.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_excluir_playlist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_excluir_playlistMouseClicked(evt);
            }
        });

        lbl_descricao_playlist.setText("descrição da playlist");

        lbl_alterar_playlist.setForeground(new java.awt.Color(148, 176, 218));
        lbl_alterar_playlist.setText("alterar playlist");
        lbl_alterar_playlist.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_alterar_playlist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_alterar_playlistMouseClicked(evt);
            }
        });

        lbl_adicionar_musica.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lbl_adicionar_musica.setText("adicionar nova música à playlist");

        lbl_id_musica.setText("id da música");

        txt_id_musica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_musicaActionPerformed(evt);
            }
        });
        txt_id_musica.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_id_musicaKeyPressed(evt);
            }
        });

        bt_adicionar.setText("adicionar");
        bt_adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_adicionarActionPerformed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txt_descricao.setEditable(false);
        txt_descricao.setColumns(20);
        txt_descricao.setLineWrap(true);
        txt_descricao.setRows(5);
        txt_descricao.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txt_descricao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(lbl_voltar)
                        .addGap(161, 161, 161)
                        .addComponent(lbl_nome_playlist))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lbl_excluir_playlist)
                                .addComponent(lbl_alterar_playlist))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_id_musica)
                                    .addComponent(lbl_descricao_playlist)
                                    .addComponent(lbl_adicionar_musica)
                                    .addComponent(bt_adicionar)
                                    .addComponent(txt_id_musica, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_nome_playlist, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_voltar)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_descricao_playlist)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_adicionar_musica)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_id_musica)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_id_musica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_adicionar)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(lbl_alterar_playlist)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_excluir_playlist)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_voltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_voltarMouseClicked

        Usuario usuario2 = new Usuario(user,nome,senha);
        c.redirectPlaylist(usuario2);
    }//GEN-LAST:event_lbl_voltarMouseClicked

    private void txt_id_musicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_musicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_musicaActionPerformed

    private void bt_adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_adicionarActionPerformed
        Usuario usuario = new Usuario(user, nome, senha);
        PlaylistModel playlist = new PlaylistModel(idPlaylist, nomePlaylist, descricaoPlaylist);
        int idMusica = Integer.parseInt(getTxt_id_musica().getText());
        Musica musica = new Musica(idMusica);
        c.addMusicaPlaylist(usuario, tabela, playlist, musica);
    }//GEN-LAST:event_bt_adicionarActionPerformed

    private void lbl_excluir_playlistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_excluir_playlistMouseClicked
//        Playlist playlist = new Playlist(user, nomePlaylist);
//        c.excluirPlaylist(playlist);
            Usuario usuario2 = new Usuario(user, nome, senha);
            PlaylistModel playlist2 = new PlaylistModel(idPlaylist, nomePlaylist, descricaoPlaylist);
            //System.out.println("playlist2: " + playlist2);
            c.excluirPlaylist(usuario2, playlist2);
//        
    }//GEN-LAST:event_lbl_excluir_playlistMouseClicked

    private void lbl_alterar_playlistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_alterar_playlistMouseClicked
        // TODO add your handling code here:
        Usuario usuario2 = new Usuario(user, nome, senha);
            PlaylistModel playlist2 = new PlaylistModel(idPlaylist, nomePlaylist, descricaoPlaylist);

        c.redirectPlaylistEdit(usuario2, playlist2);
    }//GEN-LAST:event_lbl_alterar_playlistMouseClicked

    private void txt_id_musicaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_id_musicaKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == evt.VK_ENTER){
            Usuario usuario = new Usuario(user, nome, senha);
            PlaylistModel playlist = new PlaylistModel(idPlaylist, nomePlaylist, descricaoPlaylist);
            int idMusica = Integer.parseInt(getTxt_id_musica().getText());
            Musica musica = new Musica(idMusica);
            c.addMusicaPlaylist(usuario, tabela, playlist, musica);
        }
    }//GEN-LAST:event_txt_id_musicaKeyPressed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(PlaylistInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(PlaylistInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(PlaylistInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(PlaylistInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new PlaylistInfo().setVisible(true);
//            }
//        });
//    }
    
    
    
    
    private ControlePlaylistInfo c;
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_adicionar;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_adicionar_musica;
    private javax.swing.JLabel lbl_alterar_playlist;
    private javax.swing.JLabel lbl_descricao_playlist;
    private javax.swing.JLabel lbl_excluir_playlist;
    private javax.swing.JLabel lbl_id_musica;
    private javax.swing.JLabel lbl_nome_playlist;
    private javax.swing.JLabel lbl_voltar;
    private javax.swing.JTable tabela;
    private javax.swing.JTextArea txt_descricao;
    private javax.swing.JTextField txt_id_musica;
    // End of variables declaration//GEN-END:variables
}
