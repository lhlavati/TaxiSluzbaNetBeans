/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlavati.view;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.DateTimePicker;
import com.github.lgooddatepicker.components.TimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;
import hlavati.controller.ObradaVozac;
import hlavati.model.Vozi;
import hlavati.controller.ObradaVozi;
import hlavati.controller.ObradaVozilo;
import hlavati.model.Vozac;
import hlavati.model.Vozilo;
import hlavati.utility.MyException;
import hlavati.utility.Utility;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Luka
 */
public class FormaVozi extends PomocneMetode<Vozi> {

    private ObradaVozi obrada;

    /**
     * Creates new form FormaVozaci
     */
    public FormaVozi() {
        initComponents();
        obrada = new ObradaVozi();
        setTitle(Utility.getNazivAplikacije());
        rbtnVozac.setSelected(true);
        ucitajVozaca();
        ucitajVozilo();
        ucitaj();

//        DatePickerSettings dpsP = new DatePickerSettings(new Locale("hr", "HR"));
//        dpsP.setFormatForDatesCommonEra("dd.MM.yyyy.");
//        dpPocetak.setSettings(dpsP);
//
//        DatePickerSettings dpsK = new DatePickerSettings(new Locale("hr", "HR"));
//        dpsK.setFormatForDatesCommonEra("dd.MM.yyyy.");
//        dpKraj.setSettings(dpsK);
    }

    @Override
    protected void ucitaj() {
        DefaultListModel<Vozi> model = new DefaultListModel<>();
        obrada.getVozi().forEach((vozi) -> {
            model.addElement(vozi);
        });
        lista.setModel(model);
        lista.repaint();
    }

    @Override
    protected void spremi(Vozi v) {
        if (!kontrola(v)) {
            return;
        }

        v.setVozac((Vozac) cmbVozac.getSelectedItem());
        v.setVozilo((Vozilo) cmbVozilo.getSelectedItem());

        try {
            obrada.spremi(v);
        } catch (MyException ex) {
            JOptionPane.showMessageDialog(null, ex.getPoruka());
            return;
        }

        ucitaj();
    }

    @Override
    protected boolean kontrola(Vozi v) {
        return kontrolaPocetka(v) && kontrolaKraja(v);
    }

    @Override
    protected void postaviVrijednosti(Vozi v) {
        cmbVozac.setSelectedItem(v.getVozac());
        cmbVozilo.setSelectedItem(v.getVozilo());
        dtpPocetka.setDateTimeStrict(Utility.convertToLocalDateTimeViaInstant(v.getVrijemePocetka()));
        dtpKraja.setDateTimeStrict(Utility.convertToLocalDateTimeViaInstant(v.getVrijemeKraja()));
    }

    private void ucitajVozaca() {
        DefaultComboBoxModel<Vozac> m = new DefaultComboBoxModel<>();
        new ObradaVozac<Vozac>().getVozaci().forEach((vozac) -> {
            m.addElement(vozac);
        });
        cmbVozac.setModel(m);
    }

    private void ucitajVozilo() {
        DefaultComboBoxModel<Vozilo> m = new DefaultComboBoxModel<>();
        new ObradaVozilo().getVozila().forEach((vozilo) -> {
            m.addElement(vozilo);
        });
        cmbVozilo.setModel(m);
    }

    private boolean kontrolaPocetka(Vozi v) {
//        if (dpPocetak.getText().trim().length() == 0) {
//            JOptionPane.showMessageDialog(null, "Obavezan unos datuma početka!");
//            return false;
//        }
//        if (tpPocetak.getText().trim().length() == 0) {
//            JOptionPane.showMessageDialog(null, "Obavezan unos vremena početka!");
//            return false;
//        }
//        v.setVrijemePocetka(Utility.convertToDateViaInstant(dpPocetak.getDate()));
        if (dtpPocetka.getDateTimeStrict() == null) {
            JOptionPane.showMessageDialog(null, "Obavezan unos vremena pocetka!");
            return false;
        }
        v.setVrijemePocetka(Utility.convertToDateViaSqlTimestamp(dtpPocetka.getDateTimeStrict()));
        return true;
    }

