package EntornosDeDesarrollo;

public class Cliente {
    private long numCliente;
    private String nombre;
    private long numTelefono;

    public Cliente(long numCliente, String nombre, long numTelefono) {
        this.numCliente = numCliente;
        this.nombre = nombre;
        this.numTelefono = numTelefono;
    }

    public long getNumCliente() {
        return numCliente;
    }

    public void setNumCliente(long numCliente) {
        this.numCliente = numCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(long numTelefono) {
        this.numTelefono = numTelefono;
    }

    @Override
    public String toString() {
        return "Cliente{" + "numCliente=" + numCliente + ", nombre='" + nombre + '\'' + ", numTelefono=" + numTelefono + '}';
    }
}
