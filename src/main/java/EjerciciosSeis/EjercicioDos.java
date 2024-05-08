package EjerciciosSeis;

import java.sql.*;

public class EjercicioDos {
    /*
     * Username and password and login URL
     * */
    final static String url = "jdbc:mysql://localhost:3306/ej1";
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
        consultationsSQL(st, st2);
    }
    static void consultationsSQL(Statement st, Statement st2) throws SQLException {

        ResultSet rst = st.executeQuery(instSQLConsult);
        int id, edad;
        String nombre, nombrePais, tamnnoPais, instSQLInsert;
        while (rst.next()) {
            id = rst.getInt("id");
            nombre = rst.getString("nombre");
            edad = rst.getInt("edad");
            nombrePais = rst.getString("nombrePais");
            tamnnoPais = rst.getString("tamañoPais");

            instSQLInsert = "insert into PersonasPais values(" + id + "," +
                    "'" + nombre + "'" + "," + edad + "," + "'" + nombrePais +
                    "'" + "," + "'" + tamnnoPais + "'" + ");";
           // insertTable(st2, instSQLInsert);
        }
    }
}
