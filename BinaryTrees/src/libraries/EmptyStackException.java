/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries;

/**
 *
 * @author lucializarsi
 */
public class EmptyStackException extends RuntimeException{
        EmptyStackException(){
            super("LA PILA ESTÁ VACÍA");
        }
    }


