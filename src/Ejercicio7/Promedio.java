/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio7;

/**
 *
 * @author user
 */
import java.util.Scanner;

public class Promedio {

    public static double promedio(double[] notas) {
        if (notas == null || notas.length == 0) {
            throw new IllegalArgumentException("Debe haber al menos una nota.");
        }
        double suma = 0;
        for (double nota : notas) {
            suma += nota;
        }
        return suma / notas.length;
    }

    private static int leerCantidad(Scanner sc) {
        while (true) {
            System.out.print("Cuantas notas? ");
            try {
                int n = Integer.parseInt(sc.nextLine().trim());
                if (n <= 0) {
                    System.out.println("Debe ser un entero mayor que cero.");
                    continue;
                }
                return n;
            } catch (NumberFormatException e) {
                System.out.println("Dato invalido: ingrese un número entero.");
            }
        }
    }

    private static double leerNota(Scanner sc, int posicion) {
        while (true) {
            System.out.print("Nota " + posicion + " (0 a 5): ");
            try {
                double nota = Double.parseDouble(sc.nextLine().trim().replace(',', '.'));
                if (!(nota >= 0 && nota <= 5)) {
                    System.out.println("La nota debe estar entre 0 y 5.");
                    continue;
                }
                return nota;
            } catch (NumberFormatException e) {
                System.out.println("Dato invalido: ingrese un numero (ej. 4.5).");
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = leerCantidad(sc);
            double[] notas = new double[n];
            for (int i = 0; i < n; i++) {
                notas[i] = leerNota(sc, i + 1);
            }
            System.out.printf("Promedio: %.2f%n", promedio(notas));
        }
    }
}
