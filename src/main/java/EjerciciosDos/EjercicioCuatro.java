package EjerciciosDos;

import java.io.*;
import java.util.*;

public class EjercicioCuatro {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        modificarFile();
    }

    public static void modificarFile() {
        File fichero = new File("c:/prueba/ayuda.txt");
        char abc[] = {'a', 'e', 'i', 'o', 'u'};
        ArrayList<Character> caracter = new ArrayList<>();
        String letra;
        FileWriter escribiendo = null;
        try (FileReader entrada = new FileReader(fichero)) {
            try {
                int c;
                do {
                    c = entrada.read();
                    letra = String.valueOf((char) c);
                    for (int i = 0; i < abc.length; i++) {
                        if (letra.equalsIgnoreCase(String.valueOf(abc[i]))) {
                            caracter.add('*');
                        }
                    }
                    caracter.add((char) c);
                } while (c != -1);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            escribiendo = new FileWriter(fichero, true);

            for (int i = 0; i < caracter.size(); i++) {
                escribiendo.write(caracter.get(i));
            }
            escribiendo.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
