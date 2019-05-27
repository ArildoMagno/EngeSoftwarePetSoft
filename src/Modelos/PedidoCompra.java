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
public class PedidoCompra {
    private int id;
    private String dataEmissao;
    private String dataPrevisao;
    private float valorTotal;
    private int Fornecedor_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getDataPrevisao() {
        return dataPrevisao;
    }

    public void setDataPrevisao(String dataPrevisao) {
        this.dataPrevisao = dataPrevisao;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getFornecedor_id() {
        return Fornecedor_id;
    }

    public void setFornecedor_id(int Fornecedor_id) {
        this.Fornecedor_id = Fornecedor_id;
    }
    
}
