/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlavati.view;

import hlavati.controller.Obrada;
import hlavati.controller.ObradaVozac;
import hlavati.model.Operater;
import hlavati.model.Vozac;
import hlavati.utility.MyException;
import hlavati.utility.Utility;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Luka
 */
public class FormaVozaci extends PomocneMetode<Vozac> {

    private ObradaVozac obrada;

    /**
     * Creates new form FormaVozaci
     */
    public FormaVozaci() {
        initComponents();
        setTitle(Utility.getNazivAplikacije() + " Vozači");
        obrada = new ObradaVozac();
        ucitaj();
    }

    @Override
    protected void ucitaj() {
        DefaultListModel<Vozac> model = new DefaultListModel<>();
        obrada.getVozaci().forEach((vozac) -> {
            model.addElement((Vozac) vozac);
        });
        lista.setModel(model);
        lista.repaint();
    }

    @Override
    protected void spremi(Vozac v) {
        if (!kontrola(v)) {
            return;
        }

        try {
            obrada.spremi(v);
        } catch (MyException ex) {
            JOptionPane.showMessageDialog(null, ex.getPoruka());
            return;
        }

        ucitaj();
    }

    @Override
    protected boolean kontrola(Vozac v) {
        return kontrolaIme(v) && kontrolaPrezime(v) && kontrolaOIB(v) && kontrolaSpola(v);
    }

    private boolean kontrolaIme(Vozac v) {
        if (txtIme.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Obavezno ime!");
            return false;
        }
        if (txtIme.getText().matches(".*\\d.*")) {
            JOptionPane.showMessageDialog(null, "Ime ne može sadržavati broj!");
            return false;
        }
        v.setIme(txtIme.getText());
        return true;
    }

    private boolean kontrolaPrezime(Vozac v) {
        if (txtPrezime.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Obavezno prezime!");
            return false;
        }
        if (txtPrezime.getText().matches(".*\\d.*")) {
            JOptionPane.showMessageDialog(null, "Prezime ne može sadržavati broj!");
            return false;
        }
        v.setPrezime(txtPrezime.getText());
        return true;
    }

    private boolean kontrolaSpola(Vozac v) {

        if (rbtnM.isSelected()) {
            v.setSpol(rbtnM.getText());
        }
        if (rbtnZ.isSelected()) {
            v.setSpol(rbtnZ.getText());
        }
        if (rbtnO.isSelected()) {
            v.setSpol(rbtnO.getText());
        }

        return true;
    }

    private boolean kontrolaOIB(Vozac v) {
        if (!checkOIB(txtOIB.getText())) {
            JOptionPane.showMessageDialog(null, "OIB nije važeći!");
            return false;
        }
        v.setOib(txtOIB.getText());
        return true;
    }

    public static boolean checkOIB(String oib) {

        if (oib.length() != 11) {
            return false;
        }

        try {
            Long.parseLong(oib);
        } catch (NumberFormatException e) {
            return false;
        }

        int a = 10;
        for (int i = 0; i < 10; i++) {
            a = a + Integer.parseInt(oib.substring(i, i + 1));
            a = a % 10;
            if (a == 0) {
                a = 10;
            }
            a *= 2;
            a = a % 11;
        }
        int kontrolni = 11 - a;
        if (kontrolni == 10) {
            kontrolni = 0;
        }

        return kontrolni == Integer.parseInt(oib.substring(10));
    }

    @Override
    protected void postaviVrijednosti(Vozac v) {
        txtIme.setText(v.getIme());
        txtPrezime.setText(v.getPrezime());
        if (v.getSpol().equals(rbtnM.getText())) {
            rbtnM.setSelected(true);
        }
        if (v.getSpol().equals(rbtnZ.getText())) {
            rbtnZ.setSelected(true);
        }
        if (v.getSpol().equals(rbtnO.getText())) {
            rbtnO.setSelected(true);
        }
        txtOIB.setText(v.getOib());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroup = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPrezime = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtOIB = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        rbtnM = new javax.swing.JRadioButton();
        rbtnZ = new javax.swing.JRadioButton();
        rbtnO = new javax.swing.JRadioButton();
        btnDodaj = new javax.swing.JButton();
        btnPromjeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        txtTrazi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lista.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lista);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Podaci"));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setText("Ime");

        jLabel2.setText("Prezime");

        jLabel3.setText("OIB");

        jLabel4.setText("Spol");

        btnGroup.add(rbtnM);
        rbtnM.setText("M");

        btnGroup.add(rbtnZ);
        rbtnZ.setText("Ž");

        btnGroup.add(rbtnO);
        rbtnO.setText("Ostalo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtOIB, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rbtnM, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtnZ, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtnO, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOIB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnM))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnZ)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnO)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        btnDodaj.setText("Dodaj");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnPromjeni.setText("Promjeni");
        btnPromjeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromjeniActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obrisi");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        txtTrazi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTraziKeyReleased(evt);
            }
        });

        jLabel6.setText("Traži");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTrazi)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(btnDodaj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPromjeni)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnObrisi)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTrazi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDodaj)
                            .addComponent(btnPromjeni)
                            .addComponent(btnObrisi))
                        .addContainerGap(39, Short.MAX_VALUE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        Vozac v = new Vozac();
        spremi(v);
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnPromjeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjeniActionPerformed
        Vozac v = lista.getSelectedValue();
        if (v == null) {
            JOptionPane.showMessageDialog(null, "Prvo odaberite stavku");
            return;
        }

        spremi(v);
    }//GEN-LAST:event_btnPromjeniActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        Vozac v = lista.getSelectedValue();
        if (v == null) {
            JOptionPane.showMessageDialog(null, "Prvo odaberite stavku");
            return;
        }
        if (JOptionPane.showConfirmDialog(
                null, //roditelj, bude null
                "Sigurno obrisati " + v.getIme() + " " + v.getPrezime() + "?", //tijelo dijaloga
                "Brisanje smjera", // naslov
                JOptionPane.YES_NO_OPTION, //vrsta opcija
                JOptionPane.QUESTION_MESSAGE) //ikona
                == JOptionPane.NO_OPTION) {
            return;
        }

        try {
            obrada.brisi(v);
        } catch (MyException ex) {
            JOptionPane.showMessageDialog(null, ex.getPoruka());
            return;
        }

        ucitaj();
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void listaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaValueChanged
        if (evt.getValueIsAdjusting()) {
            return;
        }
        Vozac v = lista.getSelectedValue();
        if (v == null) {
            return;
        }
        postaviVrijednosti(v);
    }//GEN-LAST:event_listaValueChanged

    private void txtTraziKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTraziKeyReleased
        DefaultListModel<Vozac> model = new DefaultListModel<>();
        obrada.getVozaci(txtTrazi.getText().trim()).forEach(
                (vozac) -> {
                    model.addElement((Vozac) vozac);
                });
        lista.setModel(model);
        lista.repaint();

    }//GEN-LAST:event_txtTraziKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.ButtonGroup btnGroup;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPromjeni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Vozac> lista;
    private javax.swing.JRadioButton rbtnM;
    private javax.swing.JRadioButton rbtnO;
    private javax.swing.JRadioButton rbtnZ;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtOIB;
    private javax.swing.JTextField txtPrezime;
    private javax.swing.JTextField txtTrazi;
    // End of variables declaration//GEN-END:variables

}
