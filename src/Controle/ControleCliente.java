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
            String query = "INSERT INTO Cliente (nomeFantasia, razaoSocial,CPFCNPJ, tipoPessoa, endereco)"
                    + "VALUES(?,?,?,?,?)";
            PreparedStatement ps = conexao.getConnection().prepareStatement(query);
            ps.setString(1, cliente.getNomeFantasia());
            ps.setString(2, cliente.getRazaoSocial());
            ps.setString(3, cliente.getCpfCnpj());
            ps.setString(4, String.valueOf(cliente.getTipoPessoa()));
            ps.setString(5, cliente.getEndereco());

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
                cliente.setCpfCnpj(rs.getString("CPFCNPJ"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setNomeFantasia(rs.getString("nomeFantasia"));
                cliente.setRazaoSocial(rs.getString("razaoSocial"));
                String aux = rs.getString("tipoPessoa");
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
            String query = "update cliente "
                    + "set nomeFantasia = ?, razaoSocial = ?, endereco = ?, "
                    + "telefone = ? where id = ?";
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
