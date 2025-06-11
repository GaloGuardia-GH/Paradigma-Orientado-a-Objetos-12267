import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import exceptions.NumeroFueraDeRangoException;

public class App {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1 -> validateInputsUser();
                case 2 -> checkFilesWithExceptions();
                case 0 -> System.out.println("Saliendo del sistema.");
                default -> System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Validación de entrada del usuario");
        System.out.println("2. Lectura/Escritura de Archivos con manejo de Excepciones");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    private static void validateInputsUser() {
        String edadStr = "";
        int edadInt = -1;

        while (true) {
            try {
                System.out.print("Ingrese su edad: ");
                edadStr = scanner.nextLine();
                edadInt = Integer.parseInt(edadStr);

                if (edadInt < 0 || edadInt > 120) {
                    throw new NumeroFueraDeRangoException("El número está fuera de rango (Entre 0 y 120).");
                }

                System.out.println("El número '" + edadInt + "' es un entero válido.");
                break;
            } catch (NumberFormatException nfe) {
                System.out.println("La cadena '" + edadStr + "' no es un número válido.");
            } catch(NumeroFueraDeRangoException nfre) {
                System.out.println("El numero " + edadInt + " no es un número válido.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void checkFilesWithExceptions() {
        try (Scanner scanner = new Scanner(new File("./data.txt"));
            PrintWriter writer = new PrintWriter(new File("./output.txt"))) {
            while (scanner.hasNext()) {
                writer.print(scanner.nextLine());
            }
            System.out.println("Contenido copiado con éxito. Cerrando archivos...");
        } catch (FileNotFoundException fnfe) {
            System.out.println("No se puede encontrar el archivo especificado.");
            System.out.print("Desea generar el archivo? (S/N): ");
            String opcionStr = scanner.nextLine();
            if (opcionStr.toUpperCase().charAt(0) == 'S') {
                createFile();
            }
        }
    }

    private static void createFile() {
        try {
            File newFile = new File("./data.txt");
            if (newFile.createNewFile()) {
                System.out.println("Archivo generado correctamente | Nombre del archivo: " + newFile.getName());
                checkFilesWithExceptions();
            }
        } catch (IOException ioe) {
            System.out.print("Se ha generado un error en la creación del archivo.");
        }
    }
}
