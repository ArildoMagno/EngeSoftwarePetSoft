/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelos.Fornecedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gungnir
 */
public class ControleFornecedor {

    public void InserirFornecedor(Fornecedor fornecedor) {
        Conexao conexao = new Conexao();
        try {
            String query = "INSERT INTO Fornecedor  (razaoSocial, CNPJ, nomeFantasia,endereco,telefone,"
                    + "ativo)"
                    + "VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = conexao.getConnection().prepareStatement(query);
            ps.setString(1, fornecedor.getRazaoSocial());
            ps.setString(2, fornecedor.getCNPJ());
            ps.setString(3, fornecedor.getNomeFantasia());
            ps.setString(4, fornecedor.getEndereco());
            ps.setString(5, fornecedor.getTelefone());
            ps.setInt(6, fornecedor.getAtivo());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControleFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }
    }

    public ArrayList<Fornecedor> ListaFornecedor() {
        Conexao conexao = new Conexao();
        ArrayList<Fornecedor> listaFornecedor = new ArrayList<>();
        Fornecedor fornecedor = new Fornecedor();
        try {
            String query = "SELECT * FROM Fornecedor";
            Statement st = conexao.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                fornecedor.setId(rs.getInt("id"));
                fornecedor.setCNPJ(rs.getString("CNPJ"));
                fornecedor.setEndereco(rs.getString("endereco"));
                fornecedor.setNomeFantasia(rs.getString("nomeFantasia"));
                fornecedor.setRazaoSocial(rs.getString("razaoSocial"));
                fornecedor.setTelefone(rs.getString("telefone"));
                listaFornecedor.add(fornecedor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControleFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }
        return listaFornecedor;
    }

    public ArrayList<Fornecedor> ListaFornecedor(String queryAux) {
        Conexao conexao = new Conexao();
        ArrayList<Fornecedor> listaFornecedor = new ArrayList<>();
        Fornecedor fornecedor = new Fornecedor();
        try {
            String query = "SELECT * FROM Fornecedor " + queryAux;
            Statement st = conexao.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                fornecedor.setId(rs.getInt("id"));
                fornecedor.setCNPJ(rs.getString("CNPJ"));
                fornecedor.setEndereco(rs.getString("endereco"));
                fornecedor.setNomeFantasia(rs.getString("nomeFantasia"));
                fornecedor.setRazaoSocial(rs.getString("razaoSocial"));
                fornecedor.setTelefone(rs.getString("telefone"));
                listaFornecedor.add(fornecedor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControleFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }
        return listaFornecedor;
    }

    public void InativaFornecedor(int id) {
        Conexao conexao = new Conexao();

        try {
            String query = "update Fornecedor set ativo = 0 where id=?";
            PreparedStatement ps = conexao.getConnection().prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControleFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }
    }

    public void AlteraFornecedor(Fornecedor fornecedor) {
        Conexao conexao = new Conexao();

        try {
            String query = "update Fornecedor "
                    + "set nomeFantasia = ?, razaoSocial = ?, endereco = ?, "
                    + "telefone = ? where id = ?";
            PreparedStatement ps = conexao.getConnection().prepareStatement(query);
            ps.setString(1, fornecedor.getNomeFantasia());
            ps.setString(2, fornecedor.getRazaoSocial());
            ps.setString(3, fornecedor.getEndereco());
            ps.setString(4, fornecedor.getTelefone());
            ps.setInt(5, fornecedor.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControleFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }

    }
}
