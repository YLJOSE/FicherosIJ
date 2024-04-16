package Serializacion;

import java.io.*;
import java.util.*;

public class Empleado  implements Serializable{
    private String nombre;
    private transient double sueldo;
    private Date fechaContrato;

    public Empleado(String n, double s, int anho, int mes, int dia) {
        nombre = n;
        sueldo = s;
        GregorianCalendar calendario = new GregorianCalendar(anho, mes - 1, dia);
        fechaContrato = calendario.getTime();
    }

    public String getNombre() {
        return nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public Date getFechaContrato() {
        return fechaContrato;
    }

    public void subirSueldo(double porcentaje) {
        double aumento = (sueldo * porcentaje) / 100;
        sueldo += aumento;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ". Sueldo: " + sueldo + ". Fecha Contrato: " + fechaContrato;
    }
}

class Administrador extends Empleado {
    private double incentivo;
    public Administrador(String n, double s, int anho, int mes, int dia) {
        super(n, s, anho, mes, dia);
        incentivo = 0;
    }

    public double getSueldo() {
        double sueldoBase = super.getSueldo();
        return sueldoBase + incentivo;
    }

    public void setIncentivo(double b) {
        incentivo = b;
    }

    @Override
    public String toString() {
        return super.toString() + ". Incentivo: " + incentivo;
    }
}

