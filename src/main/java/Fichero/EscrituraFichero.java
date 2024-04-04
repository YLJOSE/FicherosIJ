package Fichero;

import java.io.FileWriter;
import java.io.IOException;

public class EscrituraFichero {
    public static void main(String[] args) {

        escribir();

    }

    public static void escribir() {
        String cadena = "\n prueba de escribir de nuevo";
        FileWriter escribiendo = null;
        try {
            escribiendo = new FileWriter("c:/prueba/ayuda.txt", true);
            for (int i = 0; i < cadena.length(); i++) {
                escribiendo.write(cadena.charAt(i));
            }
            escribiendo.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
