/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sistema;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistema.getset.variablesCarrito;
import sistema.programVisualBL.productosBL;
import sistema.programVisualDAL.comexion;
/**
 *
 * @author admin
 */
public class frmCarrito extends javax.swing.JFrame {
    DefaultTableModel modelo=new DefaultTableModel();
    
    Statement ejecutor=null;
    comexion objConexion=new comexion();
    productosBL objcrud=new productosBL();
    variablesCarrito var=new variablesCarrito();
    float precio,subtotal;
    int cantidad,cliente;
    /**
     * Creates new form frmCarrito
     */
    protected void cargarProductos(String id_cliente){
        modelo.setRowCount(0);
        String datos[]=new String[4];
        String where=" where 1=1 ";
        if(id_cliente.isEmpty()==false){
            where=where+" and id_cliente='"+id_cliente+"' ";
        }
        String sql="select * from carrito "+where+";";
        ResultSet rs;
        try {
            ejecutor=objConexion.establecerCOnecion().createStatement();
            ejecutor.setQueryTimeout(20);
            rs=ejecutor.executeQuery(sql);
            while(rs.next()==true){
                datos[0]=rs.getString(3);
                datos[1]=rs.getString(4);
                datos[2]=rs.getString(5);
                datos[3]=rs.getString(6);
                modelo.addRow(datos);
            }
            tblCarrito.setModel(modelo);
        } catch (Exception e) {
        }
        
    }
    public frmCarrito() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/sistema/supermercado.png")).getImage());
        objConexion.establecerCOnecion();
        var.mostrarProductos(tblProductos);
        modelo.addColumn("Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio($)");
        modelo.addColumn("Precio total");
        modelo.setRowCount(0);
        brnAgregar.setEnabled(false);
        btnBorrar.setEnabled(false);
        txtIdClienteRevibir.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        brnAgregar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnBorrar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCarrito = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEliminarProducto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtIdClienteRevibir = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SUPER-MERCADO");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/recursos/cerrar-sesion.png"))); // NOI18N
        jButton1.setText("Cerrar sesion");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 15, -1, -1));

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Productos", "Marca", "Tamaño", "Stok", "Precio($)"
            }
        ));
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProductos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 92, 815, 220));

        brnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/recursos/carrito-de-comprasmas.png"))); // NOI18N
        brnAgregar.setText("Agregar a carrito");
        brnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(brnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(674, 41, -1, -1));

        jLabel1.setText("Cantidad del producto:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 58, -1, -1));

        jLabel3.setText("Carrito de compras");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 355, -1, -1));

        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/recursos/carrito-de-compraseliminar.png"))); // NOI18N
        btnBorrar.setText("Eliminar producto");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(666, 391, -1, -1));

        tblCarrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Cantidad", "Precio($)", "Precio total($)"
            }
        ));
        tblCarrito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCarritoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblCarrito);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 437, 815, 258));

        jLabel10.setText("Producto:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 58, -1, -1));

        txtProducto.setEditable(false);
        getContentPane().add(txtProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 55, 175, -1));

        jLabel11.setText("Precio:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 58, -1, -1));

        txtPrecio.setEditable(false);
        getContentPane().add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(549, 55, 72, -1));
        getContentPane().add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 55, 66, -1));

        jLabel4.setText("Producto:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 394, -1, -1));

        txtEliminarProducto.setEditable(false);
        getContentPane().add(txtEliminarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 391, 142, -1));

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel5.setText("Productos Apartados ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 352, -1, -1));

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jLabel2.setText("_______________________________________________________________________________________________________________");

        txtIdClienteRevibir.setEditable(false);

        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\admin\\Desktop\\iconos\\deber\\carrito.png")); // NOI18N
        jButton2.setText("Ver carrito Personal");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addContainerGap(249, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtIdClienteRevibir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(268, 268, 268))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(19, 19, 19))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(318, 318, 318)
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(txtIdClienteRevibir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(311, 311, 311))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 710));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked
        var.seleccionarProducto(tblProductos, txtProducto,txtPrecio);
        brnAgregar.setEnabled(true);
        btnBorrar.setEnabled(false);
    }//GEN-LAST:event_tblProductosMouseClicked

    private void brnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnAgregarActionPerformed
        this.cantidad=Integer.parseInt(txtCantidad.getText());
        this.precio=Float.parseFloat(txtPrecio.getText());
        subtotal=this.precio*this.cantidad;
        var.insertarProductosCarrito(txtIdClienteRevibir, txtProducto, txtCantidad, txtPrecio, subtotal);
        cargarProductos(txtIdClienteRevibir.getText());
        brnAgregar.setEnabled(false);
        btnBorrar.setEnabled(false);
    }//GEN-LAST:event_brnAgregarActionPerformed

    private void tblCarritoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCarritoMouseClicked
        
        var.seleccionarProductoCarrito(tblCarrito, txtEliminarProducto);
        brnAgregar.setEnabled(false);
        btnBorrar.setEnabled(true);
    }//GEN-LAST:event_tblCarritoMouseClicked

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        
        var.eliminarProductoCarrito(txtIdClienteRevibir, txtEliminarProducto);
        cargarProductos(txtIdClienteRevibir.getText());
        brnAgregar.setEnabled(false);
        btnBorrar.setEnabled(false);
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        frmUsuario abrir=new frmUsuario();
        abrir.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        cargarProductos(txtIdClienteRevibir.getText());
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmCarrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCarrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCarrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCarrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCarrito().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brnAgregar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblCarrito;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtEliminarProducto;
    public static javax.swing.JTextField txtIdClienteRevibir;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtProducto;
    // End of variables declaration//GEN-END:variables
}
