package Fichero;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class ListarFichero implements FilenameFilter {
    static String extension;
    static Scanner sc = new Scanner(System.in);

    ListarFichero(String extension) {
        this.extension = extension;
    }

    public static void main(String[] args) {
        String rutaDirectorio = "c:/dir1";
        File directorio = new File(rutaDirectorio);
        System.out.println("introducir extension:");
        extension = sc.nextLine();
        ListarFichero filtro = new ListarFichero(extension);
        File archivosTXT[] = directorio.listFiles(filtro);


        for (File file : archivosTXT) {
            System.out.println(file.getAbsoluteFile());
        }


    }

    @Override
    public boolean accept(File dir, String name) {
        return name.toLowerCase().endsWith(".txt");
    }

}
