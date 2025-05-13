package View;

import javax.swing.JLabel;
import Model.Usuario;
import Controller.ControleMusicasNaoCurtidas;

public class MusicasNaoCurtidas extends javax.swing.JFrame {

    String user, nome, senha;
    
    public MusicasNaoCurtidas(Usuario usuario) {
        initComponents();
        user = usuario.getUsuario();
        nome = usuario.getNome();
        senha = usuario.getSenha();
        c = new ControleMusicasNaoCurtidas(this);
    }

    
    
    public JLabel getLbl_musicas_curtidas() {
        return lbl_musicas_curtidas;
    }

    public void setLbl_musicas_curtidas(JLabel lbl_musicas_curtidas) {
        this.lbl_musicas_curtidas = lbl_musicas_curtidas;
    }

    public JLabel getLbl_voltar() {
        return lbl_voltar;
    }

    public void setLbl_voltar(JLabel lbl_voltar) {
        this.lbl_voltar = lbl_voltar;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_voltar = new javax.swing.JLabel();
        lbl_musicas_curtidas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_voltar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        lbl_voltar.setText("←");
        lbl_voltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_voltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_voltarMouseClicked(evt);
            }
        });

        lbl_musicas_curtidas.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        lbl_musicas_curtidas.setText("Músicas não-curtidas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lbl_voltar)
                .addGap(46, 46, 46)
                .addComponent(lbl_musicas_curtidas)
                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_voltar)
                    .addComponent(lbl_musicas_curtidas))
                .addContainerGap(248, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_voltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_voltarMouseClicked

        Usuario usuario2 = new Usuario(user, nome, senha);
        c.redirectPaginaHome(usuario2);
    }//GEN-LAST:event_lbl_voltarMouseClicked

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
//            java.util.logging.Logger.getLogger(MusicasNaoCurtidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MusicasNaoCurtidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MusicasNaoCurtidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MusicasNaoCurtidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MusicasNaoCurtidas().setVisible(true);
//            }
//        });
//    }

    private Controller.ControleMusicasNaoCurtidas c;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbl_musicas_curtidas;
    private javax.swing.JLabel lbl_voltar;
    // End of variables declaration//GEN-END:variables
}
