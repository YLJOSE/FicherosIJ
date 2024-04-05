package EjerciciosDos;

import java.io.*;
import java.util.Scanner;

public class EjercicioUno {
    static Scanner sc = new Scanner(System.in);

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
                    if (c != -1) {
                        System.out.print((char) c);
                    }
                } while (c != -1);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
