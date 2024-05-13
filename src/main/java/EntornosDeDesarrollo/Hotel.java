package EntornosDeDesarrollo;

import java.time.LocalDate;

public class Hotel extends Habitacion {
    private int codigo;
    private String nombre;
    private String direccion;
    private long numeroTelefono;

    public Hotel(long numCliente, String nombre, long numTelefono, long numReserva,
                 LocalDate fechaEntrada, LocalDate fechaSalida, int numHabitacion,
                 int numPersonas, int numero, String estado, int numeroCamas,
                 int codigo, String nombre1, String direccion, long numeroTelefono) {
        super(numCliente, nombre, numTelefono, numReserva, fechaEntrada, fechaSalida,
                numHabitacion, numPersonas, numero, estado, numeroCamas);
        this.codigo = codigo;
        this.nombre = nombre1;
        this.direccion = direccion;
        this.numeroTelefono = numeroTelefono;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(long numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }
}
