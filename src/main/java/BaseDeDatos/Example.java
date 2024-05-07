package BaseDeDatos;

import java.sql.*;

public class Example {
    public static void main(String[] args) {
        try {
            final String instSQLSelect = "select * from productos";
            final String instSQLInsert = "insert into productos values(4,'pistola',55.89)";
            final String instSQLDelete = "delete from productos where codigo=4";
            final String instSQLUpdate = "update productos set precio= precio*2 where codigo=2";

            Connection myConection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/empresa", "root", "admin");
            Statement statement = myConection.createStatement();
            /*********Operaciones basicas sql********/
            //statement.executeUpdate(instSQLDelete);
           // statement.executeUpdate(instSQLUpdate);
            statement.executeUpdate(instSQLInsert);
            /****************************************/
            ResultSet resultSet = statement.executeQuery(instSQLSelect);
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("Codigo") + "\t" +
                        resultSet.getDouble("Precio") + "\t");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
