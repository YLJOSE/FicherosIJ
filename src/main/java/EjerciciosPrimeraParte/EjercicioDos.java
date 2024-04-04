package EjerciciosPrimeraParte;

import java.io.File;
import java.util.Scanner;

public class EjercicioDos {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ejercicioDos();
    }

    static void ejercicioDos() {
        String nombreDirectorio, nombreFichero;
        System.out.println("Ingresa el nombre del directorio:");
        nombreDirectorio = sc.nextLine();
        System.out.println("Ingresa el nombre del fichero:");
        nombreFichero = sc.nextLine();
        File fichero = new File("c:/" + nombreDirectorio + File.separator + nombreFichero + ".txt");
        if (fichero.exists()) {
            System.out.println("Existe!");

        } else {
            System.out.println("Error");
            sc.close();
        }
    }
}
