/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telasPet;

import Controle.Conexao;
import Controle.ControleContasPagar;
import Controle.ControleFornecedor;
import Controle.ControlePedidoCompra;
import Controle.ControlePedidoCompraProduto;
import Controle.ControleProduto;
import Modelos.ContasPagar;
import Modelos.Fornecedor;
import Modelos.PedidoCompra;
import Modelos.PedidoCompraProduto;
import Modelos.Produto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Atlas
 */
public class PedidosCompraInserir extends javax.swing.JFrame {

    JTable table;
    ControleProduto controleP = new ControleProduto();
    ArrayList<Produto> listaProduto;
    ArrayList<Fornecedor> listaFornecedor;
    DefaultTableModel dtm;

    /**
     * Creates new form estoqueComprarProduto
     */
    public PedidosCompraInserir() {
        initComponents();
        ControleFornecedor controle = new ControleFornecedor();
        listaFornecedor = controle.ListaFornecedor();
        for (int i = 0; i < listaFornecedor.size(); i++) {
            comboFornecedor.addItem(listaFornecedor.get(i).getNomeFantasia());
        }
        String[] cabecaTabela = {"id", "descricao", "quantidade", "valor unitário", "valor total"};
        dtm = new DefaultTableModel(cabecaTabela, 0) {
            public boolean isCellEditable(int row, int column) {
                return false;//This causes all cells to be not editable
            }
        };
        dtm.addRow(cabecaTabela);
        table = new JTable(dtm);
        painel.add(table);

    }

    public PedidosCompraInserir(PedidoCompra pedido) {
        initComponents();
        ControleFornecedor controle = new ControleFornecedor();
        String descricao = "";
        listaFornecedor = controle.ListaFornecedor();
        for (int i = 0; i < listaFornecedor.size(); i++) {
            comboFornecedor.addItem(listaFornecedor.get(i).getNomeFantasia());
        }
        for (int i = 0; i < listaFornecedor.size(); i++) {
            if(listaFornecedor.get(i).getId()==pedido.getIdFornecedor()){
                comboFornecedor.setSelectedIndex(i);
            }
        }
        String[] cabecaTabela = {"id", "descricao", "quantidade", "valor unitário", "valor total"};
        dtm = new DefaultTableModel(cabecaTabela, 0) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dtm.addRow(cabecaTabela);
        ControlePedidoCompraProduto controlePCP = new ControlePedidoCompraProduto();
        ArrayList<PedidoCompraProduto> lista = controlePCP.ListaProdutos(pedido.getId());
        for (int i = 0; i < lista.size(); i++) {
            Conexao conexao = new Conexao();
            try {
                String query = "SELECT descricao FROM Produto where id = ?";
                PreparedStatement ps = conexao.getConnection().prepareStatement(query);
                ps.setInt(1, pedido.getId());
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    descricao = rs.getString("descricao");
                }
            } catch (SQLException ex) {
                Logger.getLogger(PedidosCompraInserir.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                conexao.closeConnection();
            }
            float valorTotal = lista.get(i).getValorUnitario() * lista.get(i).getQuantidade();
            dtm.addRow(new String[]{String.valueOf(lista.get(i).getIdProduto()),
                descricao,
                String.valueOf(lista.get(i).getQuantidade()),
                String.valueOf(lista.get(i).getValorUnitario()),
                String.valueOf(valorTotal)});
        }
        table = new JTable(dtm);
        painel.add(table);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PainelTabela = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        comboFornecedor = new javax.swing.JComboBox<String>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comboItem = new javax.swing.JComboBox<String>();
        txtQuantidade = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        botaoOk = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        botaoInserir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        botaoRemover = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        painel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Pedido Compra Inserir");

        comboFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboFornecedorActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Selecione o Fornecedor");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Selecione o Item");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Quantidade:");

