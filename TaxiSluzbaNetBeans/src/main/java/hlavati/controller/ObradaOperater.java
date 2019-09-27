/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlavati.controller;

import hlavati.model.Operater;
import hlavati.model.Osoba;
import hlavati.utility.MyException;
import java.util.List;

/**
 *
 * @author Luka
 */
public class ObradaOperater extends ObradaOsoba<Operater> {
    
    public List<Operater> getOperateri() {
        return session.createQuery("from Operater").list();
    }
    
    public Operater getOperater(String prezime){
        
        return (Operater)session.createQuery("from Operater a where a.prezime=:prezime ").setParameter("prezime", prezime).uniqueResult();
        
    }

    @Override
    protected void kontrolaSpremi() throws MyException {
        
    }

    @Override
    protected void kontrolaBrisi() throws MyException {
        
    }
    
    
    
}
