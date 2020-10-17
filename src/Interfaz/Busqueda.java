/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Controlador.Buscar;
import Modelo.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pablo
 */
public class Busqueda extends javax.swing.JFrame {

    public static Connection conector;
    public static Buscar busqueda1;
    public Busqueda() {
        initComponents();
        Conexion con = new Conexion("jdbc:sqlserver://localhost:1433;databaseName=TAREA_MVC;user=usrTIENDA;password=123456;");
        //Conexion conexion = new Conexion("jdbc:sqlserver://LAPTOP-1GA811GS:1433;database=TAREA_MVC; integratedSecurity=true;");
        conector = con.Conectar();
        busqueda1 = new Buscar(conector);
        llenarTabla();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    
    public void llenarTabla() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            JTlibros.setModel(modelo);
            ResultSet resultados = busqueda1.buscarLibro(JTFbuscar.getText());
            ResultSetMetaData metadata_resultados = resultados.getMetaData();
            int columnas = metadata_resultados.getColumnCount();

            modelo.addColumn("ID");
            modelo.addColumn("Género");
            modelo.addColumn("Año");
            modelo.addColumn("Nombre");
            modelo.addColumn("Autor");
            modelo.addColumn("Páginas");

            while (resultados.next()) {
                Object[] filas = new Object[columnas];
                for (int i = 0; i < columnas; i++) {
                    filas[i] = resultados.getObject(i + 1);
                }
                modelo.addRow(filas);
            }

        } catch (Exception ex) {
            System.err.println(ex.toString());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JTlibros = new javax.swing.JTable();
        JTFbuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JTlibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Género", "Año", "Nombre", "Autor", "Páginas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(JTlibros);

        JTFbuscar.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                JTFbuscarCaretUpdate(evt);
            }
        });
        JTFbuscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                JTFbuscarFocusLost(evt);
            }
        });
        JTFbuscar.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                JTFbuscarInputMethodTextChanged(evt);
            }
        });
        JTFbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFbuscarActionPerformed(evt);
            }
        });
        JTFbuscar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                JTFbuscarPropertyChange(evt);
            }
        });
        JTFbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTFbuscarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTFbuscarKeyTyped(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Buscar:");
        jLabel1.setToolTipText("");

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTFbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTFbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFbuscarActionPerformed
        llenarTabla();
    }//GEN-LAST:event_JTFbuscarActionPerformed

    private void JTFbuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFbuscarKeyPressed

    }//GEN-LAST:event_JTFbuscarKeyPressed

    private void JTFbuscarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_JTFbuscarPropertyChange

    }//GEN-LAST:event_JTFbuscarPropertyChange

    private void JTFbuscarInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_JTFbuscarInputMethodTextChanged

    }//GEN-LAST:event_JTFbuscarInputMethodTextChanged

    private void JTFbuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFbuscarKeyTyped

    }//GEN-LAST:event_JTFbuscarKeyTyped

    private void JTFbuscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTFbuscarFocusLost

    }//GEN-LAST:event_JTFbuscarFocusLost

    private void JTFbuscarCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_JTFbuscarCaretUpdate
        llenarTabla();
    }//GEN-LAST:event_JTFbuscarCaretUpdate

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int rol = JF.getRol();
        if(rol == 1){
            Menu menu = new Menu();
        menu.setVisible(true);
        this.setVisible(false);
        }else{
            menuUsuario men2 = new menuUsuario();
            men2.setVisible(true);
            this.setVisible(false);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Busqueda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTFbuscar;
    private javax.swing.JTable JTlibros;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
