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
public class Vozac extends Osoba implements Serializable{

    public Vozac() {
        super();
    }

    public Vozac(String ime, String prezime, String oib, Integer sifra) {
        super(ime, prezime, oib, sifra);
    }

}
