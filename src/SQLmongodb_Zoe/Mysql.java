package SQLmongodb_Zoe;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.Scanner;

public class Mysql {
    private static Statement sentenciaSQL = null;
    private static Connection conexion = null;

    /** método para conectar con la base de datos */
    final void conectar() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/ad2", "root", "kvMu*0Fi9RY$!Q8D"); // información de nuestra BBDD

        } catch (ClassNotFoundException | SQLException cn) {
            cn.printStackTrace();
        }
    }

    /** método para desconectarse de la base de datos */
    final void desconectar() {

        try {
            sentenciaSQL.close();
            conexion.close();

        } catch (SQLException ex) {
            System.out.println("ERROR AL CERRAR CONEXIÓN CON LA BBDD");
        }
    }

    /** método para coger los datos de la BBDD */
    public void cogerSQL(ArrayList <Usuario>listaUsuarios) {

        String sql;
        ResultSet resultset = null;

        Scanner sc = new Scanner(System.in);

        try {
            conectar();
            sentenciaSQL = conexion.createStatement();

            sql = "select * from usuarios";
            resultset = sentenciaSQL.executeQuery(sql);

            // mientras haya registros para mostrar
            while (resultset.next()) {
                listaUsuarios.add(new Usuario(resultset.getInt("id"),resultset.getString("nombre"),resultset.getString("dni"),resultset.getString("telefono1"),resultset.getString("telefono2"),resultset.getString("localidad"),resultset.getInt("edad")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            desconectar();
            System.out.println("Se han obtenido los datos de la tabla de MySQL");
        }
    }
}
