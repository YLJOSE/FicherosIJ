package Fichero;

import java.io.*;
import java.util.Scanner;

public class BufferedPrintWriter {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String texto;
        try {
            FileWriter fW = new FileWriter("C:/prueba/salida.txt");
            PrintWriter escribir = new PrintWriter(fW);
           /* escribir.write("Texto por buffer");
            escribir.newLine();
            escribir.write("Segunda linea");
            escribir.close();*/

            do {
                System.out.println("Ingresar texto");
                texto = sc.nextLine();
                if (!texto.isEmpty()) {
                    escribir.println(texto);
                }
            } while (!texto.isBlank());
            escribir.close();
            /**********************************/
            FileReader fr = new FileReader("c:/prueba/salida.txt");
            BufferedReader leer = new BufferedReader(fr);
            System.out.println("Salida:");
            do {
                texto = leer.readLine();
                if (texto != null) {
                    System.out.println(texto);
                }
            } while (texto != null);
            leer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
