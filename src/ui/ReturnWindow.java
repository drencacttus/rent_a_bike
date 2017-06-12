/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;
import model.Admin;
import model.Bike;
import model.BikeType;
import model.Client;
import model.DB;

/**
 *
 * @author CacTrainer
 */
public class ReturnWindow extends javax.swing.JFrame {

    /**
     * Creates new form ReturnWindow
     */
    public ReturnWindow() {
        
        initComponents();
        setLocationRelativeTo(null);
        
        cmbPersonalNumber.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent event) {
                
                if(event.getKeyCode() != 27) {
                    
                    refreshList();
                }
                else {
                
                    cmbPersonalNumber.setPopupVisible(false);
                }
            }
        });
        
        try {
    
            carryingClients = DB.getCarryingClients();
            bikeTypes = DB.getBikeTypes();
            allBikes = DB.getAllBikes();
        }
        catch(SQLException ex) {

            //TODO: Alert
        }
        
        cmbPersonalNumber.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(cmbPersonalNumber.getSelectedItem() != null)
                    loadClient((Client)cmbPersonalNumber.getSelectedItem());
            }
        });
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        cmbPersonalNumber = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblLeaseTime = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblReturnTime = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblTotalTime = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblPayment = new javax.swing.JLabel();
        btnReturn = new javax.swing.JToggleButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Return bike");
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        cmbPersonalNumber.setEditable(true);

        jLabel1.setText("Personal number:");

        jLabel2.setText("Lease time:");

        lblLeaseTime.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblLeaseTime.setText("--");

        jLabel4.setText("Return time:");

        lblReturnTime.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblReturnTime.setText("--");

        jLabel6.setText("Total time:");

        lblTotalTime.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTotalTime.setText("--");

        jLabel8.setText("Price:");
        jLabel8.setToolTipText("");

        lblPrice.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPrice.setText("--");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel10.setText("Payment:");
        jLabel10.setToolTipText("");

        lblPayment.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblPayment.setText("--");

        btnReturn.setText("Return");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbPersonalNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblLeaseTime)
                                    .addComponent(lblReturnTime)
                                    .addComponent(lblTotalTime)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPrice)
                                    .addComponent(lblPayment)
                                    .addComponent(btnReturn))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                            .addComponent(jSeparator1))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbPersonalNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblLeaseTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblReturnTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblTotalTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrice)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(lblPayment))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReturn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed

        returnBike();
    }//GEN-LAST:event_btnReturnActionPerformed

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
            java.util.logging.Logger.getLogger(ReturnWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnReturn;
    private javax.swing.JComboBox<String> cmbPersonalNumber;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblLeaseTime;
    private javax.swing.JLabel lblPayment;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblReturnTime;
    private javax.swing.JLabel lblTotalTime;
    // End of variables declaration//GEN-END:variables

    private Admin   admin = null;
    private Client  loadedClient = null;
    private float   payment;
    
    private ArrayList<Client>   carryingClients;
    private ArrayList<BikeType> bikeTypes;
    private ArrayList<Bike>     allBikes;

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    
    private void refreshList() {
    
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        String cmbQuery = ((JTextComponent)cmbPersonalNumber.getEditor().getEditorComponent()).getText();
        
        for(Client currentClient : carryingClients)
            if(currentClient.getPersonalNumber().contains(cmbQuery))
                dcbm.addElement(currentClient);
        
        cmbPersonalNumber.setModel(dcbm);
        
        cmbPersonalNumber.setSelectedIndex(-1);
        ((JTextComponent)cmbPersonalNumber.getEditor().getEditorComponent()).setText(cmbQuery);
    
        if(dcbm.getSize() > 0)
            cmbPersonalNumber.setPopupVisible(true);
    }
    
    private void loadClient(Client client) {
    
        loadedClient = client;
        float price = getPriceForBike(client.getBikeId());
        
        Date leaseDate = new Date(client.getLeaseTime() * 1000);
        Date returnDate = new Date();
        
        long totalTimeMinutes = (returnDate.getTime() - leaseDate.getTime()) / 1000 / 60;
        
        payment = calculatePayment(price, totalTimeMinutes);
        
        
        String totalHours = (totalTimeMinutes > 60) ? String.valueOf(totalTimeMinutes / 60) : "0";
        String totalMinutes = (totalTimeMinutes % 60) < 10 ? "0" + (totalTimeMinutes % 60) : String.valueOf(totalTimeMinutes % 60);
        
        SimpleDateFormat sdf = new SimpleDateFormat("EE, HH:mm");
        
        lblLeaseTime.setText(sdf.format(leaseDate));
        lblReturnTime.setText(sdf.format(returnDate));
        lblTotalTime.setText(totalHours + ":" + totalMinutes);
        lblPrice.setText(String.valueOf(price));
        lblPayment.setText(String.valueOf(payment));
    }
    
    private float getPriceForBike(int bikeId) {
    
        for(BikeType b : bikeTypes) {
        
            if(b.getId() == bikeId)
                return b.getPrice();
        }
        
        return 0.5f;
    }
    
    private float calculatePayment(float price, long timeMinutes) {
    
        int quarters = (int)(timeMinutes / 15);
        
        if(timeMinutes > 60) {
        
            return quarters * price / 4;
        }
        else {
        
            return price;
        }
    }
    
    private void returnBike() {
    
        try {
            
            loadedClient.setPrice(payment, false);
            loadedClient.setReturnTime(System.currentTimeMillis(), true);
            
            for(Bike b : allBikes)
                if(b.getId() == loadedClient.getBikeId())
                    b.setStatus(false);
            
            JOptionPane.showMessageDialog(null, "Bike successfully returned", "Success", JOptionPane.INFORMATION_MESSAGE);
            setVisible(false);
        }
        catch(SQLException ex) {
        
            JOptionPane.showMessageDialog(null, "Failed to access database", "Server error", JOptionPane.ERROR_MESSAGE);
        }
        catch(NullPointerException ex) {
                    
            JOptionPane.showMessageDialog(null, "No client selected", "Server error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
