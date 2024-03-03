
package sistema.programVisualBL;
import java.sql.Connection;
import javax.swing.JOptionPane;
import sistema.programVisualDAL.comexion;

public class registroUsuariosBL extends comexion{
    java.sql.Statement st;
    
    public void insertarUsuario(String nombre,String cedula,String genero,String fechaNacimiento,String direccion,String usuario,String contra,String correo){
        try {
            //conectamos la base de datos
            Connection conexion=establecerCOnecion();
            //crea un onjeto para sentencias SQL
            st=conexion.createStatement();
            String sql="insert into cliente(cliente_nombres,cliennte_cedula,cliente_genero,cliente_fechanacimiente,"
                    + "cliente_direccion,cliente_usuario,cliente_contrasena,cliente_correo) "
                    + "values('"+nombre+"','"+cedula+"','"+genero+"','"+fechaNacimiento+"','"+direccion+"','"+usuario+"','"+contra+"','"+correo+"');";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null,"El registro se guardo correctamente", "Mensaje",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"El registro no se guardo "+e, "Mensaje",JOptionPane.ERROR_MESSAGE);
        }
    }
}
