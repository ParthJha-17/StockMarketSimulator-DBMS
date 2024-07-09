/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.stockmarketsimulator;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author parth
 */
public class LoginPage extends javax.swing.JFrame {

    /**
     * Creates new form LoginPage
     */
    
    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/smms";
    private static final String USER = "root";
    private static final String PASS = "FireRage@007";

    // JDBC variables
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    
    
    public LoginPage() {
        initComponents();
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Failed to load MySQL JDBC driver: " + e.getMessage());
    }
    }
    
    private void connect() throws SQLException {
    System.out.println("Connecting to the database...");
    conn = DriverManager.getConnection(DB_URL, USER, PASS);
    System.out.println("Connected to the database successfully!");
}
    
    private void close() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
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

        jLabel1 = new javax.swing.JLabel();
        UserID = new javax.swing.JTextField();
        UserPassword = new javax.swing.JTextField();
        CompanyName = new javax.swing.JTextField();
        CompanyPassword = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        UserLoginButton = new javax.swing.JButton();
        CompanyLoginButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        AdminLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Customer Login");

        UserID.setText("UserID");

        UserPassword.setText("Password");

        CompanyName.setText("Name");

        CompanyPassword.setText("Password");

        jLabel2.setText("Company Login");

        UserLoginButton.setText("LOGIN");
        UserLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserLoginButtonActionPerformed(evt);
            }
        });

        CompanyLoginButton.setText("LOGIN");
        CompanyLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompanyLoginButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Admin Login");

        AdminLogin.setText("LOGIN");
        AdminLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(UserLoginButton)
                        .addGap(12, 12, 12))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(CompanyLoginButton)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CompanyPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UserPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UserID, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(AdminLogin, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(74, 74, 74))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(UserID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(UserPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UserLoginButton)
                    .addComponent(jLabel3))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(AdminLogin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CompanyPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CompanyLoginButton)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AdminLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminLoginActionPerformed
        // Open AdminPage
    AdminPage adminPage = new AdminPage(); // Assuming you have an AdminPage class
    adminPage.setVisible(true);

    // Close the current window
    this.dispose();
    }//GEN-LAST:event_AdminLoginActionPerformed

    private void CompanyLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompanyLoginButtonActionPerformed
        // TODO add your handling code here:
        String companyName = CompanyName.getText();
    String password = CompanyPassword.getText();

    try {
        // Connect to the database
        connect();

        // Prepare SQL statement to fetch company details
        String sql = "SELECT * FROM Company_Database WHERE Stock_Name = ? AND Password = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, companyName);
        stmt.setString(2, password);

        // Execute query
        rs = stmt.executeQuery();

        // Check if company exists
        if (rs.next()) {
            // Retrieve company details
            int listed = rs.getInt("Listed");

            // Display company information
            JOptionPane.showMessageDialog(this, getCompanyInformation(rs, listed));

            // Close the current window
            this.dispose();
        } else {
            // Company not found or invalid credentials
            JOptionPane.showMessageDialog(this, "Invalid company login credentials");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Close database resources
        close();
    }
    }//GEN-LAST:event_CompanyLoginButtonActionPerformed

    private String getCompanyInformation(ResultSet rs, int listed) throws SQLException {
    StringBuilder message = new StringBuilder();

    // Retrieve company details
    String stockName = rs.getString("Stock_Name");
    float price = rs.getFloat("Price");
    int qt = rs.getInt("Qt");
    float pe = rs.getFloat("PE");
    float eps = rs.getFloat("EPS");
    float roe = rs.getFloat("ROE");
    long gstin = rs.getLong("GSTIN");

    // Append company information to message
    message.append("Company Name: ").append(stockName).append("\n");
    message.append("Price: ").append(price).append("\n");
    message.append("Quantity: ").append(qt).append("\n");
    message.append("PE Ratio: ").append(pe).append("\n");
    message.append("EPS: ").append(eps).append("\n");
    message.append("ROE: ").append(roe).append("\n");
    message.append("GSTIN: ").append(gstin).append("\n");

    // Append specific message based on 'Listed' column value
    if (listed == 0) {
        message.append("\nYou are not listed yet!");
    } else if (listed == 1) {
        message.append("\nYou have been listed!");
    }

    return message.toString();
}
    private void UserLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserLoginButtonActionPerformed
        // TODO add your handling code here:
        System.out.println("Inside UserLoginButtonActionPerformed() method");
        String userID = UserID.getText();
        String password = UserPassword.getText();

        try {
            // Connect to the database
            connect();

            // Prepare SQL statement
            String sql = "SELECT * FROM user_database WHERE User_Id = ? AND Password = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, userID);
            stmt.setString(2, password);

            // Execute query
            rs = stmt.executeQuery();

            // Check if user exists
            if (rs.next()) {
                int intID = rs.getInt("User_ID");
                // Open UserPage window
                UserPage userPage = new UserPage(intID);
                userPage.setVisible(true);

                // Close the current window
                this.dispose();
            } else {
                // User not found or invalid credentials
                JOptionPane.showMessageDialog(this, "Invalid user login credentials");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close database resources
            close();
        }
    }//GEN-LAST:event_UserLoginButtonActionPerformed

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
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (ClassNotFoundException ex) {
        java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            LoginPage loginPage = new LoginPage();
            loginPage.setVisible(true);
        }
    });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdminLogin;
    private javax.swing.JButton CompanyLoginButton;
    private javax.swing.JTextField CompanyName;
    private javax.swing.JTextField CompanyPassword;
    private javax.swing.JTextField UserID;
    private javax.swing.JButton UserLoginButton;
    private javax.swing.JTextField UserPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
