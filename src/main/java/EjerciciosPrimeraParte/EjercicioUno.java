package EjerciciosPrimeraParte;

import java.io.File;
import java.util.Scanner;

public class EjercicioUno {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String nombreDirectorio, nombreElemento;
        System.out.println("Ingresa el nombre del directorio:");
        nombreDirectorio = sc.nextLine();
        File directorio = new File("c:/" + nombreDirectorio);
        if (directorio.isDirectory()) {
            System.out.println("Ahora ingresa el nombre del elemento:");
            nombreElemento = sc.nextLine();
            File fichero = new File(directorio + "/" + nombreElemento + ".txt");
            if (fichero.isFile()) {
                System.out.println("si es un fichero y se encuentra dentro del directorio!");
                System.out.println("El tamaño del fichero es:" + fichero.length());
                System.out.println("Ingresa el nuevo nombre del fichero:");
                String nuevoNombreFichero = sc.nextLine();


            } else {
                File fichero2 = new File(directorio + "/" + nombreElemento);
                if (fichero2.isDirectory()) {
                    System.out.println(" Es  un directorio");

                }
            }
        } else {
            System.out.println("No es un directorio o no existe!");
        }

    }
}
