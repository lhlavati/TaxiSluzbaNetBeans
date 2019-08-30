/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlavati.controller;

import java.util.ArrayList;
import java.util.List;
import hlavati.model.Vozilo;
import hlavati.utility.MyException;
import hlavati.utility.ObradaInterface;

/**
 *
 * @author Luka
 */
public class ObradaVozilo extends Obrada<Vozilo> implements ObradaInterface<Vozilo> {

    public ObradaVozilo() {
        super();
    }

    @Override
    public Vozilo create(Vozilo vozilo) throws MyException {
        unosMarke(vozilo);
        unosGorivo(vozilo);
        unosSnaga(vozilo);

        vozilo = dao.spremi(vozilo);

        return vozilo;
    }

    @Override
    public List<Vozilo> read() {
        
        List<Vozilo> vozila = new ArrayList<>();
        Vozilo vozilo = new Vozilo(1, "Škoda", "benzin", "66 kW", true, "2014", 1);
        
        vozila.add(vozilo);
        
        return vozila;
    }

    @Override
    public void update(Vozilo vozilo) throws MyException {
        unosMarke(vozilo);
        unosGorivo(vozilo);
        unosSnaga(vozilo);
        
        dao.spremi(vozilo);
    }

    @Override
    public boolean delete(Vozilo vozilo) {
        System.out.println("Brišem iz baze!");
        return true;
    }

    private void unosMarke(Vozilo vozilo) throws MyException {

        if (vozilo.getMarka() != null) {
            vozilo.setMarka(vozilo.getMarka().trim());
        }
        if (vozilo.getMarka() == null || vozilo.getMarka().length() == 0) {
            throw new MyException("Marka mora biti unešena");
        }
        if (vozilo.getMarka().length() > 50) {
            throw new MyException("Marka mora biti maksimalno 50 znakova!");
        }

    }
    
    private void unosGorivo(Vozilo vozilo) throws MyException {
        
        if (vozilo.getGorivo() != null) {
            vozilo.setGorivo(vozilo.getGorivo().trim());
        }
        if (vozilo.getGorivo() == null || vozilo.getGorivo().length() == 0) {
            throw new MyException("Gorivo mora biti unešeno");
        }
        if (vozilo.getGorivo().length() > 25) {
            throw new MyException("Gorivo mora biti maksimalno 25 znakova!");
        }
        
    }
    
    private void unosSnaga(Vozilo vozilo) throws MyException {
        
        if (vozilo.getSnaga() != null) {
            vozilo.setSnaga(vozilo.getSnaga().trim());
        }
        if (vozilo.getSnaga() == null || vozilo.getSnaga().length() == 0) {
            throw new MyException("Snaga mora biti unešeno");
        }
        if (vozilo.getSnaga().length() > 8) {
            throw new MyException("Snaga mora biti maksimalno 8 znakova!");
        }
        
    }
    
    private void unosABS(Vozilo vozilo) throws MyException {
        
        
        
    }
}
