package Fichero;

import java.io.*;

public class Ficheros {
    public static void main(String[] args) {

        File miDir = new File("c:/dir3/dir4/dir5");

        if (miDir.exists()) {
            System.out.println("midir existe");


        } else {
            System.out.println("mi dir no existe");

            if (miDir.mkdirs()) {
                System.out.println("mi dir creado");

            } else {
                System.out.println("dir no creado");
            }

        }


        File miFich = new File(miDir, "fich1");
        try {
            if (miFich.createNewFile()) {
                System.out.println("fichero creado");

            } else {
                System.out.println("fichero no creado");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
