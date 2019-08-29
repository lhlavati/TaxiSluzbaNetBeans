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
import hlavati.utility.ObradaInterface;

/**
 *
 * @author Luka
 */
public class ObradaVozac extends Obrada<Vozac> implements ObradaInterface<Vozac> {

    public ObradaVozac() {
        super();
    }

    @Override
    public Vozac create(Vozac entitet) throws MyException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Vozac> read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Vozac entitet) throws MyException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Vozac entitet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
