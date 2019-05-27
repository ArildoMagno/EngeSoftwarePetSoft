/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelos.PedidoVendaProduto;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas Oliveira
 */
public class ControlePedidoVendaProduto {
    
    public void InserirProduto(PedidoVendaProduto pedidoVendaProduto) {
        Conexao conexao = new Conexao();
        try {
            String query = "INSERT INTO PedidoVendaProduto (idPedidoVenda, idProduto, quantidade"
                    + "VALUES(?,?,?)";
            PreparedStatement ps = conexao.getConnection().prepareStatement(query);
            ps.setInt(1, pedidoVendaProduto.getIdPedidoVenda());
            ps.setInt(2, pedidoVendaProduto.getIdProduto());
            ps.setFloat(3, pedidoVendaProduto.getQuantidade());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControlePedidoVendaProduto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }
    }
}
