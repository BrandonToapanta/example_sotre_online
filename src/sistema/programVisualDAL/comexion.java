/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.programVisualDAL;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author admin
 */

public class comexion {
    Connection conectar=null;
    String usuario = "postgres";
    String contrasenia = "2020";
    String bd="programacion";
    String ip="localhost";
    String Puerto="5432";
    
    String cadena="jdbc:postgresql://"+ip+":"+Puerto+"/"+bd;
// Coneccion de a la base de datos postgres
    public Connection establecerCOnecion(){
        try {
            Class.forName("org.postgresql.Driver");
            conectar=DriverManager.getConnection(cadena,usuario,contrasenia);
            System.out.println("conectado a la base de datos");
        } catch (Exception e) {
            System.out.println("Error al conectarse a la base de datos, error: "+e);
        }
        return conectar;
    }

}
