/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author lucializarsi
 */
public class BinaryTree<T extends Comparable> implements BinaryTreeADT<T> {
     NodoBin <T> raiz;
    int cont;

    
    
    public BinaryTree() {
        raiz= new NodoBin(null); //La raíz será un centinela
        cont=0;
    }
     public BinaryTree(T elem) {
        raiz= new NodoBin(null);
        raiz.setDer(new NodoBin(elem));
        cont=1;
    }
 
    public boolean isEmpty(){
    return cont==0;
    }
    
    public int size(){
        return cont;
    }

    public void inserta(T elem){
        
    }
    
    
    public boolean contains(T elem){
        boolean res=false;
        if(find(elem)!=null)
            res=true;
        return res;
    }
    
    public T find(T elem){
        NodoBin<T> actual= raiz.getDer();
        boolean der,izq;
        if(cont==0)
            return null;
        if(cont==1){
            if(raiz.getDer().getElem().compareTo(elem)!=0)
                return null;
            else
                return elem;
        }
        
        der=find(elem,actual.getDer(),false);
        izq=find(elem,actual.getIzq(),false);
        
        if(der==true || izq==true)
            return elem;
        else
            elem=null;
        
       
    return elem;
    }
    

    private boolean find(T elem, NodoBin actual, boolean res){
        if(actual==null)
            return res;
        else {
         if (elem.compareTo(actual.getElem())==0)
            return true;
         
         else if(elem.compareTo(actual.getElem())>0)
            return find(elem,actual.getDer(),false);
            
         else if(elem.compareTo(actual.getElem())<0)
            return find(elem,actual.getIzq(),false);
      
        }
       return res; 
        }
    
         
        
    
    
    
    
    public NodoBin<T> getRaiz() {
        return raiz.getDer();
    }
    
    
    public ArrayList<T> inOrdn(){
       ArrayList<T> lista= new ArrayList();
       inOrdn(raiz.getDer(),lista);
       return lista;
    }
    
    private void inOrdn(NodoBin<T> actual, ArrayList<T> lista){
        if(actual==null)
            return;
        inOrdn(actual.getIzq(),lista);
        lista.add(actual.getElem());
        inOrdn(actual.getDer(),lista);
    }
    
    public ArrayList<T> postOrdn(){
       ArrayList<T> lista= new ArrayList();
       postOrdn(raiz.getDer(),lista);
       return lista;  
    }
    
    private void postOrdn(NodoBin<T> actual, ArrayList<T> lista){
        if(actual==null)
            return;
        postOrdn(actual.getIzq(),lista);
        postOrdn(actual.getDer(),lista);
        lista.add(actual.getElem());
        
    }
    public ArrayList<T> preOrdn(){
      ArrayList<T> lista= new ArrayList();
       preOrdn(raiz.getDer(),lista);
       return lista;  
    }
    
    private void preOrdn(NodoBin<T> actual, ArrayList<T> lista){
          if(actual==null)
            return;
        lista.add(actual.getElem());
        preOrdn(actual.getIzq(),lista);
        preOrdn(actual.getDer(),lista);
    }
    
   
    public ArrayList<T> levelOrdnIt(){
       ArrayQueue<NodoBin<T>> queue=new ArrayQueue();
        ArrayList<T> lista=new ArrayList();
        queue.enqueue(raiz.getDer());
        
        while(!queue.isEmpty()){
            NodoBin<T> e= queue.dequeue();
            lista.add(e.getElem());
            if(e.getDer()!=null)
                queue.enqueue(e.getDer());
            if(e.getIzq()!=null)
                queue.enqueue(e.getDer());     
        }
        
        return lista;
    }
    
    
    public ArrayList<T> preOrdnIt(NodoBin<T> raiz ){
        ArrayStack<NodoBin<T>> stack=new ArrayStack();
        ArrayList<T> lista=new ArrayList();
        stack.push(raiz);
        
        while(!stack.isEmpty()){
            NodoBin<T> e= stack.pop();
            lista.add(e.getElem());
            if(e.getDer()!=null)
                stack.push(e.getDer());
            if(e.getIzq()!=null)
                stack.push(e.getIzq());
        }
        
        return lista;
    }
    
    
      public int getAltura() {
        return getAltura(raiz.getDer());
    }
      
    private int getAltura(NodoBin<T> actual) {
        if(actual==null) {
            return 0;
        }
        int aIzq = getAltura(actual.getIzq())+1;
        int aDer = getAltura(actual.getDer())+1;
        if(aIzq<aDer) {
            return aDer;
        }
        else {
            return aIzq;
        }
    }

}
