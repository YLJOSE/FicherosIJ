package BaseDeDatos;

import java.sql.*;

public class Examen {
    /*
     * Username and password and login URL
     * consultas sql
     * */
    final static String url = "jdbc:mysql://localhost:3306";
    final static String userName = "root";
    final static String password = "admin";
    final static String instSQLUpdateCreateDB = "create database Tienda;";
    final static String instSQLUpdateFabricantes = "create table Fabricantes(" + "  CLFAB int Primary Key," + "  Nombre varchar(30)" + ");";
    final static String instSQLUpdateArticulos = "create table Articulos(" + "  CLART int Primary Key," + "  Nombre varchar(30)," + "  Precio int," + "  CLFAB int,\n" + "  Foreign Key (CLFAB) References Fabricantes(CLFAB)\n" + "  ON DELETE CASCADE ON UPDATE CASCADE\n" + ")ENGINE=InnoDB;";
    final static String instSQLverBDs = "show databases;";
    final static String insertArticulos = "insert into articulos values";
    final static String insertFabricantes = "insert into fabricantes values";
    final static String instSQLUpdateCreateArtFab = "create table ArtFab(nombreArticulo varchar(40),nombreFabricante varchar(40),precio int ,IVA varchar(10));";
    final static String instSQLConsult = "select a.nombre, f.nombre,a.precio from fabricantes  f join articulos a on a.clfab =f.clfab;";

    public static void main(String[] args) {
        try {
            dBConection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //metodo que te permite establecer
    static void dBConection() throws SQLException {
        Connection conectionJnr = DriverManager.getConnection(url, userName, password);
        Statement st = conectionJnr.createStatement();
        Statement st2 = conectionJnr.createStatement();
        consultationsSQL(st, st2);

    }

    //metodo donde se encuentran las consultas y lo que esta comentado son los insert
    static void consultationsSQL(Statement st, Statement st2) throws SQLException {
        /*
         * create DB if not exists*/
        ResultSet rst = st.executeQuery(instSQLverBDs);
        while (rst.next()) {
            System.out.println("BD: " + rst.getString(1));
        }
        System.out.println();
        st.executeUpdate(instSQLUpdateCreateDB);
        st.executeUpdate("use tienda;");
        st.executeUpdate(instSQLUpdateFabricantes);
        st.executeUpdate(instSQLUpdateArticulos);
        st.executeUpdate(insertFabricantes + "(1,'Kingston');");
        st.executeUpdate(insertFabricantes + "(2,'Adata');");
        st.executeUpdate(insertFabricantes + "(3,'Logitech');");
        st.executeUpdate(insertFabricantes + "(4,'Lexar');");
        st.executeUpdate(insertFabricantes + "(5,'Seagate');");
        st.executeUpdate(insertArticulos + "(1,'Teclado',100,3);");
        st.executeUpdate(insertArticulos + "(2,'Disco Duro 300Gb',500,5);");
        st.executeUpdate(insertArticulos + "(3,'Mouse',80,3);");
        st.executeUpdate(insertArticulos + "(4,'Memoria USB',140,4);");
        st.executeUpdate(insertArticulos + "(5,'Memoria Ram',290,1);");
        st.executeUpdate(insertArticulos + "(6,'Disco Duro Extraible 250 Gb',650,5);");
        st.executeUpdate(insertArticulos + "(7,'Memoria USB',279,1);");
        st.executeUpdate(insertArticulos + "(8,'DVD Rom',450,2);");
        st.executeUpdate(insertArticulos + "(9,'CD Rom',200,2);");
        st.executeUpdate(insertArticulos + "(10,'Tarjeta de Red',180,3);");
        st2.executeUpdate(instSQLUpdateCreateArtFab);
        listarTabla(st, st2);
    }

    //metodo donde te lista la tabla y se va almacenando en una variable donde se insertará una por una
    static void listarTabla(Statement st, Statement st2) throws SQLException {

        ResultSet rst = st.executeQuery(instSQLConsult);
        int precio;
        String nombreArticulo, nombreFabircante, instSQLInsert, iVA;
        while (rst.next()) {

            nombreArticulo = rst.getString("nombre");
            nombreFabircante = rst.getString("nombre");
            precio = rst.getInt("precio");
            iVA = calIva(precio);
            System.out.println(nombreArticulo + nombreFabircante + precio);
            instSQLInsert = "insert into  ArtFab values(" + "'" + nombreArticulo + "'," + "'" + nombreFabircante + "'," + precio + ",'" + iVA + "');";
            insertTable(st2, instSQLInsert);
        }
    }

    //metodo donde se insertara los valores rescatados
    static void insertTable(Statement st, String instSQLInsert) throws SQLException {
        st.executeUpdate(instSQLInsert);
    }

    //metodo donde se calcula el iva y te retorna un string
    static String calIva(int precio) {
        String seguro = "";
        if (precio < 200) {
            seguro = String.valueOf(10 * precio / 100);
        }
        if (precio < 500) {
            seguro = String.valueOf(8 * precio / 100);
        }
        if (precio < 700) {
            seguro = String.valueOf(6 * precio / 100);
        }
        return seguro;
    }

}
