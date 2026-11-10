/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio11;

/**
 *
 * @javier alvarez
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class ReporteNotas {
    public static void main(String[] args) {
        int procesados = 0;
        int conError = 0;
        int numeroLinea = 1; 

        try (BufferedReader br = new BufferedReader(
                     new FileReader("notas.csv", StandardCharsets.UTF_8));
             PrintWriter pw = new PrintWriter(
                     new FileWriter("reporte.csv", StandardCharsets.UTF_8))) {

            pw.println("codigo,nombre,promedio,estado");
            br.readLine(); 
            String linea;
            while ((linea = br.readLine()) != null) {
                numeroLinea++;
                if (linea.isBlank()) {
                    continue;
                }
                try {
                    String[] c = linea.split(",");
                    if (c.length != 5) {
                        throw new IllegalArgumentException(
                                "se esperaban 5 columnas y hay " + c.length);
                    }
                    double suma = 0;
                    for (int i = 2; i < 5; i++) {
                        try {
                            suma += Double.parseDouble(c[i].trim());
                        } catch (NumberFormatException e) {
                            throw new IllegalArgumentException(
                                    "nota no numérica \"" + c[i] + "\"");
                        }
                    }
                    double promedio = suma / 3;
                    String estado = promedio >= 3.0 ? "APROBADO" : "REPROBADO";
                    pw.println(c[0] + "," + c[1] + ","
                            + String.format(Locale.US, "%.2f", promedio) + "," + estado);
                    procesados++;
                } catch (IllegalArgumentException e) {
                    System.out.println("Línea " + numeroLinea + " ignorada: " + e.getMessage());
                    conError++;
                }
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer o escribir un archivo: " + e.getMessage());
            return;
        }

        System.out.println("Registros procesados: " + procesados);
        System.out.println("Registros con error: " + conError);
    }
}
