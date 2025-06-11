package personajes;

import interfaces.AccionPersonaje;

public class Arquero extends Personaje implements AccionPersonaje {
    private Integer nivelArco;
    private Integer danioFlechas;

    public Arquero(String nombre, Integer nivel, Integer ptsVida, Integer nivelArco, Integer danioFlechas) {
        super(nombre, nivel, ptsVida);
        this.nivelArco = nivelArco;
        this.danioFlechas = danioFlechas;
    }

    public Integer getNivelArco() {
        return nivelArco;
    }
    public void setNivelArco(Integer nivelArco) {
        this.nivelArco = nivelArco;
    }

    public Integer getDanioFlechas() {
        return danioFlechas;
    }
    public void setDanioFlechas(Integer danioFlechas) {
        this.danioFlechas = danioFlechas;
    }

    @Override
    public String saludar() {
        return "Hola, soy un Arquero!";
    }

    @Override
    public String atacar() {
        return "El arquero " + this.getNombre() + " ataca con su arco de nivel " + this.nivelArco + "!";
    }
}

