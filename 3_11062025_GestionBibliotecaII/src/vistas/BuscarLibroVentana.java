package vistas;

import modelos.Libro;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BuscarLibroVentana extends JFrame {
    private JTextField txtBuscar = new JTextField(20);
    private JTable tablaLibros;
    private DefaultTableModel modelo;

    public BuscarLibroVentana(List<Libro> libros) {
        setTitle("Buscar Libros");
        setSize(600, 400);
        setLocationRelativeTo(null);

        try {
            Image icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/recursos/icono.png"));
            setIconImage(icono);
        } catch (Exception ex) {
            System.out.println("No se pudo cargar el ícono.");
        }

        modelo = new DefaultTableModel(new String[]{"Título", "Autor", "Categoría", "Disponible"}, 0);
        tablaLibros = new JTable(modelo);
        cargarTabla(libros);

        txtBuscar.addCaretListener(e -> {
            String filtro = txtBuscar.getText().toLowerCase();
            List<Libro> filtrados = libros.stream().filter(libro ->
                    libro.getTitulo().toLowerCase().contains(filtro) ||
                    libro.getAutor().toLowerCase().contains(filtro) ||
                    libro.getCategoria().toLowerCase().contains(filtro))
                    .toList();
            cargarTabla(filtrados);
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Buscar:"));
        panel.add(txtBuscar);

        add(panel, "North");
        add(new JScrollPane(tablaLibros), "Center");

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> dispose());  // Cierra esta ventana

        JPanel panelInferior = new JPanel();
        panelInferior.add(btnVolver);
        add(panelInferior, "South");

        setVisible(true);
    }

    private void cargarTabla(List<Libro> lista) {
        modelo.setRowCount(0);
        for (Libro l : lista) {
            modelo.addRow(new Object[]{
                    l.getTitulo(),
                    l.getAutor(),
                    l.getCategoria(),
                    l.getDisponible() ? "Sí" : "No"
            });
        }
    }
}