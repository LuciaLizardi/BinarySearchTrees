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
public class NodoBin <T extends Comparable>{
    T elem;
    NodoBin<T> izq;
    NodoBin<T> der;
    NodoBin<T> papa;
    
    public NodoBin(T e){
        elem=e;
        izq=null;
        der=null;
    }

    public void setPapa(NodoBin<T> papa) {
        this.papa = papa;
    }

    public NodoBin<T> getPapa() {
        return papa;
    }
    
    
//cuelga
    
    public void cuelga(NodoBin<T> n){
        if(n==null)
            return;
        if(elem==null){
            der=n;
             n.setPapa(this);
            return;
        }
        if(n.getElem().compareTo(elem)<0)
            izq=n;
        else
            der=n;
        n.setPapa(this);
    }
    
    public T getElem() {
        return elem;
    }

    public NodoBin<T> getIzq() {
        return izq;
    }

    public NodoBin<T> getDer() {
        return der;
    }

    public void setElem(T elem) {
        this.elem = elem;
    }

    public void setIzq(NodoBin<T> izq) {
        this.izq = izq;
    }

    public void setDer(NodoBin<T> der) {
        this.der = der;
    }
    
    
    public int numDescendentes(){ //CUANTOS DESCENDIENTES TIENE ESE NODO 
        int res=0;
       if(izq!=null)
            res=izq.numDescendentes()+1; //Le pregunto a cada nodo cuántos hijos tien
       if(der!=null)
        res+=der.numDescendentes()+1;
       return res;
    }
    
    public int numHijosDirectos(){
        int cont=0;
        if(izq!=null)
        cont++;
        if(der!=null)
        cont++;
        return cont;
    }
}
