/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlavati.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author Luka
 */
@Entity
public class Voznja extends Entitet implements Serializable{
    
    private BigDecimal cijena;
    private String adresaPolazista;
    private String adresaOdredista;
    private String brojMob;
    private Date pocetakVoznje;
    private Date krajVoznje;
    private Integer brojPutnika;
    
    @ManyToOne
    private Vozi vozi;

    public Voznja() {
        super();
    }

    public Voznja(Integer sifra, BigDecimal cijena, String adresaPolazista, String adresaOdredista, String brojMob, Date pocetakVoznje, Date krajVoznje, Integer brojPutnika, Vozi vozi) {
        super(sifra);
        this.cijena = cijena;
        this.adresaPolazista = adresaPolazista;
        this.adresaOdredista = adresaOdredista;
        this.brojMob = brojMob;
        this.pocetakVoznje = pocetakVoznje;
        this.krajVoznje = krajVoznje;
        this.brojPutnika = brojPutnika;
        this.vozi = vozi;
    }

    public BigDecimal getCijena() {
        return cijena;
    }

    public void setCijena(BigDecimal cijena) {
        this.cijena = cijena;
    }

    public String getAdresaPolazista() {
        return adresaPolazista;
    }

    public void setAdresaPolazista(String adresaPolazista) {
        this.adresaPolazista = adresaPolazista;
    }

    public String getAdresaOdredista() {
        return adresaOdredista;
    }

    public void setAdresaOdredista(String adresaOdredista) {
        this.adresaOdredista = adresaOdredista;
    }

    public String getBrojMob() {
        return brojMob;
    }

    public void setBrojMob(String brojMob) {
        this.brojMob = brojMob;
    }

    public Date getPocetakVoznje() {
        return pocetakVoznje;
    }

    public void setPocetakVoznje(Date pocetakVoznje) {
        this.pocetakVoznje = pocetakVoznje;
    }

    public Date getKrajVoznje() {
        return krajVoznje;
    }

    public void setKrajVoznje(Date krajVoznje) {
        this.krajVoznje = krajVoznje;
    }

    public Integer getBrojPutnika() {
        return brojPutnika;
    }

    public void setBrojPutnika(Integer brojPutnika) {
        this.brojPutnika = brojPutnika;
    }

    public Vozi getVozi() {
        return vozi;
    }

    public void setVozi(Vozi vozi) {
        this.vozi = vozi;
    }
    
    
}
