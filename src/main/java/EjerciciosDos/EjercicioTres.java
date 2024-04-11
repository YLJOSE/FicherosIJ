package EjerciciosDos;

import java.io.*;
import java.util.Scanner;

public class EjercicioTres {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ejercicioTres();
    }

    static void ejercicioTres() {
        String nombreFichero, nombreElemento;
        System.out.println("Ingresa el nombre del directorio:");
        nombreFichero = sc.nextLine();
        File directorio = new File("c:/" + nombreFichero);
        if (directorio.isDirectory()) {
            System.out.println("Ahora ingresa el nombre del fichero:");
            nombreElemento = sc.nextLine();
            File fichero = new File(directorio + File.separator + nombreElemento + ".txt");
            if (fichero.isFile()) {
                System.out.println("si es un fichero y se encuentra dentro del directorio!");
                System.out.println("El tamaño del fichero es:" + fichero.length());
                try {
                    System.out.println(tamanoLineas(fichero));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("No existe!");
            }
        } else {
            System.out.println("No es un directorio o no existe!");
        }


    }

    static String tamanoLineas(File fichero) throws IOException {

        int numeroLineasFichero = 1, numeroPalabras = 1;
        try (FileReader reader = new FileReader(fichero)) {
            try {
                int c;
                do {
                    c = reader.read();
                    if (c != -1) {
                        if (c == ' ' || c == '\n') {
                            numeroPalabras++;
                            if (c == '\n') {
                                numeroLineasFichero++;
                            }
                        }
                    }
                } while (c != -1);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        return "Nº de lineas es: " + numeroLineasFichero + "\nNº de palabras es: " + numeroPalabras;
    }
}
