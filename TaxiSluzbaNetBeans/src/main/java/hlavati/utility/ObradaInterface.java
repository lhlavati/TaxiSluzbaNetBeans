/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlavati.utility;

import java.util.List;

/**
 *
 * @author Luka
 */
public interface ObradaInterface<T> {
    
    public T create(T entitet) throws MyException;
    public List<T> read();
    public void update(T entitet) throws MyException;
    public boolean delete(T entitet);
    
}
