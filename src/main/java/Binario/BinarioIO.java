package Binario;

import java.io.*;
import java.util.Scanner;

public class BinarioIO {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int numeroMateria;
        double nota;
        try {
            FileOutputStream fos = new FileOutputStream("c:/prueba/prueba.data", true);
            DataOutputStream dos = new DataOutputStream(fos);
            System.out.println("Ingrese un codigo de asignatura: (0 = SALIR)");
            numeroMateria = sc.nextInt();
            while (numeroMateria != 0) {
                dos.writeInt(numeroMateria);
                System.out.println("Ingrese una nota: ");
                nota = sc.nextDouble();
                dos.writeDouble(nota);
                System.out.println("Ingrese un codigo de asignatura: (0 = SALIR)");
                numeroMateria = sc.nextInt();
            }
            dos.close();
            fos.close();
            FileInputStream fis = new FileInputStream("c:/prueba/notas.data");
            DataInputStream dis = new DataInputStream(fis);
            while (dis.available() > 0) {
                numeroMateria = dis.readInt();
                nota = dis.readDouble();
                System.out.println(numeroMateria + " nota: " + nota);
            }
            dis.close();
            fis.close();
        } catch (IOException | RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
