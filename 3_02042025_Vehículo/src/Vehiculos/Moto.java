package Vehiculos;

import Interfaces.Motorizado;

public class Moto extends Vehiculo implements Motorizado {
    private Boolean tieneCasco;

    public Moto(String marca, String modelo, String color, Integer ano, Integer km, Integer velocidad, Boolean tieneCasco) {
        super(marca, modelo, color, ano, km, velocidad);
        this.tieneCasco = tieneCasco;
    }

    public String getTieneCasco() {
        return (this.tieneCasco) ? "Tiene casco" : "No tiene casco";
    }
    public void setTieneCasco(Boolean tieneCasco) {
        this.tieneCasco = tieneCasco;
    }

    @Override
    public String desplazar() {
        return "Moto desplazándose...";
    }

    @Override
    public String encenderMotor() {
        return "Motor de la moto encendido...";
    }

    @Override
    public String apagarMotor() {
        return "Motor de la moto apagado...";
    }
}
