package ejercicio2;

public class SistemaDeControlDeVuelo {
    private String fabricante;
    private Integer numeroModos;
    private String tipoSistema;

    public SistemaDeControlDeVuelo(String fabricante, Integer numeroModos, String tipoSistema) {
        this.fabricante = fabricante;
        this.numeroModos = numeroModos;
        this.tipoSistema = tipoSistema;
    }

    public String getFabricante() {
        return fabricante;
    }
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Integer getNumeroModos() {
        return numeroModos;
    }
    public void setNumeroModos(Integer numeroModos) {
        this.numeroModos = numeroModos;
    }

    public String getTipoSistema() {
        return tipoSistema;
    }
    public void setTipoSistema(String tipoSistema) {
        this.tipoSistema = tipoSistema;
    }

    public void activarPilotoAutomatico() {
        this.tipoSistema = "Automático";
        System.out.println("Piloto automático activado...");
    }
    public void desactivarPilotoAutomatico() {
        this.tipoSistema = "Manual";
        System.out.println("Piloto automático desactivado...");
    }
}
