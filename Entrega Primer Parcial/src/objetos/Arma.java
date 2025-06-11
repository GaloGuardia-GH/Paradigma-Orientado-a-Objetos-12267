package objetos;

import interfaces.AccionObjeto;

public class Arma extends Objeto implements AccionObjeto {
    private String rafaga;

    public Arma(String tipo, String nombre, String habilidad, String rafaga) {
        super(tipo, nombre, habilidad);
        this.rafaga = rafaga;
    }

    public String getRafaga() {
        return rafaga;
    }
    public void setRafaga(String rafaga) {
        this.rafaga = rafaga;
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

