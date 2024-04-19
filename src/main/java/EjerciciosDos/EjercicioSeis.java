package EjerciciosDos;

import java.io.*;
import java.util.ArrayList;

public class EjercicioSeis {
    public static void main(String[] args) {
        ejercicioSeis();
    }

    static void ejercicioSeis() {
        int moda = 0, total = 0, contador = 0, contadorDos = 0;
        double media;
        String valores = "";
        ArrayList<Character> numeros = new ArrayList<Character>();
        File fichero = new File("c:/prueba/numeros.txt");
        try (FileReader entrada = new FileReader(fichero)) {
            try {
                int c;
                do {
                    c = entrada.read();
                    if (c != -1) {
                        System.out.print((char) c);
                        numeros.add((char) c);
                    }
                } while (c != -1);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\nNumeros: ");
        numeros.forEach(num -> System.out.print(num.toString()));
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < numeros.size(); j++) {
                if (i == Character.getNumericValue(numeros.get(j))) {
                    contador++;
                }
                if (i == 0) {
                    contadorDos++;
                    total += Character.getNumericValue(numeros.get(j));
                }
            }
            valores += "Numero: " + i + " - " + contador + " veces.\n";
            contador = 0;
        }
        media = (double) total / contadorDos;
        valores += "Media: " + media;
        //insertarATxt(valores);
        System.out.println(valores);
    }

    static void insertarATxt(String texto) {
        FileWriter escribiendo = null;
        try {
            escribiendo = new FileWriter("c:/prueba/estadistica.txt", true);
            for (int i = 0; i < texto.length(); i++) {
                escribiendo.write(texto.charAt(i));
            }
            escribiendo.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
