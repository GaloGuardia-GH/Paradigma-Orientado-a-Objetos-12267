package persistencia;

import modelos.Libro;

import java.io.*;
import java.util.List;

public class BibliotecaData {
    // Private constructor to prevent instantiation
    private BibliotecaData() {
        // This class should not be instantiated
    }

    public static void guardarDatos(List<Libro> libros, String archivo) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo))) {
            out.writeObject(libros);
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Libro> cargarDatos(String archivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
            return (List<Libro>) in.readObject();
        }
    }
}