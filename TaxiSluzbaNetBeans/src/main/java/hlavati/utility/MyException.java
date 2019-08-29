/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlavati.utility;

/**
 *
 * @author Luka
 */
public class MyException extends Exception {

    private String poruka;

    public MyException(String poruka) {

        this.poruka = poruka;
    }

    public String getPoruka() {
        return poruka;
    }

}
