package BaseDeDatos;

import java.sql.*;

public class PrepareStatement {
    /*
     * Username and password and login URL
     * */
    final static String url = "jdbc:mysql://localhost:3306/pruebas";
    final static String userName = "root";
    final static String password = "admin";

    public static void main(String[] args) {
        try {
            Connection conectionJnr = DriverManager.getConnection(url, userName, password);
            PreparedStatement sentencia = conectionJnr.prepareStatement
                    ("select * from productos where nombre =? and importador=? ");
            sentencia.setString(1, "taladradora");
            sentencia.setBoolean(2, false);
            ResultSet rst = sentencia.executeQuery();
            while (rst.next()) {
                System.out.println(rst.getInt("codigo") + "\t" +
                        rst.getString("nombre") + "\t" + rst.getInt("precio") +
                        rst.getBoolean("importador"));
            }
            System.out.println();
            sentencia.setString(1, "destornillador");
            sentencia.setBoolean(2, true);
            while (rst.next()) {
                System.out.println(rst.getInt("codigo") + "\t" +
                        rst.getString("nombre") + "\t" + rst.getInt("precio") +
                        rst.getBoolean("importador"));
            }
            rst.close();
            sentencia.close();
            conectionJnr.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
