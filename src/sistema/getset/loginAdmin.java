/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.getset;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import sistema.frmAdmin;
import sistema.programVisualDAL.comexion;

/**
 *
 * @author admin
 */
public class loginAdmin {
    public boolean validarUsuario(JTextField usuario, JPasswordField contra){
   
        try {
           ResultSet rs=null;
           PreparedStatement ps=null;
           
           comexion objetoConexion=new comexion();
           
           String consulta="select * from admin where admin_usuario=? and admin_contrasena=? ;";
           ps=objetoConexion.establecerCOnecion().prepareStatement(consulta);
           
           String contras=String.valueOf(contra.getPassword());
           ps.setString(1, usuario.getText());
           ps.setString(2, contras);
           
           rs=ps.executeQuery();
           
                     
            if(rs.next()){                
                frmAdmin objetoAbrir=new frmAdmin();
                objetoAbrir.setVisible(true);
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
