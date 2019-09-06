/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlavati.controller;

import hlavati.utility.HibernateUtil;
import hlavati.utility.MyException;
import org.hibernate.Session;

/**
 *
 * @author Luka
 */
public abstract class Obrada<T> {
    
    protected abstract void kontrolaSpremi()throws MyException;
    protected abstract void kontrolaBrisi()throws MyException;
    
    protected Session session;

    public Obrada() {
        this.session = HibernateUtil.getSession();
    }
    
    public T spremi(T entitet) throws MyException{
        //polimorfizam
        kontrolaSpremi();
        session.beginTransaction();
        session.save(entitet);
        session.getTransaction().commit();
        
        return entitet;
    }
    
    public void brisi(T entitet)throws MyException{
        kontrolaBrisi();
        session.beginTransaction();
        session.delete(entitet);
        session.getTransaction().commit();
    }
    
}
