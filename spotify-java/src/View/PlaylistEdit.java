
package View;

import Model.Usuario;
import Model.PlaylistModel;
import Controller.ControlePlaylistEdit;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;


public class PlaylistEdit extends javax.swing.JFrame {

    private String user, nome, senha;
    private String nomePlaylist, descricaoPlaylist;
    private int idPlaylist;
    
    public PlaylistEdit() {
        initComponents();
        c = new ControlePlaylistEdit(this);
    }    
    
    public PlaylistEdit(Usuario usuario, PlaylistModel playlist) {
        initComponents();
        user = usuario.getUsuario();
        nome = usuario.getNome();
        senha = usuario.getSenha();
        idPlaylist = playlist.getId_playlist();
        nomePlaylist = playlist.getNome_playlist();
        descricaoPlaylist = playlist.getDescricao_playlist();
        c = new ControlePlaylistEdit(this);
        
    }

    public JToggleButton getBt_confirmar() {
        return bt_confirmar;
    }

    public void setBt_confirmar(JToggleButton bt_confirmar) {
        this.bt_confirmar = bt_confirmar;
    }

    public JLabel getLbl_aviso() {
        return lbl_aviso;
    }

    public void setLbl_aviso(JLabel lbl_aviso) {
        this.lbl_aviso = lbl_aviso;
    }

    public JLabel getLbl_editar_perfil() {
        return lbl_editar_perfil;
    }

    public void setLbl_editar_perfil(JLabel lbl_editar_perfil) {
        this.lbl_editar_perfil = lbl_editar_perfil;
    }

    public JLabel getLbl_nova_descricao() {
        return lbl_nova_descricao;
    }

    public void setLbl_nova_descricao(JLabel lbl_nova_descricao) {
        this.lbl_nova_descricao = lbl_nova_descricao;
    }

    public JLabel getLbl_novo_nome() {
        return lbl_novo_nome;
    }

    public void setLbl_novo_nome(JLabel lbl_novo_nome) {
        this.lbl_novo_nome = lbl_novo_nome;
    }

    public JLabel getLbl_voltar() {
        return lbl_voltar;
    }

    public void setLbl_voltar(JLabel lbl_voltar) {
        this.lbl_voltar = lbl_voltar;
    }

    public JTextArea getTxt_nova_descricao() {
        return txt_nova_descricao;
    }

    public void setTxt_nova_descricao(JTextArea txt_nova_descricao) {
        this.txt_nova_descricao = txt_nova_descricao;
    }

    public JTextField getTxt_novo_nome() {
        return txt_novo_nome;
    }

    public void setTxt_novo_nome(JTextField txt_novo_nome) {
        this.txt_novo_nome = txt_novo_nome;
    }
    
    
    
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_nova_descricao = new javax.swing.JLabel();
        lbl_editar_perfil = new javax.swing.JLabel();
        lbl_novo_nome = new javax.swing.JLabel();
        lbl_voltar = new javax.swing.JLabel();
        bt_confirmar = new javax.swing.JToggleButton();
        lbl_aviso = new javax.swing.JLabel();
        txt_novo_nome = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_nova_descricao = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_nova_descricao.setText("nova descrição:");

        lbl_editar_perfil.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        lbl_editar_perfil.setText("Alterar playlist");

        lbl_novo_nome.setText("novo nome:");

        lbl_voltar.setText("←");
        lbl_voltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_voltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_voltarMouseClicked(evt);
            }
        });

        bt_confirmar.setText("Confirmar");
        bt_confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_confirmarActionPerformed(evt);
            }
        });

        lbl_aviso.setText("*caso não deseje fazer alguma modificação, deixe-a nula*");

        txt_novo_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_novo_nomeActionPerformed(evt);
            }
        });
        txt_novo_nome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_novo_nomeKeyPressed(evt);
            }
        });

        txt_nova_descricao.setColumns(20);
        txt_nova_descricao.setLineWrap(true);
        txt_nova_descricao.setRows(5);
        txt_nova_descricao.setWrapStyleWord(true);
        txt_nova_descricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nova_descricaoKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(txt_nova_descricao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lbl_voltar)
                .addGap(127, 127, 127)
                .addComponent(lbl_editar_perfil)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_nova_descricao)
                    .addComponent(lbl_novo_nome)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txt_novo_nome, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(bt_confirmar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(87, Short.MAX_VALUE)
                .addComponent(lbl_aviso)
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_voltar)
                    .addComponent(lbl_editar_perfil))
                .addGap(18, 18, 18)
                .addComponent(lbl_aviso)
                .addGap(18, 18, 18)
                .addComponent(lbl_novo_nome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_novo_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(lbl_nova_descricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_confirmar)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_voltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_voltarMouseClicked
        Usuario usuario = new Usuario(user, nome, senha);
        PlaylistModel playlist = new PlaylistModel(idPlaylist, nomePlaylist, descricaoPlaylist);
        c.redirectPlaylistInfo(usuario, playlist);
    }//GEN-LAST:event_lbl_voltarMouseClicked

    private void bt_confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_confirmarActionPerformed
        // TODO add your handling code here:
        Usuario usuario = new Usuario(user, nome, senha);
        PlaylistModel playlist = new PlaylistModel(idPlaylist, nomePlaylist, descricaoPlaylist);
        c.editarPlaylist(usuario, playlist);
    }//GEN-LAST:event_bt_confirmarActionPerformed

    private void txt_novo_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_novo_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_novo_nomeActionPerformed

    private void txt_novo_nomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_novo_nomeKeyPressed
        Usuario usuario = new Usuario(user, nome, senha);
        if(evt.getKeyCode() == evt.VK_ENTER){
            PlaylistModel playlist = new PlaylistModel(idPlaylist, nomePlaylist, descricaoPlaylist);
            c.editarPlaylist(usuario, playlist);
        }
    }//GEN-LAST:event_txt_novo_nomeKeyPressed

    private void txt_nova_descricaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nova_descricaoKeyPressed
        Usuario usuario = new Usuario(user, nome, senha);
        if(evt.getKeyCode() == evt.VK_ENTER){
            PlaylistModel playlist = new PlaylistModel(idPlaylist, nomePlaylist, descricaoPlaylist);
            c.editarPlaylist(usuario, playlist);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nova_descricaoKeyPressed
//
//    /**
//     * @param args the command line arguments
//     */
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
//            java.util.logging.Logger.getLogger(PlaylistEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(PlaylistEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(PlaylistEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(PlaylistEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
////                new PlaylistEdit().setVisible(true);
//            }
//        });
//    }

    private ControlePlaylistEdit c;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton bt_confirmar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_aviso;
    private javax.swing.JLabel lbl_editar_perfil;
    private javax.swing.JLabel lbl_nova_descricao;
    private javax.swing.JLabel lbl_novo_nome;
    private javax.swing.JLabel lbl_voltar;
    private javax.swing.JTextArea txt_nova_descricao;
    private javax.swing.JTextField txt_novo_nome;
    // End of variables declaration//GEN-END:variables
}
