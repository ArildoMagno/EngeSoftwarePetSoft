/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelos.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pedro Mendonça
 */
public class ControleCliente {

    public void InserirCliente(Cliente cliente) {
        Conexao conexao = new Conexao();
        try {
            String query = "INSERT INTO Cliente (NomeFantasia, RazaoSocial,"
                    + " CpfCnpj, TipoPessoa, Endereco, Telefone)"
                    + "VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = conexao.getConnection().prepareStatement(query);
            ps.setString(1, cliente.getNomeFantasia());
            ps.setString(2, cliente.getRazaoSocial());
            ps.setString(3, cliente.getCpfCnpj());
            ps.setString(4, String.valueOf(cliente.getTipoPessoa()));
            ps.setString(5, cliente.getEndereco());
            ps.setString(6, cliente.getTelefone());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControleCliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }
    }

    public ArrayList<Cliente> ListaCliente() {
        Conexao conexao = new Conexao();
        ArrayList<Cliente> listaCliente = new ArrayList<>();
        try {
            String query = "SELECT * FROM Cliente";
            Statement st = conexao.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setCpfCnpj(rs.getString("CpfCnpj"));
                cliente.setEndereco(rs.getString("Endereco"));
                cliente.setNomeFantasia(rs.getString("NomeFantasia"));
                cliente.setRazaoSocial(rs.getString("RazaoSocial"));
                String aux = rs.getString("TipoPessoa");
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setAtivo(rs.getBoolean("ativo"));
                cliente.setTipoPessoa(aux.charAt(0));
                listaCliente.add(cliente);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ControleCliente.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }
        return listaCliente;
    }

    public ArrayList<Cliente> ListaCliente(String queryAux) {
        Conexao conexao = new Conexao();
        ArrayList<Cliente> listaCliente = new ArrayList<>();
        try {
            String query = "SELECT * FROM Cliente " + queryAux;
            Statement st = conexao.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setCpfCnpj(rs.getString("CpfCnpj"));
                cliente.setEndereco(rs.getString("Endereco"));
                cliente.setNomeFantasia(rs.getString("NomeFantasia"));
                cliente.setRazaoSocial(rs.getString("RazaoSocial"));
                cliente.setTelefone(rs.getString("telefone"));
                String aux = rs.getString("TipoPessoa");
                cliente.setTipoPessoa(aux.charAt(0));
                cliente.setAtivo(rs.getBoolean("ativo"));
                listaCliente.add(cliente);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ControleCliente.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }
        return listaCliente;
    }

    public void InativaCliente(int id) {
        Conexao conexao = new Conexao();

        try {
            String query = "update Cliente set ativo = 0 where id=?";
            PreparedStatement ps = conexao.getConnection().prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ControleCliente.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }
    }

    public void AlteraCliente(Cliente cliente) {
        Conexao conexao = new Conexao();

        try {
            String query = "update Cliente "
                    + "set NomeFantasia = ?, RazaoSocial = ?, Endereco = ?, "
                    + "Telefone = ? where id = ?";
            PreparedStatement ps = conexao.getConnection().prepareStatement(query);
            ps.setString(1, cliente.getNomeFantasia());
            ps.setString(2, cliente.getRazaoSocial());
            ps.setString(3, cliente.getEndereco());
            ps.setString(4, cliente.getTelefone());
            ps.setInt(5, cliente.getId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ControleCliente.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }

    }
}
