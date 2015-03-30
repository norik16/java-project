/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xandel
 */
public class mrizkaImpl implements mrizka {

    private char [][] herniPole;
    private int size;
    private ClientImpl client;
    
    public mrizkaImpl(int size, ClientImpl client) {
        this.client = client;
        this.size = size;
        herniPole = new char[size][size];
    }
    
    
    
    @Override
    public int getsize() {
        return size;
        
    }

    @Override
    public char zjistitZnak(int x, int y) {
        return herniPole[x][y];
        
    }

    @Override
    public void vypsatMrizku() {
        
    }

    @Override
    public void aktualizaceMrizky() {
        
        for(int r=0; r<=size; r++){
            for(int s=0; s<=size; s++){
                try {
                    herniPole[r][s]=client.getGrid(r,s);
                } catch (IOException ex) {
                    Logger.getLogger(mrizkaImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
        }
    }
    
}
