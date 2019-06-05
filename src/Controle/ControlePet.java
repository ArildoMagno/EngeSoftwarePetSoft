/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelos.Pet;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nikollas
 */
public class ControlePet {

    public void InserirPet(Pet pet) {
        Conexao conexao = new Conexao();
        try {
            String query = "INSERT INTO Pet (nome,raca,tipo,idCliente)"
                    + " VALUES(?,?,?,?)";
            PreparedStatement ps = conexao.getConnection().prepareStatement(query);
            ps.setString(1, pet.getNome());
            ps.setString(2, pet.getRaca());
            ps.setString(3, pet.getTipo());
            ps.setInt(4, pet.getIdCliente());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControlePet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }
    }

    public ArrayList<Pet> ListaPet() {
        ArrayList<Pet> listaPet = new ArrayList<>();
        Conexao conexao = new Conexao();
        String query = "SELECT * FROM Pet ";
        try {
            Statement st = conexao.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String raca = rs.getString("raca");
                String tipo = rs.getString("tipo");
                int idCliente = rs.getInt("idCliente");
                Pet pet = new Pet(id, nome, raca, tipo, idCliente);
                listaPet.add(pet);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlePet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }
        return listaPet;
    }

    public ArrayList<Pet> ListaPet(String queryAux) {
        ArrayList<Pet> listaPet = new ArrayList<>();
        Conexao conexao = new Conexao();
        String query = "SELECT * FROM Pet " + queryAux;
        try {
            Statement st = conexao.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String raca = rs.getString("raca");
                String tipo = rs.getString("tipo");
                int idCliente = rs.getInt("idCliente");
                Pet pet = new Pet(id, nome, raca, tipo, idCliente);
                listaPet.add(pet);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlePet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }
        return listaPet;
    }

    public ArrayList<Pet> ListaPet(int idCliente) {
        ArrayList<Pet> listaPet = new ArrayList<>();
        Conexao conexao = new Conexao();
        String query = "SELECT * FROM Pet where idCliente = ?";
        try {
            PreparedStatement ps = conexao.getConnection().prepareStatement(query);
            ps.setInt(1, idCliente);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String raca = rs.getString("raca");
                String tipo = rs.getString("tipo");
                Pet pet = new Pet(id, nome, raca, tipo, idCliente);
                listaPet.add(pet);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlePet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }
        return listaPet;
    }

    public void AlteraPet(Pet pet) {
        Conexao conexao = new Conexao();
        try {
            String query = "UPDATE Pet SET"
                    + " nome = ?, raca=?, tipo=? "
                    + "WHERE id = ?";
            PreparedStatement ps = conexao.getConnection().prepareStatement(query);
            ps.setString(1, pet.getNome());
            ps.setString(2, pet.getRaca());
            ps.setString(3, pet.getTipo());
            ps.setInt(4, pet.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControleAgenda.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }
    }

    public void InativaPet(int id) {
        Conexao conexao = new Conexao();
        try {
            String query = "UPDATE Pet SET"
                    + " ativo=? "
                    + "WHERE id = ?";
            PreparedStatement ps = conexao.getConnection().prepareStatement(query);
            ps.setBoolean(1, false);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControleAgenda.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }
    }
}
