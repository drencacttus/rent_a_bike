/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Report;

/**
 *
 * @author CacTrainer
 */
public class ReportWindow extends javax.swing.JFrame {

    private String bodyContents;
    private JLabel lblReport = new JLabel();
    private JButton btnExport = new JButton("Export");
    
    /**
     * Creates new form ReportWindow
     */
    public ReportWindow() {
        initComponents();
        setLocationRelativeTo(null);
        
        bodyContents = Report.generateHTML();
        
        String content = "<html><body width=\"" + ((getWidth() - 20) / 1.3f) + "px\">" +
                         bodyContents +
                         "</table></body></html>";
        
        setLayout(new BorderLayout());
        
        lblReport.setText(content);
        lblReport.setVerticalAlignment(SwingConstants.TOP);
        lblReport.setBounds(0, 0, getWidth(), getHeight());
        JScrollPane scroller = new JScrollPane(lblReport, 
                                                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
                                                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        this.getContentPane().add(scroller);
        
        btnExport.setSize(100, 30);
        btnExport.setLocation(getWidth() / 2 - btnExport.getWidth() / 2,
                              getHeight() - btnExport.getHeight() - 10);
        
        
        this.getContentPane().add(btnExport, BorderLayout.SOUTH);
        
        btnExport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                exportReport();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Report");
        setType(java.awt.Window.Type.UTILITY);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 353, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 346, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        
        String content = "<html><body width=\"" + ((getWidth() - 20)/ 1.3f) + "px\">" +
                         bodyContents +
                         "</table></body></html>";
        
        lblReport.setText(content);
    }//GEN-LAST:event_formComponentResized

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
            java.util.logging.Logger.getLogger(ReportWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    private void exportReport() {
    
        JFileChooser jfc = new JFileChooser();
        if(jfc.showSaveDialog(this)== JFileChooser.APPROVE_OPTION) {
        
            String exportContents = "<html><body width=\"100%\">" +
                                    bodyContents +
                                    "</body></html>";
            
            try{
                String fileName = jfc.getSelectedFile().getAbsolutePath() + ".html";
                
                PrintWriter printWriter = new PrintWriter(fileName);
                printWriter.print(exportContents);
                printWriter.close();
                JOptionPane.showMessageDialog(null, "Report generated successfully", "Report generated", JOptionPane.INFORMATION_MESSAGE);
            }
            catch(IOException ex) {
            
                JOptionPane.showMessageDialog(null, "Failed to write in specified file", "Error wiring file", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
