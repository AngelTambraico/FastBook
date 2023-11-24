/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package fb.gui;

import fb.daos.AutorDaoFactory;
import fb.daos.LibroDaoFactory;
import fb.model.Libro;
import fb.util.Constantes;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class MantenimientoLibro extends javax.swing.JInternalFrame {

    public MantenimientoLibro() {
        initComponents();
        cargarDatos();
    }

    public void cargarDatos() {
        var lista = LibroDaoFactory.getFabrica().getLibroDao(Constantes.ACTUAL).findAll();
        DefaultTableModel modelo = (DefaultTableModel) tbLibros.getModel();

        modelo.setColumnCount(0);
        modelo.setRowCount(0);
        modelo.addColumn("Codigo");
        modelo.addColumn("Autor");
        modelo.addColumn("Titulo");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");
        modelo.addColumn("Estado");

        for (Libro l : lista) {
            Object[] fila = new Object[6];
            fila[0] = l.getId();
            fila[1] = AutorDaoFactory.getFabrica().getAutorDao(Constantes.ACTUAL).findById(l.getIdAutor()).getNombreCompleto();
            fila[2] = l.getTitulo();
            fila[3] = l.getPrecio();
            fila[4] = l.getStock();
            fila[5] = l.getEstado();
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
        tbLibros = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnOrdenar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Libros");

        tbLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbLibros);

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

        lblTitulo.setText("Titulo:");

        txtTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTituloActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnOrdenar.setText("Ordenar por Titulo");
        btnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnAgregar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnActualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar)))
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnOrdenar)
                    .addComponent(lblTitulo))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addGap(34, 34, 34)
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
            FormularioLibro.codigo="";
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                FormularioLibro obj = new FormularioLibro(topFrame, true);
                obj.setVisible(true);
                cargarDatos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error interno del sistema");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        try {
            int fila = tbLibros.getSelectedRow();

            if (fila != -1) {
                FormularioLibro.codigo = tbLibros.getValueAt(fila, 0).toString();
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                FormularioLibro obj = new FormularioLibro(topFrame, true);
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
            int fila = tbLibros.getSelectedRow();

            if (fila != -1) {
                int dialogResult = JOptionPane.showConfirmDialog (null, "¿Seguro de eliminar?","Aviso",0);
                if(dialogResult == JOptionPane.YES_OPTION){
                    if(LibroDaoFactory.getFabrica().getLibroDao(Constantes.ACTUAL).delete(tbLibros.getValueAt(fila, 0).toString())){
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

    private void txtTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTituloActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
        String nombreBusqueda = txtTitulo.getText().trim();
        Libro[] resultadoBusqueda = LibroDaoFactory.getFabrica().getLibroDao(Constantes.ACTUAL).findByName(nombreBusqueda);
        mostrarResultados(resultadoBusqueda);
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error interno del sistema");
    }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarActionPerformed
        try {
            LibroDaoFactory.getFabrica().getLibroDao(Constantes.ACTUAL).quickSort();
            cargarDatos(); // Recargar los datos después de ordenar
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error interno del sistema");
        }
    }//GEN-LAST:event_btnOrdenarActionPerformed
    
    private void mostrarResultados(Libro[] resultados) {
        DefaultTableModel modelo = (DefaultTableModel) tbLibros.getModel();
        
        modelo.setColumnCount(0);
        modelo.setRowCount(0);
        modelo.addColumn("Codigo");
        modelo.addColumn("Codigo de Autor");
        modelo.addColumn("Titulo");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");
        modelo.addColumn("Estado");

        for (Libro l : resultados) {
            Object[] fila = new Object[6];
            fila[0] = l.getId();
            fila[1] = l.getIdAutor();
            fila[2] = l.getTitulo();
            fila[3] = l.getPrecio();
            fila[4] = l.getStock();
            fila[5] = l.getEstado();
            modelo.addRow(fila);
        }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnOrdenar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tbLibros;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}