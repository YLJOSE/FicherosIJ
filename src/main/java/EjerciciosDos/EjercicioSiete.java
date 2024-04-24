package EjerciciosDos;

import java.io.*;

public class EjercicioSiete {
    public static void main(String[] args) {
        encriptarTexto("c:/prueba/incriptar.txt", "c:/prueba/texto_incriptado.txt");
    }

    /*metodo para leer y escribir al mismo tiempo el texto encriptado*/
    public static void encriptarTexto(String archivoEntrada, String archivoSalida) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivoEntrada)); BufferedWriter bw = new BufferedWriter(new FileWriter(archivoSalida))) {

            int caracter;
            while ((caracter = br.read()) != -1) {
                if (Character.isLetter(caracter)) {
                    char encriptado = encriptarCaracter((char) caracter);
                    bw.write(encriptado);
                } else {
                    bw.write(caracter);
                }
            }
            System.out.println("Texto encriptado correctamente.");

        } catch (IOException e) {
            System.err.println("Error al encriptar el texto: " + e.getMessage());
        }
    }

    /*Metodo que encripta los caracteres solicitados, revisando si está en minusculas o mayusculas
     * el cual nos reemplaza con la letra siguiente en tres  y modulo 26 para asegurarnos que esta
     * dentro del rango de la tabla ascci en letras*/
    public static char encriptarCaracter(char caracter) {
        char encriptado;
        if (caracter >= 'a' && caracter <= 'z') {
            encriptado = (char) ('a' + (caracter - 'a' + 3) % 26);
        } else if (caracter >= 'A' && caracter <= 'Z') {
            encriptado = (char) ('A' + (caracter - 'A' + 3) % 26);
        } else {
            encriptado = caracter;
        }
        return encriptado;
    }

}
