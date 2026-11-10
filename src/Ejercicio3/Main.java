
package Ejercicio3;

/**
 *
 * @javier alvarez
 */
public class Main {
    public static void main(String[] args) {

        Equipo e = new Multifuncional("123");

        Imprimible i = new Multifuncional("A1");

        ((Escaneable) i).escanear();
    }
}
