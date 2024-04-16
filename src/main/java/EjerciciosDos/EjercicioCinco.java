package EjerciciosDos;

import java.io.*;
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
        File fichero = new File("c:/prueba/auxilio.txt");
        System.out.println("Ingresa la palabra que deseas buscar:");
        palabraABuscar = sc.nextLine();
        try (FileReader entrada = new FileReader(fichero)) {
            try {
                int c;
                do {
                    c = entrada.read();
                    if (c != -1) {
                        texto += (char) c;
                    }
                } while (c != -1);
                System.out.print(texto);
                int value = texto.indexOf(palabraABuscar);
                System.out.println(value);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}

