package Comparadores;

import java.util.Comparator;

import Objetos.Libro;

public class ComparadorPorTitulo implements Comparator<Libro> {
    @Override
    public int compare(Libro l1, Libro l2) {
        return l1.getTitulo().compareToIgnoreCase(l2.getTitulo());
    }
}