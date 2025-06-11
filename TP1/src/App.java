import ejercicio1.Ala;
import ejercicio2.SistemaDeControlDeVuelo;

public class App {
    public static void main(String[] args) {
        System.out.println("****** Primer Ejercicio ******");

        Ala primerAla = new Ala("10m", "Blanco", "Aluminio");
        System.out.println("\n*** Primer ala ***");
        System.out.println("Envergadura: " + primerAla.getEnvergadura());
        System.out.println("Color: " + primerAla.getColor());
        System.out.println("Tipo de material: " + primerAla.getTipoMaterial());
        primerAla.activarFlap();
        primerAla.desactivarFlap();

        Ala segundaAla = new Ala("20m", "Negro", "Compuesto");
        System.out.println("\n*** Segunda ala ***");
        System.out.println("Envergadura: " + segundaAla.getEnvergadura());
        System.out.println("Color: " + segundaAla.getColor());
        System.out.println("Tipo de material: " + segundaAla.getTipoMaterial());
        segundaAla.activarFlap();
        segundaAla.desactivarFlap();

        System.out.println("\n****** Segundo Ejercicio ******");

        SistemaDeControlDeVuelo primerSistemaDeControlDeVuelo = new SistemaDeControlDeVuelo("Airbus", 2, "Manual");
        System.out.println("\n*** Primer sistema de control de vuelo ***");
        System.out.println("Fabricante: " + primerSistemaDeControlDeVuelo.getFabricante());
        System.out.println("Número de modos: " + primerSistemaDeControlDeVuelo.getNumeroModos());
        System.out.println("Tipo de sistema: " + primerSistemaDeControlDeVuelo.getTipoSistema());
        primerSistemaDeControlDeVuelo.activarPilotoAutomatico();
        System.out.println("Tipo de sistema: " + primerSistemaDeControlDeVuelo.getTipoSistema());
        primerSistemaDeControlDeVuelo.desactivarPilotoAutomatico();
        System.out.println("Tipo de sistema: " + primerSistemaDeControlDeVuelo.getTipoSistema());

        SistemaDeControlDeVuelo segundoSistemaDeControlDeVuelo = new SistemaDeControlDeVuelo("Boeing", 2, "Manual");
        System.out.println("\n*** Primer sistema de control de vuelo ***");
        System.out.println("Fabricante: " + segundoSistemaDeControlDeVuelo.getFabricante());
        System.out.println("Número de modos: " + segundoSistemaDeControlDeVuelo.getNumeroModos());
        System.out.println("Tipo de sistema: " + segundoSistemaDeControlDeVuelo.getTipoSistema());
        segundoSistemaDeControlDeVuelo.activarPilotoAutomatico();
        System.out.println("Tipo de sistema: " + segundoSistemaDeControlDeVuelo.getTipoSistema());
        segundoSistemaDeControlDeVuelo.desactivarPilotoAutomatico();
        System.out.println("Tipo de sistema: " + segundoSistemaDeControlDeVuelo.getTipoSistema());
    }
}
