/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Nikollas
 */
public class Conexao {

    /*public static Connection con = null;

    public static void Conectar() {
        System.out.println("Conectando ao banco...");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/mydb", "root", "root");
        } catch (ClassNotFoundException ex) {
            System.out.println("Classe não encontrada, adicione o driver nas bibliotecas.");
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }

    }*/
    private Connection con = null;

    private String hostName = null;
    private String userName = null;
    private String password = null;
    private String url = null;
    private String jdbcDriver = null;
    private String dataBaseName = null;
    private String dataBasePrefix = null;
    private String dabaBasePort = null;

    public Conexao() {
        super();
        /**
         * Os dados setados abaixo servem para uma conexão em MySQL. Altere de
         * acordo com seu BD. Aconselhamos carregar estes dados de um arquivo.
         */
        // "jdbc: mysql:/localhost:3306/meu_bd";
        hostName = "127.0.0.1";
        userName = "root";
        password = "root";
        jdbcDriver = "com.mysql.jdbc.Driver";
        dataBaseName = "mydb";
        dataBasePrefix = "jdbc:mysql://";
        dabaBasePort = "3306";

        
        url = dataBasePrefix + hostName + ":" + dabaBasePort + "/" + dataBaseName;

        /**
         * Exemplo de um URL completo para MySQL: a concatenação acima deve
         * ficar algo como: jdbc:'mysql:/localhost:3306/meu_bd'
         */
    }

    /**
     * Retorna uma java.sql.Connection.
     *
     * @return con
     */
    public Connection getConnection() {
        try {
            if (con == null) {
                Class.forName(jdbcDriver);
                con = DriverManager.getConnection(url, userName, password);
            } else if (con.isClosed()) {
                con = null;
                return getConnection();
            }
        } catch (ClassNotFoundException e) {

            //TODO: use um sistema de log apropriado.
            e.printStackTrace();
        } catch (SQLException e) {

            //TODO: use um sistema de log apropriado.
            e.printStackTrace();
        }
        return con;
    }

    public void closeConnection() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                //TODO: use um sistema de log apropriado.
                e.printStackTrace();
            }
        }
    }
}
