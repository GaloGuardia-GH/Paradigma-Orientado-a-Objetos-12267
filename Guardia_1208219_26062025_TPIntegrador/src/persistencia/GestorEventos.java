package persistencia;

import modelos.Evento;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorEventos {
    private List<Evento> eventos = new ArrayList<>();

    public List<Evento> getEventos() {
        return eventos;
    }

    public void agregarEvento(Evento e) {
        eventos.add(e);
    }

    public void guardarEventos(String archivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(eventos);
        }
    }

    public void cargarEventos(String archivo) throws IOException, ClassNotFoundException {
        File file = new File(archivo);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
                eventos = (List<Evento>) ois.readObject();
            }
        }
    }
}