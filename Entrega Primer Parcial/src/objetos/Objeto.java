package objetos;

public class Objeto {
    private String tipo;
    private String nombre;
    private String habilidad;

    public Objeto(String tipo, String nombre, String habilidad) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.habilidad = habilidad;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHabilidad() {
        return habilidad;
    }
    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }
}
