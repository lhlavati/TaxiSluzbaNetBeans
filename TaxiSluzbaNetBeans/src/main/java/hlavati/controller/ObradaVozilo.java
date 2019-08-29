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
    public Vozilo create(Vozilo entitet) throws MyException {
        unosMarke(entitet);

        entitet = dao.spremi(entitet);

        return entitet;
    }

    @Override
    public List<Vozilo> read() {
        
        List<Vozilo> vozila = new ArrayList<>();
        Vozilo vozilo = new Vozilo(1, "Škoda", "benzin", "66 kW", true, "2014", 1);
        
        vozila.add(vozilo);
        
        return vozila;
    }

    @Override
    public void update(Vozilo entitet) throws MyException {
        unosMarke(entitet);
        dao.spremi(entitet);
    }

    @Override
    public boolean delete(Vozilo entitet) {
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

}
