/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelos.ContasPagar;
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
public class ControleContasPagar {

    public void InserirContasPagar(ContasPagar contasPagar) {
        Conexao conexao = new Conexao();

        try {
            String query = "INSERT INTO ContasPagar  (idFornecedor,valor)"
                    + "VALUES(?,?)";
            PreparedStatement ps = conexao.getConnection().prepareStatement(query);
            ps.setInt(1, contasPagar.getIdFornecedor());
            ps.setFloat(2, contasPagar.getValor());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControleContasPagar.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }

    }

    public ArrayList<ContasPagar> ListarContasPagar() {
        ArrayList<ContasPagar> listaConta = new ArrayList<>();
        Conexao conexao = new Conexao();

        try {
            String query = "SELECT * FROM ContasPagar";
            Statement st = conexao.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                int idFornecedor = rs.getInt("idFornecedor");
                float valor = rs.getFloat("valor");
                ContasPagar contas = new ContasPagar(idFornecedor, id, valor);
                listaConta.add(contas);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControleContasPagar.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }

        return listaConta;
    }

    
    
}
