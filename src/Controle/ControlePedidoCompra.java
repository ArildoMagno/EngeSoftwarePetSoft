/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelos.PedidoCompra;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas Oliveira
 */

public class ControlePedidoCompra {
    public void InserirPedidoCompra(PedidoCompra pedido){
                Conexao conexao = new Conexao();
        try {
            String query = "INSERT INTO PedidoCompra (id,dataEmissao,dataPrevisao,valorTotal,idFornecedor,status)"
                    + "VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = conexao.getConnection().prepareStatement(query);
            ps.setInt(1, pedido.getId());
            ps.setString(2, pedido.getDataEmissao());
            ps.setString(3, pedido.getDataPrevisao());
            ps.setFloat(4, pedido.getValorTotal());
            ps.setInt(5, pedido.getIdFornecedor());
            ps.setString(6, String.valueOf(pedido.getStatus()));
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControlePedidoCompra.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }
    }

    public ArrayList<PedidoCompra> ListaPedidos(String queryAux) {
        Conexao conexao = new Conexao();
        PedidoCompra pedido = new PedidoCompra();
        ArrayList<PedidoCompra> listaPedidos = new ArrayList<>();
        try {
            String query = "SELECT * FROM PedidoCompra" + queryAux;
            Statement st = conexao.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                pedido.setId(rs.getInt("id"));
                pedido.setDataEmissao(rs.getString("dataEmissao"));
                pedido.setDataPrevisao(rs.getString("dataPrevisao"));
                pedido.setValorTotal(rs.getFloat("valorTotal"));
                pedido.setIdFornecedor(rs.getInt("idFornecedor"));
                listaPedidos.add(pedido);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlePedidoCompra.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }
        return listaPedidos;
    }
    
    public void AlteraPedidoCompra(PedidoCompra pedido){
        Conexao conexao = new Conexao();
        
        try{
            String query = "update PedidoCompra "
                    + "set dataEmissao = ?, dataPrevisao = ?, valorTotal = ?, idFornecedor = ?"
                    + "where id = ?";
           PreparedStatement ps = conexao.getConnection().prepareStatement(query);
           ps.setString(1, pedido.getDataEmissao());
           ps.setString(2, pedido.getDataPrevisao());
           ps.setFloat(3, pedido.getValorTotal());
           ps.setInt(4, pedido.getIdFornecedor());
           ps.setInt(5, pedido.getId());
           ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControlePedidoCompra.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            conexao.closeConnection();
        } 
    }
    
    public void ConcluiPedidoCompra(PedidoCompra pedido){
        Conexao conexao = new Conexao();
        
        try{
            String query = "update PedidoCompra "
                    + "set status = ?"
                    + "where id = ?";
           PreparedStatement ps = conexao.getConnection().prepareStatement(query);
           ps.setString(1, String.valueOf(pedido.getStatus()));
           ps.setInt(2, pedido.getId());
           ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControlePedidoCompra.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            conexao.closeConnection();
        }
    }
    
    public void ExcluiPedidoCompra(int id){
        Conexao conexao = new Conexao();
        
        try{
            String query = "DELETE FROM PedidoCompra where id = ?";
            PreparedStatement ps = conexao.getConnection().prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControlePedidoCompra.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            conexao.closeConnection();
        }
    }
}
