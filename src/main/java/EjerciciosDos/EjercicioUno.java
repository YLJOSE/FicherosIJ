package EjerciciosDos;

import java.io.*;
import java.util.*;

public class EjercicioUno {
    public static void main(String[] args) {
        try {
            lecturaEscrituraYLecturaReverse();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void lecturaEscrituraYLecturaReverse() throws IOException {
        ArrayList<Character> ayuda = new ArrayList<>();

        try (FileReader entrada = new FileReader("c:/prueba/ayuda.txt")) {
            try {
                int c;
                do {
                    c = entrada.read();
                    if (c != -1) {
                        ayuda.add((char) c);
                        System.out.print((char) c);
                    }
                } while (c != -1);
                FileWriter escribiendo = new FileWriter("c:/prueba/ayudaInvertido.txt", true);
                for (int i = ayuda.size(); i > 0; i--) {
                    escribiendo.write(ayuda.get(i - 1));
                }
                escribiendo.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("\nLectura Invertida");
            /**/
            try (FileReader lecturaReverse = new FileReader("c:/prueba/ayudaInvertido.txt")) {
                try {
                    int a;
                    do {
                        a = lecturaReverse.read();
                        if (a != -1) {

                            System.out.print((char) a);
                        }
                    } while (a != -1);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                /**/
            }

        }
    }
}
