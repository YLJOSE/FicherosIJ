package EjerciciosDos;

import java.io.*;
import java.util.Scanner;

public class EjercicioCinco {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String palabraBuscada = obtenerPalabra();
        int contador = contarPalabra(palabraBuscada);
        System.out.println("La palabra: " + palabraBuscada + " aparece " + contador + " veces en el archivo.");
    }

    public static String obtenerPalabra() {
        System.out.println("Ingresa la palbra que deseas buscar:");
        String palabraABuscar = sc.nextLine();
        return palabraABuscar;
    }

    public static int contarPalabra(String palabra) {
        int contador = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("c:/prueba/ayuda20.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] palabras = linea.split(" ");
                for (String p : palabras) {
                    if (p.equalsIgnoreCase(palabra)) {
                        contador++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contador;
    }

}

