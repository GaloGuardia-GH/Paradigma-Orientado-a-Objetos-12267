package vistas;

import modelos.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class AdministrarUsuariosVentana extends JFrame {
    private JTable tabla;
    private DefaultTableModel modelo;

    public AdministrarUsuariosVentana(List<Usuario> usuarios) {
        setTitle("Administrar Usuarios");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        modelo = new DefaultTableModel(new Object[]{"ID", "Nombre"}, 0);
        tabla = new JTable(modelo);
        cargarUsuarios(usuarios);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(e -> agregarUsuario(usuarios));

        JButton btnEditar = new JButton("Editar");
        btnEditar.addActionListener(e -> editarUsuario(usuarios));

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(e -> eliminarUsuario(usuarios));

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> dispose());

        panelBotones.add(btnAgregar);
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnVolver);

        add(panelBotones, BorderLayout.SOUTH);
        setVisible(true);
    }

    private void agregarUsuario(List<Usuario> usuarios) {
        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new BoxLayout(panelFormulario, BoxLayout.Y_AXIS));
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel labelId = new JLabel("ID:");
        JTextField campoId = new JTextField(15);
        JLabel labelNombre = new JLabel("Nombre:");
        JTextField campoNombre = new JTextField(15);

        labelId.setAlignmentX(Component.LEFT_ALIGNMENT);
        campoId.setAlignmentX(Component.LEFT_ALIGNMENT);
        labelNombre.setAlignmentX(Component.LEFT_ALIGNMENT);
        campoNombre.setAlignmentX(Component.LEFT_ALIGNMENT);

        panelFormulario.add(labelId);
        panelFormulario.add(campoId);
        panelFormulario.add(Box.createVerticalStrut(5));
        panelFormulario.add(labelNombre);
        panelFormulario.add(campoNombre);

        int resultado = JOptionPane.showConfirmDialog(
            this,
            panelFormulario,
            "Agregar Usuario",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );

        if (resultado == JOptionPane.OK_OPTION) {
            String id = campoId.getText().trim();
            String nombre = campoNombre.getText().trim();

            if (id.isEmpty() || nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe completar todos los campos.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Verificar si el ID ya existe
            boolean idExiste = usuarios.stream().anyMatch(u -> u.getId().equalsIgnoreCase(id));

            if (idExiste) {
                JOptionPane.showMessageDialog(this, "Ya existe un usuario con ese ID.", "ID duplicado", JOptionPane.ERROR_MESSAGE);
                return;
            }

            usuarios.add(new Usuario(id, nombre));
            modelo.addRow(new Object[]{id, nombre});
        }
    }

    private void editarUsuario(List<Usuario> usuarios) {
        int fila = tabla.getSelectedRow();
        if (fila >= 0) {
            String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre:", modelo.getValueAt(fila, 1));
            if (nuevoNombre != null && !nuevoNombre.isBlank()) {
                modelo.setValueAt(nuevoNombre, fila, 1);
                usuarios.get(fila).setNombre(nuevoNombre);
            }
        }
    }

    private void eliminarUsuario(List<Usuario> usuarios) {
        int opcion = JOptionPane.showConfirmDialog(
            this,
            "¿Estás seguro de que deseas eliminar el usuario?",
            "Confirmar eliminación",
            JOptionPane.YES_NO_OPTION
        );

        if (opcion == JOptionPane.YES_OPTION) {
            int fila = tabla.getSelectedRow();
            if (fila >= 0) {
                usuarios.remove(fila);
                modelo.removeRow(fila);
            }
        }
    }

    private void cargarUsuarios(List<Usuario> usuarios) {
        for (Usuario u : usuarios) {
            modelo.addRow(new Object[]{u.getId(), u.getNombre()});
        }
    }
}