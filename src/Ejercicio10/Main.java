/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio10;

/**
 *
 * @javier alvarez
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        Bitacora bitacora = new Bitacora("bitacora.txt");
        try {
            bitacora.registrar("Sistema iniciado");
            bitacora.registrar("ERROR: no se pudo conectar a la base de datos");
            bitacora.registrar("Usuario Lamine inició sesión");
            bitacora.registrar("Error al guardar el reporte");

            System.out.println("Contenido de la bitácora:");
            for (String linea : bitacora.leer()) {
                System.out.println(linea);
            }
            System.out.println("Total de errores: " + bitacora.contar("error"));
        } catch (IOException e) {
            System.out.println("Error de archivo: " + e.getMessage());
        }

        try (FileReader fr = new FileReader("noexiste.txt", StandardCharsets.UTF_8)) {
            System.out.println("Archivo abierto");
        } catch (FileNotFoundException e) {
            System.out.println("El archivo noexiste.txt no se encontro. Verifique el nombre y la ruta.");
        } catch (IOException e) {
            System.out.println("Error de lectura: " + e.getMessage());
        }
    }
}
