package personajes;

import interfaces.AccionPersonaje;

public class Mago extends Personaje implements AccionPersonaje {
    private Integer nivelMagia;
    private Integer danioHabilidades;

    public Mago(String nombre, Integer nivel, Integer ptsVida, Integer nivelMagia, Integer danioHabilidades) {
        super(nombre, nivel, ptsVida);
        this.nivelMagia = nivelMagia;
        this.danioHabilidades = danioHabilidades;
    }

    public Integer getNivelMagia() {
        return nivelMagia;
    }
    public void setNivelMagia(Integer nivelMagia) {
        this.nivelMagia = nivelMagia;
    }

    public Integer getDanioHabilidades() {
        return danioHabilidades;
    }
    public void setDanioHabilidades(Integer danioHabilidades) {
        this.danioHabilidades = danioHabilidades;
    }

    @Override
    public String lanzarHechizo() {
        return "El mago " + this.getNombre() + " lanza un hechizo de magia de nivel " + this.nivelMagia + "!";
    }

    public String lanzarHechizo(String tipoHechizo) {
        String resp = "";
        switch (tipoHechizo) {
            case "fuego":
                resp = "El mago " + this.getNombre() + " lanza un hechizo de fuego!";
                break;
            case "hielo":
                resp = "El mago " + this.getNombre() + " lanza un hechizo de hielo!";
                break;
            case "rayo":
                resp = "El mago " + this.getNombre() + " lanza un hechizo de rayo!";
                break;
            default:
                resp = "Tipo de hechizo no reconocido!";
        }
        return resp;
    }

    @Override
    public String saludar() {
        return "Hola, soy un Mago!";
    }

    @Override
    public String atacar() {
        return "El mago " + this.getNombre() + " ataca con su magia de nivel " + this.nivelMagia + "!";
    }
}

