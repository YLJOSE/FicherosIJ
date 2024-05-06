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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPortal() {
        return portal;
    }

    public void setPortal(String portal) {
        this.portal = portal;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public double getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public void setMetrosCuadrados(double metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }

    public int getNumeroHabitaciones() {
        return numeroHabitaciones;
    }

    public void setNumeroHabitaciones(int numeroHabitaciones) {
        this.numeroHabitaciones = numeroHabitaciones;
    }

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