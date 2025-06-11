import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import Comparadores.ComparadorPorAnio;
import Comparadores.ComparadorPorTitulo;
import Objetos.Libro;

public class App {
    private static List<Libro> libros = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1 -> agregarLibro();
                case 2 -> eliminarLibro();
                case 3 -> buscarLibro();
                case 4 -> mostrarLibros();
                case 5 -> ordenarPorTitulo();
                case 6 -> ordenarPorAnio();
                case 0 -> System.out.println("Saliendo del sistema.");
                default -> System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Menu Biblioteca ---");
        System.out.println("1. Agregar libro");
        System.out.println("2. Eliminar libro (por ISBN)");
        System.out.println("3. Buscar libro (por ISBN)");
        System.out.println("4. Mostrar todos los libros");
        System.out.println("5. Ordenar libros por titulo");
        System.out.println("6. Ordenar libros por anio de publicacion");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    private static void agregarLibro() {
        System.out.print("Titulo: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Año de publicacion: ");
        int anio = scanner.nextInt();
        scanner.nextLine();
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        Libro nuevo = new Libro(titulo, autor, anio, isbn);
        if (libros.contains(nuevo)) {
            System.out.println("El libro ya existe.");
        } else {
            libros.add(nuevo);
            System.out.println("Libro agregado exitosamente.");
        }
    }

    private static void eliminarLibro() {
        System.out.print("Ingrese el ISBN del libro a eliminar: ");
        String isbn = scanner.nextLine();
        Iterator<Libro> it = libros.iterator();
        boolean encontrado = false;
        while (it.hasNext()) {
            if (it.next().getISBN().equals(isbn)) {
                it.remove();
                encontrado = true;
                System.out.println("Libro eliminado.");
                break;
            }
        }
        if (!encontrado) System.out.println("Libro no encontrado.");
    }

    private static void buscarLibro() {
        System.out.print("Ingrese el ISBN del libro a buscar: ");
        String isbn = scanner.nextLine();
        Iterator<Libro> it = libros.iterator();
        while (it.hasNext()) {
            Libro l = it.next();
            if (l.getISBN().equals(isbn)) {
                System.out.println("Libro encontrado: " + l);
                return;
            }
        }
        System.out.println("Libro no encontrado.");
    }

    private static void mostrarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
        } else {
            System.out.println("\n--- Lista de Libros ---");
            for (Libro l : libros) {
                System.out.println(l);
            }
        }
    }

    private static void ordenarPorTitulo() {
        libros.sort(new ComparadorPorTitulo());
        System.out.println("Libros ordenados por titulo.");
    }

    private static void ordenarPorAnio() {
        libros.sort(new ComparadorPorAnio());
        System.out.println("Libros ordenados por año de publicacion.");
    }
}
