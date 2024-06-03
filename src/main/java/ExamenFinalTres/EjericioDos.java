package ExamenFinalTres;

import java.io.*;
import java.sql.*;
import java.util.*;

public class EjericioDos {
    static Scanner sc = new Scanner(System.in);
    final static String url = "jdbc:mysql://localhost:3306";
    final static String userName = "root";
    final static String password = "admin";
    final static String instSQLverBDs = "show databases;";
    final static String instSQLUpdateCreateDB = "create database if not exists Datosciudades;";
    final static String instSQLupdate = "use Datosciudades;";
    final static String instSQLUpdateCiudades = "CREATE TABLE if not exists ciudades (nombre VARCHAR(25) ,poblacion long,viviendas long,renta long,extension double,densidadPoblacion long,riqueza long);";
    final static String getInstSQLShowTable = "select * from ciudades;";

    public static void main(String[] args) {
        try {
            dBConection();
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    //metodo que te permite establecer
    static void dBConection() throws SQLException, IOException {
        Connection conectionJnr = DriverManager.getConnection(url, userName, password);
        Statement st = conectionJnr.createStatement();
        Statement st2 = conectionJnr.createStatement();
        consultationsSQL(st, st2);

    }

    //metodo crear y consultar que quieres hacer el usuario"switch?"
    static void consultationsSQL(Statement st, Statement st2) throws SQLException, IOException {
        ResultSet rst = st.executeQuery(instSQLverBDs);
        while (rst.next()) {
            System.out.println("BD: " + rst.getString(1));
        }
        System.out.println();
        st.executeUpdate(instSQLupdate);
        System.out.println("Despues de ver las bases de datos quieres crear la base de datos?");
        String respuestaCrearBD = sc.nextLine();
        if (respuestaCrearBD.equalsIgnoreCase("si")) {
            st.executeUpdate(instSQLUpdateCreateDB);

            System.out.println("BD creada correctamente o ya existe!");
        }
        System.out.println("Quieres crear la tabla ciudades? si/no");
        String respuestaCrearTabla = sc.nextLine();
        if (respuestaCrearTabla.equalsIgnoreCase("si")) {
            st.executeUpdate(instSQLUpdateCiudades);
            System.out.println("Tabla ciudades creada correctamente o ya existe!");
        }
        System.out.println("Quieres visualizar la tabla?");
        String respuestashowBBDD = sc.nextLine();
        if (respuestashowBBDD.equalsIgnoreCase("si")) {
            showBBDD(st2);
        }
        System.out.println("Quieres eliminar alguna ciudad de la tabla?");
        String respuestaDelete = sc.nextLine();
        if (respuestaDelete.equalsIgnoreCase("si")) {
            deleteDat(st2);
        }

    }

    //no
    static void insertDatBBDD(Statement st) throws IOException, SQLException {
        String nombreCiudad, rutaFicheroEscribir = "c:/prueba/ciudades.bin", instSQLInsert;
        long poblacion, viviendas, renta, extension, densidadPoblacion = 0, riqueza = 0;
        FileInputStream fis = new FileInputStream(rutaFicheroEscribir);
        DataInputStream dis = new DataInputStream(fis);
        System.out.println("Nombre\tPoblacion\tViviendas\tRenta\tExtension");
        while (dis.available() > 0) {
            nombreCiudad = dis.readUTF();
            poblacion = Long.parseLong(dis.readUTF());
            viviendas = Long.parseLong(dis.readUTF());
            renta = Long.parseLong(dis.readUTF());
            extension = Long.parseLong(dis.readUTF());
            instSQLInsert = "insert into ciudades values ('" + nombreCiudad + "'" + poblacion + viviendas + renta + extension + densidadPoblacion + riqueza + ");";
            st.executeUpdate(instSQLInsert);
        }
        dis.close();
        fis.close();
    }

    //metodo de eliminar un elemento de la bbdd
    static void deleteDat(Statement st) throws SQLException {
        System.out.println("Que ciudad deseas eliminar de la BBDD?");
        String ciudadABorrar = sc.nextLine();
        String instSQLDelete = "delete from ciudades where nombre='" + ciudadABorrar + "';";
        st.executeUpdate(instSQLDelete);
        System.out.println("ciudad borrada exitosamente!");
    }

    //metodo de visualizar bbdd
    static void showBBDD(Statement st) throws SQLException {
        ResultSet rst = st.executeQuery(getInstSQLShowTable);
        String nombre;
        long poblacion, viviendas, extension, renta, densidadPoblacion, riqueza;
        while (rst.next()) {

            nombre = rst.getString("nombre");
            poblacion = rst.getLong("poblacion");
            viviendas = rst.getLong("viviendas");
            renta = rst.getLong("renta");
            extension = rst.getLong("extension");
            densidadPoblacion = rst.getLong("densidadPoblacion");
            riqueza = rst.getLong("riqueza");

            System.out.println(nombre + "\t" + poblacion + "\t" + viviendas + "\t" + renta + "\t" + extension + "\t" + densidadPoblacion + "\t" + riqueza);

        }
    }
}
