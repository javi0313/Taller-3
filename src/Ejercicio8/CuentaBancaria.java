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

public class CuentaBancaria {
    private final String titular;
    private double saldo;

    public CuentaBancaria(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public void depositar(double monto) throws MontoInvalidoException {
        if (monto <= 0) {
            throw new MontoInvalidoException(monto);
        }
        saldo += monto;
    }

    public void retirar(double monto) throws MontoInvalidoException, SaldoInsuficienteException {
        if (monto <= 0) {
            throw new MontoInvalidoException(monto);
        }
        if (monto > saldo) {
            throw new SaldoInsuficienteException(saldo, monto);
        }
        saldo -= monto;
    }

    public String getTitular() { return titular; }
    public double getSaldo() { return saldo; }

    public static String formatear(double valor) {
        return String.format(Locale.forLanguageTag("es-CO"), "$%,.0f", valor);
    }
}
