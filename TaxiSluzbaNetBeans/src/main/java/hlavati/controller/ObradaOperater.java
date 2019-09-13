/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlavati.controller;

import hlavati.model.Operater;
import java.util.List;

/**
 *
 * @author Luka
 */
public class ObradaOperater extends ObradaVozac<Operater> {
    
    public List<Operater> getEntiteti() {
        return session.createQuery("from Operater").list();
    }
    
    
    
}
