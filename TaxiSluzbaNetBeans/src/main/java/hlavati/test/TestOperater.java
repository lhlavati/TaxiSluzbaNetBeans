/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlavati.test;

import hlavati.controller.ObradaOperater;
import hlavati.model.Operater;
import hlavati.utility.MyException;
import hlavati.utility.HibernateUtil;
import java.math.BigDecimal;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Admin
 */
public class TestOperater {

    public static void test() {
        Operater o = new Operater();
        o.setIme("Luka");
        o.setPrezime("Hlavati");
        o.setSpol("M");
        o.setLozinka(BCrypt.hashpw("12345", BCrypt.gensalt()));

        ObradaOperater obrada = new ObradaOperater();
        try {
            o = obrada.spremi(o);
        } catch (MyException e) {
            System.out.println(e.getPoruka());
        }

        System.out.println(o.getSifra());

    }

}
