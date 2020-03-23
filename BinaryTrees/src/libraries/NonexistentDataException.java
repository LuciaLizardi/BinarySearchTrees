/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries;


/**
 *
 * @author lucializarsi
 * */

public class NonexistentDataException extends RuntimeException{
    public NonexistentDataException(){
        super("NO EXISTE EL DATO");
    }
}
