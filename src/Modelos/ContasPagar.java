/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Atlas
 */
public class ContasPagar {

    private int idFornecedor;
    private int id;
    private float valor;
    private boolean concluido;
    private int idPedidoCompra;

    public ContasPagar(int idFornecedor, int id, float valor, boolean concluido, int idPedidoCompra) {
        this.idFornecedor = idFornecedor;
        this.id = id;
        this.valor = valor;
        this.concluido = concluido;
        this.idPedidoCompra = idPedidoCompra;
    }

    public ContasPagar() {
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }

    public int getIdPedidoCompra() {
        return idPedidoCompra;
    }

    public void setIdPedidoCompra(int idPedidoCompra) {
        this.idPedidoCompra = idPedidoCompra;
    }

}
