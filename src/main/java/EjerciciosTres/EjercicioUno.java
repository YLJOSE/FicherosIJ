package EjerciciosTres;

import java.io.*;
import java.util.Scanner;

public class EjercicioUno {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String archivoEntrada = pedirEntrada();
        String archivoSalida = pedirSalida();
        try {
            copiarArchivo(archivoEntrada, archivoSalida);
            System.out.println("El archivo se ha copiado exitosamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String pedirEntrada() {
        String nombreFichero, extensionFichero;
        System.out.println("Ingresa el nombre del fichero:");
        nombreFichero = sc.nextLine();
        System.out.println("Ingresa la extension del fichero:");
        extensionFichero = sc.nextLine();
        return nombreFichero + "." + extensionFichero;
    }

    private static String pedirSalida() {
        String nombreFicheroSalida, extensionFichero;
        System.out.println("Ahora ingresa el nombre del fichero de salida:");
        nombreFicheroSalida = sc.nextLine();
        System.out.println("Ingresa la extension del fichero:");
        extensionFichero = sc.nextLine();
        return nombreFicheroSalida + "." + extensionFichero;
    }

    static void copiarArchivo(String archivoEntrada, String archivoSalida) throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        fis = new FileInputStream("c:" + File.separator + "prueba" + File.separator + archivoEntrada);
        fos = new FileOutputStream("c:" + File.separator + "prueba" + File.separator + archivoSalida);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = fis.read(buffer)) > 0) {
            fos.write(buffer, 0, length);
        }
        if (fis != null || fos != null) {
            fis.close();
            fos.close();
        }

    }
}
