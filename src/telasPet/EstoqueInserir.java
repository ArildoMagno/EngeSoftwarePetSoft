/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telasPet;

import Controle.ControleFornecedor;
import Controle.ControleProduto;
import Modelos.Fornecedor;
import Modelos.Produto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Atlas
 */
public class EstoqueInserir extends javax.swing.JFrame {

    /**
     * Creates new form entradaEstoqueExistente
     */
    public EstoqueInserir() {
        initComponents();
        try {
            MaskFormatter maskData = new MaskFormatter("##/##/####");
            maskData.install(textDataCadastramento);
        } catch (ParseException ex) {
            Logger.getLogger(EstoqueInserir.class.getName()).log(Level.SEVERE, null, ex);
        }
        ControleFornecedor controleF = new ControleFornecedor();

        ArrayList<Fornecedor> listaFornecedor = controleF.ListaFornecedor("where ativo = true");
        for (int i = 0; i < listaFornecedor.size(); i++) {
            comboFornecedor.addItem(listaFornecedor.get(i).getNomeFantasia());
        }
        botaoConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Produto produto = new Produto();
                produto.setDescricao(textDescricao.getText());
                produto.setUnidade(textValorUnitario.getText());
                produto.setEstoque(Integer.parseInt(textEstoque.getText()));
                produto.setEstoqueMinimo(Integer.parseInt(textEstoqueMinimo.getText()));
                produto.setAliquota(Float.parseFloat(textAliquota.getText()));
                produto.setModelo(textModelo.getText());
                produto.setPrecoCompra(Float.parseFloat(textPrecoCompra.getText()));
                produto.setPrecoVenda(Float.parseFloat(textPrecoVenda.getText()));
                produto.setDataCadastramento(textDataCadastramento.getText());
                produto.setIdFornecedor(comboFornecedor.getSelectedIndex() + 1);

                ControleProduto controle = new ControleProduto();
                controle.InserirProduto(produto);
                dispose();

            }
        });
    }

    public EstoqueInserir(Produto produto) {
        initComponents();
        try {
            MaskFormatter maskData = new MaskFormatter("##/##/####");
            maskData.install(textDataCadastramento);
        } catch (ParseException ex) {
            Logger.getLogger(EstoqueInserir.class.getName()).log(Level.SEVERE, null, ex);
        }
        textDescricao.setText(produto.getDescricao());
        textValorUnitario.setText(produto.getUnidade());
        textEstoque.setText(String.valueOf(produto.getEstoque()));
        textEstoqueMinimo.setText(String.valueOf(produto.getEstoqueMinimo()));
        textAliquota.setText(String.valueOf(produto.getAliquota()));
        textModelo.setText(produto.getModelo());
        textPrecoCompra.setText(String.valueOf(produto.getPrecoCompra()));
        textPrecoVenda.setText(String.valueOf(produto.getPrecoVenda()));
        textDataCadastramento.setText(produto.getDataCadastramento());
        
        ControleFornecedor controleF = new ControleFornecedor();

        ArrayList<Fornecedor> listaFornecedor = controleF.ListaFornecedor("where ativo = true");
        for (int i = 0; i < listaFornecedor.size(); i++) {
            comboFornecedor.addItem(listaFornecedor.get(i).getNomeFantasia());
        }
        comboFornecedor.setSelectedIndex(produto.getIdFornecedor() - 1);
        botaoConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                produto.setDescricao(textDescricao.getText());
                produto.setUnidade(textValorUnitario.getText());
                produto.setEstoque(Integer.parseInt(textEstoque.getText()));
                produto.setEstoqueMinimo(Integer.parseInt(textEstoqueMinimo.getText()));
                produto.setAliquota(Float.parseFloat(textAliquota.getText()));
                produto.setModelo(textModelo.getText());
                produto.setPrecoCompra(Float.parseFloat(textPrecoCompra.getText()));
                produto.setPrecoVenda(Float.parseFloat(textPrecoVenda.getText()));
                produto.setDataCadastramento(textDataCadastramento.getText());
                produto.setIdFornecedor(comboFornecedor.getSelectedIndex() + 1);

                ControleProduto controle = new ControleProduto();
                controle.AlteraProduto(produto);
                
                new EstoqueAlterar().setVisible(true);
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
        jLabel1 = new javax.swing.JLabel();
        botaoConfirmar = new javax.swing.JButton();
        botaoLimpar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        textDescricao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textValorUnitario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        textEstoque = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        textAliquota = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        textModelo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        textPrecoCompra = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        textPrecoVenda = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        textEstoqueMinimo = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        comboFornecedor = new javax.swing.JComboBox<>();
        textDataCadastramento = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Inserir");

        botaoConfirmar.setText("Confirmar");
        botaoConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConfirmarActionPerformed(evt);
            }
        });

        botaoLimpar.setText("Limpar");
        botaoLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLimparActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Descrição:");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Valor Unitário:");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Estoque:");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("Aliquota:");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setText("Modelo:");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setText("Preço compra:");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setText("Preço venda:");

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setText("Data:");

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setText(" Fornecedor:");

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setText("Estoque Minimo:");

        textDataCadastramento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDataCadastramentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(250, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(254, 254, 254))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(botaoConfirmar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoLimpar)
                .addGap(89, 89, 89))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10)
                            .addComponent(jLabel14)
                            .addComponent(jLabel8))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textPrecoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textAliquota, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textEstoqueMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textDataCadastramento, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addGap(87, 87, 87)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textEstoqueMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textAliquota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(textModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textPrecoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(textDataCadastramento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(comboFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoConfirmar)
                    .addComponent(botaoLimpar))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLimparActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoLimparActionPerformed

    private void botaoConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfirmarActionPerformed

    }//GEN-LAST:event_botaoConfirmarActionPerformed

    private void textDataCadastramentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDataCadastramentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDataCadastramentoActionPerformed

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
            java.util.logging.Logger.getLogger(EstoqueInserir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EstoqueInserir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EstoqueInserir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EstoqueInserir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EstoqueInserir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoConfirmar;
    private javax.swing.JButton botaoLimpar;
    private javax.swing.JComboBox<String> comboFornecedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField textAliquota;
    private javax.swing.JFormattedTextField textDataCadastramento;
    private javax.swing.JTextField textDescricao;
    private javax.swing.JTextField textEstoque;
    private javax.swing.JTextField textEstoqueMinimo;
    private javax.swing.JTextField textModelo;
    private javax.swing.JTextField textPrecoCompra;
    private javax.swing.JTextField textPrecoVenda;
    private javax.swing.JTextField textValorUnitario;
    // End of variables declaration//GEN-END:variables
}
