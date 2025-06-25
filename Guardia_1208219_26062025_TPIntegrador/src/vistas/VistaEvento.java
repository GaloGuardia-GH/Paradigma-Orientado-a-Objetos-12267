package vistas;

import persistencia.GestorEventos;
import modelos.Asistente;
import modelos.Evento;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class VistaEvento extends JFrame {
    private MainFrame padre;
    private transient GestorEventos gestor;
    private Evento eventoExistente;
    private List<Asistente> asistentesTemporales;

    private JTextField txtNombre;
    private JTextField txtDescripcion;
    private JTextField txtFecha;
    private JTextField txtUbicacion;

    public VistaEvento(MainFrame padre, GestorEventos gestor, Evento eventoExistente) {
        this.padre = padre;
        this.gestor = gestor;
        this.eventoExistente = eventoExistente;
        this.asistentesTemporales = new ArrayList<>();

        setTitle("Nuevo Evento");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        try {
            Image icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/recursos/icono.png"));
            setIconImage(icono);
        } catch (Exception ex) {
            System.out.println("No se pudo cargar el ícono.");
        }

        // Campos del formulario
        this.txtNombre = new JTextField(this.eventoExistente != null ? this.eventoExistente.getNombre() : "");
        this.txtDescripcion = new JTextField(this.eventoExistente != null ? this.eventoExistente.getDescripcion() : "");
        this.txtFecha = new JTextField(this.eventoExistente != null ? this.eventoExistente.getFecha().toString() : "yyyy-mm-dd");
        this.txtUbicacion = new JTextField(this.eventoExistente != null ? this.eventoExistente.getUbicacion() : "");

        add(getPanelFormulario(), BorderLayout.NORTH);
        add(getPanelAsistentes(), BorderLayout.CENTER);
        add(getPanelButtons(), BorderLayout.SOUTH);

        setVisible(true);
    }

    public JPanel getPanelFormulario() {
        JPanel panelFormulario = new JPanel(new GridLayout(4, 2, 5, 5));
        panelFormulario.setBorder(new EmptyBorder(15, 20, 15, 20));

        // Completa el panel con etiquetas y campos de texto
        panelFormulario.add(new JLabel("Nombre:"));
        panelFormulario.add(this.txtNombre);
        panelFormulario.add(new JLabel("Descripción:"));
        panelFormulario.add(this.txtDescripcion);
        panelFormulario.add(new JLabel("Fecha:"));
        panelFormulario.add(this.txtFecha);
        panelFormulario.add(new JLabel("Ubicación:"));
        panelFormulario.add(this.txtUbicacion);

        return panelFormulario;
    }

    public JPanel getPanelAsistentes() {
        // Panel para mostrar asistentes
        DefaultListModel<String> listaModel = new DefaultListModel<>();
        if (this.eventoExistente != null) {
            // Si hay un evento existente, cargar sus asistentes
            this.asistentesTemporales = new ArrayList<>(this.eventoExistente.getAsistentes());
            this.asistentesTemporales.forEach(a -> listaModel.addElement("Nombre: " + a.getNombre() + " | Email: " + a.getEmail()));
        } else {
            // Si no hay evento existente, inicializar la lista vacía
            this.asistentesTemporales = new ArrayList<>();
        }
        // Crear la lista de asistentes
        JList<String> listaAsistentes = new JList<>(listaModel);

        JPanel panelAsistentes = new JPanel(new BorderLayout());
        panelAsistentes.setBorder(new EmptyBorder(5, 20, 15, 20));
        panelAsistentes.add(new JLabel("Asistentes registrados:"), BorderLayout.NORTH);
        panelAsistentes.add(new JScrollPane(listaAsistentes), BorderLayout.CENTER);

        JButton btnAgregarAsistente = new JButton("Agregar Asistente");
        btnAgregarAsistente.addActionListener(ev -> {
            // Crear campos para ingresar datos del asistente
            JTextField campoNombre = new JTextField();
            JTextField campoEmail = new JTextField();
            JPanel panel = new JPanel(new GridLayout(2, 2));
            panel.add(new JLabel("Nombre:"));
            panel.add(campoNombre);
            panel.add(new JLabel("Email:"));
            panel.add(campoEmail);

            // Mostrar diálogo para ingresar datos del asistente
            int res = JOptionPane.showConfirmDialog(this, panel, "Nuevo Asistente", JOptionPane.OK_CANCEL_OPTION);
            if (res == JOptionPane.OK_OPTION) {
                String nombre = campoNombre.getText().trim();
                String email = campoEmail.getText().trim();
                if (!nombre.isEmpty() && !email.isEmpty()) {
                    if (email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                        Asistente nuevo = new Asistente(nombre, email);
                        this.asistentesTemporales.add(nuevo);
                        listaModel.addElement("Nombre: " + nombre + " | Email: " + email);
                    } else {
                        JOptionPane.showMessageDialog(this, "Email inválido. Intente con un formato válido.", "Error de email", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Campos incompletos", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        JButton btnEliminar = new JButton("Eliminar Seleccionado");
        btnEliminar.addActionListener(e -> {
            int seleccionado = listaAsistentes.getSelectedIndex();
            if (seleccionado >= 0) {
                listaModel.remove(seleccionado);

                if (this.eventoExistente != null) {
                    this.eventoExistente.getAsistentes().remove(seleccionado);
                } else {
                    this.asistentesTemporales.remove(seleccionado);
                }
            }
        });

        JPanel panelBotones = new JPanel(new GridLayout(2, 1, 5, 2));
        panelBotones.add(btnAgregarAsistente);
        panelBotones.add(btnEliminar);
        panelAsistentes.add(panelBotones, BorderLayout.SOUTH);

        return panelAsistentes;
    }

    public JPanel getPanelButtons() {
        JPanel panelBotones = new JPanel();
        panelBotones.setBorder(new EmptyBorder(5, 20, 15, 20));

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> {
            try {
                // Validar campos antes de guardar
                if (this.txtNombre.getText().trim().isEmpty() || this.txtDescripcion.getText().trim().isEmpty() || this.txtFecha.getText().trim().isEmpty() || this.txtUbicacion.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validar formato de fecha. Si la fecha no es válida, se lanzará una excepción
                if (!isValidDate(this.txtFecha.getText().trim())) {
                    JOptionPane.showMessageDialog(this, "La fecha debe estar en formato 'yyyy-mm-dd'.", "Error de formato", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Guardar los datos del evento
                String nombre = this.txtNombre.getText().trim();
                String descripcion = this.txtDescripcion.getText().trim();
                LocalDate fecha = LocalDate.parse(this.txtFecha.getText().trim());
                String ubicacion = this.txtUbicacion.getText().trim();

                // Si hay un evento existente, actualizarlo, sino crear uno nuevo
                if (this.eventoExistente != null) {
                    this.eventoExistente.setNombre(nombre);
                    this.eventoExistente.setDescripcion(descripcion);
                    this.eventoExistente.setFecha(fecha);
                    this.eventoExistente.setUbicacion(ubicacion);
                    // Asegurarse de actualizar también los asistentes
                    this.eventoExistente.getAsistentes().clear();
                    this.eventoExistente.getAsistentes().addAll(this.asistentesTemporales);
                } else {
                    // Crear un nuevo evento y agregar los asistentes temporales
                    Evento evento = new Evento(nombre, descripcion, fecha, ubicacion);
                    this.asistentesTemporales.forEach(evento::agregarAsistente);
                    this.gestor.agregarEvento(evento);
                }

                this.gestor.guardarEventos("eventos.dat");
                JOptionPane.showMessageDialog(this, "Evento guardado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                this.padre.cargarTabla();
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error en los datos ingresados.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        panelBotones.add(btnGuardar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> dispose());
        panelBotones.add(btnCancelar);

        return panelBotones;
    }

    private boolean isValidDate(String fecha) {
        try {
            LocalDate.parse(fecha);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}