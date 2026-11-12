/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio10;

/**
 *
 * @author user
 */
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Bitacora {
    private static final DateTimeFormatter FORMATO =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private final String ruta;

    public Bitacora(String ruta) {
        this.ruta = ruta;
    }

    public void registrar(String mensaje) throws IOException {
        String linea = "[" + LocalDateTime.now().format(FORMATO) + "] " + mensaje;
        
        try (PrintWriter pw = new PrintWriter(
                new FileWriter(ruta, StandardCharsets.UTF_8, true))) {
            pw.println(linea);
        }
    }

    public List<String> leer() throws IOException {
        return Files.readAllLines(Path.of(ruta), StandardCharsets.UTF_8);
    }

    public int contar(String palabra) throws IOException {
        int total = 0;
        for (String linea : leer()) {
            if (linea.toLowerCase().contains(palabra.toLowerCase())) {
                total++;
            }
        }
        return total;
    }
}
