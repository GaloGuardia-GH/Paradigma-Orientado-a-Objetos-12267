package Ejercicio1;

public class Televisor {
    private String marca;
    private String modelo;
    private Integer ano;
    private String tipo;
    private Integer tamanoPantalla;
    private Integer resolucion;
    private Boolean inteligente;

    public Televisor(String marca, String modelo, Integer ano, String tipo, Integer tamanoPantalla, Integer resolucion, Boolean inteligente) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.tipo = tipo;
        this.tamanoPantalla = tamanoPantalla;
        this.resolucion = resolucion;
        this.inteligente = inteligente;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAno() {
        return ano;
    }
    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getTamanoPantalla() {
        return tamanoPantalla;
    }
    public void setTamanoPantalla(Integer tamanoPantalla) {
        this.tamanoPantalla = tamanoPantalla;
    }

    public Integer getResolucion() {
        return resolucion;
    }
    public void setResolucion(Integer resolucion) {
        this.resolucion = resolucion;
    }

    public String getInteligente() {
        String response = "";
        if (this.inteligente) {
            response = "Smart";
        } else {
            response = "No Smart";
        }
        return response;
    }
    public void setInteligente(Boolean inteligente) {
        this.inteligente = inteligente;
    }
}
