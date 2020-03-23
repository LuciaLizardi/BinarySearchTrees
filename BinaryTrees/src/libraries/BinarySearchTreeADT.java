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
public interface BinarySearchTreeADT <T> extends BinaryTreeADT<T>{
    public void inserta(T elem);
    public  T borra(T elem);
    public T borraMin();
    public T borraMax();
    public T encuentraMin();
    public T encuentraMax();
}
