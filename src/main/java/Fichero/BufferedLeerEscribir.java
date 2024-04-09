package Fichero;

import java.io.*;
import java.util.Scanner;

public class BufferedLeerEscribir {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String texto;
        try {
            FileWriter fW = new FileWriter("C:/prueba/salida.txt");
            BufferedWriter escribir = new BufferedWriter(fW);
           /* escribir.write("Texto por buffer");
            escribir.newLine();
            escribir.write("Segunda linea");
            escribir.close();*/

            do {
                System.out.println("Ingresar texto");
                texto = sc.nextLine();
                escribir.write(texto);
                escribir.newLine();
            } while (!texto.isEmpty());
            escribir.close();
            /**********************************/
            FileReader fr = new FileReader("c:/prueba/salida.txt");
            BufferedReader leer = new BufferedReader(fr);
            System.out.println("Salida:");
            do {
                texto = leer.readLine();
                System.out.println(texto);
            } while (!texto.isEmpty());
            leer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
