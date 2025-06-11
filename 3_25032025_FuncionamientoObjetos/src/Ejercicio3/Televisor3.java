package Ejercicio3;

import Ejercicio2.Pantalla;

public class Televisor3 {
    private String marca;
    private String modelo;
    private Integer ano;
    private String estado;
    private Pantalla pantalla;

    public Televisor3(String marca, String modelo, Integer ano, Pantalla pantalla) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.pantalla = pantalla;
        this.estado = "Apagado";
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

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Pantalla getPantalla() {
        return pantalla;
    }
    public void setPantalla(Pantalla pantalla) {
        this.pantalla = pantalla;
    }

    public void encender() {
        System.out.println("Encendiendo televisor...");
        this.estado = "Encendido";
    }

    public void apagar() {
        System.out.println("Apagando televisor...");
        this.estado = "Apagado";
    }
}
