package EntornosDeDesarrollo;

import java.time.LocalDate;

public class Reserva extends Cliente{
    private long numReserva;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private int numHabitacion;
    private int numPersonas;

    public Reserva(long numCliente, String nombre, long numTelefono,
                   long numReserva, LocalDate fechaEntrada, LocalDate fechaSalida,
                   int numHabitacion, int numPersonas) {
        super(numCliente, nombre, numTelefono);
        this.numReserva = numReserva;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.numHabitacion = numHabitacion;
        this.numPersonas = numPersonas;
    }

    public long getNumReserva() {
        return numReserva;
    }

    public void setNumReserva(long numReserva) {
        this.numReserva = numReserva;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getNumHabitacion() {
        return numHabitacion;
    }

    public void setNumHabitacion(int numHabitacion) {
        this.numHabitacion = numHabitacion;
    }

    public int getNumPersonas() {
        return numPersonas;
    }

    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }

    @Override
    public String toString() {
        return "Reserva{" + "numReserva=" + numReserva + ", fechaEntrada=" + fechaEntrada + ", fechaSalida=" + fechaSalida + ", numHabitacion=" + numHabitacion + ", numPersonas=" + numPersonas + '}';
    }
}