        botaoOk.setText("Ok");
        botaoOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoOkActionPerformed(evt);
            }
        });

        jButton1.setText("Limpar");

        botaoInserir.setText("Inserir");
        botaoInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoInserirActionPerformed(evt);
            }
        });

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        botaoRemover.setText("Remover");
        botaoRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRemoverActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Valor:");

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        painel.setLayout(new java.awt.CardLayout());
        jScrollPane1.setViewportView(painel);

        javax.swing.GroupLayout PainelTabelaLayout = new javax.swing.GroupLayout(PainelTabela);
        PainelTabela.setLayout(PainelTabelaLayout);
        PainelTabelaLayout.setHorizontalGroup(
            PainelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelTabelaLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(PainelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelTabelaLayout.createSequentialGroup()
                        .addComponent(botaoInserir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoRemover)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PainelTabelaLayout.createSequentialGroup()
                        .addComponent(botaoOk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PainelTabelaLayout.createSequentialGroup()
                        .addGroup(PainelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(45, 45, 45)
                        .addGroup(PainelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(comboItem, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addGroup(PainelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PainelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PainelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelTabelaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(322, 322, 322))))
            .addGroup(PainelTabelaLayout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );
        PainelTabelaLayout.setVerticalGroup(
            PainelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelTabelaLayout.createSequentialGroup()
                .addGroup(PainelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PainelTabelaLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel2)
                        .addGap(55, 55, 55)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PainelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botaoInserir)
                            .addComponent(botaoRemover)))
                    .addGroup(PainelTabelaLayout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelTabelaLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PainelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(botaoOk))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelTabela, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelTabela, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoInserirActionPerformed
        float valorTotal = Float.parseFloat(txtQuantidade.getText()) * Float.parseFloat(txtValor.getText());
        dtm.addRow(new String[]{String.valueOf(listaProduto.get(comboItem.getSelectedIndex()).getId()),
            listaProduto.get(comboItem.getSelectedIndex()).getDescricao(),
            txtQuantidade.getText(), txtValor.getText(), String.valueOf(valorTotal)});

    }//GEN-LAST:event_botaoInserirActionPerformed

    private void botaoOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoOkActionPerformed
        ControlePedidoCompra controlePedido = new ControlePedidoCompra();
        PedidoCompra pedido = new PedidoCompra();
        pedido.setIdFornecedor(listaFornecedor.get(comboFornecedor.getSelectedIndex()).getId());
        pedido.setStatus('P');
        float valor = 0;
        for (int i = 1; i < table.getRowCount(); i++) {
            valor += Float.parseFloat(dtm.getValueAt(i, 4).toString());
        }
        pedido.setValorTotal(valor);
        Date data = new Date(System.currentTimeMillis());
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyyy");
        pedido.setDataEmissao(formatarDate.format(data).toString());
        controlePedido.InserirPedidoCompra(pedido);
        pedido.setId(controlePedido.ContadorPedido());

        PedidoCompraProduto pedidoProduto = new PedidoCompraProduto();
        pedidoProduto.setIdPedidoCompra(pedido.getId());
        ControlePedidoCompraProduto controlePedidoProduto = new ControlePedidoCompraProduto();
        for (int i = 1; i < table.getRowCount(); i++) {
            pedidoProduto.setIdProduto(Integer.parseInt(dtm.getValueAt(i, 0).toString()));
            pedidoProduto.setQuantidade(Float.parseFloat(dtm.getValueAt(i, 1).toString()));
            pedidoProduto.setValorUnitario(Float.parseFloat(dtm.getValueAt(i, 2).toString()));
            controlePedidoProduto.InserirProduto(pedidoProduto);
        }

        ContasPagar contas = new ContasPagar();
        ControleContasPagar controle = new ControleContasPagar();

        contas.setIdFornecedor(pedido.getIdFornecedor());
        contas.setValor(valor);
        controle.InserirContasPagar(contas);
    }//GEN-LAST:event_botaoOkActionPerformed

    private void comboFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFornecedorActionPerformed
        comboItem.removeAllItems();
        ArrayList<Produto> listaAux = controleP.ListaProduto("where idFornecedor = "
                + listaFornecedor.get(comboFornecedor.getSelectedIndex()).getId());
        for (int i = 0; i < listaAux.size(); i++) {
            comboItem.addItem(listaAux.get(i).getDescricao());
        }
        listaProduto = listaAux;
    }//GEN-LAST:event_comboFornecedorActionPerformed

    private void botaoRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRemoverActionPerformed
        dtm.removeRow(table.getSelectedRow());
        listaProduto.remove(table.getSelectedRow());
    }//GEN-LAST:event_botaoRemoverActionPerformed

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
            java.util.logging.Logger.getLogger(PedidosCompraInserir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PedidosCompraInserir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PedidosCompraInserir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PedidosCompraInserir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new PedidosCompraInserir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PainelTabela;
    private javax.swing.JButton botaoInserir;
    private javax.swing.JButton botaoOk;
    private javax.swing.JButton botaoRemover;
    private javax.swing.JComboBox<String> comboFornecedor;
    private javax.swing.JComboBox<String> comboItem;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel painel;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
