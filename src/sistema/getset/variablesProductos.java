
package sistema.getset;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import sistema.programVisualDAL.comexion;


public class variablesProductos {
    private static int id;
    private static String nombre;
    private static String marca;
    private static String tamano;
    private static int stock;
    private static float precio;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        variablesProductos.id = id;
    }

    public static int getStock() {
        return stock;
    }

    public static void setStock(int stock) {
        variablesProductos.stock = stock;
    }

    public static float getPrecio() {
        return precio;
    }

    public static void setPrecio(float precio) {
        variablesProductos.precio = precio;
    }

//    metodo para mostrar datos en la tabla
    public void mostrarProductos(JTable paraTablaProductos){
        comexion objetoConexion=new comexion();
        DefaultTableModel modelo=new DefaultTableModel();
        
        String sql="";
//      crear colmnas de la tabla a mostrar
        modelo.addColumn("Codigo");
        modelo.addColumn("Producto");
        modelo.addColumn("Marca");
        modelo.addColumn("Tamaño");
        modelo.addColumn("Stock");
        modelo.addColumn("Precio");
        
        paraTablaProductos.setModel(modelo);
//        ejecutar SQL ,rebisar datos e imprimir
        sql="select*FROM producto";
//        numero de columnas que se nesesitan
        String [] datos = new String[6];
        
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
                
                modelo.addRow(datos);
            }
            paraTablaProductos.setModel(modelo);
            
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
    }
//  Funccion para seleccionar datos
    public void seleccionarProducto(JTable paraTablaProductos,JTextField paraId,JTextField paraNombre,JTextField paraMarca,JTextField paraTamano,JTextField paraStok,JTextField paraPrecio){
        try {
            int fila=paraTablaProductos.getSelectedRow();
            
            if (fila>=0) {
                
                paraId.setText(paraTablaProductos.getValueAt(fila, 0).toString());
                paraNombre.setText(paraTablaProductos.getValueAt(fila, 1).toString());
                paraMarca.setText(paraTablaProductos.getValueAt(fila, 2).toString());
                paraTamano.setText(paraTablaProductos.getValueAt(fila, 3).toString());
                paraStok.setText(paraTablaProductos.getValueAt(fila, 4).toString());
                paraPrecio.setText(paraTablaProductos.getValueAt(fila, 5).toString());
            }else{
                JOptionPane.showMessageDialog(null,"Fila no seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: "+e.toString());
        }
    }
//    Funcion para modificar datos
    public void modificarProductos(JTextField paraCodigo,JTextField paraNombre,JTextField paraMarca,JTextField paraTamano,JTextField paraStok,JTextField paraPrecio){
    
        setId(Integer.parseInt(paraCodigo.getText()));
        setNombre(paraNombre.getText());
        setMarca(paraMarca.getText());
        setTamano(paraTamano.getText());
        setStock(Integer.parseInt(paraStok.getText()));
        setPrecio(Float.parseFloat(paraPrecio.getText()));
        
        comexion objetoConexion=new comexion();
        
        String consulta="update producto set producto_nombre=?,producto_marca=?, producto_tamano=?,producto_stock=?,producto_precio=? where id_productos=?;";
        
        try {
            CallableStatement cs= objetoConexion.establecerCOnecion().prepareCall(consulta);
            cs.setString(1, getNombre());
            cs.setString(2, getMarca());
            cs.setString(3, getTamano());
            cs.setInt(4, getStock());
            cs.setFloat(5, getPrecio());
            cs.setInt(6, getId());
            
            cs.execute();
            JOptionPane.showMessageDialog(null,"Se modifico correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: "+e.toString());
        }
    }
//    Funcion para eliminar datos
    public void eliminarProducto(JTextField paraCodigo){
    
        setId(Integer.parseInt(paraCodigo.getText()));
        
        comexion objetoConexion=new comexion();
        
        String consulta="DELETE FROM producto where id_productos=?";
        
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
