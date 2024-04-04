package EjerciciosPrimeraParte;

import java.io.File;
import java.util.Scanner;

public class EjercicioUno {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        ejercicioUno();
    }
    static void ejercicioUno() {
        String nombreDirectorio, nombreElemento;
        System.out.println("Ingresa el nombre del directorio:");
        nombreDirectorio = sc.nextLine();
        File directorio = new File("c:/" + nombreDirectorio);
        if (directorio.isDirectory()) {
            System.out.println("Ahora ingresa el nombre del elemento:");
            nombreElemento = sc.nextLine();
            File fichero = new File(directorio + File.separator + nombreElemento + ".txt");
            if (fichero.isFile()) {
                System.out.println("si es un fichero y se encuentra dentro del directorio!");
                System.out.println("El tamaño del fichero es:" + fichero.length());
                System.out.println("Ingresa el nuevo nombre del fichero:");
                String nuevoNombreFichero = sc.nextLine();
                File ficheroRenombrado = new File(directorio + File.separator + nuevoNombreFichero + ".txt");
                if (fichero.renameTo(ficheroRenombrado)) {
                    System.out.println("archivo renombrado");
                }
            } else {
                File fichero2 = new File(directorio + File.separator + nombreElemento);
                if (fichero2.isDirectory()) {
                    System.out.println(" Es  un directorio");
                    File listarArchivos[] = fichero2.listFiles();
                    for (File file : listarArchivos) {
                        System.out.println(file.getName());
                    }

                }
            }
        } else {
            System.out.println("No es un directorio o no existe!");
        }

    }
}
