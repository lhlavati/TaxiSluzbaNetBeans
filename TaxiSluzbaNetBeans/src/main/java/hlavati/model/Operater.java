/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlavati.model;

import java.io.Serializable;

/**
 *
 * @author Luka
 */
public class Operater extends Vozac implements Serializable {
    
    private String lozinka;

    public Operater() {
    }

    public Operater(Integer sifra, String ime, String prezime, String oib, String spol, String lozinka) {
        super(sifra, ime, prezime, oib, spol);
        this.lozinka = lozinka;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }
    
    
}
