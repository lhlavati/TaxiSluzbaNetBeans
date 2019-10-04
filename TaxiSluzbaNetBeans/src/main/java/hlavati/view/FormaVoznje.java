/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlavati.view;

import hlavati.controller.ObradaVozi;
import hlavati.controller.ObradaVoznja;
import hlavati.model.Voznja;
import hlavati.model.Vozi;
import hlavati.utility.MyException;
import hlavati.utility.Utility;
import java.math.BigDecimal;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Luka
 */
public class FormaVoznje extends PomocneMetode<Voznja> {

    private ObradaVoznja obrada;

    /**
     * Creates new form FormaVoznje
     */
    public FormaVoznje() {
        initComponents();
        obrada = new ObradaVoznja();
        setTitle(Utility.getNazivAplikacije());
        dtpPocetak.setDateTimeStrict(Utility.convertToLocalDateTimeViaInstant(new Date()));
        dtpKraj.setDateTimeStrict(Utility.convertToLocalDateTimeViaInstant(new Date()));
        ucitajVozi();
        ucitaj();
    }

    @Override
    protected void ucitaj() {
        DefaultListModel<Voznja> model = new DefaultListModel<>();
        obrada.getVoznje().forEach(
                (voznja) -> {
                    model.addElement(voznja);
                });

        lista.setModel(model);
        lista.repaint();
    }

    @Override
    protected void spremi(Voznja v) {
        if (!kontrola(v)) {
            return;
        }

        v.setBrojMob(txtBrojMobitela.getText());
        v.setBrojPutnika((int) spBrojPutnika.getValue());

        try {
            obrada.spremi(v);
        } catch (MyException ex) {
            JOptionPane.showMessageDialog(null, ex.getPoruka());
            return;
        }

        ucitaj();
    }

    @Override
    protected boolean kontrola(Voznja v) {
        return kontrolaPolaziste(v) && kontrolaOdrediste(v) && kontrolaCijene(v) && kontrolaDatumPocetka(v) && kontrolaDatumKraja(v) && kontrolaVozi(v);
    }

    private boolean kontrolaPolaziste(Voznja v) {
        if (txtPolaziste.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Obavezna adresa polazista!");
            return false;
        }
        v.setAdresaPolazista(txtPolaziste.getText());
        return true;
    }

    private boolean kontrolaOdrediste(Voznja v) {
        if (txtOdrediste.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Obavezna adresa odredišta!");
            return false;
        }
        v.setAdresaOdredista(txtOdrediste.getText());
        return true;
    }

