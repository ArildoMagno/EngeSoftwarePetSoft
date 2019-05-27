/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelos.PedidoCompraProduto;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas Oliveira
 */
public class ControlePedidoCompraProduto {
     public void InserirProduto(PedidoCompraProduto pedidoCompraProduto) {
        Conexao conexao = new Conexao();
        try {
            String query = "INSERT INTO PedidoCompraProduto (idPedidoCompra, idProduto, quantidade"
                    + "VALUES(?,?,?)";
            PreparedStatement ps = conexao.getConnection().prepareStatement(query);
            ps.setInt(1, pedidoCompraProduto.getIdPedidoCompra());
            ps.setInt(2, pedidoCompraProduto.getIdProduto());
            ps.setFloat(3, pedidoCompraProduto.getQuantidade());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControlePedidoCompraProduto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }
    }
}
