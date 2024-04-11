package RandomFile;

import java.io.*;
import java.util.*;

public class RandomUno {
    static RandomAccessFile raf = null;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int numero;
        try {
            raf = new RandomAccessFile("c:/prueba/nuevoDoc.dat", "rw");
            mostrarFichero();
            System.out.println("Ingresar un nº entero para añadir al final del fichero");
            numero = sc.nextInt();
            raf.seek(raf.length());
            raf.writeInt(numero);
            mostrarFichero();
            raf.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void mostrarFichero() {
        int numero;
        try {
            raf.seek(0);
            while (true) {
                numero = raf.readInt();
                System.out.println(numero);
            }
        } catch (EOFException ignored) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
