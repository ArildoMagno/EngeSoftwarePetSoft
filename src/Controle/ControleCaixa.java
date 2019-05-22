/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelos.Caixa;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Atlas
 */
public class ControleCaixa {

    //banco
    public void contasReceber(Caixa caixa) throws MessagingException {
        Conexao conexao = new Conexao();

        try {
            String query = "INSERT INTO Caixa  (cliente)"
                    + "VALUES(?,?,?,?,?)";
            PreparedStatement ps = conexao.getConnection().prepareStatement(query);
            ps.setString(1, caixa.getCliente());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new MessagingException("\nErro teste");
        } finally {
            conexao.closeConnection();
        }

    }

   
}
