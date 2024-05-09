package EjerciciosSeis;

import java.io.*;
import java.sql.*;
import java.util.*;

public class EjercicioDos {
    static Scanner sc = new Scanner(System.in);
    /*
     * Username and password and login URL
     * */
    final static String rutaArchivo="c:/prueba/DB/datosbd.dat";
    final static String url = "jdbc:mysql://localhost:3306/empresaDos";
    final static String userName = "root";
    final static String password = "admin";
    final static String instSQLConsult = "select e.emp_no,e.apellido,e.salario,d.dnombre " +
            "from empleados e join departamentos d on e.dept_no=d.dept_no; ";

    public static void main(String[] args) {
        try {
            dBConection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static void dBConection() throws SQLException {
        Connection conectionJnr = DriverManager.getConnection(url, userName, password);
        Statement st = conectionJnr.createStatement();
        Statement st2 = conectionJnr.createStatement();
        menu(st, st2);
    }

    static void menu(Statement st, Statement st2) throws SQLException {
        boolean exceptionControl = false;
        boolean exitProgram = false;
        // menu controlado por un bucle do while y capturando excepciones para que el
        // usuario ingrese un numero
        do {
            int opcion;
            System.out.println("********MENU*********");
            System.out.println("1. Dar de alta aun empleado.");
            System.out.println("2. Dar de baja a un empleado.");
            System.out.println("3. Modificar un empleado.");
            System.out.println("0. Ingresa 0 si deseas salir.");
            try {
                opcion = sc.nextInt();
                exceptionControl = true;
                sc.nextLine();
                switch (opcion) {
                    case 1:
                        insertSQL(st, st2);
                        break;
                    case 2:
                        deleteSQL(st, st2);
                        break;
                    case 3:
                        alterSQL(st, st2);
                        break;
                    case 0:
                        System.out.println("Saliendo del programa");
                        System.out.println("Muchas Gracias!");
                        exitProgram = true;
                        break;
                    default:
                        exitProgram = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ingresa un numero por favor!\n");
                sc.nextLine();
            }
        } while (!exceptionControl || !exitProgram);


    }

    static void consultationsSQL(Statement st) throws SQLException {

        ResultSet rst = st.executeQuery(instSQLConsult);
        int numId, salario;
        String nombre, nombreDep;
        while (rst.next()) {
            numId = rst.getInt("emp_no");
            nombre = rst.getString("apellido");
            salario = rst.getInt("salario");
            nombreDep = rst.getString("dnombre");
            System.out.println(numId + "\t" + nombre + "\t" + salario + "\t" + nombreDep);
        }
    }

    static void insertSQL(Statement st, Statement st2) throws SQLException {
        /*
         * variables donde se almacenas los datos que posteriormente se insertara a la base de datos
         * */
        String nombreEmpleado, oficio, fechaAlta, instSQLInsert,texto;
        int idEmpleado, dir, numDepartamento;
        long salario, comision;
        System.out.println("Indica el nº de empleado:");
        idEmpleado = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingresa el nombre:");
        nombreEmpleado = sc.nextLine();
        System.out.println("Oficio:");
        oficio = sc.nextLine();
        System.out.println("Dir:");
        dir = sc.nextInt();
        sc.nextLine();
        System.out.println("Fecha de alta: ejemplo: '1990/12/17' ");
        fechaAlta = sc.nextLine();
        System.out.println("salario:");
        salario = sc.nextLong();
        System.out.println("Comision:");
        comision = sc.nextLong();
        System.out.println("Nº de departamento:");
        numDepartamento = sc.nextInt();
        /*
         * sentencia sql para insertar en la tabla
         * */
        instSQLInsert = "insert into empleados values(" + idEmpleado + "," +
                "'" + nombreEmpleado + "'" + "," + "'" + oficio + "'" + "," + dir +
                "," + "'" + fechaAlta + "'" + "," + salario + "," + comision
                + "," + numDepartamento + ");";
        insertTable(st, instSQLInsert);
        consultationsSQL(st2);
        texto=idEmpleado+" "+nombreEmpleado+" "+oficio+" "+dir+" "+
                fechaAlta+" "+salario+" "+comision+" "+numDepartamento;
        escribirArchivo(texto);
    }

    static void deleteSQL(Statement st, Statement st2) {

    }

    static void alterSQL(Statement st, Statement st2) {

    }

    static void insertTable(Statement st, String instSQLInsert) throws SQLException {
        st.executeUpdate(instSQLInsert);
        System.out.println("Operacion exitosa!");
    }

    public static void escribirArchivo(String texto) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(rutaArchivo))) {
            //writer.println("alta: ");
            //writer.println("Baja: ");
            //writer.println("Modificacion: ");
            writer.println(texto);
            System.out.println("Se han escrito los datos en el archivo correctamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
