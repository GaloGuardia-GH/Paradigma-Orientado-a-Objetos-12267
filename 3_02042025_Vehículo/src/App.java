import Vehiculos.Bicicleta;
import Vehiculos.Coche;
import Vehiculos.Moto;

public class App {
    public static void main(String[] args) throws Exception {
        Coche coche = new Coche("Toyota", "Corolla", "Rojo", 2020, 15000, 180, 4);
        Moto moto = new Moto("Yamaha", "YZF-R3", "Azul", 2019, 5000, 200, true);
        Bicicleta bicicleta = new Bicicleta("Giant", "Escape 3", "Verde", 2021, 100, 30, true, 21);

        System.out.println("Coche: " + coche.getMarca() + " " + coche.getModelo() + " " + coche.getColor() + " " + coche.getAno() + " - " + coche.getKm() + "KM - " + coche.getVelocidad() + "KM/H - " + coche.getCantPuertas() + " puertas");
        System.out.println("Moto: " + moto.getMarca() + " " + moto.getModelo() + " " + moto.getColor() + " " + moto.getAno() + " - " + moto.getKm() + "KM - " + moto.getVelocidad() + "KM/H - " + moto.getTieneCasco());
        System.out.println("Bicicleta: " + bicicleta.getMarca() + " " + bicicleta.getModelo() + " " + bicicleta.getColor() + " " + bicicleta.getAno() + " - " + bicicleta.getKm() + "KM - " + bicicleta.getVelocidad() + "KM/H - " + bicicleta.getTieneCasco() + " - " + bicicleta.getCantCambios() + " cambios");

        System.out.println("\nDesplazamiento:");
        System.out.println("* " + coche.desplazar());
        System.out.println("* " + coche.desplazar("normal"));
        System.out.println("* " + moto.desplazar());
        System.out.println("* " + bicicleta.desplazar());

        // Prueba de la interfaz Motorizado
        System.out.println("\nEncender y apagar motor:");
        System.out.println("* " + coche.encenderMotor());
        System.out.println("* " + coche.apagarMotor());
        System.out.println("* " + moto.encenderMotor());
        System.out.println("* " + moto.apagarMotor());
    }
}
