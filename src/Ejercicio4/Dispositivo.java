/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio4;

/**
 *
 * @author user
 */
public abstract class Dispositivo {
    protected String marca, modelo;
    protected double precio;

    public Dispositivo(String marca, String modelo, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    public abstract void describir();

    public String getMarca() { return marca; }

    protected String precioFormateado() {
        return String.format(java.util.Locale.forLanguageTag("es-CO"), "$%,.0f", precio);
    }
}
