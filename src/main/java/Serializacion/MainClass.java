package Serializacion;

import java.io.*;


public class MainClass {
    public static void main(String[] args) {
        Administrador jefe = new Administrador("Jose", 40000, 2012, 3, 15);
        jefe.setIncentivo(5000);

        Empleado[] personal = new Empleado[3];
        personal[0] = jefe;
        personal[1] = new Empleado("Elena", 27000, 2007, 11, 2);
        personal[2] = new Empleado("Pedro", 25000, 2009, 2, 7);

        try {
            ObjectOutputStream escribirFichero = new ObjectOutputStream(new FileOutputStream("c:/prueba/serializar.dat"));
            escribirFichero.writeObject(personal);
            escribirFichero.close();
            Empleado[] personalDos;
            try (ObjectInputStream recuperarFichero = new ObjectInputStream(new FileInputStream("c:/prueba/serializar.dat"))) {
                personalDos = (Empleado[]) recuperarFichero.readObject();
            }
            for (Empleado e : personalDos) System.out.println(e);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
