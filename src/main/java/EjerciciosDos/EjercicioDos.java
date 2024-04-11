package EjerciciosDos;

import java.io.*;
import java.util.*;

public class EjercicioDos {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            tamanoLineas();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void ejercicioDos(int lineasALeer) throws IOException {
        int comprobar = 0;
        try (FileReader entrada = new FileReader("c:/prueba/auxilio.txt")) {
            try {
                int c;
                do {
                    c = entrada.read();
                    if (c != -1) {
                        if (c == '\n') {
                            comprobar++;
                        }
                        if (comprobar < lineasALeer) {
                            System.out.print((char) c);
                        }
                    }
                } while (c != -1);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static void tamanoLineas() throws IOException {

        int lineasALeer, contador = 0;
        do {
            System.out.println("Ingresa cuantas lineas quieres leer:");
            lineasALeer = sc.nextInt();

            try (FileReader reader = new FileReader("c:/prueba/auxilio.txt")) {
                try {
                    int c;
                    do {
                        c = reader.read();
                        if (c != -1) {
                            if (c == '\n') {
                                contador++;
                            }
                        }
                    } while (c != -1);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
            contador++;
            if (lineasALeer > contador) {
                System.out.println("El nª de lineas ingresado es superior al del fichero!");
            }
        } while (contador < lineasALeer);
        contador--;
        ejercicioDos(lineasALeer);
    }
}
