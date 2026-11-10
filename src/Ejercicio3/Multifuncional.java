package Ejercicio3;

public class Multifuncional extends Equipo implements Imprimible, Escaneable {

    public Multifuncional(String serial) {
        super(serial);
    }

    @Override
    public void encender() {
        System.out.println("Encendiendo...");
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo...");
    }

    @Override
    public void escanear() {
        System.out.println("Escaneando...");
    }
}