package EjerciciosDos;

import java.io.*;
import java.util.ArrayList;

public class EjercicioSeis {
    public static void main(String[] args) {
        ejercicioSeis();
    }

    static void ejercicioSeis() {
        int moda, media = 0, contador = 0;
        String valores = "";
        ArrayList<Character> numero = new ArrayList<>();
        numero.add('0');
        numero.add('1');
        numero.add('2');
        numero.add('3');
        numero.add('4');
        numero.add('5');
        numero.add('6');
        numero.add('7');
        numero.add('8');
        numero.add('9');
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
        for (int i = 0; i < numero.size(); i++) {
            for (int j = 0; j < numeros.size(); j++) {
                if (numero.get(i) == numeros.get(j)) {
                    contador++;
                }
            }
            valores += "Numero: " + numero.get(i) + " - " + contador + " veces.\n";
            contador = 0;
        }
        System.out.println(valores);
        // insertarATxt(valores);
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
