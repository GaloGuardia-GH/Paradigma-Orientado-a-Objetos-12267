package comparadores;

import java.util.Comparator;

import personajes.Personaje;

public class ComparadorPorNivel implements Comparator<Personaje> {
    @Override
    public int compare(Personaje p1, Personaje p2) {
        return Integer.compare(p1.getNivel(), p2.getNivel());
    }
}