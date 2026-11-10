package Ejercicio3;

public interface Escaneable {
    void escanear();

    default void estado() {
        System.out.println("Escáner listo");
    }
}