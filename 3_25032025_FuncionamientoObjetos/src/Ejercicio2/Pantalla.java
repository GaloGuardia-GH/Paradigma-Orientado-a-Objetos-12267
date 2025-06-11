package Ejercicio2;

public class Pantalla {
    private String tipo;
    private Integer tamano;
    private Integer resolucion;
    private Boolean inteligente;

    public Pantalla(String tipo, Integer tamano, Integer resolucion, Boolean inteligente) {
        this.tipo = tipo;
        this.tamano = tamano;
        this.resolucion = resolucion;
        this.inteligente = inteligente;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getTamano() {
        return tamano;
    }
    public void setTamano(Integer tamano) {
        this.tamano = tamano;
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
