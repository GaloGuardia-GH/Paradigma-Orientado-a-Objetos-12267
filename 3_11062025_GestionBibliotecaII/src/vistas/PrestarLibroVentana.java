package vistas;

import modelos.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PrestarLibroVentana extends JFrame {
    public PrestarLibroVentana(List<Libro> libros, List<Usuario> usuarios, List<Prestamo> prestamos) {
        setTitle("Prestar Libro");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        try {
            Image icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/recursos/icono.png"));
            setIconImage(icono);
        } catch (Exception ex) {
            System.out.println("No se pudo cargar el ícono.");
        }

        JPanel panelCentro = new JPanel(new GridLayout(2, 2, 10, 10));

        JComboBox<String> comboUsuarios = new JComboBox<>();
        for (Usuario u : usuarios) {
            comboUsuarios.addItem(u.getId() + " - " + u.getNombre());
        }

        JComboBox<String> comboLibros = new JComboBox<>();
        for (Libro l : libros) {
            if (l.getDisponible()) {
                comboLibros.addItem(l.getTitulo());
            }
        }

        panelCentro.add(new JLabel("Seleccionar Usuario:"));
        panelCentro.add(comboUsuarios);
        panelCentro.add(new JLabel("Seleccionar Libro:"));
        panelCentro.add(comboLibros);

        add(panelCentro, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();
        JButton btnPrestar = new JButton("Prestar");
        JButton btnVolver = new JButton("Volver");

        btnPrestar.addActionListener(e -> {
            int libroIndex = comboLibros.getSelectedIndex();
            int usuarioIndex = comboUsuarios.getSelectedIndex();

            if (libroIndex >= 0 && usuarioIndex >= 0) {
                Libro libro = libros.stream().filter(Libro::getDisponible).toList().get(libroIndex);
                Usuario usuario = usuarios.get(usuarioIndex);

                prestamos.add(new Prestamo(libro, usuario));
                libro.setDisponible(false);

                JOptionPane.showMessageDialog(this, "Libro prestado con éxito.");
                dispose();
            }
        });

        btnVolver.addActionListener(e -> dispose());

        panelBotones.add(btnPrestar);
        panelBotones.add(btnVolver);
        add(panelBotones, BorderLayout.SOUTH);

        setVisible(true);
    }
}