package EjerciciosCuatro;

import java.io.*;
import java.util.*;

public class EjerciciosLista {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Integer> referencias = new ArrayList<>();
        ArrayList<Double> precio = new ArrayList<>();
        insertArray(referencias, precio);
        ejercicioUno(referencias, precio, "ayuda.txt");

    }

    static void insertArray(ArrayList<Integer> referenciaArticulo, ArrayList<Double> precioProductos) {
        Random rnd = new Random();
        for (int i = 0; i < 10; i++) {
            double iterador = rnd.nextDouble(10);
            referenciaArticulo.add(i);
            precioProductos.add(15 * iterador);
        }
    }

    /*Metodo que ingresa la informacion del arraylist solicitado*/
    static void ejercicioUno(ArrayList<Integer> referenciaArticulo, ArrayList<Double> precioProductos, String nombreFichero) {
        String texto = "";
        for (int i = 0; i < referenciaArticulo.size(); i++) {
            texto += "ref: " + referenciaArticulo.get(i) + " Precio: " + precioProductos.get(i) + "\n";
        }
        try {
            FileWriter fW = new FileWriter("c:" + File.separator + "prueba" + File.separator + nombreFichero);
            PrintWriter escribir = new PrintWriter(fW);
            escribir.println(texto);
            escribir.close();
            System.out.println("Texto guardado correctamente!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ejercicioDos(nombreFichero);
    }

    /*metodo que muestra el contenido del fichero.*/
    static void ejercicioDos(String nombreFichero) {
        String texto;
        try {
            FileReader fr = new FileReader("c:" + File.separator + "prueba" + File.separator + nombreFichero);
            BufferedReader leer = new BufferedReader(fr);
            System.out.println("Salida:");
            do {
                texto = leer.readLine();
                if (texto != null) {
                    System.out.println(texto);
                }
            } while (!texto.isEmpty());
            leer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ejercicioTres(nombreFichero);
    }

    /*Falta terminar este ejercicio*/
    static void ejercicioTres(String nombreFichero) {
        String texto;
        try {
            FileReader fr = new FileReader("c:" + File.separator + "prueba" + File.separator + nombreFichero);
            BufferedReader leer = new BufferedReader(fr);
            do {
                texto = leer.readLine();
                if (texto != null) {
                    System.out.println(texto);
                }
            } while (texto != null);
            leer.close();
            /**********************************/
            FileWriter fW = new FileWriter("C:/prueba/salida.txt");
            PrintWriter escribir = new PrintWriter(fW);
            do {
                System.out.println("Ingresar texto");
                texto = sc.nextLine();
                if (!texto.isEmpty()) {
                    escribir.println(texto);
                }
            } while (!texto.isBlank());
            escribir.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}