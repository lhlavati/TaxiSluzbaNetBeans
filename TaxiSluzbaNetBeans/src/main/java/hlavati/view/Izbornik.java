/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlavati.view;

import hlavati.controller.ObradaOperater;
import hlavati.model.Operater;
import hlavati.model.Vozac;
import hlavati.utility.Utility;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Luka
 */
public class Izbornik extends javax.swing.JFrame {

    /**
     * Creates new form Izbornik
     */
    public Izbornik() {
        initComponents();
        setTitle(Utility.getNazivAplikacije());
        new Vrijeme().start();
        new RadnoVrijeme().start();
        Pozdrav();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSat = new javax.swing.JLabel();
        lblDatum = new javax.swing.JLabel();
        lblRadnoVrijeme = new javax.swing.JLabel();
        lblPozdrav = new javax.swing.JLabel();
        lblVrijemeRada = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnVozaci = new javax.swing.JButton();
        btnVozila = new javax.swing.JButton();
        btnVozi = new javax.swing.JButton();
        btnVoznja = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblSat.setText("Sat");

        lblDatum.setText("Datum");

        lblRadnoVrijeme.setText("00:00:00");

        lblPozdrav.setText("Dobar dan!");

        lblVrijemeRada.setText("Vrijeme rada:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Baza"));

        btnVozaci.setText("Vozaci");
        btnVozaci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVozaciActionPerformed(evt);
            }
        });

        btnVozila.setText("Vozila");
        btnVozila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVozilaActionPerformed(evt);
            }
        });

        btnVozi.setText("Vozi");
        btnVozi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoziActionPerformed(evt);
            }
        });

        btnVoznja.setText("Voznje");
        btnVoznja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoznjaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnVozaci)
                .addGap(18, 18, 18)
                .addComponent(btnVozila)
                .addGap(18, 18, 18)
                .addComponent(btnVozi)
                .addGap(18, 18, 18)
                .addComponent(btnVoznja)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVozaci)
                    .addComponent(btnVozila)
                    .addComponent(btnVozi)
                    .addComponent(btnVoznja))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblVrijemeRada)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblRadnoVrijeme))
                            .addComponent(lblPozdrav))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 231, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDatum)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblSat)
                                .addGap(8, 8, 8)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSat)
                    .addComponent(lblPozdrav))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDatum)
                    .addComponent(lblRadnoVrijeme)
                    .addComponent(lblVrijemeRada))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVozaciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVozaciActionPerformed
        new FormaVozaci().setVisible(true);
    }//GEN-LAST:event_btnVozaciActionPerformed

    private void btnVoziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoziActionPerformed
        new FormaVozi().setVisible(true);
    }//GEN-LAST:event_btnVoziActionPerformed

    private void btnVoznjaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoznjaActionPerformed
        new FormaVoznje().setVisible(true);
    }//GEN-LAST:event_btnVoznjaActionPerformed

    private void btnVozilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVozilaActionPerformed
        new FormaVozila().setVisible(true);
    }//GEN-LAST:event_btnVozilaActionPerformed

    private class Vrijeme extends Thread {

        SimpleDateFormat dfSat = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat dfDatum = new SimpleDateFormat("dd.MM.YYYY.");

        @Override
        public void run() {

            lblSat.setText(dfSat.format(new Date()));
            lblDatum.setText(dfDatum.format(new Date()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {

            }
            run();
        }

    }

    private class RadnoVrijeme extends Thread {

        int h = 0;
        int m = 0;
        int s = 0;

        @Override
        public void run() {
            if (s > 59) {
                s = 0;
                m++;
            }
            if (m > 59) {
                m = 0;
                h++;
            }

            lblRadnoVrijeme.setText(String.format("%02d:%02d:%02d", h, m, s));
            s++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

            run();
        }

    }

    private void Pozdrav() {
        Operater o = new Operater();
        if (Integer.parseInt(lblSat.getText().substring(0, 2)) < 12) {
            lblPozdrav.setText("Dobro jutro!");
        } else if (Integer.parseInt(lblSat.getText().substring(0, 2)) < 24 && Integer.parseInt(lblSat.getText().substring(0, 2)) >= 18) {
            lblPozdrav.setText("Dobra večer!");
        } else {
            lblPozdrav.setText("Dobar dan!");
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVozaci;
    private javax.swing.JButton btnVozi;
    private javax.swing.JButton btnVozila;
    private javax.swing.JButton btnVoznja;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDatum;
    private javax.swing.JLabel lblPozdrav;
    private javax.swing.JLabel lblRadnoVrijeme;
    private javax.swing.JLabel lblSat;
    private javax.swing.JLabel lblVrijemeRada;
    // End of variables declaration//GEN-END:variables
}