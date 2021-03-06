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
 * @author Lucas Oliveira
 */
public class ControlePedidoVenda {

    public void InserirPedidoVenda(PedidoVenda pedido) {
        Conexao conexao = new Conexao();
        try {
            String query = "INSERT INTO PedidoVenda (dataEmissao,valorTotal,idCliente,status)"
                    + "VALUES(?,?,?,?)";
            PreparedStatement ps = conexao.getConnection().prepareStatement(query);
            ps.setString(1, pedido.getDataEmissao());
            ps.setFloat(2, pedido.getValorTotal());
            ps.setInt(3, pedido.getIdCliente());
            ps.setString(4, String.valueOf(pedido.getStatus()));
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControlePedidoVenda.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }
    }
    
    public ArrayList<PedidoVenda> ListaPedidos() {
        Conexao conexao = new Conexao();
        
        ArrayList<PedidoVenda> listaPedidos = new ArrayList<>();
        try {
            String query = "SELECT * FROM PedidoVenda";
            Statement st = conexao.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                PedidoVenda pedido = new PedidoVenda();
                pedido.setId(rs.getInt("id"));
                pedido.setDataEmissao(rs.getString("dataEmissao"));
                pedido.setValorTotal(rs.getFloat("valorTotal"));
                pedido.setIdCliente(rs.getInt("idCliente"));
                String status = rs.getString("status");
                pedido.setStatus(status.charAt(0));
                listaPedidos.add(pedido);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlePedidoVenda.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }
        return listaPedidos;
    }
    
    public ArrayList<PedidoVenda> ListaPedidos(String queryAux) {
        Conexao conexao = new Conexao();
        
        ArrayList<PedidoVenda> listaPedidos = new ArrayList<>();
        try {
            String query = "SELECT * FROM PedidoVenda " + queryAux;
            Statement st = conexao.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                PedidoVenda pedido = new PedidoVenda();
                pedido.setId(rs.getInt("id"));
                pedido.setDataEmissao(rs.getString("dataEmissao"));
                pedido.setValorTotal(rs.getFloat("valorTotal"));
                pedido.setIdCliente(rs.getInt("idCliente"));
                pedido.setStatus(rs.getString("status").charAt(0));
                listaPedidos.add(pedido);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlePedidoVenda.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }
        return listaPedidos;
    }
    
    public void AlteraPedidoVenda(PedidoVenda pedido) {
        Conexao conexao = new Conexao();
        
        try {
            String query = "update PedidoVenda "
                    + "set valorTotal = ?, idCliente = ? "
                    + "where id = ?";
            PreparedStatement ps = conexao.getConnection().prepareStatement(query);
            ps.setFloat(1, pedido.getValorTotal());
            ps.setInt(2, pedido.getIdCliente());
            ps.setInt(3, pedido.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControlePedidoVenda.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }
    }
    
    public void ConcluiPedidoVenda(PedidoVenda pedido) {
        Conexao conexao = new Conexao();
        
        try {
            String query = "update PedidoVenda "
                    + "set status = ?"
                    + "where id = ?";
            PreparedStatement ps = conexao.getConnection().prepareStatement(query);
            ps.setString(1, "C");
            ps.setInt(2, pedido.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControlePedidoVenda.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }
    }
    
    public void ExcluiPedidoVenda(int id) {
        Conexao conexao = new Conexao();
        
        try {
            String query = "DELETE FROM PedidoVenda where id = ?";
            PreparedStatement ps = conexao.getConnection().prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControlePedidoVenda.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }
    }
    
    public int ContadorPedido() {
        int id = 0;
        Conexao conexao = new Conexao();
        try {
            String query = "SELECT id FROM PedidoVenda ORDER BY id desc LIMIT 1";
            Statement st = conexao.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlePedidoVenda.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }
        return id;
    }
}
