/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telasPet;

import Controle.ControleCliente;
import Controle.ControlePet;
import Modelos.Cliente;
import Modelos.Pet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Atlas
 */
public class GerenciarCadastrarPet extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    ArrayList<Cliente> listaCliente;

    public GerenciarCadastrarPet() {
        initComponents();
        ControleCliente controleC = new ControleCliente();
        listaCliente = controleC.ListaCliente();
        for (int i = 0; i < listaCliente.size(); i++) {
            comboCliente.addItem(listaCliente.get(i).getNomeFantasia());
        }
        botaoOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Pet pet = new Pet();
                ControlePet controle = new ControlePet();
                pet.setNome(txtNome.getText());
                pet.setRaca(txtRaca.getText());
                pet.setTipo(txtTipo.getText());
                pet.setIdCliente(listaCliente.get(comboCliente.getSelectedIndex()).getId());
                controle.InserirPet(pet);
                dispose();
            }
        });

    }

    public GerenciarCadastrarPet(Pet pet) {
        initComponents();
        ControleCliente controleC = new ControleCliente();
        listaCliente = controleC.ListaCliente();
        for (int i = 0; i < listaCliente.size(); i++) {
            comboCliente.addItem(listaCliente.get(i).getNomeFantasia());
        }
        for (int i = 0; i < listaCliente.size(); i++) {
            if (pet.getIdCliente() == listaCliente.get(i).getId()) {
                comboCliente.setSelectedIndex(i);
            }
        };
        txtNome.setText(pet.getNome());
        txtRaca.setText(pet.getRaca());
        txtTipo.setText(pet.getTipo());
        System.out.println("" + pet.getId());
        botaoOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControlePet controle = new ControlePet();
                pet.setNome(txtNome.getText());
                pet.setRaca(txtRaca.getText());
                pet.setTipo(txtTipo.getText());
                pet.setIdCliente(listaCliente.get(comboCliente.getSelectedIndex()).getId());
                controle.AlteraPet(pet);
                new GerenciarAlterarDadosPet().setVisible(true);
                dispose();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtRaca = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        botaoOk = new javax.swing.JButton();
        comboCliente = new javax.swing.JComboBox<>();
        botaoLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("Cadastrar Pet");

        jLabel1.setText("Nome");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        jLabel3.setText("Tipo");

        txtTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoActionPerformed(evt);
            }
        });

        jLabel4.setText("Raça");

        txtRaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRacaActionPerformed(evt);
            }
        });

        jLabel5.setText("Cliente");

        botaoOk.setText("Cadastrar");
        botaoOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoOkActionPerformed(evt);
            }
        });

        botaoLimpar.setText("Limpar");
        botaoLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtRaca, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                    .addComponent(txtTipo)
                    .addComponent(txtNome)
                    .addComponent(comboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(124, 124, 124))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(botaoOk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoLimpar)
                .addGap(184, 184, 184))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel2)
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoOk)
                        .addGap(62, 62, 62))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(comboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(botaoLimpar)
                        .addGap(70, 70, 70))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoActionPerformed

    private void txtRacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRacaActionPerformed

    private void botaoOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoOkActionPerformed

    }//GEN-LAST:event_botaoOkActionPerformed

    private void botaoLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLimparActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoLimparActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GerenciarCadastrarPet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerenciarCadastrarPet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerenciarCadastrarPet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerenciarCadastrarPet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GerenciarCadastrarPet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoLimpar;
    private javax.swing.JButton botaoOk;
    private javax.swing.JComboBox<String> comboCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtRaca;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}
