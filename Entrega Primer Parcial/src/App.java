import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import comparadores.ComparadorPorNivel;
import comparadores.ComparadorPorNombre;
import objetos.Objeto;
import personajes.Personaje;

public class App {
    private static List<Personaje> personajes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1 -> agregarPersonaje();
                case 2 -> eliminarPersonaje();
                case 3 -> buscarPersonaje();
                case 4 -> mostrarPersonajes();
                case 5 -> ordenarPorNivel();
                case 6 -> ordenarPorNombre();
                case 7 -> buscarMagosPorNivel();
                case 0 -> System.out.println("Saliendo del sistema.");
                default -> System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Menu Juego ---");
        System.out.println("1. Agregar personaje");
        System.out.println("2. Eliminar personaje (por nombre)");
        System.out.println("3. Buscar personaje (por nombre)");
        System.out.println("4. Mostrar todos los personajes");
        System.out.println("5. Ordenar personajes por nombre");
        System.out.println("6. Ordenar personajes por nivel");
        System.out.println("7. Buscar magos por nivel");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    private static List<Objeto> agregarObjetos() {
        List<Objeto> objetos = new ArrayList<>();
        String tipo = "";
        do {
            System.out.println("Ingrese 'Salir' para cargar los objetos.");
            System.out.print("Tipo: ");
            tipo = scanner.nextLine();
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Habilidad: ");
            String habilidad = scanner.nextLine();
            Objeto nuevo = new Objeto(tipo, nombre, habilidad);
            if (objetos.contains(nuevo)) {
                System.out.println("El objeto ya existe.");
            } else {
                objetos.add(nuevo);
                System.out.println("Objeto agregado exitosamente.");
            }
        } while (!tipo.equals("Salir"));
        return objetos;
    }

    private static void agregarPersonaje() {
        System.out.print("Tipo: ");
        String tipo = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Nivel: ");
        Integer nivel = scanner.nextInt();
        System.out.print("Puntos de Vida: ");
        Integer ptsVida = scanner.nextInt();
        scanner.nextLine();
        List<Objeto> objetos = agregarObjetos();
        Personaje nuevo = new Personaje(tipo, nombre, nivel, ptsVida, objetos);
        if (personajes.contains(nuevo)) {
            System.out.println("El personaje ya existe.");
        } else {
            personajes.add(nuevo);
            System.out.println("Personaje agregado exitosamente.");
        }
    }

    private static void eliminarPersonaje() {
        System.out.print("Ingrese el nombre del personaje a eliminar: ");
        String nombre = scanner.nextLine();
        Iterator<Personaje> it = personajes.iterator();
        boolean encontrado = false;
        while (it.hasNext()) {
            if (it.next().getNombre().equals(nombre)) {
                it.remove();
                encontrado = true;
                System.out.println("Personaje eliminado.");
                break;
            }
        }
        if (!encontrado) System.out.println("Personaje no encontrado.");
    }

    private static void buscarPersonaje() {
        System.out.print("Ingrese el nombre del personaje a buscar: ");
        String nombre = scanner.nextLine();
        Iterator<Personaje> it = personajes.iterator();
        while (it.hasNext()) {
            Personaje l = it.next();
            if (l.getNombre().equals(nombre)) {
                System.out.println("Personaje encontrado: " + l);
                return;
            }
        }
        System.out.println("Personaje no encontrado.");
    }

    private static void mostrarPersonajes() {
        if (personajes.isEmpty()) {
            System.out.println("No hay personajes registrados.");
        } else {
            System.out.println("\n--- Lista de Personajes ---");
            for (Personaje l : personajes) {
                System.out.println(l);
            }
        }
    }

    private static void ordenarPorNivel() {
        personajes.sort(new ComparadorPorNivel());
        System.out.println("Personajes ordenados por nivel.");
    }

    private static void ordenarPorNombre() {
        personajes.sort(new ComparadorPorNombre());
        System.out.println("Personajes ordenados por nombre.");
    }

    private static void buscarMagosPorNivel() {
        System.out.print("Ingrese el nivel de los magos a buscar: ");
        Integer nivel = scanner.nextInt();
        Iterator<Personaje> it = personajes.iterator();
        while (it.hasNext()) {
            Personaje l = it.next();
            if (l.getNivel().equals(nivel) && l.getTipo().equals("Mago")) {
                System.out.println("Mago encontrado: " + l);
                return;
            }
        }
        System.out.println("Magos no encontrados.");
    }
}
