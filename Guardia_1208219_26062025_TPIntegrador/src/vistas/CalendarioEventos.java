package vistas;

import modelos.Evento;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.time.*;
import java.util.List;

public class CalendarioEventos extends JFrame {
    private List<Evento> eventos;

    public CalendarioEventos(List<Evento> eventos) {
        this.eventos = eventos;

        setTitle("Calendario de Eventos");
        setSize(700, 500);
        setLocationRelativeTo(null);

        try {
            Image icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/recursos/icono.png"));
            setIconImage(icono);
        } catch (Exception ex) {
            System.out.println("No se pudo cargar el ícono.");
        }

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(15, 20, 15, 20));
        panel.add(crearCalendario(LocalDate.now()), BorderLayout.CENTER);
        add(panel);

        setVisible(true);
    }

    private JPanel crearCalendario(LocalDate fecha) {
        JPanel panelCalendario = new JPanel(new BorderLayout());

        JLabel lblMes = new JLabel(fecha.getMonth() + " " + fecha.getYear(), SwingConstants.CENTER);
        lblMes.setFont(new Font("Arial", Font.BOLD, 18));
        panelCalendario.add(lblMes, BorderLayout.NORTH);

        JPanel grid = new JPanel(new GridLayout(0, 7, 5, 5));
        String[] dias = {"Dom", "Lun", "Mar", "Mié", "Jue", "Vie", "Sáb"};
        for (String dia : dias) {
            JLabel l = new JLabel(dia, SwingConstants.CENTER);
            l.setFont(new Font("Arial", Font.BOLD, 14));
            grid.add(l);
        }

        LocalDate primerDiaMes = fecha.withDayOfMonth(1);
        int inicio = primerDiaMes.getDayOfWeek().getValue() % 7;

        for (int i = 0; i < inicio; i++) {
            grid.add(new JLabel(""));
        }

        int diasMes = fecha.lengthOfMonth();
        for (int dia = 1; dia <= diasMes; dia++) {
            LocalDate diaActual = fecha.withDayOfMonth(dia);
            JButton btnDia = new JButton(String.valueOf(dia));
            btnDia.setMargin(new Insets(2, 2, 2, 2));

            boolean hayEvento = eventos.stream().anyMatch(e -> e.getFecha().equals(diaActual));
            if (hayEvento) {
                btnDia.setBackground(Color.YELLOW);
            }

            btnDia.addActionListener(e -> mostrarEventosDelDia(diaActual));
            grid.add(btnDia);
        }

        panelCalendario.add(grid, BorderLayout.CENTER);
        return panelCalendario;
    }

    private void mostrarEventosDelDia(LocalDate fecha) {
        StringBuilder sb = new StringBuilder();
        for (Evento e : eventos) {
            if (e.getFecha().equals(fecha)) {
                sb.append("(*) Nombre: " + e.getNombre() + " | Descripción: " + e.getDescripcion() + " | Ubicación: " + e.getUbicacion()).append("\n");
            }
        }

        if (sb.length() == 0) {
            sb.append("No hay eventos en esta fecha.");
        }

        JOptionPane.showMessageDialog(this, sb.toString(), "Eventos del " + fecha, JOptionPane.INFORMATION_MESSAGE);
    }
}