/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Lucas Oliveira
 */
public class PedidoVendaProduto {
    private int idPedidoVenda;
    private int idProduto;
    private float quantidade;

    public int getIdPedidoVenda() {
        return idPedidoVenda;
    }

    public void setIdPedidoVenda(int idPedidoVenda) {
        this.idPedidoVenda = idPedidoVenda;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }    
}
