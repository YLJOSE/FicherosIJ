package EjerciciosCinco;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Casa implements Serializable {
    private String direccion;
    private String portal;
    private String piso;
    private String localidad;
    private String codigoPostal;
    private double metrosCuadrados;
    private int numeroHabitaciones;

    // Constructor
    public Casa(String direccion, String portal, String piso, String localidad, String codigoPostal,
                double metrosCuadrados, int numeroHabitaciones) {
        this.direccion = direccion;
        this.portal = portal;
        this.piso = piso;
        this.localidad = localidad;
        this.codigoPostal = codigoPostal;
        this.metrosCuadrados = metrosCuadrados;
        this.numeroHabitaciones = numeroHabitaciones;
    }

    // Getters
    // Setters

    // Método para escribir lista de casas en un archivo
    public static void escribirCasas(List<Casa> casas, String nombreArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(casas);
            System.out.println("Datos de casas escritos en el archivo correctamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    // Método para leer lista de casas desde un archivo
    public static List<Casa> leerCasas(String nombreArchivo) {
        List<Casa> casas = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            casas = (List<Casa>) ois.readObject();
            System.out.println("Datos de casas leídos desde el archivo correctamente.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return casas;
    }
}

// Clase principal
public class Main {
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
