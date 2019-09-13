/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlavati.controller;

import java.util.List;
import javax.swing.JOptionPane;
import hlavati.model.Vozac;
import hlavati.model.Vozilo;
import hlavati.utility.MyException;

/**
 *
 * @author Luka
 */
public class ObradaVozac<T extends Vozac> extends Obrada<T> {

    public List<Vozac> getVozaci(){
        return session.createQuery("from Vozac").list();
    }
    
    @Override
    protected void kontrolaSpremi() throws MyException {
        
    }

    @Override
    protected void kontrolaBrisi() throws MyException {
        
    }

    
}
