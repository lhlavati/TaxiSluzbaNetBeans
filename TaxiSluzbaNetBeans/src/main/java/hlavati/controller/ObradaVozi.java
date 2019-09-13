/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlavati.controller;

import hlavati.model.Vozi;
import hlavati.utility.MyException;
import java.util.List;

/**
 *
 * @author Luka
 */
public class ObradaVozi extends Obrada<Vozi> {

    public List<Vozi> getVozila(){
        return session.createQuery("from Vozi").list();
    }
    
    @Override
    protected void kontrolaSpremi() throws MyException {
        
    }

    @Override
    protected void kontrolaBrisi() throws MyException {
        
    }
    
    
    
}
