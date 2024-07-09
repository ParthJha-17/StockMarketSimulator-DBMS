/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.stockmarketsimulator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author parth
 */
public class IPO extends javax.swing.JFrame {
    private int userID;
    /**
     * Creates new form IPO
     */
    public IPO(int userID) {
        this.userID = userID;
        initComponents();
        populateIPOList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        IPOList = new java.awt.List();
        jLabel1 = new javax.swing.JLabel();
        ApplyButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        IPOList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IPOListMouseClicked(evt);
            }
        });

        jLabel1.setText("IPOs Availiable");

        ApplyButton.setText("APPLY");
        ApplyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApplyButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(IPOList, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(ApplyButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IPOList, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(ApplyButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IPOListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IPOListMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_IPOListMouseClicked

    private void ApplyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApplyButtonActionPerformed
        // TODO add your handling code here:
        String selectedStockName = IPOList.getSelectedItem();
    
    if (selectedStockName != null) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/smms", "root", "FireRage@007")) {
            // Retrieve Stock_ID for the selected stock name
            String stockIdQuery = "SELECT Stock_ID FROM Company_Database WHERE Stock_Name = ?";
            PreparedStatement stockIdStatement = connection.prepareStatement(stockIdQuery);
            stockIdStatement.setString(1, selectedStockName);
            ResultSet stockIdResult = stockIdStatement.executeQuery();
            
            if (stockIdResult.next()) {
                int stockId = stockIdResult.getInt("Stock_ID");
                
                // Check if the entry already exists in IPO_Apply
                String checkQuery = "SELECT * FROM IPO_Apply WHERE User_Id = ? AND Stock_ID = ?";
                PreparedStatement checkStatement = connection.prepareStatement(checkQuery);
                checkStatement.setInt(1, userID);
                checkStatement.setInt(2, stockId);
                ResultSet existingResult = checkStatement.executeQuery();
                
                if (existingResult.next()) {
                    javax.swing.JOptionPane.showMessageDialog(this, "You have already applied for this stock.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                } else {
                    System.out.println("Check");
                    // Insert record into IPO_Apply table
                    String insertQuery = "INSERT INTO IPO_Apply (User_Id, Stock_ID) VALUES (?, ?)";
                    PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
                    insertStatement.setInt(1, userID);
                    insertStatement.setInt(2, stockId);
                    insertStatement.executeUpdate();
                    
                    javax.swing.JOptionPane.showMessageDialog(this, "Applied successfully!", "Success", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                    
                }
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Stock ID not found for selected stock name.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
            
            stockIdResult.close();
            stockIdStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Error applying IPO: " + ex.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    } else {
        javax.swing.JOptionPane.showMessageDialog(this, "Please select a stock from the list.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_ApplyButtonActionPerformed

    private void populateIPOList() {
        // Retrieve names of companies with listed = 0 from the database
         try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/smms", "root", "FireRage@007")) {
            String sql = "SELECT Stock_Name FROM Company_Database WHERE Listed = 0";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            // Clear existing items in IPOList

            // Add retrieved company names to IPOList
            while (resultSet.next()) {
                String companyName = resultSet.getString("Stock_Name");
                IPOList.add(companyName);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle database connection or query exception
            // You can show an error message dialog if needed
            javax.swing.JOptionPane.showMessageDialog(this, "Error retrieving company names: " + ex.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
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
            java.util.logging.Logger.getLogger(IPO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IPO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IPO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IPO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            // Check if command line arguments are provided
            if (args.length > 0) {
                // Convert the first argument to an integer (assuming it's the user ID)
                int userID = Integer.parseInt(args[0]);
                // Instantiate BuyStocks with the provided user ID
                IPO ipoWindow = new IPO(userID);
                ipoWindow.setVisible(true);
            } else {
                // If no user ID is provided, display an error message
                System.err.println("Error: No user ID provided.");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ApplyButton;
    private java.awt.List IPOList;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
