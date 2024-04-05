package EjerciciosUno;

import java.io.File;
import java.util.Scanner;

public class EjercicioTres {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ejercicioTres();
    }

    static void ejercicioTres() {
        String nombreDirectorio, nombreFichero;
        System.out.println("Ingresa el nombre del directorio:");
        nombreDirectorio = sc.nextLine();
        System.out.println("Ingresa el nombre del fichero:");
        nombreFichero = sc.nextLine();
        File fichero = new File("c:/" + nombreDirectorio + File.separator + nombreFichero + ".txt");
        if (fichero.exists()) {
            System.out.println(fichero.getName() + " -> Existe!");
            File directorio = new File("c:" + File.separator + nombreDirectorio);
            File listarArchivos[] = directorio.listFiles();
            System.out.println("Los subdirectorios son: ");
            listarFicheroDirectorio(listarArchivos, 1);
            System.out.println("Los ficheros son: ");
            listarFicheroDirectorio(listarArchivos, 2);
            listarFicheroPorLetra(listarArchivos);

        } else {
            System.out.println("Error");
        }
    }

    static void listarFicheroDirectorio(File array[], int opcion) {
        long tamañoTotal = 0;
        for (File file : array) {
            if (opcion == 1 && file.isDirectory()) {
                System.out.println(file.getName());
            }
            if (opcion == 2 && file.isFile()) {
                System.out.println(file.getName());
                tamañoTotal = tamañoTotal + file.length();
            }
        }
        if (opcion == 2) {
            System.out.println("El tamaño total de todos los ficheros es: " + tamañoTotal);
        }
    }

    static void listarFicheroPorLetra(File array[]) {
        boolean ayuda = true;
        System.out.println("Ingresa la letra por la que comienza el fichero: ");
        char letra = sc.nextLine().charAt(0);
        for (File file : array) {
            if (file.isFile() && (file.getName().charAt(0) == letra)) {
                System.out.println(file.getName());
                ayuda = false;
            }
        }
        if (ayuda) {
            System.out.println("No se encontraron ficheros con esa inicial!");
        }
    }
}
