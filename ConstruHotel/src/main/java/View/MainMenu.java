/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
/**
 *
 * @author BBoyp
 */
public class MainMenu extends javax.swing.JFrame {

    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        initComponents();
        initStyles();
    }
    
    private void initStyles(){
        hotelName.putClientProperty( "FlatLaf.styleClass", "h00" );
        hotelName.setForeground(Color.white);
        //contactInformationTitle.putClientProperty( "FlatLaf.style", "font: bold $h2.regular.font" );
        contactInformationTitle.setForeground(Color.white);
    }
    
    
    
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        hotelName = new javax.swing.JLabel();
        buttonsPanel = new javax.swing.JPanel();
        btnReserve = new javax.swing.JButton();
        btnPromo = new javax.swing.JButton();
        contactInformationTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnAdmin = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        btnUserProfile = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        contentPanel = new javax.swing.JPanel();
        imageLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 650));

        background.setBackground(new java.awt.Color(255, 255, 255));

        header.setBackground(new java.awt.Color(51, 153, 255));

        hotelName.setFont(new java.awt.Font("Eras Bold ITC", 1, 48)); // NOI18N
        hotelName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        hotelName.setText("5 STARS");
        hotelName.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        hotelName.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(hotelName, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(271, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(hotelName, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        buttonsPanel.setBackground(new java.awt.Color(102, 204, 255));
        buttonsPanel.setPreferredSize(new java.awt.Dimension(312, 502));

        btnReserve.setBackground(new java.awt.Color(51, 153, 255));
        btnReserve.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        btnReserve.setForeground(new java.awt.Color(255, 255, 255));
        btnReserve.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngegg.png"))); // NOI18N
        btnReserve.setText("Reservar ");
        btnReserve.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 0)));
        btnReserve.setBorderPainted(false);
        btnReserve.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReserve.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReserve.setIconTextGap(25);
        btnReserve.setPreferredSize(new java.awt.Dimension(574, 512));

        btnPromo.setBackground(new java.awt.Color(51, 153, 255));
        btnPromo.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        btnPromo.setForeground(new java.awt.Color(255, 255, 255));
        btnPromo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/giftbox.png"))); // NOI18N
        btnPromo.setText("Promociones ");
        btnPromo.setToolTipText("");
        btnPromo.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 5, 1, 1, new java.awt.Color(0, 0, 0)));
        btnPromo.setBorderPainted(false);
        btnPromo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPromo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPromo.setIconTextGap(15);
        btnPromo.setPreferredSize(new java.awt.Dimension(574, 512));

        contactInformationTitle.setBackground(new java.awt.Color(255, 255, 255));
        contactInformationTitle.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        contactInformationTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        contactInformationTitle.setText("Información de contacto");

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(0, 0, 0));
        jTextArea1.setRows(5);
        jTextArea1.setText("  \n  Col. Imaginaria cale X por Y y Z, New Weston\n\n                hotelgenial@correo.com\n\n                      Tel: 999 99 99 999");
        jScrollPane1.setViewportView(jTextArea1);

        btnAdmin.setBackground(new java.awt.Color(51, 153, 255));
        btnAdmin.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        btnAdmin.setForeground(new java.awt.Color(255, 255, 255));
        btnAdmin.setText("Admin");
        btnAdmin.setToolTipText("");
        btnAdmin.setBorder(new javax.swing.border.MatteBorder(null));
        btnAdmin.setBorderPainted(false);
        btnAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnLogin.setBackground(new java.awt.Color(51, 153, 255));
        btnLogin.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Engrane.png"))); // NOI18N
        btnLogin.setText("Log in");
        btnLogin.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 0)));
        btnLogin.setBorderPainted(false);
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLogin.setIconTextGap(30);

        btnUserProfile.setBackground(new java.awt.Color(51, 153, 255));
        btnUserProfile.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        btnUserProfile.setForeground(new java.awt.Color(255, 255, 255));
        btnUserProfile.setText("Perfil");
        btnUserProfile.setToolTipText("");
        btnUserProfile.setBorder(new javax.swing.border.MatteBorder(null));
        btnUserProfile.setBorderPainted(false);
        btnUserProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnLogOut.setBackground(new java.awt.Color(51, 153, 255));
        btnLogOut.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        btnLogOut.setForeground(new java.awt.Color(255, 255, 255));
        btnLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Engrane.png"))); // NOI18N
        btnLogOut.setText("Log out");
        btnLogOut.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 0)));
        btnLogOut.setBorderPainted(false);
        btnLogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogOut.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLogOut.setIconTextGap(30);

        javax.swing.GroupLayout buttonsPanelLayout = new javax.swing.GroupLayout(buttonsPanel);
        buttonsPanel.setLayout(buttonsPanelLayout);
        buttonsPanelLayout.setHorizontalGroup(
            buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(contactInformationTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonsPanelLayout.createSequentialGroup()
                .addGroup(buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnReserve, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, buttonsPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(buttonsPanelLayout.createSequentialGroup()
                                .addComponent(btnUserProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                            .addComponent(btnLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)))
                    .addComponent(btnPromo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        buttonsPanelLayout.setVerticalGroup(
            buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnReserve, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnPromo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(contactInformationTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUserProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        contentPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatMaterialLighterIJTheme.setup();
 
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }
    
    public void showPanel(JPanel panel){
        panel.setSize(485, 567);
        panel.setLocation(0, 0);
        
        contentPanel.removeAll();
        contentPanel.revalidate();
        contentPanel.add(panel,BorderLayout.CENTER);
        contentPanel.repaint();
    }
    
    public void showAdminButton(boolean isAdmin){
        if (isAdmin) {
            btnAdmin.setVisible(true);
        }else{
            btnAdmin.setVisible(false);
        }
    }
    
    public void showProfileButton(boolean isLogedIn){
        if (isLogedIn) {
            btnUserProfile.setVisible(true);
        }else{
            btnUserProfile.setVisible(false);
        }
    }
    
    public void showLogInButton(boolean isLogedIn){
        if (isLogedIn) {
            btnLogin.setVisible(false);
        }else{
            btnLogin.setVisible(true);
        }
    }
    
    public void showLogOutButton(boolean isLogedIn){
        if (isLogedIn) {
            btnLogOut.setVisible(true);
        }else{
            btnLogOut.setVisible(false);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    public javax.swing.JButton btnAdmin;
    public javax.swing.JButton btnLogOut;
    public javax.swing.JButton btnLogin;
    public javax.swing.JButton btnPromo;
    public javax.swing.JButton btnReserve;
    public javax.swing.JButton btnUserProfile;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JLabel contactInformationTitle;
    public javax.swing.JPanel contentPanel;
    private javax.swing.JPanel header;
    public javax.swing.JLabel hotelName;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
