
package sistema.getset;

import com.toedter.calendar.JDateChooser;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import sistema.programVisualDAL.comexion;

public class variablesUsuarios {
    private static int id;
    private static String nombre;
    private static String cedula;
    private static String genero;
    private static String fecha;
    private static String direccion;
    private static String usuario;
    private static String contra;
    private static String correo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    //    metodo para mostrar datos en la tabla
    public void mostrarUsuarios(JTable paraTablaProductos){
        comexion objetoConexion=new comexion();
        DefaultTableModel modelo=new DefaultTableModel();
        
        String sql="";
//      crear colmnas de la tabla a mostrar
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Cedula");
        modelo.addColumn("Genero");
        modelo.addColumn("Fecha de nacimineto");
        modelo.addColumn("Direccion");
        modelo.addColumn("Usuario");
        modelo.addColumn("Contaseña");
        modelo.addColumn("E-mail");
        
        paraTablaProductos.setModel(modelo);
//        ejecutar SQL ,rebisar datos e imprimir
        sql="select*FROM cliente";
//        numero de columnas que se nesesitan
        String [] datos = new String[9];
        
        Statement st;
        
        try {
            st=objetoConexion.establecerCOnecion().createStatement();
            
            ResultSet rs= st.executeQuery(sql);
            
            while (rs.next()) {
                
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                datos[5]=rs.getString(6);
                datos[6]=rs.getString(7);
                datos[7]=rs.getString(8);
                datos[8]=rs.getString(9);
                
                modelo.addRow(datos);
            }
            paraTablaProductos.setModel(modelo);
            
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
    }
//    Funccion para insertar datos 
    public void insertarUsuario(JTextField paraNombre,JTextField paraCedula,String paraGenero,String paraFecha,JTextField paraDireccion,JTextField paraUser,JTextField paraContra,JTextField paraEmail){
    
        setNombre(paraNombre.getText());
        setCedula(paraCedula.getText());
        setDireccion(paraDireccion.getText());
        setUsuario(paraUser.getText());
        setContra(paraContra.getText());
        setCorreo(paraEmail.getText());
        
        comexion objetoConexion=new comexion();
        
        String consulta="insert into cliente(cliente_nombres,cliennte_cedula,cliente_genero,cliente_fechanacimiente,"
                    + "cliente_direccion,cliente_usuario,cliente_contrasena,cliente_correo) "
                    + "values(?,?,'"+paraGenero+"','"+paraFecha+"',?,?,?,?);";
        
        try {
            CallableStatement cs= objetoConexion.establecerCOnecion().prepareCall(consulta);
            cs.setString(1, getNombre());
            cs.setString(2, getCedula());
            cs.setString(3, getDireccion());
            cs.setString(4, getUsuario());
            cs.setString(5, getContra());
            cs.setString(6, getCorreo());
            
            cs.execute();
            JOptionPane.showMessageDialog(null,"Se modifico correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: "+e.toString());
        }
    }
    
    //  Funccion para seleccionar datos
    public void seleccionarUsuario(JTable paraTablaProductos,JTextField paraId,JTextField paraNombre,JTextField paraCedula,JTextField paraDireccion,JTextField paraUser,JTextField paraContra,JTextField paraEmail){
        try {
            int fila=paraTablaProductos.getSelectedRow();
            
            if (fila>=0) {
                
                paraId.setText(paraTablaProductos.getValueAt(fila, 0).toString());
                paraNombre.setText(paraTablaProductos.getValueAt(fila, 1).toString());
                paraCedula.setText(paraTablaProductos.getValueAt(fila, 2).toString());
                paraDireccion.setText(paraTablaProductos.getValueAt(fila, 5).toString());
                paraUser.setText(paraTablaProductos.getValueAt(fila, 6).toString());
                paraContra.setText(paraTablaProductos.getValueAt(fila, 7).toString());
                paraEmail.setText(paraTablaProductos.getValueAt(fila, 8).toString());
            }else{
                JOptionPane.showMessageDialog(null,"Fila no seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: "+e.toString());
        }
    }
//    Funcion para modificar datos
    public void modificarUsuario(JTextField paraId,JTextField paraNombre,JTextField paraCedula,String paraGenero,String paraFecha,JTextField paraDireccion,JTextField paraUser,JTextField paraContra,JTextField paraEmail){
    
        setId(Integer.parseInt(paraId.getText()));
        setNombre(paraNombre.getText());
        setCedula(paraCedula.getText());
        setDireccion(paraDireccion.getText());
        setUsuario(paraUser.getText());
        setContra(paraContra.getText());
        setCorreo(paraEmail.getText());
        
        comexion objetoConexion=new comexion();
        
        String consulta="update cliente set cliente_nombres=?,cliennte_cedula=?,cliente_genero=?,cliente_fechanacimiente=?,cliente_direccion=?,cliente_usuario=?,cliente_contrasena=?,cliente_correo=? where id_cliente=?;";
        
        try {
            CallableStatement cs= objetoConexion.establecerCOnecion().prepareCall(consulta);
            cs.setString(1, getNombre());
            cs.setString(2, getCedula());
            cs.setString(3, getGenero());
            cs.setString(4, getFecha());
            cs.setString(5, getDireccion());
            cs.setString(6, getUsuario());
            cs.setString(7, getContra());
            cs.setString(8, getCorreo());
            cs.setInt(9, getId());
            
            cs.execute();
            JOptionPane.showMessageDialog(null,"Se modifico correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: "+e.toString());
        }
    }
//    Funcion para eliminar datos
    public void eliminarUsuario(JTextField paraCodigo){
    
        setId(Integer.parseInt(paraCodigo.getText()));
        
        comexion objetoConexion=new comexion();
        
        String consulta="DELETE FROM cliente where id_cliente=?";
        
        try {
            CallableStatement cs= objetoConexion.establecerCOnecion().prepareCall(consulta);
            cs.setInt(1, getId());
            
            cs.execute();
            JOptionPane.showMessageDialog(null,"Se elimino correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: "+e.toString());
        }
    }
}
