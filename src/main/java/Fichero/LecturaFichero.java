package Fichero;

import java.io.*;

public class LecturaFichero {
    public static void main(String[] args) {
        try {
            leer();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void leer() throws IOException {
        try (FileReader entrada = new FileReader("c:/prueba/ayuda.txt")) {
            try {
                int c;
                do {
                    c = entrada.read();
                    System.out.print((char) c);
                } while (c != -1);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
