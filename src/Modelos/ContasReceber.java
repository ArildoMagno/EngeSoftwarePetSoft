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
public class ContasReceber {

    private int idCliente;
    private int id;
    private float valor;

    public ContasReceber(int idCliente, int id, float valor) {
        this.idCliente = idCliente;
        this.id = id;
        this.valor = valor;
    }

    public ContasReceber() {
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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
