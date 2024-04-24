package EjerciciosTres;

import java.io.*;
import java.util.Scanner;

public class EjercicioDos {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        insertarPersonas();
    }

    static void insertarPersonas() {
        String nombre, apellido1, apellido2, fechaNacimiento;
        try {
            FileOutputStream fos = new FileOutputStream("c:/prueba/personas.dat", true);
            DataOutputStream dos = new DataOutputStream(fos);
            System.out.println("Ingrese un nombre: (0 = SALIR)");
            nombre = sc.nextLine();
            while (!nombre.equals("0")) {
                dos.writeUTF(nombre);
                System.out.println("Ingrese apellido1: ");
                apellido1 = sc.nextLine();
                dos.writeUTF(apellido1);
                System.out.println("Ingrese apellido2: ");
                apellido2 = sc.nextLine();
                dos.writeUTF(apellido2);
                System.out.println("Ingresa la fecha de nacimiento: ");
                fechaNacimiento = sc.nextLine();
                dos.writeUTF(fechaNacimiento);
                System.out.println("Ingrese un nombre: (0 = SALIR)");
                nombre = sc.nextLine();
            }
            dos.close();
            fos.close();
            FileInputStream fis = new FileInputStream("c:/prueba/personas.dat");
            DataInputStream dis = new DataInputStream(fis);
            while (dis.available() > 0) {
                nombre = dis.readUTF();
                apellido1 = dis.readUTF();
                apellido2 = dis.readUTF();
                fechaNacimiento = dis.readUTF();
                System.out.println(nombre + " " + apellido1 + " " + apellido2 + " " + fechaNacimiento);
            }
            dis.close();
            fis.close();
        } catch (IOException | RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
