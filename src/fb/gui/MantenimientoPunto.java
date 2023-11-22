/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package fb.gui;
import fb.daos.PuntoDaoFactory;
import fb.model.Punto;
import fb.util.Constantes;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author USUARIO
 */
public class MantenimientoPunto extends javax.swing.JInternalFrame {

    /**
     * Creates new form MantenimientoPunto
     */
    public MantenimientoPunto() {
        initComponents();
        cargarDatos();
    }

    public void cargarDatos() {
        var lista = PuntoDaoFactory.getFabrica().getPuntoDao(Constantes.ACTUAL).findAll();
        DefaultTableModel modelo = (DefaultTableModel) tbPuntos.getModel();

        modelo.setColumnCount(0);
        modelo.setRowCount(0);
        modelo.addColumn("ID");
        modelo.addColumn("Latitud");
        modelo.addColumn("Longitud");
        modelo.addColumn("Distrito");
        modelo.addColumn("Dirección");
        modelo.addColumn("Estado");
        modelo.addColumn("Tipo");
        modelo.addColumn("Nombre");

        for (Punto p : lista) {
            Object[] fila = new Object[8];
            fila[0] = p.getId();
            fila[1] = p.getLatitud();
            fila[2] = p.getLongitud();
            fila[3] = p.getDistrito();
            fila[4] = p.getNombre();
            fila[5] = p.getDireccion();
            fila[6] = p.getTipo();
            fila[7] = p.getEstado();
            modelo.addRow(fila);
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
        tbPuntos = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        BtnBuscar = new javax.swing.JButton();
        BtnOrdenar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Puntos");

        tbPuntos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbPuntos);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel1.setText("Dirección: ");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        BtnBuscar.setText("Buscar");
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });

        BtnOrdenar.setText("Ordenar por dirección");
        BtnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnOrdenarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)))
                .addGap(12, 12, 12))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnOrdenar)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre)
                    .addComponent(BtnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnOrdenar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try {
            FormularioCliente.codigo="";
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            FormularioCliente obj = new FormularioCliente(topFrame, true);
            obj.setVisible(true);
            cargarDatos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error interno del sistema");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        try {
            int fila = tbPuntos.getSelectedRow();

            if (fila != -1) {
                FormularioCliente.codigo = tbPuntos.getValueAt(fila, 0).toString();
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                FormularioCliente obj = new FormularioCliente(topFrame, true);
                obj.setVisible(true);
                cargarDatos();
            } else {
                JOptionPane.showMessageDialog(this, "No ha seleccionado ninguna fila");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error interno del sistema");
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            int fila = tbPuntos.getSelectedRow();

            if (fila != -1) {
                int dialogResult = JOptionPane.showConfirmDialog (null, "¿Seguro de eliminar?","Aviso",0);
                if(dialogResult == JOptionPane.YES_OPTION){
                    if(PuntoDaoFactory.getFabrica().getPuntoDao(Constantes.ACTUAL).delete(tbPuntos.getValueAt(fila, 0).toString())){
                        JOptionPane.showMessageDialog(this, "Inactivado correctamente");
                    }else{
                        JOptionPane.showMessageDialog(this, "Error interno del sistema");
                    }
                    cargarDatos();
                }
            } else {
                JOptionPane.showMessageDialog(this, "No ha seleccionado ninguna fila");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error interno del sistema");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
        try {
            String nombreBusqueda = txtNombre.getText().trim();
            Punto[] resultadoBusqueda = PuntoDaoFactory.getFabrica().getPuntoDao(Constantes.ACTUAL).findByName(nombreBusqueda);
            mostrarResultados(resultadoBusqueda);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error interno del sistema");
        }
    }//GEN-LAST:event_BtnBuscarActionPerformed

    private void BtnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnOrdenarActionPerformed
        try {      
            PuntoDaoFactory.getFabrica().getPuntoDao(Constantes.ACTUAL).quickSort();
            cargarDatos(); // Recargar los datos después de ordenar
            } catch (Exception ex) {    
                JOptionPane.showMessageDialog(this, "Error interno del sistema");
            }
    }//GEN-LAST:event_BtnOrdenarActionPerformed
        
    
    private void mostrarResultados(Punto[] resultados) {
        DefaultTableModel modelo = (DefaultTableModel) tbPuntos.getModel();

        modelo.setColumnCount(0);
        modelo.setRowCount(0);
        modelo.addColumn("ID");
        modelo.addColumn("Latitud");
        modelo.addColumn("Longitud");
        modelo.addColumn("Distrito");
        modelo.addColumn("Dirección");
        modelo.addColumn("Estado");
        modelo.addColumn("Tipo");
        modelo.addColumn("Nombre");
        
        for (Punto p : resultados) {
            Object[] fila = new Object[8];
            fila[0] = p.getId();
            fila[1] = p.getLatitud();
            fila[2] = p.getLongitud();
            fila[3] = p.getDistrito();
            fila[4] = p.getNombre();
            fila[5] = p.getDireccion();
            fila[6] = p.getTipo();
            fila[7] = p.getEstado();
            modelo.addRow(fila);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JButton BtnOrdenar;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbPuntos;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
