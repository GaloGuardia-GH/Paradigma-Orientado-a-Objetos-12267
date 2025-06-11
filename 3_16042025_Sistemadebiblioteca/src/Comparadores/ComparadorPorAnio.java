package Comparadores;

import java.util.Comparator;

import Objetos.Libro;

public class ComparadorPorAnio implements Comparator<Libro> {
    @Override
    public int compare(Libro l1, Libro l2) {
        return Integer.compare(l1.getAnioPublicacion(), l2.getAnioPublicacion());
    }
}
