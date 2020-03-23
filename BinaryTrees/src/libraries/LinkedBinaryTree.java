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
public class LinkedBinaryTree<T extends Comparable> extends BinaryTree<T> implements BinarySearchTreeADT<T> {
    
    private int cont;
   
    //Constructores
    public LinkedBinaryTree(){
        super();
        cont=0;
        
    }
    public LinkedBinaryTree(T elem){
        super(elem);
        cont=1;
        
    }
    
    
    
        //Método que regresa un nodo que se desea encontrar.
    public NodoBin<T> encuentra(T elem){
           NodoBin<T> actual = raiz.getDer();
        
            while(actual!=null) {
            if(actual.getElem().equals(elem)) {
                return actual;
            }
            if(elem.compareTo(actual.getElem())<0) {
                actual = actual.getIzq();
            }
            else {
                actual = actual.getDer();
            }
        }
        return null; //nunca lo encontró
    }
     
        //Método que inserta un elemento en el árbol
    public void inserta(T elem){
        NodoBin<T> nuevo = new NodoBin<T>(elem);

        if(cont==0){// Si está vacío el árbol
            raiz.setDer(nuevo);
            cont++;
            return;
        }
        
        else{
            NodoBin<T> actual=raiz.getDer();
            NodoBin<T> papa = actual.getDer();

            while(actual!=null){
                papa=actual;
                if(elem.compareTo(actual.getElem())<0)
                 actual=actual.getIzq();
                else
                 actual=actual.getDer();
            }
         
            papa.cuelga(nuevo);
            cont++;
        }
        
        }
        
        //Método que borra un elemento del árbol
    public  T borra(T elem){
        T res=elem;
        NodoBin<T> aux= encuentra(elem);
        //No está en el árbol
        if(aux==null){
            res=null;
        }
        else{
                //Si es el primer elemento
                if(cont==1){
                raiz.setDer(null);
                cont--;
                return elem;
            }
                    //Si es una hoja.
                    if(aux.getIzq()==null && aux.getDer()==null){
                        
                        if(aux.getPapa().getIzq().equals(aux)) 
                            aux.getPapa().setIzq(null);
                            else
                            aux.getPapa().setDer(null);
                    }
                    
                    else { //no es una hoja
                        //Cuando sólo es un hijo
                         if(aux.getIzq()==null || aux.getDer()==null) {
                            if(aux.getIzq()!=null) 
                                 aux.getPapa().cuelga(aux.getIzq());
                                     else
                                    aux.getPapa().cuelga(aux.getDer());
                         }
                         
                         else {
                             //Es una rama
                                    NodoBin<T> actual = aux;
                                    actual = actual.getDer();
                                    while(actual.getIzq()!=null) {
                                       actual = actual.getIzq();
                                     }
                                    if(actual.getDer()!=null) {
                                    actual.getPapa().cuelga(actual.getDer());
                                    }
                                    else {
                                    actual.getPapa().setIzq(null);
                                    }
                                    aux.setElem(actual.getElem());
                            }
                    }
        cont--;
                        
        }
        
        return elem;
                    
  }
                  
        //Método que borra el menor elemento en el árbol. 

    public T borraMin(){
        T res=null;
        if(!isEmpty()){
        NodoBin<T> min=raiz.getDer();
        while(min.getIzq()!=null)
            min=min.getIzq();
        res=borra(min.getElem());
        }
        else
            throw new EmptyCollectionException();
        
        return res;
    }
        
        //Método que borra el mayor elemento en el árbol. 

    public T borraMax(){
        T res=null;
        if(!isEmpty()){
        NodoBin<T> max=raiz.getDer();
        while(max.getDer()!=null)
            max=max.getDer();
        res=borra(max.getElem());
        }
        else
            throw new EmptyCollectionException();
        
        return res;
    }

        //Método que busca el menor elemento en el árbol. 

    public T encuentraMin(){
       NodoBin<T> actual=raiz.getDer();
           if(cont==0)
            throw new EmptyCollectionException();
           
            while(actual.getIzq()!=null)
            actual=actual.getIzq();
        //El elemento se encuentra hasta la rama más izquierda.
        return actual.getElem();
    }
        //Método que busca el mayor elemento en el árbol. 

    public T encuentraMax(){
        NodoBin<T> actual=raiz.getDer();
           if(cont==0)
            throw new EmptyCollectionException();
           
            while(actual.getDer()!=null)
            actual=actual.getDer();
        //El elemento se encuentra hasta la hoja más derecha.
        return actual.getElem();
    }
}
