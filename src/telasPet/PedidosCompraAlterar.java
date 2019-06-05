/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telasPet;

import Controle.Conexao;
import Controle.ControlePedidoCompra;
import Modelos.PedidoCompra;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Atlas
 */
public class PedidosCompraAlterar extends javax.swing.JFrame {

    /**
     * Creates new form PedidosCompraAlterar
     */
    public PedidosCompraAlterar() {
        initComponents();
        ControlePedidoCompra pedidoCompra = new ControlePedidoCompra();
        ArrayList<PedidoCompra> listaPedido = pedidoCompra.ListaPedidos();
        String[] cabecaTabela = {"idPedido", "nome fornecedor", "valor total", "data emissão", "status"};
        DefaultTableModel dtm = new DefaultTableModel(cabecaTabela, 0) {
            public boolean isCellEditable(int row, int column) {
                return false;//This causes all cells to be not editable
            }
        };
        dtm.addRow(cabecaTabela);
        for (int i = 0; i < listaPedido.size(); i++) {
            String status = "teste: ", nomeFantasia = "";

            if (listaPedido.get(i).getStatus() == 'P') {
                status = "Pendente";
            } else {
                status = "Concluído";
            }
            Conexao conexao = new Conexao();
            try {
                String query = "SELECT nomeFantasia FROM Fornecedor where id =?";
                PreparedStatement ps = conexao.getConnection().prepareStatement(query);
                ps.setInt(1, listaPedido.get(i).getIdFornecedor());
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    nomeFantasia = rs.getString("nomeFantasia");
                }
            } catch (SQLException ex) {
                Logger.getLogger(PedidosCompraAlterar.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                conexao.closeConnection();
            }

            dtm.addRow(new String[]{String.valueOf(listaPedido.get(i).getId()),
                nomeFantasia, String.valueOf(listaPedido.get(i).getValorTotal()),
                listaPedido.get(i).getDataEmissao(), status});
        }
        JTable table = new JTable(dtm);
        painel.add(table);
         table.addMouseListener(
                new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt
            ) {
                int row = table.rowAtPoint(evt.getPoint());
                int col = table.columnAtPoint(evt.getPoint());
                if (row >= 0 && col >= 0) {
                    int opcao = JOptionPane.showConfirmDialog(painel,
                            "Deseja alterar o pedido?",
                            "Sim ou não?", JOptionPane.YES_NO_OPTION);
                    boolean flag;
                    flag = opcao == JOptionPane.YES_OPTION;
                    if (flag) {
                        new PedidosCompraInserir(listaPedido.get(row-1)).setVisible(true);
                        dispose();
                        
                    }
                }
            }
        }
        );
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
        PainelTabela = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        painel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Pedido Compra Alterar");

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        painel.setLayout(new java.awt.CardLayout());
        jScrollPane2.setViewportView(painel);

        javax.swing.GroupLayout PainelTabelaLayout = new javax.swing.GroupLayout(PainelTabela);
        PainelTabela.setLayout(PainelTabelaLayout);
        PainelTabelaLayout.setHorizontalGroup(
            PainelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelTabelaLayout.createSequentialGroup()
                .addContainerGap(208, Short.MAX_VALUE)
                .addGroup(PainelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelTabelaLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(322, 322, 322))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelTabelaLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(187, 187, 187))))
            .addGroup(PainelTabelaLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane2))
        );
        PainelTabelaLayout.setVerticalGroup(
            PainelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelTabelaLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PainelTabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelTabela, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(PedidosCompraAlterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PedidosCompraAlterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PedidosCompraAlterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PedidosCompraAlterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PedidosCompraAlterar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PainelTabela;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel painel;
    // End of variables declaration//GEN-END:variables
}
