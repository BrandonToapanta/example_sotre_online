package sistema.programVisualBL;
import java.sql.Connection;
import javax.swing.JOptionPane;
import sistema.programVisualDAL.comexion;
import java.sql.ResultSet;
import sistema.getset.variablesProductos;
public class productosBL extends comexion{
    java.sql.Statement st;
    ResultSet rs;
    variablesProductos var=new variablesProductos();
    
    public void insertarProducto(String nombre, String marca, String tamano, int stock, float precio){
//        comexion con = sitema.comexion;
        try {
            //conectamos la base de datos
            Connection conexion=establecerCOnecion();
            //crea un onjeto para sentencias SQL
            st=conexion.createStatement();
            String sql="insert into producto(producto_nombre,producto_marca,producto_tamano,"
                    + "producto_stock,producto_precio) "
                    + "values('"+nombre+"','"+marca+"','"+tamano+"',"+stock+","+precio+");";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null,"El producto se guardo correctamente", "Mensaje",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"El producto no se guardo "+e, "Mensaje",JOptionPane.ERROR_MESSAGE);
        }
    }

}
