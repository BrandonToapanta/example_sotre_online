
package sistema.getset;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import sistema.frmCarrito;
import sistema.programVisualDAL.comexion;

public class login {
    private static int id;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        login.id = id;
    }
    
   
   public boolean validarUsuario(JTextField usuario, JPasswordField contra){
   
        try {
           ResultSet rs=null;
           PreparedStatement ps=null;
           
           comexion objetoConexion=new comexion();
           
           String consulta="select * from cliente where cliente_usuario=? and cliente_contrasena=? ;";
           ps=objetoConexion.establecerCOnecion().prepareStatement(consulta);
           
           String contras=String.valueOf(contra.getPassword());
           ps.setString(1, usuario.getText());
           ps.setString(2, contras);
           
           rs=ps.executeQuery();
           
           String [] codigo=new String[1];
           
            if(rs.next()){
                codigo[0]=rs.getString(1);
                frmCarrito objetoAbrir=new frmCarrito();
                objetoAbrir.setVisible(true);
                objetoAbrir.txtIdClienteRevibir.setText(codigo[0]);
                return true;   
            }
            else{
                JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrecta");
                return false;
            }
           
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error: "+e.toString());
           return false;
       }
   } 
    
}
