/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlavati;

import javax.swing.JOptionPane;
import hlavati.controller.ObradaVozilo;
import hlavati.model.Vozilo;
import hlavati.utility.HibernateUtil;
import hlavati.utility.MyException;

/**
 *
 * @author Luka
 */
public class Start {
    
    public static void main(String[] args) {
        
//        Vozilo v = new Vozilo();
//        v.setMarka(JOptionPane.showInputDialog("Unesite marku"));
//        
//        ObradaVozilo ov = new ObradaVozilo();
//        
//        try {
//            ov.create(v);
//        } catch (MyException e) {
//            System.out.println(e.getPoruka());
//        }
          HibernateUtil.getSession();
    }
}
