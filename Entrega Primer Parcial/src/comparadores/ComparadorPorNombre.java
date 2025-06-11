package comparadores;

import java.util.Comparator;

import personajes.Personaje;

public class ComparadorPorNombre implements Comparator<Personaje> {
    @Override
    public int compare(Personaje p1, Personaje p2) {
        return p1.getNombre().compareToIgnoreCase(p2.getNombre());
    }
}
