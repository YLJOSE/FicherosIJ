package Fichero;

import java.io.IOException;

public class LecturaLinea {
    public static void main(String[] args) {
        int c, contador = 0;
        while (true) {
            try {
                if (!((c = System.in.read()) != '\n')) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            contador++;
            System.out.println((char) c);
        }
        System.out.println("Numero de caracteres: " + contador);
    }
}
