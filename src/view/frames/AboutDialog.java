package view.frames;

import java.awt.Font;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author conde
 */
public class AboutDialog extends javax.swing.JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form AboutDialog
     */
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
        aboutLbl.setText("Acerca de esta aplicacion:");

        appInfoTxtArea.setColumns(20);
        appInfoTxtArea.setRows(5);
        appInfoTxtArea.setText("Parking App es una aplicación de escritorio diseñada para\nllevar a cabo la administración de un sistema de aparcamien-\nto de vehículos. \n\nAlgunas de las operaciones basicas que cubre son:\n\n- Ingresar los datos de los vehículos a una base de datos\nlocal.\n- Cronometrar el tiempo en el que el vehículo permanece\naparcado.\n- Mostrar el monto que debe adeudar cada cliente de acuerdo\nal tiempo que lleva aparcado su vehiculo.\n- Actualizar la tarifa por hora.\n- Consultar los registros de la recaudacion de la caja y\nguardarla en un archivo de texto.\n- Consultar la información del ingreso y salida de los \nvehículos y guardarla en un archivo de texto.\n\nLo que este sistema no es:\n-No es un sistema contable. Sólo guarda y muestra la \ninformación básica del monto ingresado + el descuento.\n-No es un sistema de impresion de tickets. Ni tiene salida\na otros dispositivos de impresión.\n-No es un sistema de parking profesional. Sólo realiza las\noperaciones básicas antes mencionadas.\n\ndesarrollada por Martín Kun - Java Developer.\ncontacto: martinkunbrc@hotmail.com");
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
