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

    private float saldo;
    private float contasReceber;
    private float contasPagar;

    
    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public float getContasReceber() {
        return contasReceber;
    }

    public void setContasReceber(float contasReceber) {
        this.contasReceber = contasReceber;
    }

    public float getContasPagar() {
        return contasPagar;
    }

    public void setContasPagar(float contasPagar) {
        this.contasPagar = contasPagar;
    }

}
