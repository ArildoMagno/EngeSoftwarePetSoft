/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;


import Modelos.ContasReceber;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
}
