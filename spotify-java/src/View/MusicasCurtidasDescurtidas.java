package View;

import Controller.ControleMusicasCurtidasDescurtidas;
import Model.Usuario;
import javax.swing.JLabel;
import javax.swing.JTable;

public class MusicasCurtidasDescurtidas extends javax.swing.JFrame {

    private String user, nome, senha;
    
    public MusicasCurtidasDescurtidas() {
        initComponents();
    }

    public MusicasCurtidasDescurtidas(Usuario usuario, String curtidas_descurtidas, String liked_unliked){
        initComponents();
        user = usuario.getUsuario();
        nome = usuario.getNome();
        senha = usuario.getSenha();
        
        lbl_curtidas_descurtidas.setText(curtidas_descurtidas);
        
        c = new ControleMusicasCurtidasDescurtidas(this);
        JTable tabela = getTabela();
        c.buscar(usuario, tabela, liked_unliked);
    }

    public JLabel getLbl_curtidas_descurtidas() {
        return lbl_curtidas_descurtidas;
    }

    public void setLbl_curtidas_descurtidas(JLabel lbl_curtidas_descurtidas) {
        this.lbl_curtidas_descurtidas = lbl_curtidas_descurtidas;
    }

    public JLabel getLbl_musicas() {
        return lbl_musicas;
    }

    public void setLbl_musicas(JLabel lbl_musicas) {
        this.lbl_musicas = lbl_musicas;
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
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_voltar = new javax.swing.JLabel();
        lbl_musicas = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        lbl_curtidas_descurtidas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_voltar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        lbl_voltar.setText("←");
        lbl_voltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_voltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_voltarMouseClicked(evt);
            }
        });

        lbl_musicas.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        lbl_musicas.setText("Músicas");

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Música", "Artista", "Álbum", "Gênero", "Duração"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabela);

        lbl_curtidas_descurtidas.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        lbl_curtidas_descurtidas.setText("curtidas/descurtidas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_voltar)
                        .addGap(106, 106, 106)
                        .addComponent(lbl_musicas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_curtidas_descurtidas)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_voltar)
                    .addComponent(lbl_musicas)
                    .addComponent(lbl_curtidas_descurtidas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_voltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_voltarMouseClicked

        Usuario usuario2 = new Usuario(user, nome, senha);
        c.redirectPaginaHome(usuario2);
    }//GEN-LAST:event_lbl_voltarMouseClicked

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
//            java.util.logging.Logger.getLogger(MusicasCurtidasDescurtidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MusicasCurtidasDescurtidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MusicasCurtidasDescurtidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MusicasCurtidasDescurtidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MusicasCurtidasDescurtidas().setVisible(true);
//            }
//        });
//    }
    
    private Controller.ControleMusicasCurtidasDescurtidas c;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_curtidas_descurtidas;
    private javax.swing.JLabel lbl_musicas;
    private javax.swing.JLabel lbl_voltar;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
