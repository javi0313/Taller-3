/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio8;

/**
 *
 * @author user
 */
import java.util.Locale;

public class SaldoInsuficienteException extends Exception {
    private final double saldo;
    private final double monto;

    public SaldoInsuficienteException(double saldo, double monto) {
        super(String.format(Locale.forLanguageTag("es-CO"),
                "Saldo insuficiente. Saldo: $%,.0f - Faltan: $%,.0f", saldo, monto - saldo));
        this.saldo = saldo;
        this.monto = monto;
    }

    public double getFaltante() { return monto - saldo; }
}
