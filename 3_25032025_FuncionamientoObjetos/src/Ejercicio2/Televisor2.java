package Ejercicio2;

public class Televisor2 {
    private String marca;
    private String modelo;
    private Integer ano;
    private Pantalla pantalla;

    public Televisor2(String marca, String modelo, Integer ano, Pantalla pantalla) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.pantalla = pantalla;
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

    public Pantalla getPantalla() {
        return pantalla;
    }
    public void setPantalla(Pantalla pantalla) {
        this.pantalla = pantalla;
    }
}
