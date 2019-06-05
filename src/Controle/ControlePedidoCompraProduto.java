/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelos.PedidoCompraProduto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
            String query = "INSERT INTO PedidoCompraProduto (idPedidoCompra, idProduto, quantidade, valorUnitario) "
                    + "VALUES (?,?,?,?)";
            PreparedStatement ps = conexao.getConnection().prepareStatement(query);
            ps.setInt(1, pedidoCompraProduto.getIdPedidoCompra());
            ps.setInt(2, pedidoCompraProduto.getIdProduto());
            ps.setFloat(3, pedidoCompraProduto.getQuantidade());
            ps.setFloat(4, pedidoCompraProduto.getValorUnitario());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControlePedidoCompraProduto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }
    }

    public ArrayList<PedidoCompraProduto> ListaProdutos(int id) {
        ArrayList<PedidoCompraProduto> lista = new ArrayList<>();
        Conexao conexao = new Conexao();
        try{
            String query = "SELECT * FROM PedidoCompraProduto WHERE idPedidoCompra = ?";
            PreparedStatement ps = conexao.getConnection().prepareCall(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                PedidoCompraProduto pedido = new PedidoCompraProduto();
                pedido.setIdPedidoCompra(rs.getInt("idPedidoCompra"));
                pedido.setIdProduto(rs.getInt("idProduto"));
                pedido.setQuantidade(rs.getFloat("quantidade"));
                pedido.setValorUnitario(rs.getFloat("valorUnitario"));
                lista.add(pedido);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlePedidoCompraProduto.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            conexao.closeConnection();
        }
        return lista;
    }

    public void DeletarPedido(int id) {
        Conexao conexao = new Conexao();
        try {
            String query = "DELETE FROM PedidoCompraProduto WHERE idPedidoCompra = ?";
            PreparedStatement ps = conexao.getConnection().prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControlePedidoCompra.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }
    }
}
