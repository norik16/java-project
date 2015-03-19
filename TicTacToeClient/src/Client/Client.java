/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Client;


import java.io.*;
import java.net.*;
/**
 *
 * @author LukeMcNemee
 */
public interface Client {
    
    public int connect(String IP, int port) throws IOException;
    
    public int disconnect() throws IOException;
    
    public State getStatus() throws IOException;
    
    public int getSize() throws IOException;
    
    public char getColor() throws IOException;
    
    public char getGrid(int x, int y) throws IOException;
    
    public int play(int x, int y) throws IOException;
}
