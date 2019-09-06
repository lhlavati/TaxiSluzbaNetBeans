/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlavati.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Luka
 */
@Entity
public class Vozilo extends Entitet implements Serializable {

    @Id
    private Integer sifra;
    private String marka;
    private String gorivo;
    private String snaga;
    private Boolean abs;
    private String godiste;
    private Integer brojVozila;

    public Vozilo() {
        super();
    }

    public Vozilo(Integer sifra, String marka, String gorivo, String snaga, Boolean abs, String godiste, Integer brojVozila) {
        super(sifra);
        this.marka = marka;
        this.gorivo = gorivo;
        this.snaga = snaga;
        this.abs = abs;
        this.godiste = godiste;
        this.brojVozila = brojVozila;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getGorivo() {
        return gorivo;
    }

    public void setGorivo(String gorivo) {
        this.gorivo = gorivo;
    }

    public String getSnaga() {
        return snaga;
    }

    public void setSnaga(String snaga) {
        this.snaga = snaga;
    }

    public Boolean isAbs() {
        return abs;
    }

    public void setAbs(Boolean abs) {
        this.abs = abs;
    }

    public String getGodiste() {
        return godiste;
    }

    public void setGodiste(String godiste) {
        this.godiste = godiste;
    }

    public Integer getBrojVozila() {
        return brojVozila;
    }

    public void setBrojVozila(Integer brojVozila) {
        this.brojVozila = brojVozila;
    }

}
