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

    public List<Vozi> getVozi(){
        return session.createQuery("from Vozi").list();
    }
    
//    public List<Vozi> getVozi(String uvjet){
//        return session.createQuery("from Vozi as a inner join a.vozac " +
//                                   "inner join a.vozilo " + 
//                                   "where a.vozac.ime like :uvjet or a.vozac.prezime like :uvjet " +
//                                   "or a.vozilo.brojVozila like :uvjet or a.vozilo.marka like :uvjet")
//                                   .setParameter("uvjet", "%" + uvjet + "%").setMaxResults(20).list();
//    }
    
    public List<Vozi> getVoziVozaca(String uvjet){
        return session.createQuery("from Vozi a where a.vozac.ime like :uvjet or a.vozac.prezime like :uvjet")
                                   .setParameter("uvjet", "%" + uvjet + "%").setMaxResults(20).list();
    }
    
    public List<Vozi> getVoziVozilo(String uvjet){
        return session.createQuery("from Vozi a where a.vozilo.marka like :uvjet or a.vozilo.brojVozila like :uvjet")
                                   .setParameter("uvjet", "%" + uvjet + "%").setMaxResults(20).list();
    }
    
    @Override
    protected void kontrolaSpremi() throws MyException {
        
    }

    @Override
    protected void kontrolaBrisi() throws MyException {
        
    }
    
    
    
}
