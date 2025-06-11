package personajes;

import interfaces.AccionPersonaje;

public class Guerrero extends Personaje implements AccionPersonaje {
    private Integer nivelEspada;
    private Integer nivelEscudo;

    public Guerrero(String nombre, Integer nivel, Integer ptsVida, Integer nivelEspada, Integer nivelEscudo) {
        super(nombre, nivel, ptsVida);
        this.nivelEspada = nivelEspada;
        this.nivelEscudo = nivelEscudo;
    }

    public Integer getNivelEspada() {
        return nivelEspada;
    }
    public void setNivelEspada(Integer nivelEspada) {
        this.nivelEspada = nivelEspada;
    }

    public Integer getNivelEscudo() {
        return nivelEscudo;
    }
    public void setNivelEscudo(Integer nivelEscudo) {
        this.nivelEscudo = nivelEscudo;
    }

    @Override
    public String saludar() {
        return "Hola, soy un Guerrero!";
    }

    @Override
    public String atacar() {
        return "El guerrero " + this.getNombre() + " ataca con su espada de nivel " + this.nivelEspada + "!";
    }
}

