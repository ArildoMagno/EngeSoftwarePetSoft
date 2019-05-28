/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelos.ContasPagar;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Atlas
 */
public class ControleContasPagar {

    public void InserirContasReceber(ContasPagar contasPagar) {
        Conexao conexao = new Conexao();

        try {
            String query = "INSERT INTO ContasPagar  (idFornecedor,valor)"
                    + "VALUES(?,?)";
            PreparedStatement ps = conexao.getConnection().prepareStatement(query);
            ps.setInt(1, contasPagar.getIdFornecedor());
            ps.setFloat(2, contasPagar.getValor());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControleContasReceber.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }

    }
}
