package Vehiculos;

public class Bicicleta extends Vehiculo {
    private Boolean tieneCasco;
    private Integer cantCambios;

    public Bicicleta(String marca, String modelo, String color, Integer ano, Integer km, Integer velocidad, Boolean tieneCasco, Integer cantCambios) {
        super(marca, modelo, color, ano, km, velocidad);
        this.tieneCasco = tieneCasco;
        this.cantCambios = cantCambios;
    }

    public String getTieneCasco() {
        return (this.tieneCasco) ? "Tiene casco" : "No tiene casco";
    }
    public void setTieneCasco(Boolean tieneCasco) {
        this.tieneCasco = tieneCasco;
    }

    public Integer getCantCambios() {
        return cantCambios;
    }
    public void setCantCambios(Integer cantCambios) {
        this.cantCambios = cantCambios;
    }

    @Override
    public String desplazar() {
        return "Bicicleta desplazándose con pedaleo...";
    }
}