    private boolean kontrolaKraja(Vozi v) {
//        if (dpKraj.getText().trim().length() == 0) {
//            JOptionPane.showMessageDialog(null, "Obavezan unos datum kraja!");
//            return false;
//        }
//        if (tpKraj.getText().trim().length() == 0) {
//            JOptionPane.showMessageDialog(null, "Obavezan unos kraja vremena!");
//            return false;
//        }
//        v.setVrijemeKraja(Utility.convertToDateViaInstant(dpKraj.getDate()));
        if (dtpKraja.getDateTimeStrict() == null) {
            JOptionPane.showMessageDialog(null, "Obavezan unos vremena pocetka!");
            return false;
        }
        v.setVrijemeKraja(Utility.convertToDateViaSqlTimestamp(dtpKraja.getDateTimeStrict()));
        return true;
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
        jScrollPane2 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbVozac = new javax.swing.JComboBox<>();
        cmbVozilo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dtpPocetka = new com.github.lgooddatepicker.components.DateTimePicker();
        dtpKraja = new com.github.lgooddatepicker.components.DateTimePicker();
        btnDodaj = new javax.swing.JButton();
        btnPromjeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        txtTrazi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        rbtnVozac = new javax.swing.JRadioButton();
        rbtnVozilo = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lista.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lista);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Podaci"));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setText("Vozač");

        jLabel2.setText("Vozilo");

        jLabel3.setText("vozi");

        jLabel4.setText("Vrijeme početka rada");

        jLabel5.setText("Vrijeme kraja rada");

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
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cmbVozac, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbVozilo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(dtpPocetka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtpKraja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 4, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbVozac, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbVozilo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addGap(8, 8, 8)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dtpPocetka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dtpKraja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        btnObrisi.setText("Obriši");
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

        btnGroup.add(rbtnVozac);
        rbtnVozac.setText("Tražim po vozaču");

        btnGroup.add(rbtnVozilo);
        rbtnVozilo.setText("Tražim po vozilu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDodaj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPromjeni)
                        .addGap(18, 18, 18)
                        .addComponent(btnObrisi))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtTrazi))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtnVozac)
                            .addComponent(rbtnVozilo))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTrazi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbtnVozac)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbtnVozilo)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDodaj)
                            .addComponent(btnPromjeni)
                            .addComponent(btnObrisi)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        Vozi v = new Vozi();
        spremi(v);
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        Vozi v = lista.getSelectedValue();
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
            JOptionPane.showMessageDialog(null, "Ne možete obrisati parent row! Negdje se već koristi!");
            return;
        }

        ucitaj();
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnPromjeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjeniActionPerformed
        Vozi v = lista.getSelectedValue();
        if (v == null) {
            JOptionPane.showMessageDialog(null, "Prvo odaberite stavku");
            return;
        }

        spremi(v);
    }//GEN-LAST:event_btnPromjeniActionPerformed

    private void listaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaValueChanged
        if (evt.getValueIsAdjusting()) {
            return;
        }
        Vozi v = lista.getSelectedValue();
        if (v == null) {
            return;
        }
        postaviVrijednosti(v);
    }//GEN-LAST:event_listaValueChanged

    private void txtTraziKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTraziKeyReleased
        DefaultListModel<Vozi> model = new DefaultListModel<>();
        if (rbtnVozac.isSelected()) {
            obrada.getVoziVozaca(txtTrazi.getText().trim()).forEach(
                    (vozi) -> {
                        model.addElement(vozi);
                    });
            lista.setModel(model);
            lista.repaint();
        } else {
            obrada.getVoziVozilo(txtTrazi.getText().trim()).forEach(
                (vozi) -> {
                            model.addElement(vozi);
                          });
        lista.setModel(model);
        lista.repaint();
        }

    }//GEN-LAST:event_txtTraziKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.ButtonGroup btnGroup;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPromjeni;
    private javax.swing.JComboBox<Vozac> cmbVozac;
    private javax.swing.JComboBox<Vozilo> cmbVozilo;
    private com.github.lgooddatepicker.components.DateTimePicker dtpKraja;
    private com.github.lgooddatepicker.components.DateTimePicker dtpPocetka;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<Vozi> lista;
    private javax.swing.JRadioButton rbtnVozac;
    private javax.swing.JRadioButton rbtnVozilo;
    private javax.swing.JTextField txtTrazi;
    // End of variables declaration//GEN-END:variables

}
