package objetos;

import interfaces.AccionObjeto;

public class Pocion extends Objeto implements AccionObjeto {
    private Integer efectividad;

    public Pocion(String tipo, String nombre, String habilidad, Integer efectividad) {
        super(tipo, nombre, habilidad);
        this.efectividad = efectividad;
    }

    public Integer getEfectividad() {
        return efectividad;
    }
    public void setEfectividad(Integer efectividad) {
        this.efectividad = efectividad;
    }

    @Override
    public String utilizar() {
        return "Utilizando " + this.getNombre() + " de tipo " + this.getTipo() + " con habilidad " + this.getHabilidad();
    }

    @Override
    public String descartar() {
        return "Descartando " + this.getNombre() + " de tipo " + this.getTipo();
    }
}

