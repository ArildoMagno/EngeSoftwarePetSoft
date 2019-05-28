package Controle;

import Modelos.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControleProduto {

    public void InserirProduto(Produto produto) {
        Conexao conexao = new Conexao();

        try {
            String query = "INSERT INTO Produton (descricao, estoque, estoqueMinimo,"
                    + " precoVenda, modelo, precoCompra, dataCadastramento, aliquota, unidade, idFornecedor)"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement ps = conexao.getConnection().prepareStatement(query);
            ps.setString(1, produto.getDescricao());

        } catch (SQLException ex) {
            Logger.getLogger(ControleProduto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }

    }

    public ArrayList<Produto> ListaProduto() {
        Conexao conexao = new Conexao();
        ArrayList<Produto> listaProduto = new ArrayList<>();
        Produto produto = new Produto();

        try {
            String query = "SELECT * FROM Produto";
            Statement st = conexao.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                produto.setId(rs.getInt("id"));
                produto.setIdFornecedor(rs.getInt("idFornecedor"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setEstoque(rs.getInt("estoque"));
                produto.setEstoqueMinimo(rs.getInt("estoqueMinimo"));
                produto.setPrecoVenda(rs.getFloat("precoVenda"));
                produto.setPrecoCompra(rs.getFloat("precoCompra"));
                produto.setModelo(rs.getString("modelo"));
                produto.setDataCadastramento(rs.getString("dataCadastramento"));
                produto.setAliquota(rs.getFloat("aliquota"));
                produto.setUnidade(rs.getString("unidade"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(ControleProduto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection();
        }
        return listaProduto;
    }

    public void InativaProduto(int id) {
        Conexao conexao = new Conexao();

        try {
            String query = "update Produto set ativo = 0 where id = ?";
            PreparedStatement ps = conexao.getConnection().prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControleProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            conexao.closeConnection();
        }
    }
    
    public void AlteraProduto(Produto produto){
        Conexao conexao = new Conexao();
        
        try{
            String query = "update Produto"
                    + "set descricao = ?, estoque = ?, estoqueMinimo = ?, precoVenda = ?, precoCompra = ?,"
                    + "modelo = ?, aliquota = ?, unidade = ?";
            PreparedStatement ps = conexao.getConnection().prepareStatement(query);
            ps.setString(1,produto.getDescricao());
            ps.setInt(2,produto.getEstoque());
            ps.setInt(3,produto.getEstoqueMinimo());
            ps.setFloat(4,produto.getPrecoVenda());
            ps.setFloat(5,produto.getPrecoCompra());
            ps.setString(6,produto.getModelo());
            ps.setFloat(7,produto.getAliquota());
            ps.setString(8,produto.getUnidade());
                    
        } catch (SQLException ex) {
            Logger.getLogger(ControleProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            conexao.closeConnection();
        }
        
    }

}
