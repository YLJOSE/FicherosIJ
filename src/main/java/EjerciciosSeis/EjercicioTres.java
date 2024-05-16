package EjerciciosSeis;

import java.sql.*;

public class EjercicioTres {
    /*
     * Username and password and login URL
     * */
    final static String url = "jdbc:mysql://localhost:3306/coches";
    final static String userName = "root";
    final static String password = "admin";
    final static String instSQLUpdate = "create table SeguroCoche(dni varchar(5)," +
            " edad integer, matricula varchar(20), seguro varchar(20))";
    final static String instSQLConsult = "select  p.dni,p.edad,c.matricula,c.precio from propietarios p join coches c on p.dni=c.dni;";
    final static int EDAD_LIMITE = 40;
    final static int PREMISA_MENOR_CUARENTA = 2;
    final static int PREMISA_RESTO = 1;
    final static int SEGURO_MENOR_CIEN = 5;

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
        consultationsSQL(st, st2);
    }

    static void consultationsSQL(Statement st, Statement st2) throws SQLException {
        /*
         * create table if exists db*/
        st.executeUpdate(instSQLUpdate);
        ResultSet rst = st.executeQuery(instSQLConsult);
        int edad, precio;
        String dni, matricula, instSQLInsert, seguro;
        while (rst.next()) {
            precio = rst.getInt("precio");
            dni = rst.getString("dni");
            edad = rst.getInt("edad");
            matricula = rst.getString("matricula");
            seguro = calcSeguro(edad, precio);
            instSQLInsert = "insert into PersonasPais values(" + "'" + dni + "'" + "," + edad + "," + "'" + matricula + "'" + "," + "'" + seguro + "'" + ");";
            insertTable(st2, instSQLInsert);
        }
    }

    static String calcSeguro(int edad, long precio) {
        String seguro;
        if (edad < EDAD_LIMITE) {
            seguro = String.valueOf(Math.toIntExact(PREMISA_MENOR_CUARENTA * precio / 100));
        } else {
            seguro = String.valueOf(Math.toIntExact(PREMISA_RESTO * precio / 100));
        }

        if (Integer.parseInt(seguro) < 100) {
            seguro = String.valueOf(Math.toIntExact((long) SEGURO_MENOR_CIEN * Integer.parseInt(seguro) / 100));
        } else if (Integer.parseInt(seguro) > 400) {
            seguro = "Baja";
        }
        return seguro;
    }

    static void insertTable(Statement st, String instSQLInsert) throws SQLException {
        st.executeUpdate(instSQLInsert);
    }
}
