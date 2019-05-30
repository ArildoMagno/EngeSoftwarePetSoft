package Controle;

import Modelos.Agenda;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControleAgenda {

    public void InsereAgenda(Agenda agenda) {
        Conexao conexao = new Conexao();
        try {
            String query = "INSERT INTO Agenda (data,horario,valor,tipo,idUsuario,idCliente,concluido)"
                    + "VALUES(?,?,?,?,?,?,?)";
            PreparedStatement ps = conexao.getConnection().prepareStatement(query);
            ps.setString(1, agenda.getData());
            ps.setString(2, agenda.getHora());
            ps.setFloat(3, agenda.getValor());
            ps.setString(4, String.valueOf(agenda.getTipo()));
            ps.setInt(5, agenda.getIdUsuario());
            ps.setInt(6, agenda.getIdCliente());
            ps.setBoolean(7, false);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControleAgenda.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }
    }

    public ArrayList<Agenda> ListaAgendas() {

        Conexao conexao = new Conexao();
        ArrayList<Agenda> listaAgenda = new ArrayList<>();
        try {
            String query = "SELECT * FROM Agenda ";
            Statement st = conexao.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                int id = (rs.getInt("id"));
                String data = (rs.getString("data"));
                String hora = (rs.getString("horario"));
                int idCliente = (rs.getInt("idCliente"));
                int idUsuario = (rs.getInt("idUsuario"));
                String aux = rs.getString("tipo");
                float valor = (rs.getFloat("valor"));
                boolean concluido = (rs.getBoolean("concluido"));
                Agenda agenda = new Agenda(id, data, hora, valor, aux.charAt(0), idUsuario, idCliente, concluido);
                listaAgenda.add(agenda);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControleFornecedor.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            conexao.closeConnection();
        }
        return listaAgenda;
    }

    public ArrayList<Agenda> ListaAgendas(String queryAux) {

        Conexao conexao = new Conexao();
        ArrayList<Agenda> listaAgenda = new ArrayList<>();
        try {
            String query = "SELECT * FROM Agenda " + queryAux;
            Statement st = conexao.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                int id = (rs.getInt("id"));
                String data = (rs.getString("data"));
                String hora = (rs.getString("horario"));
                int idCliente = (rs.getInt("idCliente"));
                int idUsuario = (rs.getInt("idUsuario"));
                String aux = rs.getString("tipo");
                float valor = (rs.getFloat("valor"));
                boolean concluido = (rs.getBoolean("concluido"));
                Agenda agenda = new Agenda(id, data, hora, valor, aux.charAt(0), idUsuario, idCliente, concluido);
                listaAgenda.add(agenda);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControleFornecedor.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            conexao.closeConnection();
        }
        return listaAgenda;
    }

    public void ConcluiAgenda(int id) {
        Conexao conexao = new Conexao();
        try {
            String query = "UPDATE agenda SET"
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

    public void AlteraAgenda(Agenda agenda) {
        Conexao conexao = new Conexao();
        try {
            String query = "UPDATE Agenda SET"
                    + "data = ?, horario = ?, valor = ?,"
                    + "WHERE id = ?";
            PreparedStatement ps = conexao.getConnection().prepareStatement(query);
            ps.setString(1, agenda.getData());
            ps.setString(2, agenda.getHora());
            ps.setFloat(3, agenda.getValor());
            ps.setInt(4, agenda.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControleAgenda.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }
    }

    public void DeletaAgenda(int id) {
        Conexao conexao = new Conexao();
        try {
            String query = "DELETE FROM Agenda where id = ?";
            PreparedStatement ps = conexao.getConnection().prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControleAgenda.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }
    }
}
