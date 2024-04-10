package Binario;

import java.io.*;
import java.util.Scanner;

public class BinarioIODos {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String numeroMateria;
        String nota;
        try {
            FileOutputStream fos = new FileOutputStream("c:/prueba/Strings.dat", true);
            DataOutputStream dos = new DataOutputStream(fos);
            System.out.println("Ingrese un String: (0 = SALIR)");
            numeroMateria = sc.nextLine();
            while (!numeroMateria.equals("0")) {
                dos.writeUTF(numeroMateria);
                System.out.println("Ingrese un String: ");
                nota = sc.nextLine();
                dos.writeUTF(nota);
                System.out.println("Ingrese un String: (0 = SALIR)");
                numeroMateria = sc.nextLine();
            }
            dos.close();
            fos.close();
            FileInputStream fis = new FileInputStream("c:/prueba/Strings.dat");
            DataInputStream dis = new DataInputStream(fis);
            while (dis.available() > 0) {
                numeroMateria = dis.readUTF();
                nota = dis.readUTF();
                System.out.println(numeroMateria + " nota: " + nota);
            }
            dis.close();
            fis.close();
        } catch (IOException | RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}