    private boolean kontrolaCijene(Voznja v) {
        if (txtCijena.getText().trim().matches("^[a-zA-Z]*$")) {
            JOptionPane.showMessageDialog(null, "Cijena mora biti broj!");
            return false;
        }

        if (new BigDecimal(txtCijena.getText()).compareTo(BigDecimal.ZERO) < 0) {
            JOptionPane.showMessageDialog(null, "Cijena mora biti veća od 0!");
            return false;
        }
        try {
            v.setCijena(new BigDecimal(txtCijena.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cijena nije važeća!");
        }
        return true;
    }

    private boolean kontrolaDatumPocetka(Voznja v) {
        if (dtpPocetak.getDateTimeStrict() == null) {
            JOptionPane.showMessageDialog(null, "Obavezan unos vremena pocetka voznje!");
            return false;
        }
        v.setPocetakVoznje(Utility.convertToDateViaSqlTimestamp(dtpPocetak.getDateTimeStrict()));
        return true;
    }

    private boolean kontrolaDatumKraja(Voznja v) {
        if (dtpKraj.getDateTimeStrict() == null) {
            JOptionPane.showMessageDialog(null, "Obavezan unos vremena kraja voznje!");
            return false;
        }
        v.setKrajVoznje(Utility.convertToDateViaSqlTimestamp(dtpKraj.getDateTimeStrict()));
        return true;
    }

    private boolean kontrolaVozi(Voznja v) {
        if (cmbVozi.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Odabavezan odabir Vozi!");
            return false;
        }
        v.setVozi((Vozi) cmbVozi.getSelectedItem());
        return true;
    }

    @Override
    protected void postaviVrijednosti(Voznja v) {
        txtPolaziste.setText(v.getAdresaPolazista());
        txtOdrediste.setText(v.getAdresaOdredista());
        txtBrojMobitela.setText(v.getBrojMob() == null ? "" : v.getBrojMob().trim());
        txtCijena.setText(v.getCijena() == null ? "" : v.getCijena().toString());
        spBrojPutnika.setValue(v.getBrojPutnika());
        dtpPocetak.setDateTimeStrict(Utility.convertToLocalDateTimeViaInstant(v.getPocetakVoznje()));
        dtpKraj.setDateTimeStrict(Utility.convertToLocalDateTimeViaInstant(v.getKrajVoznje()));
        cmbVozi.setSelectedItem(v.getVozi());
    }

    private void ucitajVozi() {
        DefaultComboBoxModel<Vozi> m = new DefaultComboBoxModel<>();
        new ObradaVozi().getVozi().forEach((vozi) -> {
            m.addElement(vozi);
        });
        cmbVozi.setModel(m);
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
        txtPolaziste = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtOdrediste = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtBrojMobitela = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCijena = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<>();
        dtpPocetak = new com.github.lgooddatepicker.components.DateTimePicker();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dtpKraj = new com.github.lgooddatepicker.components.DateTimePicker();
        cmbVozi = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        spBrojPutnika = new javax.swing.JSpinner();
        btnDodaj = new javax.swing.JButton();
        btnPromjeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtTrazi = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Adresa polazišta");

        jLabel2.setText("Adresa odredišta");

        jLabel3.setText("Broj mobitela");

        jLabel4.setText("Broj putnika");

        jLabel5.setText("Cijena");

        lista.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lista);

        jLabel6.setText("Početak vožnje");

        jLabel7.setText("Kraj vožnje");

        jLabel8.setText("Vozac, vozilo");

        spBrojPutnika.setModel(new javax.swing.SpinnerNumberModel(1, 1, 4, 1));

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

        btnObrisi.setText("Obriši");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        jLabel9.setText("Traži");

        txtTrazi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTraziKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(txtPolaziste)
                            .addComponent(txtOdrediste)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtCijena, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                        .addComponent(txtBrojMobitela, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(spBrojPutnika, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(dtpPocetak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dtpKraj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbVozi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDodaj)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnPromjeni)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnObrisi))
                            .addComponent(jLabel9)
                            .addComponent(txtTrazi))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPolaziste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTrazi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOdrediste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDodaj)
                    .addComponent(btnPromjeni)
                    .addComponent(btnObrisi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBrojMobitela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtpPocetak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dtpKraj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCijena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbVozi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spBrojPutnika, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        Voznja v = new Voznja();
        spremi(v);
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnPromjeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjeniActionPerformed
        Voznja v = lista.getSelectedValue();
        if (v == null) {
            JOptionPane.showMessageDialog(null, "Prvo odaberite stavku");
            return;
        }

        spremi(v);
    }//GEN-LAST:event_btnPromjeniActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        Voznja v = lista.getSelectedValue();
        if (v == null) {
            JOptionPane.showMessageDialog(null, "Prvo odaberite stavku");
            return;
        }
        if (JOptionPane.showConfirmDialog(
                null, //roditelj, bude null
                "Sigurno obrisati?", //tijelo dijaloga
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
        Voznja v = lista.getSelectedValue();
        if (v == null) {
            return;
        }
        postaviVrijednosti(v);
    }//GEN-LAST:event_listaValueChanged

    private void txtTraziKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTraziKeyReleased
        DefaultListModel<Voznja> model = new DefaultListModel<>();
        obrada.getVoznje(txtTrazi.getText().trim()).forEach(
                (voznja) -> {
                    model.addElement(voznja);
                });

        lista.setModel(model);
        lista.repaint();
    }//GEN-LAST:event_txtTraziKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPromjeni;
    private javax.swing.JComboBox<Vozi> cmbVozi;
    private com.github.lgooddatepicker.components.DateTimePicker dtpKraj;
    private com.github.lgooddatepicker.components.DateTimePicker dtpPocetak;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Voznja> lista;
    private javax.swing.JSpinner spBrojPutnika;
    private javax.swing.JTextField txtBrojMobitela;
    private javax.swing.JTextField txtCijena;
    private javax.swing.JTextField txtOdrediste;
    private javax.swing.JTextField txtPolaziste;
    private javax.swing.JTextField txtTrazi;
    // End of variables declaration//GEN-END:variables

}
