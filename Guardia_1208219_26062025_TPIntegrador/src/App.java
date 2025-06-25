import persistencia.GestorEventos;
import vistas.MainFrame;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GestorEventos gestor = new GestorEventos();
            try {
                gestor.cargarEventos("eventos.dat");
            } catch (Exception e) {
                System.out.println("No se pudo cargar eventos anteriores.");
            }
            new MainFrame(gestor);
        });
    }
}