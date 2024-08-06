/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import com.mycompany.projetoloja.Cliente;
import com.mycompany.projetoloja.LojaOnline;
import com.mycompany.projetoloja.Pedido;
import com.mycompany.projetoloja.PedidosDAO;
import com.mycompany.projetoloja.Produto;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author mateus
 */
public class TelaRealizarPedido extends javax.swing.JFrame {

    /**
     * Creates new form TelaRealizarPedido
     */
    public TelaRealizarPedido() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jTEditProd.getModel();
        jTEditProd.setRowSorter(new TableRowSorter(modelo));
        
        DefaultTableModel modelo2 = (DefaultTableModel) jTPedidos.getModel();
        jTPedidos.setRowSorter(new TableRowSorter(modelo2));
        
        readJTable();
        readJTable2();
    }
    
        public void readJTable(){
                DefaultTableModel modelo = (DefaultTableModel) jTEditProd.getModel();
                modelo.setNumRows(0);
                LojaOnline loja = new LojaOnline();

                for(Produto p: loja.readProd()){

                    modelo.addRow(new Object[]{
                        p.getId(),
                        p.getNome(),
                        p.getPreco(),
                        p.getDescricao()
                    });
                }
            }
        public void readJTable2(){
                DefaultTableModel modelo2 = (DefaultTableModel) jTPedidos.getModel();
                modelo2.setNumRows(0);
                LojaOnline loja = new LojaOnline();
                PedidosDAO pdao = new PedidosDAO();

                for(Pedido p: pdao.readPed()){

                    modelo2.addRow(new Object[]{
                        p.getId(),
                        p.getCliente().getId(),
                        p.getStatus(),
                        
                    });
                }
            }
    
    
    public void readJTableForDesc(String nomeprod){
            DefaultTableModel modelo = (DefaultTableModel) jTEditProd.getModel();
            modelo.setNumRows(0);
            LojaOnline loja = new LojaOnline();

            for(Produto p: loja.readProdForDesc(nomeprod)){

                modelo.addRow(new Object[]{
                    p.getId(),
                    p.getNome(),
                    p.getPreco(),
                    p.getDescricao()
                });
            }
    }
    
    public void readJTable(String nomeprod){
            DefaultTableModel modelo = (DefaultTableModel) jTPedidos.getModel();
            modelo.setNumRows(0);
            LojaOnline loja = new LojaOnline();

            for(Produto p: loja.readProdForDesc(nomeprod)){

                modelo.addRow(new Object[]{
                    p.getId(),
                    p.getNome(),
                    p.getPreco(),
                    p.getDescricao()
                });
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

        jButton1 = new javax.swing.JButton();
        tfBusca = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTEditProd = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTPedidos = new javax.swing.JTable();
        tfIdPed = new javax.swing.JTextField();
        tfIdProd = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        tfQtd = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTEditProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "Preço", "Descrição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTEditProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTEditProdMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTEditProd);

        jTPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "IdPedido", "IdCliente", "Status"
            }
        ));
        jTPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTPedidosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTPedidos);

        jButton3.setText("Realizar Pedido");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText("Id Pedido");

        jLabel2.setText("Id Produto");

        jLabel3.setText("Quantidade");

        jLabel4.setText("Busca de produtos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(tfQtd, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(tfIdProd)
                    .addComponent(tfIdPed))
                .addGap(113, 113, 113)
                .addComponent(jButton3)
                .addContainerGap(116, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(131, 131, 131))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfIdPed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfIdProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(2, 2, 2)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTEditProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTEditProdMouseClicked
    
        if(jTEditProd.getSelectedRow() != -1){
            tfIdProd.setText(jTEditProd.getValueAt(jTEditProd.getSelectedRow(), 0).toString());
        }
    }//GEN-LAST:event_jTEditProdMouseClicked

    private void jTPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTPedidosMouseClicked
     if(jTPedidos.getSelectedRow() != -1){
            tfIdPed.setText(jTPedidos.getValueAt(jTPedidos.getSelectedRow(), 0).toString());
        }
    }//GEN-LAST:event_jTPedidosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        readJTableForDesc(tfBusca.getText());
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Pedido ped = new Pedido();
        Produto prod = new Produto();
        PedidosDAO pedDao = new PedidosDAO();
        
        int idProd = Integer.parseInt(tfIdProd.getText());
        int quantidade = Integer.parseInt(tfQtd.getText());
        
        prod.setId(idProd);
        ped.setProdutos(prod);
        ped.setId(Integer.parseInt(tfIdPed.getText()));
        ped.setQuantidade(quantidade);
        
        pedDao.RealizarPedido(ped);
        
        
        tfQtd.setText("");
        tfIdProd.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaRealizarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRealizarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRealizarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRealizarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRealizarPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTEditProd;
    private javax.swing.JTable jTPedidos;
    private javax.swing.JTextField tfBusca;
    private javax.swing.JTextField tfIdPed;
    private javax.swing.JTextField tfIdProd;
    private javax.swing.JTextField tfQtd;
    // End of variables declaration//GEN-END:variables
}