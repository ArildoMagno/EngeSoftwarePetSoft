/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelos.PedidoVenda;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas  Oliveira
 */

public class ControlePedidoVenda {
    public void InserirPedidoVenda(PedidoVenda pedido){
                Conexao conexao = new Conexao();
        try {
            String query = "INSERT INTO Fornecedor  (dataEmissao,valorTotal,cliente,quantidade)"
                    + "VALUES(?,?,?,?,?)";
            PreparedStatement ps = conexao.getConnection().prepareStatement(query);
            ps.setString(1, pedido.getDataEmissao());
            ps.setFloat(2, pedido.getValorTotal());
            ps.setInt(3, pedido.getCliente());
            ps.setFloat(4, pedido.getQuantidade());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControlePedidoVenda.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }
    }

    public ArrayList<PedidoVenda> ListaPedidos() {
        Conexao conexao = new Conexao();
        PedidoVenda pedido = new PedidoVenda();
        ArrayList<PedidoVenda> listaPedidos = new ArrayList<>();
        try {
            String query = "SELECT * FROM PedidoVenda";
            Statement st = conexao.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                pedido.setId(rs.getInt("id"));
                pedido.setDataEmissao(rs.getString("dataEmissao"));
                pedido.setValorTotal(rs.getFloat("valorTotal"));
                pedido.setCliente(rs.getInt("cliente"));
                pedido.setQuantidade(rs.getInt("quantidade"));
                listaPedidos.add(pedido);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlePedidoVenda.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }
        return listaPedidos;
    }
    
    public void AlteraPedidoVenda(PedidoVenda pedido){
        Conexao conexao = new Conexao();
        
        try{
            String query = "update PedidoVenda "
                    + "set valorTotal = ?, cliente = ?, quantidade = ?, "
                    + "where id = ?";
           PreparedStatement ps = conexao.getConnection().prepareStatement(query);
           ps.setFloat(1, pedido.getValorTotal());
           ps.setInt(2, pedido.getCliente());
           ps.setFloat(3, pedido.getQuantidade());
           ps.setInt(4, pedido.getId());
           ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControlePedidoVenda.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            conexao.closeConnection();
        }
        
    }
}