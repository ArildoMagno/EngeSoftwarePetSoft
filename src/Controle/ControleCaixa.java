/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelos.Caixa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Atlas
 */
public class ControleCaixa {

    //banco
    public void caixaTotal(Caixa caixa) {
        Conexao conexao = new Conexao();

        try {
            String query = "INSERT INTO Caixa  (saldo,contasReceber,contasPagar)"
                    + "VALUES(?,?,?)";
            PreparedStatement ps = conexao.getConnection().prepareStatement(query);

            ps.setFloat(1, caixa.getSaldo());
            ps.setFloat(2, caixa.getContasReceber());
            ps.setFloat(3, caixa.getContasPagar());

            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(ControleFornecedor.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            conexao.closeConnection();
        }

    }

    public void UpdateContasPagar(Caixa caixa) {
        Conexao conexao = new Conexao();

        try {
            String query = "UPDATE Caixa SET saldo=?, contasPagar=?";
            PreparedStatement ps = conexao.getConnection().prepareStatement(query);

            ps.setFloat(1, caixa.getSaldo());
            ps.setFloat(2, caixa.getContasPagar());
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(ControleFornecedor.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            conexao.closeConnection();
        }

    }

    public void UpdateContasReceber(Caixa caixa) {
        Conexao conexao = new Conexao();

        try {
            String query = "UPDATE Caixa SET saldo=?, contasReceber=?";
            PreparedStatement ps = conexao.getConnection().prepareStatement(query);

            ps.setFloat(1, caixa.getSaldo());
            ps.setFloat(2, caixa.getContasReceber());
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(ControleFornecedor.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            conexao.closeConnection();
        }
    }

    public Caixa ListarCaixa() {
        Conexao conexao = new Conexao();
        Caixa caixa = new Caixa();
        try {
            String query = "SELECT * FROM caixa";
            Statement st = conexao.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                caixa.setSaldo(rs.getFloat("saldo"));
                caixa.setContasReceber(rs.getFloat("contasReceber"));
                caixa.setContasPagar(rs.getFloat("contasPagar"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControleCaixa.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }
        return caixa;

    }

}
