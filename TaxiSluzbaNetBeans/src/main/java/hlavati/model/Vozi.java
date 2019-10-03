/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlavati.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author Luka
 */
@Entity
public class Vozi extends Entitet implements Serializable{
    
    private Date vrijemePocetka;
    private Date vrijemeKraja;
    
    @ManyToOne
    private Vozac vozac;
    
    @ManyToOne
    private Vozilo vozilo;

    public Vozi() {
        super();
    }

    public Vozi(Integer sifra, Date vrijemePocetka, Date vrijemeKraja, Vozac vozac, Vozilo vozilo) {
        super(sifra);
        this.vrijemePocetka = vrijemePocetka;
        this.vrijemeKraja = vrijemeKraja;
        this.vozac = vozac;
        this.vozilo = vozilo;
    }

    public Date getVrijemePocetka() {
        return vrijemePocetka;
    }

    public void setVrijemePocetka(Date vrijemePocetka) {
        this.vrijemePocetka = vrijemePocetka;
    }

    public Date getVrijemeKraja() {
        return vrijemeKraja;
    }

    public void setVrijemeKraja(Date vrijemeKraja) {
        this.vrijemeKraja = vrijemeKraja;
    }

    public Vozac getVozac() {
        return vozac;
    }

    public void setVozac(Vozac vozac) {
        this.vozac = vozac;
    }

    public Vozilo getVozilo() {
        return vozilo;
    }

    public void setVozilo(Vozilo vozilo) {
        this.vozilo = vozilo;
    }

    @Override
    public String toString() {
        return vozac + "\t vozi \t" + vozilo;
    }
    
}
