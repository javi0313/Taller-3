
package Ejercicio4;

/**
 *
 * @javier alvarez 
 */
public class Main {
    public static void main(String[] args) {
        Dispositivo[] dispositivos = {
            new Smartphone("Samsung", "Galaxy S24", 3500000, 50),
            new Camara("Canon", "EOS R50", 4200000, 24),
            new Smartphone("Xiaomi", "Redmi Note 13 Pro", 1800000, 108)
        };

        int mayor = 0;
        for (Dispositivo d : dispositivos) {
            d.describir();

            if (d instanceof Fotografiable) {
                Fotografiable f = (Fotografiable) d;
                f.tomarFoto();
                if (f.getMegapixeles() > mayor) {
                    mayor = f.getMegapixeles();
                }
            }
            if (d instanceof Llamable) {
                Llamable l = (Llamable) d;
                l.llamar("3001234567");
                l.colgar();
            }
            System.out.println();
        }
        System.out.println("Mayor resolución: " + mayor + " MP");
    }
}