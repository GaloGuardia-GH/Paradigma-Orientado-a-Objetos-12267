package vistas;

import modelos.Libro;
import modelos.Usuario;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AdministrarLibrosVentana extends JFrame {
    private JTable tabla;
    private DefaultTableModel modelo;
    private List<Libro> libros;

    public AdministrarLibrosVentana(List<Libro> libros) {
        this.libros = libros;

        setTitle("Administrar Libros");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        try {
            Image icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/recursos/icono.png"));
            setIconImage(icono);
        } catch (Exception ex) {
            System.out.println("No se pudo cargar el ícono.");
        }

        modelo = new DefaultTableModel(new String[]{"Título", "Autor", "Categoría", "Disponible"}, 0);
        tabla = new JTable(modelo);
        cargarTabla();

        JPanel panelBotones = new JPanel();
        JButton btnAgregar = new JButton("Agregar");
        JButton btnEditar = new JButton("Editar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnVolver = new JButton("Volver");

        btnAgregar.addActionListener(e -> agregarLibro());
        btnEditar.addActionListener(e -> editarLibro());
        btnEliminar.addActionListener(e -> eliminarLibro());
        btnVolver.addActionListener(e -> dispose());

        panelBotones.add(btnAgregar);
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnVolver);

        add(new JScrollPane(tabla), BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void cargarTabla() {
        modelo.setRowCount(0);
        for (Libro l : libros) {
            modelo.addRow(new Object[]{
                    l.getTitulo(),
                    l.getAutor(),
                    l.getCategoria(),
                    l.getDisponible() ? "Sí" : "No"
            });
        }
    }

    private void agregarLibro() {
        JTextField txtTitulo = new JTextField();
        JTextField txtAutor = new JTextField();
        JTextField txtCategoria = new JTextField();
        Object[] campos = {"Título:", txtTitulo, "Autor:", txtAutor, "Categoría:", txtCategoria};

        int opcion = JOptionPane.showConfirmDialog(this, campos, "Nuevo Libro", JOptionPane.OK_CANCEL_OPTION);
        if (opcion == JOptionPane.OK_OPTION) {
            String titulo = txtTitulo.getText().trim();
            String autor = txtAutor.getText().trim();
            String categoria = txtCategoria.getText().trim();

            if (!titulo.isEmpty() && !autor.isEmpty() && !categoria.isEmpty()) {
                libros.add(new Libro(titulo, autor, categoria));
                cargarTabla();
            } else {
                JOptionPane.showMessageDialog(this, "Debe completar todos los campos.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void editarLibro() {
        int fila = tabla.getSelectedRow();
        if (fila >= 0) {
            Libro libro = libros.get(fila);
            JTextField txtTitulo = new JTextField(libro.getTitulo());
            JTextField txtAutor = new JTextField(libro.getAutor());
            JTextField txtCategoria = new JTextField(libro.getCategoria());
            Object[] campos = {"Título:", txtTitulo, "Autor:", txtAutor, "Categoría:", txtCategoria};

            int opcion = JOptionPane.showConfirmDialog(this, campos, "Editar Libro", JOptionPane.OK_CANCEL_OPTION);
            if (opcion == JOptionPane.OK_OPTION) {
                String titulo = txtTitulo.getText().trim();
                String autor = txtAutor.getText().trim();
                String categoria = txtCategoria.getText().trim();

                if (!titulo.isEmpty() && !autor.isEmpty() && !categoria.isEmpty()) {
                    libro.setTitulo(titulo);
                    libro.setAutor(autor);
                    libro.setCategoria(categoria);
                    cargarTabla();
                } else {
                    JOptionPane.showMessageDialog(this, "Debe completar todos los campos.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }

    private void eliminarLibro() {
        int opcion = JOptionPane.showConfirmDialog(
            this,
            "¿Estás seguro de que deseas eliminar el libro?",
            "Confirmar eliminación",
            JOptionPane.YES_NO_OPTION
        );

        if (opcion == JOptionPane.YES_OPTION) {
            int fila = tabla.getSelectedRow();
            if (fila >= 0) {
                libros.remove(fila);
                cargarTabla();
            }
        }
    }
}