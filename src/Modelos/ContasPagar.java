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

    public ContasPagar(int idFornecedor, int id, float valor) {
        this.idFornecedor = idFornecedor;
        this.id = id;
        this.valor = valor;
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

}
