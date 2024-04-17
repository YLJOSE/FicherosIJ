package Serializacion;

import java.io.*;

public class MainPersona {
    public static void main(String[] args) {
        Persona p1;
        try {
            FileOutputStream fos = new FileOutputStream("c:/prueba/nuevosDatos.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            p1 = new Persona("Juanjo", 22);
            oos.writeObject(p1);
            p1 = new Persona("Andres", 22);
            oos.writeObject(p1);
            oos.close();
            fos.close();
            /**/
            File f2 = new File("c:/prueba/auxiliarDos.bin");
            fos = new FileOutputStream(f2, true);
            oos = new ObjectOutputStream(fos);
            p1 = new Persona("pepe", 25);
            oos.writeObject(p1);
            p1 = new Persona("carlos", 65);
            oos.writeObject(p1);
            File f1 = new File("c:/prueba/nuevosDatos.bin");
            /**/
            FileInputStream fis = new FileInputStream(f1);
            ObjectInputStream ois = new ObjectInputStream(fis);
            try {
                while (true) {
                    p1 = (Persona) ois.readObject();
                    oos.writeObject(p1);
                }
            } catch (EOFException e) {
            }
            oos.close();
            fos.close();
            ois.close();
            fis.close();
            f1.delete();
            f2.renameTo(f1);
            fis = new FileInputStream(f1);
            ois = new ObjectInputStream(fis);
            try {
                while (true) {
                    p1 = (Persona) ois.readObject();
                    System.out.println("Nombre: " + p1.nombre + " Edad:" + p1.edad);
                }
            } catch (EOFException e) {
            }
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
