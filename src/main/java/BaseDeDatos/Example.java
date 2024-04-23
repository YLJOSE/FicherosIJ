package BaseDeDatos;

import com.mysql.cj.jdbc.StatementImpl;

import java.sql.*;

public class Example {
    public static void main(String[] args) {
        Connection myConection = null;
        try {
            myConection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3307/pruebaProgramacion", "root", "admin");
            Statement statement = myConection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from productos");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("Codigo") + "\t" +
                        resultSet.getDouble("Precio")
                        + resultSet.getBoolean("Importado"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
