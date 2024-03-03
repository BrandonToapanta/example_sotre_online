/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package sistema;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import sistema.getset.variablesUsuarios;
import sistema.programVisualBL.productosBL;
import sistema.programVisualDAL.comexion;
/**
 *
 * @author admin
 */
public class frmAdminUsuarios extends javax.swing.JFrame {
    
    comexion objConexion=new comexion();
    productosBL objcrud=new productosBL();
    variablesUsuarios var=new variablesUsuarios();
    /** Creates new form frmAdminUsuarios */
    public frmAdminUsuarios() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/sistema/supermercado.png")).getImage());
        var.mostrarUsuarios(tblCliente);
        limpiar();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtGenero = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtFecha = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtContra = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SUPER-MERCADO");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/recursos/atras.png"))); // NOI18N
        jButton1.setText("Atras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 14, -1, -1));

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/recursos/agregar.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 205, -1, -1));

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/recursos/editar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 205, -1, -1));

        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/recursos/eliminar.png"))); // NOI18N
        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 205, -1, -1));

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombres", "Cedula", "Genero", "Fecha de nacimiento", "Direccion", "Usuario", "Contraseña", "E-mail"
            }
        ));
        tblCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCliente);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 239, 1122, 333));

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/recursos/desactivar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(757, 205, -1, -1));

        jLabel1.setText("Codigo:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 57, -1, -1));

        txtCodigo.setEditable(false);
        getContentPane().add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 54, 73, -1));

        jLabel2.setText("Nombres:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 97, -1, -1));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 94, 149, -1));

        jLabel3.setText("Cedula:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 137, -1, -1));
        getContentPane().add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 134, 100, -1));

        jLabel4.setText("Genero:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 177, -1, -1));

        txtGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino", "Otros" }));
        getContentPane().add(txtGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 174, -1, -1));

        jLabel5.setText("Fecha de nacimiento:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 20, -1, -1));

        txtFecha.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(536, 14, 128, -1));

        jLabel6.setText("Direccion:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 57, -1, -1));
        getContentPane().add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(536, 54, 160, -1));

        jLabel7.setText("Usuario:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 97, -1, -1));
        getContentPane().add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(536, 94, 160, -1));

        jLabel8.setText("Contaseña:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 137, -1, -1));
        getContentPane().add(txtContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(536, 134, 160, -1));

        jLabel9.setText("E-mail:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 177, -1, -1));
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(536, 174, 160, -1));

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1140, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String genero=txtGenero.getSelectedItem().toString();
        String date=((JTextField)txtFecha.getDateEditor().getUiComponent()).getText();
        var.insertarUsuario(txtNombre, txtCedula, genero, date, txtDireccion, txtUser, txtContra, txtEmail);
        var.mostrarUsuarios(tblCliente);
        limpiar();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        String genero=txtGenero.getSelectedItem().toString();
        String date=((JTextField)txtFecha.getDateEditor().getUiComponent()).getText();
        var.modificarUsuario(txtCodigo,txtNombre, txtCedula, genero, date, txtDireccion, txtUser, txtContra, txtEmail);
        var.mostrarUsuarios(tblCliente);
        limpiar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void tblClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClienteMouseClicked
        
//        String genero=String.valueOf(tblCliente.getValueAt(tblCliente.getSelectedRow(),3).toString());
        String ls_fecha=String.valueOf(tblCliente.getValueAt(tblCliente.getSelectedRow(),4));
        SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date fecha;
        try {
            fecha=(java.util.Date) s.parse(ls_fecha);
            txtFecha.setDate(fecha);
        } catch (ParseException e) {
        }
        var.seleccionarUsuario(tblCliente, txtCodigo,txtNombre, txtCedula, txtDireccion, txtUser, txtContra, txtEmail);
        btnAgregar.setEnabled(false);
        btnEditar.setEnabled(true);
        btnBorrar.setEnabled(true);
    }//GEN-LAST:event_tblClienteMouseClicked

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        var.eliminarUsuario(txtCodigo);
        var.mostrarUsuarios(tblCliente);
        limpiar();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        frmAdmin abrir=new frmAdmin();
        abrir.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    public void limpiar(){
        txtCodigo.setText("");
        txtNombre.setText("");
        txtCedula.setText("");
        txtDireccion.setText("");
        txtUser.setText("");
        txtContra.setText("");
        txtEmail.setText("");
        txtFecha.setDate(null);
        txtGenero.setSelectedIndex(0);
        
        btnAgregar.setEnabled(true);
        btnEditar.setEnabled(false);
        btnBorrar.setEnabled(false);
    }
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
            java.util.logging.Logger.getLogger(frmAdminUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAdminUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAdminUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAdminUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAdminUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCliente;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtContra;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private com.toedter.calendar.JDateChooser txtFecha;
    private javax.swing.JComboBox<String> txtGenero;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables

}