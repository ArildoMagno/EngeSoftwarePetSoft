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
public class Caixa {

    private String cliente;
    private String fornecedor;
    private String item;
    private float valorCaixaTotal;
    private float valorCaixaPagar;
    private float valorCaixaReceber;

    //SETS & GETS
    public float getValorCaixaTotal() {
        return valorCaixaTotal;
    }

    public void setValorCaixaTotal(float valorCaixaTotal) {
        this.valorCaixaTotal = valorCaixaTotal;
    }

    public float getValorCaixaPagar() {
        return valorCaixaPagar;
    }

    public void setValorCaixaPagar(float valorCaixaPagar) {
        this.valorCaixaPagar = valorCaixaPagar;
    }

    public float getValorCaixaReceber() {
        return valorCaixaReceber;
    }

    public void setValorCaixaReceber(float valorCaixaReceber) {
        this.valorCaixaReceber = valorCaixaReceber;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

}
