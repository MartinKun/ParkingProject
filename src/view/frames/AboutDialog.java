package view.frames;

import java.awt.Font;

import helpers.LanguageManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class AboutDialog extends javax.swing.JDialog {

	private static final long serialVersionUID = 1L;

	private LanguageManager languageManager = LanguageManager.getInstance();
	
    public AboutDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void initComponents() {

        logoLbl = new javax.swing.JLabel();
        logoLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/parkingapp.png")));
        aboutLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        appInfoTxtArea = new javax.swing.JTextArea();
        appInfoTxtArea.setEditable(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        aboutLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        aboutLbl.setText(languageManager.getProperty("about_this_app") + ":");

        appInfoTxtArea.setColumns(20);
        appInfoTxtArea.setRows(5);
        appInfoTxtArea.setText(languageManager.getProperty("app_description"));
        appInfoTxtArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));
        jScrollPane1.setViewportView(appInfoTxtArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aboutLbl)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(logoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(logoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(aboutLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aboutLbl;
    private javax.swing.JTextArea appInfoTxtArea;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logoLbl;
    // End of variables declaration//GEN-END:variables
}
