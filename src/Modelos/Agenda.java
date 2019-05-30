package Modelos;

public class Agenda {

    private int id;
    private String data;
    private String hora;
    private float valor;
    private char tipo;
    private int idUsuario;
    private int idCliente;
    private boolean concluido;

    public Agenda(int id,String data, String hora, float valor, char tipo, int idUsuario, int idCliente, boolean concluido) {
       this.id = id;
        this.data = data;
        this.hora = hora;
        this.valor = valor;
        this.tipo = tipo;
        this.idUsuario = idUsuario;
        this.idCliente = idCliente;
        this.concluido = concluido;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }

    public Agenda() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

}
