package BaseDeDatos;

import java.sql.*;

public class VerBaseDeDatos {
    public static void main(String[] args) throws SQLException {
        final String url = "jdbc:mysql://localhost:3306";
        final String userName = "root";
        final String password = "admin";
        final String instSQLverBDs = "show databases";

            Connection conectionJnr = DriverManager.getConnection(url, userName, password);
            Statement st = conectionJnr.createStatement();
            ResultSet rs = st.executeQuery(instSQLverBDs);
            while (rs.next()) {
                System.out.println("BD: " + rs.getString(1));
            }
            String consulta = "CREATE DATABASE " + "BDNueva";
            st.executeUpdate(consulta);
            st.executeUpdate("USE BDNueva");
            st.executeUpdate(
                    "create table newTable(id int primary key, nombre varchar(25), apellido varchar(25),)");

    }
}