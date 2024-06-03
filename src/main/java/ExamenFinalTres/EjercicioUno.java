package ExamenFinalTres;

import java.io.*;
import java.util.*;

public class EjercicioUno {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        insertFichero();
    }

    static void insertFichero() {
        String nombreCiudad, poblacion, viviendas, renta, extension, rutaFicheroEscribir, controlBucle;
        System.out.println("Ingresa la ruta del fichero correctamente para evitar errores:");
        System.out.println("Ejemplo: c:/prueba/ayuda.bin");
        rutaFicheroEscribir = sc.nextLine();
        try {
            FileOutputStream fos = new FileOutputStream(rutaFicheroEscribir, true);
            DataOutputStream dos = new DataOutputStream(fos);
            do {
                System.out.println("Ingrese el nombre:");
                nombreCiudad = sc.nextLine();
                dos.writeUTF(nombreCiudad + "\t");
                System.out.println("Ingrese la poblacion:");
                poblacion = sc.nextLine();
                dos.writeUTF(poblacion + "\t");
                System.out.println("Ingresa las viviendas:");
                viviendas = sc.nextLine();
                dos.writeUTF(viviendas + "\t");
                System.out.println("Ahora ingresa la renta per capitá en €:");
                renta = sc.nextLine();
                dos.writeUTF(renta + "\t");
                System.out.println("Ingresa la extension en km2:");
                extension = sc.nextLine();
                dos.writeUTF(extension);
                System.out.println("Si quieres dejar añadir una ciudad ingresa 'si'");
                controlBucle = sc.nextLine();
            } while (!controlBucle.equalsIgnoreCase("si"));

            dos.close();
            fos.close();

            visualizarDatosFichero(rutaFicheroEscribir);
        } catch (IOException | RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    static void moficarDarosFichero(String rutaFicheroEscribir) throws IOException {
        long densidadDePoblacion, riqueza = 0, poblacionDos, extensionDos, rentaDos;
        String nombreCiudad, poblacion, viviendas, renta, extension;
        FileInputStream fis = new FileInputStream(rutaFicheroEscribir);
        DataInputStream dis = new DataInputStream(fis);
        while (dis.available() > 0) {
            nombreCiudad = dis.readUTF();
            poblacion = dis.readUTF();
            viviendas = dis.readUTF();
            renta = dis.readUTF();
            extension = dis.readUTF();
            /**/
            poblacionDos = Long.parseLong(poblacion);
            extensionDos = Long.parseLong(extension);
            rentaDos = Long.parseLong(renta);
            densidadDePoblacion = poblacionDos / extensionDos;
            riqueza = rentaDos * poblacionDos;

        }
        dis.close();
        fis.close();

    }

    static void visualizarDatosFichero(String rutaFicheroEscribir) throws IOException {
        String nombreCiudad, poblacion, viviendas, renta, extension;
        FileInputStream fis = new FileInputStream(rutaFicheroEscribir);
        DataInputStream dis = new DataInputStream(fis);
        System.out.println("Nombre\tPoblacion\tViviendas\tRenta\tExtension");
        while (dis.available() > 0) {
            nombreCiudad = dis.readUTF();
            poblacion = dis.readUTF();
            viviendas = dis.readUTF();
            renta = dis.readUTF();
            extension = dis.readUTF();
            System.out.println(nombreCiudad + poblacion + viviendas + renta + extension);
        }
        dis.close();
        fis.close();
    }
}
