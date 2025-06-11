import modelos.*;
import persistencia.BibliotecaData;
import vistas.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class MainFrame extends JFrame {

    private static List<Libro> libros = new ArrayList<>();
    private static List<Usuario> usuarios = new ArrayList<>();
    private static List<Prestamo> prestamos = new ArrayList<>();

    public MainFrame() {
        setTitle("Sistema de Biblioteca");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        try {
            Image icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/recursos/icono.png"));
            setIconImage(icono);
        } catch (Exception ex) {
            System.out.println("No se pudo cargar el ícono.");
        }

        cargarDatos();

        JButton btnBuscar = new JButton("Buscar Libros");
        JButton btnPrestar = new JButton("Prestar Libro");
        JButton btnDevolver = new JButton("Devolver Libro");
        JButton btnAdmin = new JButton("Administrar Libros");
        JButton btnAdminUsuarios = new JButton("Administrar Usuarios");
        JButton btnSalir = new JButton("Salir");

        btnBuscar.addActionListener(e -> new BuscarLibroVentana(libros));
        btnPrestar.addActionListener(e -> new PrestarLibroVentana(libros, usuarios, prestamos));
        btnDevolver.addActionListener(e -> new DevolverLibroVentana(prestamos));
        btnAdmin.addActionListener(e -> new AdministrarLibrosVentana(libros));
        btnAdminUsuarios.addActionListener(e -> new AdministrarUsuariosVentana(usuarios));
        btnSalir.addActionListener(e -> {
            int opcion = JOptionPane.showConfirmDialog(
                this,
                "¿Estás seguro de que deseas salir?",
                "Confirmar salida",
                JOptionPane.YES_NO_OPTION
            );

            if (opcion == JOptionPane.YES_OPTION) {
                guardarDatos();  // Guardar antes de salir
                System.exit(0);
            }
        });

        JPanel panel = new JPanel(new GridLayout(6, 1, 10, 10));
        panel.add(btnBuscar);
        panel.add(btnPrestar);
        panel.add(btnDevolver);
        panel.add(btnAdmin);
        panel.add(btnAdminUsuarios);
        panel.add(btnSalir);
        add(panel);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                guardarDatos();
            }
        });

        setVisible(true);
    }

    private static void cargarDatos() {
        try {
            libros = BibliotecaData.cargarDatos("libros.dat");
        } catch (Exception e) {
            libros = new ArrayList<>();
        }

        usuarios.add(new Usuario("U1", "Ana"));
        usuarios.add(new Usuario("U2", "Luis"));
        usuarios.add(new Usuario("U3", "Marta"));
    }

    private void guardarDatos() {
        try {
            BibliotecaData.guardarDatos(libros, "libros.dat");
        } catch (Exception e) {
            System.out.println("Error al guardar los datos");
        }
    }
}