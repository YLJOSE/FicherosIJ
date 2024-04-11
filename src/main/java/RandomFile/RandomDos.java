package RandomFile;

import java.io.*;
import java.util.*;

public class RandomDos {
    static Scanner sc = new Scanner(System.in);
    static RandomAccessFile raf = null;
    public static void main(String[] args) {
        int posicion, tamanno;
        try {
            raf = new RandomAccessFile("c:/prueba/nuevoDoc.dat", "rw");
            tamanno = Math.toIntExact(raf.length() / 4);
            System.out.println("El fichero tiene: " + tamanno + " enteros");
            do {
                System.out.println("Posicion (>=1 o <=" + tamanno + ")");
                posicion = sc.nextInt();
            } while (posicion < 1 || posicion > tamanno);
            posicion--;
            raf.seek(posicion * 4L);
            System.out.println("Valor: " + raf.readInt());
            System.out.println("Ingresa un nuevo valor: ");
            raf.seek(raf.getFilePointer() - 4);
            raf.writeInt(sc.nextInt());
            System.out.println("Contenido del fichero: ");
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
