/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlavati.model;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author Luka
 */
@Entity
public class Vozac extends Entitet implements Serializable{

    private String ime;
    private String prezime;
    private String oib;
    private String spol;

    public Vozac() {
        super();
    }

    public Vozac(Integer sifra, String ime, String prezime, String oib, String spol) {
        super(sifra);
        this.ime = ime;
        this.prezime = prezime;
        this.oib = oib;
        this.spol = spol;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    public String getSpol() {
        return spol;
    }

    public void setSpol(String spol) {
        this.spol = spol;
    }

    @Override
    public String toString() {
        return getIme() + " " + getPrezime();
    }

    
    
}
