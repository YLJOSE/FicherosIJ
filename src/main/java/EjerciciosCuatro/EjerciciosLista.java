package EjerciciosCuatro;

import java.io.*;
import java.util.*;

public class EjerciciosLista {
    static Scanner sc = new Scanner(System.in);

    // Método para escribir referencias y precios en un archivo
    public static void escribirArchivo(String[] referencias, double[] precios, String nombreArchivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            for (int i = 0; i < referencias.length; i++) {
                writer.println(referencias[i] + " " + precios[i]);
            }
            System.out.println("Se han escrito los datos en el archivo correctamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    // Método para mostrar el contenido de un archivo por pantalla
    public static void mostrarContenido(String nombreArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // Método para actualizar precios en un archivo
    public static void actualizarPrecios(String nombreArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo));
             PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo + "_temp"))) {

            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(" ");
                String referencia = partes[0];
                double precio = Double.parseDouble(partes[1]);

                if (precio > 100) {
                    precio *= 0.5; // Decrementar un 50%
                } else {
                    precio *= 1.5; // Incrementar un 50%
                }
                writer.println(referencia + " " + precio);
            }

            // Renombrar el archivo temporal al original
            File archivoOriginal = new File(nombreArchivo);
            File archivoTemporal = new File(nombreArchivo + "_temp");
            if (archivoOriginal.delete() && archivoTemporal.renameTo(archivoOriginal)) {
                System.out.println("Precios actualizados correctamente.");
            } else {
                System.err.println("Error al actualizar los precios.");
            }

        } catch (IOException | NumberFormatException e) {
            System.err.println("Error al actualizar los precios: " + e.getMessage());
        }
    }

    // Método main para probar las funciones
    public static void main(String[] args) {
        // Ejemplo de uso
        String[] referencias = {"REF001", "REF002", "REF003"};
        double[] precios = {120.0, 80.0, 150.0};
        String nombreArchivo = "articulos.txt";

        // Escribir referencias y precios en el archivo
        escribirArchivo(referencias, precios, nombreArchivo);

        // Mostrar contenido del archivo
        System.out.println("Contenido del archivo:");
        mostrarContenido(nombreArchivo);

        // Actualizar precios del archivo
        actualizarPrecios(nombreArchivo);

        // Mostrar contenido actualizado del archivo
        System.out.println("Contenido actualizado del archivo:");
        mostrarContenido(nombreArchivo);
    }
}
