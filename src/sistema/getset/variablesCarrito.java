
package sistema.getset;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import sistema.programVisualDAL.comexion;

public class variablesCarrito {
    
    private static int id;
    private static int cantidad;
    private static String nombre;
    private static String marca;
    private static String tamano;
    private static int stock;
    private static float precio;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        variablesCarrito.id = id;
    }

    public static int getCantidad() {
        return cantidad;
    }

    public static void setCantidad(int cantidad) {
        variablesCarrito.cantidad = cantidad;
    }
    
    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        variablesCarrito.nombre = nombre;
    }

    public static String getMarca() {
        return marca;
    }

    public static void setMarca(String marca) {
        variablesCarrito.marca = marca;
    }

    public static String getTamano() {
        return tamano;
    }

    public static void setTamano(String tamano) {
        variablesCarrito.tamano = tamano;
    }

    public static int getStock() {
        return stock;
    }

    public static void setStock(int stock) {
        variablesCarrito.stock = stock;
    }

    public static float getPrecio() {
        return precio;
    }

    public static void setPrecio(float precio) {
        variablesCarrito.precio = precio;
    }

    

//    metodo para mostrar datos en la tabla
    public void mostrarProductos(JTable paraTablaProductos){
        comexion objetoConexion=new comexion();
        DefaultTableModel modelo=new DefaultTableModel();
        
        String sql="";
//      crear colmnas de la tabla a mostrar
        modelo.addColumn("Producto");
        modelo.addColumn("Marca");
        modelo.addColumn("Tamaño");
        modelo.addColumn("Stock");
        modelo.addColumn("Precio");
        
        paraTablaProductos.setModel(modelo);
//        ejecutar SQL ,rebisar datos e imprimir
        sql="select*FROM producto";
//        numero de columnas que se nesesitan
        String [] datos = new String[5];
        
        Statement st;
        
        try {
            st=objetoConexion.establecerCOnecion().createStatement();
            
            ResultSet rs= st.executeQuery(sql);
            
            while (rs.next()) {
                
                datos[0]=rs.getString(2);
                datos[1]=rs.getString(3);
                datos[2]=rs.getString(4);
                datos[3]=rs.getString(5);
                datos[4]=rs.getString(6);
                
                modelo.addRow(datos);
            }
            paraTablaProductos.setModel(modelo);
            
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
    }
//  Funccion para seleccionar datos
    public void seleccionarProducto(JTable paraTablaProductos,JTextField paraNombre,JTextField paraPrecio){
        try {
            int fila=paraTablaProductos.getSelectedRow();
            
            if (fila>=0) {
                
                paraNombre.setText(paraTablaProductos.getValueAt(fila, 0).toString());
                paraPrecio.setText(paraTablaProductos.getValueAt(fila, 4).toString());
            }else{
                JOptionPane.showMessageDialog(null,"Fila no seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: "+e.toString());
        }
    }
    
//    funcion para introducir productos al carrito
    public void insertarProductosCarrito(JTextField paraUser, JTextField paraNombre,JTextField paraCantidad,JTextField paraPrecio,float paraSubtotal){
    
        setId(Integer.parseInt(paraUser.getText()));
        setNombre(paraNombre.getText());
        setCantidad(Integer.parseInt(paraCantidad.getText()));
        setPrecio(Float.parseFloat(paraPrecio.getText()));
        
        comexion objetoConexion=new comexion();
        
        String consulta="insert into carrito (id_cliente,carrito_item,carrito_cantidad,carrito_preciounitario,carrito_subtotal)"
                    + "values(?,?,?,?,"+paraSubtotal+");";
        
        try {
            CallableStatement cs= objetoConexion.establecerCOnecion().prepareCall(consulta);
            cs.setInt(1, getId());
            cs.setString(2, getNombre());
            cs.setInt(3, getCantidad());
            cs.setFloat(4, getPrecio());
            
            cs.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: "+e.toString());
        }
    }
//    Funccion para seleccionar datos
    public void seleccionarProductoCarrito(JTable paraTablaProductos,JTextField paraNombre){
        try {
            int fila=paraTablaProductos.getSelectedRow();
            
            if (fila>=0) {
                
                paraNombre.setText(paraTablaProductos.getValueAt(fila, 0).toString());
            }else{
                JOptionPane.showMessageDialog(null,"Fila no seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: "+e.toString());
        }
    }
    
    //    Funcion para eliminar datos
    public void eliminarProductoCarrito(JTextField paraCodigo, JTextField paraNombre){
    
        setId(Integer.parseInt(paraCodigo.getText()));
        setNombre(paraNombre.getText());
        
        comexion objetoConexion=new comexion();
        
        String consulta="DELETE FROM carrito where id_cliente=? and carrito_item=?";
        
        try {
            CallableStatement cs= objetoConexion.establecerCOnecion().prepareCall(consulta);
            cs.setInt(1, getId());
            cs.setString(2, getNombre());
            cs.execute();
            JOptionPane.showMessageDialog(null,"Se elimino correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: "+e.toString());
        }
    }
}
