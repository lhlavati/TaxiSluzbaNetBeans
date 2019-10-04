/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlavati.controller;

import hlavati.model.Voznja;
import hlavati.utility.MyException;
import java.util.List;

/**
 *
 * @author Luka
 */
public class ObradaVoznja extends Obrada<Voznja> {

    public List<Voznja> getVoznje(){
        return session.createQuery("from Voznja").list();
    }
    
    public List<Voznja> getVoznje(String uvjet){
        return session.createQuery("from Voznja a where a.adresaOdredista like :uvjet " + 
                                   "or a.adresaPolazista like :uvjet")
                                   .setParameter("uvjet", "%" + uvjet + "%").setMaxResults(20).list();
    }
    
    @Override
    protected void kontrolaSpremi() throws MyException {
        
    }

    @Override
    protected void kontrolaBrisi() throws MyException {
        
    }
    
}
