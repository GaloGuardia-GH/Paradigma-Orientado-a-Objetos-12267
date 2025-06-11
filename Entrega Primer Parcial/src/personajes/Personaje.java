package personajes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import objetos.Objeto;

public class Personaje implements Comparable<Personaje> {
    private String tipo;
    private String nombre;
    private Integer nivel;
    private Integer ptsVida;
    private List<Objeto> objetos = new ArrayList<>();

    public Personaje(String tipo, String nombre, Integer nivel, Integer ptsVida, List<Objeto> objetos) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.nivel = nivel;
        this.ptsVida = ptsVida;
        this.objetos = objetos;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNivel() {
        return nivel;
    }
    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Integer getPtsVida() {
        return ptsVida;
    }
    public void setPtsVida(Integer ptsVida) {
        this.ptsVida = ptsVida;
    }

    public List<Objeto> getObjetos() {
        return objetos;
    }
    public void setObjetos(List<Objeto> objetos) {
        this.objetos = objetos;
    }

    public String lanzarHechizo() {
        return "El personaje " + this.nombre + " lanza un hechizo!";
    }

    @Override
    public int compareTo(Personaje pj) {
        return this.nombre.compareTo(pj.nombre);
    }

    @Override
    public String toString() {
        return "Personaje -> [Nombre: " + nombre + " | Nivel: " + nivel + " | Puntos de Vida: " + ptsVida + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Personaje pj = (Personaje) o;
        return Objects.equals(nombre, pj.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
