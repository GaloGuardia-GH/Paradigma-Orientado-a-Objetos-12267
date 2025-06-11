import Ejercicio1.Televisor;
import Ejercicio2.Pantalla;
import Ejercicio2.Televisor2;
import Ejercicio3.Televisor3;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("~~~ Pimer ejercicio ~~~");
        Televisor televisor = new Televisor("Sony", "Bravia", 2021, "LED", 55, 4, true);
        Televisor televisor2 = new Televisor("Samsung", "QLED", 2021, "QLED", 65, 8, true);
        Televisor televisor3 = new Televisor("LG", "OLED", 2021, "OLED", 75, 8, true);
        System.out.println("* Televisor: " + televisor.getMarca() + " " + televisor.getModelo() + " " + televisor.getTipo() + " " + televisor.getAno() + " -- " + televisor.getTamanoPantalla() + " Pulgadas -- " + televisor.getResolucion() + "K -- " + televisor.getInteligente());
        System.out.println("* Televisor: " + televisor2.getMarca() + " " + televisor2.getModelo() + " " + televisor2.getTipo() + " " + televisor2.getAno() + " -- " + televisor2.getTamanoPantalla() + " Pulgadas -- " + televisor2.getResolucion() + "K -- " + televisor2.getInteligente());
        System.out.println("* Televisor: " + televisor3.getMarca() + " " + televisor3.getModelo() + " " + televisor3.getTipo() + " " + televisor3.getAno() + " -- " + televisor3.getTamanoPantalla() + " Pulgadas -- " + televisor3.getResolucion() + "K -- " + televisor3.getInteligente());

        System.out.println("\n~~~ Segundo ejercicio ~~~");
        Pantalla pantalla = new Pantalla("LED", 55, 4, true);
        System.out.println("* Pantalla: " + pantalla.getTipo() + " " + pantalla.getTamano() + " Pulgadas -- " + pantalla.getResolucion() + "K -- " + pantalla.getInteligente());
        Televisor2 televisor4 = new Televisor2("Sony", "Bravia", 2021, pantalla);
        Televisor2 televisor5 = new Televisor2("Samsung", "QLED", 2021, pantalla);
        System.out.println("* Televisor: " + televisor4.getMarca() + " " + televisor4.getModelo() + " " + televisor4.getPantalla().getTipo() + " " + televisor4.getAno() + " -- " + televisor4.getPantalla().getTamano() + " Pulgadas -- " + televisor4.getPantalla().getResolucion() + "K -- " + televisor4.getPantalla().getInteligente());
        System.out.println("* Televisor: " + televisor5.getMarca() + " " + televisor5.getModelo() + " " + televisor5.getPantalla().getTipo() + " " + televisor5.getAno() + " -- " + televisor5.getPantalla().getTamano() + " Pulgadas -- " + televisor5.getPantalla().getResolucion() + "K -- " + televisor5.getPantalla().getInteligente());

        System.out.println("\n~~~ Tercer ejercicio ~~~");
        Televisor3 televisor6 = new Televisor3("Sony", "Bravia", 2021, pantalla);
        Televisor3 televisor7 = new Televisor3("Samsung", "QLED", 2021, pantalla);
        System.out.println("* Televisor: " + televisor6.getMarca() + " " + televisor6.getModelo() + " " + televisor6.getPantalla().getTipo() + " " + televisor6.getAno() + " -- " + televisor6.getPantalla().getTamano() + " Pulgadas -- " + televisor6.getPantalla().getResolucion() + "K -- " + televisor6.getPantalla().getInteligente());
        televisor6.encender();
        System.out.println("* Estado: " + televisor6.getEstado());
        televisor6.apagar();
        System.out.println("* Estado: " + televisor6.getEstado());
        System.out.println("\n* Televisor: " + televisor7.getMarca() + " " + televisor7.getModelo() + " " + televisor7.getPantalla().getTipo() + " " + televisor7.getAno() + " -- " + televisor7.getPantalla().getTamano() + " Pulgadas -- " + televisor7.getPantalla().getResolucion() + "K -- " + televisor7.getPantalla().getInteligente());
        televisor7.encender();
        System.out.println("* Estado: " + televisor7.getEstado());
        televisor7.apagar();
        System.out.println("* Estado: " + televisor7.getEstado());
    }
}
