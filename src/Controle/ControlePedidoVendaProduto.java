/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelos.PedidoVendaProduto;
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
    
    public ArrayList<PedidoVendaProduto> ListaProdutos(int id) {
        ArrayList<PedidoVendaProduto> lista = new ArrayList<>();
        Conexao conexao = new Conexao();
        try{
            String query = "SELECT * FROM PedidoVendaProduto WHERE idPedidoVenda = ?";
            PreparedStatement ps = conexao.getConnection().prepareCall(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                PedidoVendaProduto pedido = new PedidoVendaProduto();
                pedido.setIdPedidoVenda(rs.getInt("idPedidoVenda"));
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
            String query = "DELETE FROM PedidoVendaProduto WHERE idPedidoVenda = ?";
            PreparedStatement ps = conexao.getConnection().prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControlePedidoVenda.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }
    }
}
