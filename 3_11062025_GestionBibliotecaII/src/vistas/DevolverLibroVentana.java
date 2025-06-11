package vistas;

import modelos.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DevolverLibroVentana extends JFrame {
    public DevolverLibroVentana(List<Prestamo> prestamos) {
        setTitle("Devolver Libro");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        try {
            Image icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/recursos/icono.png"));
            setIconImage(icono);
        } catch (Exception ex) {
            System.out.println("No se pudo cargar el ícono.");
        }

        JPanel panelCentro = new JPanel(new GridLayout(1, 2, 10, 10));
        JComboBox<String> comboPrestamos = new JComboBox<>();
        for (Prestamo p : prestamos) {
            comboPrestamos.addItem(p.getUsuario().getNombre() + " - " + p.getLibro().getTitulo());
        }

        panelCentro.add(new JLabel("Seleccionar préstamo:"));
        panelCentro.add(comboPrestamos);
        add(panelCentro, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();
        JButton btnDevolver = new JButton("Devolver");
        JButton btnVolver = new JButton("Volver");

        btnDevolver.addActionListener(e -> {
            int index = comboPrestamos.getSelectedIndex();
            if (index >= 0) {
                Prestamo prestamo = prestamos.get(index);
                prestamo.getLibro().setDisponible(true);
                prestamos.remove(index);

                JOptionPane.showMessageDialog(this, "Libro devuelto con éxito.");
                dispose();
            }
        });

        btnVolver.addActionListener(e -> dispose());

        panelBotones.add(btnDevolver);
        panelBotones.add(btnVolver);
        add(panelBotones, BorderLayout.SOUTH);

        setVisible(true);
    }
}