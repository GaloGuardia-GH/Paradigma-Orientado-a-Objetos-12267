package Vehiculos;

import Interfaces.Motorizado;

public class Coche extends Vehiculo implements Motorizado {
    private Integer cantPuertas;

    public Coche(String marca, String modelo, String color, Integer ano, Integer km, Integer velocidad, Integer cantPuertas) {
        super(marca, modelo, color, ano, km, velocidad);
        this.cantPuertas = cantPuertas;
    }

    public Integer getCantPuertas() {
        return cantPuertas;
    }
    public void setCantPuertas(Integer cantPuertas) {
        this.cantPuertas = cantPuertas;
    }

    @Override
    public String desplazar() {
        return "Coche desplazándose...";
    }

    public String desplazar(String modo) {
        return (modo.equalsIgnoreCase("normal")) ?  "Coche desplazándose en modo normal..." : "Coche desplazándose en modo automático...";
    }

    @Override
    public String encenderMotor() {
        return "Motor del coche encendido...";
    }

    @Override
    public String apagarMotor() {
        return "Motor del coche apagado...";
    }
}
