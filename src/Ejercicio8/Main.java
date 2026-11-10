/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio8;

/**
 *
 * @javier alvarez
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria("Pau cubarsi", 500000);
        Scanner sc = new Scanner(System.in);
        try {
            int opcion = 0;
            while (opcion != 4) {
                System.out.println("\n1. Consultar  2. Depositar  3. Retirar  4. Salir");
                System.out.print("Opcion: ");
                try {
                    opcion = Integer.parseInt(sc.nextLine().trim());
                    switch (opcion) {
                        case 1:
                            System.out.println("Saldo: " + CuentaBancaria.formatear(cuenta.getSaldo()));
                            break;
                        case 2:
                            System.out.print("Monto a depositar: ");
                            cuenta.depositar(Double.parseDouble(sc.nextLine().trim()));
                            System.out.println("Deposito exitoso. Saldo: "
                                    + CuentaBancaria.formatear(cuenta.getSaldo()));
                            break;
                        case 3:
                            System.out.print("Monto a retirar: ");
                            cuenta.retirar(Double.parseDouble(sc.nextLine().trim()));
                            System.out.println("Retiro exitoso. Saldo: "
                                    + CuentaBancaria.formatear(cuenta.getSaldo()));
                            break;
                        case 4:
                            System.out.println("Hasta pronto.");
                            break;
                        default:
                            System.out.println("Opcion no valida.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: debe ingresar un numero.");
                } catch (SaldoInsuficienteException | MontoInvalidoException e) {
                    System.out.println(e.getMessage());
                }
            }
        } finally {
            sc.close();
        }
    }
}
