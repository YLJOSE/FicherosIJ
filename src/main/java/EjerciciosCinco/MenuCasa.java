package EjerciciosCinco;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MenuCasa {
    public static void main(String[] args) {
        // Ejemplo de uso:
        List<Casa> casas = new ArrayList<>();
        casas.add(new Casa("Calle Ejemplo", "1", "2", "Ciudad Ejemplo", "12345", 100.0, 3));

        // Escribir casas en un archivo
        Casa.escribirCasas(casas, "casas.dat");

        // Leer casas desde un archivo
        List<Casa> casasLeidas = Casa.leerCasas("casas.dat");
        for (Casa casa : casasLeidas) {
            System.out.println(casa.toString());
        }
    }
}
