/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlavati.controller;

import java.util.List;
import hlavati.model.Vozilo;
import hlavati.utility.MyException;

/**
 *
 * @author Luka
 */
public class ObradaVozilo extends Obrada<Vozilo> {

    public List<Vozilo> getVozila(){
        return session.createQuery("from Vozilo").list();
    }
    
    public List<Vozilo> getVozila(String uvjet){
        return session.createQuery("from Vozilo a where a.marka like :uvjet or a.brojVozila like :uvjet")
                                   .setParameter("uvjet", "%" + uvjet + "%").setMaxResults(20).list();
    }
    
    @Override
    protected void kontrolaSpremi() throws MyException {
        Vozilo vozilo = new Vozilo();
        unosMarke(vozilo);
        unosGorivo(vozilo);
        unosSnaga(vozilo);
        unosABS(vozilo);
    }

    @Override
    protected void kontrolaBrisi() throws MyException {
        
    }
    
    private void unosMarke(Vozilo vozilo) throws MyException {

//        if (vozilo.getMarka() != null) {
//            vozilo.setMarka(vozilo.getMarka().trim());
//        }
//        if (vozilo.getMarka() == null || vozilo.getMarka().length() == 0) {
//            throw new MyException("Marka mora biti unešena");
//        }
//        if (vozilo.getMarka().length() > 50) {
//            throw new MyException("Marka mora biti maksimalno 50 znakova!");
//        }

    }
    
    private void unosGorivo(Vozilo vozilo) throws MyException {
        
//        if (vozilo.getGorivo() != null) {
//            vozilo.setGorivo(vozilo.getGorivo().trim());
//        }
//        if (vozilo.getGorivo() == null || vozilo.getGorivo().length() == 0) {
//            throw new MyException("Gorivo mora biti unešeno");
//        }
//        if (vozilo.getGorivo().length() > 25) {
//            throw new MyException("Gorivo mora biti maksimalno 25 znakova!");
//        }
//        
    }
    
    private void unosSnaga(Vozilo vozilo) throws MyException {
        
//        if (vozilo.getSnaga() != null) {
//            vozilo.setSnaga(vozilo.getSnaga().trim());
//        }
//        if (vozilo.getSnaga() == null || vozilo.getSnaga().length() == 0) {
//            throw new MyException("Snaga mora biti unešeno");
//        }
//        if (vozilo.getSnaga().length() > 8) {
//            throw new MyException("Snaga mora biti maksimalno 8 znakova!");
//        }
        
    }
    
    private void unosABS(Vozilo vozilo) throws MyException {
        
        
        
    }

    
}
