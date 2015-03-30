/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

/**
 *
 * @author xandel
 */
public interface mrizka {
   /**
     * vrati velikost mrizky     
     * @return size
     */
    public int getsize();   
    
    /**
     * vrati aktualni znak na dane souradnici
     * O nebo X nebo "_"
     * @param x
     * @param y
     * @return 
     */
    public char zjistitZnak(int x,int y);
    
    /**
     * vypise mrizku
     */
    public void vypsatMrizku();    
    
    /**
     * aktualizuje mrizku
     */
    public void aktualizaceMrizky();    
    
    
    
    
}
