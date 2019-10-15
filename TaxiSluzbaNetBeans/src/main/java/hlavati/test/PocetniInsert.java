/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlavati.test;

import hlavati.controller.ObradaVozac;
import hlavati.controller.ObradaVozi;
import hlavati.controller.ObradaVozilo;
import hlavati.controller.ObradaVoznja;
import hlavati.model.Vozac;
import hlavati.model.Vozilo;
import hlavati.model.Vozi;
import hlavati.model.Voznja;
import hlavati.utility.MyException;
import java.math.BigDecimal;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Luka
 */
public class PocetniInsert {
    public static void unesi(){
        Vozac vozac = new Vozac();
        vozac.setIme("Bilbo");
        vozac.setPrezime("Baggins");
        vozac.setOib("06093182169");
        vozac.setSpol("M");
        ObradaVozac obradaVozac = new ObradaVozac();
        try {
            obradaVozac.spremi(vozac);
        } catch (MyException e) {
            JOptionPane.showMessageDialog(null, e.getPoruka());
        }
        Vozilo vozilo = new Vozilo();
        vozilo.setMarka("Tesla");
        vozilo.setGorivo("Struja");
        vozilo.setGodiste("2019");
        vozilo.setSnaga("500 kW");
        vozilo.setAbs(true);
        vozilo.setBrojVozila(1);
        ObradaVozilo obradaVozilo = new ObradaVozilo();
        try {
            obradaVozilo.spremi(vozilo);
        } catch (MyException e) {
            JOptionPane.showMessageDialog(null, e.getPoruka());
        }
        Vozi vozi = new Vozi();
        vozi.setVrijemeKraja(new Date());
        vozi.setVrijemeKraja(new Date());
        vozi.setVozac(vozac);
        vozi.setVozilo(vozilo);
        ObradaVozi obradaVozi = new ObradaVozi();
        try {
            obradaVozi.spremi(vozi);
        } catch (MyException e) {
            JOptionPane.showMessageDialog(null, e.getPoruka());
        }
        Voznja voznja = new Voznja();
        voznja.setAdresaOdredista("J.J. Strossmayer 150, Osijek");
        voznja.setAdresaPolazista("Sjenjak 50, Osijek");
        voznja.setBrojMob("0991234567");
        voznja.setBrojPutnika(2);
        voznja.setCijena(new BigDecimal(20));
        voznja.setPocetakVoznje(new Date());
        voznja.setKrajVoznje(new Date());
        ObradaVoznja obradaVoznja = new ObradaVoznja();
        try {
            obradaVoznja.spremi(voznja);
        } catch (MyException e) {
            JOptionPane.showMessageDialog(null, e.getPoruka());
        }
        
    }
}
