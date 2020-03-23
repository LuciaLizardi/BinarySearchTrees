/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import libraries.LinkedBinaryTree;

/**
 *
 * @author lucializardi
 */
public class binaryTreeTest {
     public static void main(String[] args) {
      LinkedBinaryTree<Double> a= new LinkedBinaryTree(34.5);
      System.out.println("IS BINARY TREE 'a' empty? "+a.isEmpty());  
      System.out.println("IS THE NUMBER GIVEN THERE? "+a.find(34.5));
      System.out.println("DOES THE BT CONTAINS 3? "+ a.contains(3.0)+"\n");
      
      LinkedBinaryTree<Double> b= new LinkedBinaryTree();
      System.out.println("IS BINARY TREE 'b' empty? "+b.isEmpty());  
      System.out.println("IS THE NUMBER GIVEN THERE? "+b.find(34.5));
      System.out.println("DOES THE BT CONTAINS 3? "+ b.contains(3.0));
      System.out.println(b.inOrdn());
      b.inserta(1.0);
      b.inserta(10.34);
      b.inserta(Math.cos(Math.PI/4));
      b.inserta(1000.1);
      b.inserta(-1000.0);
      b.inserta(99.90);
      b.inserta(3.0);
      
      System.out.println(b.inOrdn());
      
      
      b.borra(-1000.0);

      System.out.println(b.inOrdn());
      
      b.borra(3.0);
      
      System.out.println(b.inOrdn());
      
      b.borra(10.43);
      
      System.out.println(b.inOrdn()+"\n");

      System.out.println("MAX NUMBER: "+b.encuentraMax()+"\n");
           
      System.out.println("MIN NUMBER: "+b.encuentraMin());

}
}
