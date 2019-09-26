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
public class Operater extends Osoba implements Serializable {
    
    private String lozinka;

    public Operater() {
    }

    public Operater(Integer sifra, String ime, String prezime, String oib, String lozinka) {
        super(ime, prezime, oib, sifra);
        this.lozinka = lozinka;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }
    
    
}
