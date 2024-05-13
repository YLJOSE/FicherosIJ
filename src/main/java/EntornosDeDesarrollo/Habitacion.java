package EntornosDeDesarrollo;

import java.time.LocalDate;

public class Habitacion extends Reserva {
    private int numero;
    private String estado;
    private int numeroCamas;

    public Habitacion(long numCliente, String nombre, long numTelefono,
                      long numReserva, LocalDate fechaEntrada, LocalDate fechaSalida,
                      int numHabitacion, int numPersonas, int numero, String estado, int numeroCamas) {
        super(numCliente, nombre, numTelefono, numReserva, fechaEntrada, fechaSalida, numHabitacion, numPersonas);
        this.numero = numero;
        this.estado = estado;
        this.numeroCamas = numeroCamas;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNumeroCamas() {
        return numeroCamas;
    }

    public void setNumeroCamas(int numeroCamas) {
        this.numeroCamas = numeroCamas;
    }
}
