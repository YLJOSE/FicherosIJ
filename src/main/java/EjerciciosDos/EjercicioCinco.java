package EjerciciosDos;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EjercicioCinco {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            buscarPalabra();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    static void buscarPalabra() throws IOException {
        String palabraABuscar, texto = "";
        char letra;
        File fichero = new File("c:/prueba/auxilio.txt");
        System.out.println("Ingresa la palabra que deseas buscar:");
        palabraABuscar = sc.nextLine();
        try (FileReader entrada = new FileReader(fichero)) {
            try {
                int c;
                do {
                    c = entrada.read();
                    letra = (char) c;
                    if (c != -1) {
                        texto += letra;
                    }
                } while (c != -1);
                System.out.println(texto);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}

