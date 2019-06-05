/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelos.ContasPagar;
import Modelos.ContasReceber;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Atlas
 */
public class ControleContasReceber {

    public void InserirContasReceber(ContasReceber contasReceber) {
        Conexao conexao = new Conexao();

        try {
            String query = "INSERT INTO ContasReceber  (idCliente,valor)"
                    + "VALUES(?,?)";
            PreparedStatement ps = conexao.getConnection().prepareStatement(query);
            ps.setInt(1, contasReceber.getIdCliente());
            ps.setFloat(2, contasReceber.getValor());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControleContasReceber.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }

    }

    public ArrayList<ContasReceber> ListarContasReceber() {
        ArrayList<ContasReceber> listaConta = new ArrayList<>();
        Conexao conexao = new Conexao();

        try {
            String query = "SELECT * FROM ContasReceber";
            Statement st = conexao.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                int idCliente = rs.getInt("idCliente");
                float valor = rs.getFloat("valor");
                boolean concluido = (rs.getBoolean("concluido"));
                ContasReceber contas = new ContasReceber(idCliente, id, valor, concluido);
                listaConta.add(contas);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControleContasPagar.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }

        return listaConta;
    }

    public ArrayList<ContasReceber> ListarContasReceber(String queryAux) {
        ArrayList<ContasReceber> listaConta = new ArrayList<>();
        Conexao conexao = new Conexao();

        try {
            String query = "SELECT * FROM ContasReceber " + queryAux;
            Statement st = conexao.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                int idCliente = rs.getInt("idCliente");
                float valor = rs.getFloat("valor");
                boolean concluido = (rs.getBoolean("concluido"));
                ContasReceber contas = new ContasReceber(idCliente, id, valor, concluido);
                listaConta.add(contas);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControleContasPagar.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }

        return listaConta;
    }

    public void ConcluirContasReceber(int id) {
        Conexao conexao = new Conexao();
        try {
            String query = "UPDATE contasreceber SET"
                    + " concluido = ? WHERE id = ?";
            PreparedStatement ps = conexao.getConnection().prepareStatement(query);
            ps.setBoolean(1, true);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControleAgenda.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }

    }
}
