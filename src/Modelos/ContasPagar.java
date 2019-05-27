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

    //vai ser string fornecedor ou fornecedorID?
    private String fornecedor;
    private float contasPagar;

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public float getContasPagar() {
        return contasPagar;
    }

    public void setContasPagar(float contasPagar) {
        this.contasPagar = contasPagar;
    }

}
