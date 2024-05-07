package EjerciciosSeis;

import java.sql.*;
import java.util.*;

public class EjercicioUno {
    /*
     * Username and password and login URL
     * */
    final static String url = "jdbc:mysql://localhost:3306/ej1";
    final static String userName = "root";
    final static String password = "admin";

    static Scanner sc = new Scanner(System.in);

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
        consultationsSQL(st);
    }

    static void consultationsSQL(Statement st) throws SQLException {
        /*
         * create table if exists db*/
       // st.executeUpdate("create table PersonasPais(id int primary key," +
         //       " nombre varchar(25), edad tinyint, nombrePais varchar(25), tamnno varchar(25))");
        ResultSet rst = st.executeQuery("select persona.id, persona.nombre," +
                "persona.edad,nombrePais,tamañoPais from persona join pais on pais.idPais =persona.id;");
        while (rst.next()) {

        }
    }
}