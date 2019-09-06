/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlavati.test;

import hlavati.controller.ObradaVozilo;
import hlavati.model.Vozilo;
import hlavati.utility.MyException;

/**
 *
 * @author Luka
 */
public class TestVozilo {
    
    public static void test(){
        
        Vozilo vozilo = new Vozilo();
        vozilo.setMarka("BMW");
        
        ObradaVozilo obrada = new ObradaVozilo();
        
        try {
            vozilo = obrada.spremi(vozilo);
        } catch (MyException e) {
            System.out.println(e.getPoruka());
        }
        
    }
    
}
