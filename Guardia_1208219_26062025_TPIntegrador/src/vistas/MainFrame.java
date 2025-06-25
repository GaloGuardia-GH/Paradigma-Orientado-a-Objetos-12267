package vistas;

import persistencia.GestorEventos;
import modelos.Evento;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.format.DateTimeFormatter;

public class MainFrame extends JFrame {
    private transient GestorEventos gestor;
    private JTable tablaEventos;
    private DefaultTableModel modelo;

    public MainFrame(GestorEventos gestor) {
        this.gestor = gestor;

        setTitle("Gestión de Eventos");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        try {
            Image icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/recursos/icono.png"));
            setIconImage(icono);
        } catch (Exception ex) {
            System.out.println("No se pudo cargar el ícono.");
        }

        this.modelo = new DefaultTableModel(new Object[]{"Nombre", "Fecha", "Ubicación"}, 0) {
            // Override para evitar que las celdas sean editables
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.tablaEventos = new JTable(this.modelo);
        cargarTabla();

        JPanel panelTabla = new JPanel(new BorderLayout());
        panelTabla.setBorder(new EmptyBorder(15, 15, 0, 15));
        panelTabla.add(new JScrollPane(tablaEventos), BorderLayout.CENTER);
        add(panelTabla, BorderLayout.CENTER);
        add(getPanelButtons(), BorderLayout.SOUTH);
        setVisible(true);
    }

    public void cargarTabla() {
        this.modelo.setRowCount(0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for (Evento e : this.gestor.getEventos()) {
            this.modelo.addRow(new Object[]{e.getNombre(), e.getFecha().format(formatter), e.getUbicacion()});
        }
    }

    public JPanel getPanelButtons() {
        JPanel panelBotones = new JPanel();
        panelBotones.setBorder(new EmptyBorder(5, 20, 15, 20));

        JButton btnCalendario = new JButton("Calendario");
        btnCalendario.addActionListener(e -> new CalendarioEventos(gestor.getEventos()));
        panelBotones.add(btnCalendario);

        JButton btnAgregar = new JButton("Agregar Evento");
        btnAgregar.addActionListener(e -> new VistaEvento(this, this.gestor, null));
        panelBotones.add(btnAgregar);

        JButton btnEditar = new JButton("Editar Evento");
        btnEditar.addActionListener(e -> editarEvento());
        panelBotones.add(btnEditar);

        JButton btnEliminar = new JButton("Eliminar Evento");
        btnEliminar.addActionListener(e -> eliminarEvento());
        panelBotones.add(btnEliminar);

        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(e -> salirPrograma());
        panelBotones.add(btnSalir);

        return panelBotones;
    }

    private void editarEvento() {
        int fila = this.tablaEventos.getSelectedRow();
        if (fila >= 0) {
            Evento evento = this.gestor.getEventos().get(fila);
            new VistaEvento(this, this.gestor, evento);
            try {
                this.gestor.guardarEventos("eventos.dat");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al guardar cambios.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un evento para editar.", "Atención", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void eliminarEvento() {
        int fila = this.tablaEventos.getSelectedRow();
        if (fila >= 0) {
            int confirm = JOptionPane.showConfirmDialog(
                this,
                "¿Estás seguro de que deseas eliminar este evento?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
            );
            if (confirm == JOptionPane.YES_OPTION) {
                gestor.getEventos().remove(fila);
                cargarTabla();
                try {
                    gestor.guardarEventos("eventos.dat");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error al guardar cambios.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un evento para eliminar.", "Atención", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void salirPrograma() {
        int confirm = JOptionPane.showConfirmDialog(
            this,
            "¿Deseás salir del programa?",
            "Confirmar salida",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}