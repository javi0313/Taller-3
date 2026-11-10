/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio3;

public abstract class Equipo {
    protected String serial;

    public Equipo(String serial) {
        this.serial = serial;
    }

    public abstract void encender();
}
