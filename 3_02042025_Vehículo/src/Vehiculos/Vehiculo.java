package Vehiculos;

public class Vehiculo {
    private String marca;
    private String modelo;
    private String color;
    private Integer ano;
    private Integer km;
    private Integer velocidad;

    public Vehiculo(String marca, String modelo, String color, Integer ano, Integer km, Integer velocidad) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.ano = ano;
        this.km = km;
        this.velocidad = velocidad;
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

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public Integer getAno() {
        return ano;
    }
    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getKm() {
        return km;
    }
    public void setKm(Integer km) {
        this.km = km;
    }

    public Integer getVelocidad() {
        return velocidad;
    }
    public void setVelocidad(Integer velocidad) {
        this.velocidad = velocidad;
    }

    public String desplazar() {
        return "Vehículo desplazandose...";
    }
}
