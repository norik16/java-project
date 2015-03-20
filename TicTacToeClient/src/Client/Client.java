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
    
    /**
     * připojí se k serveru
     * @param IP adresa (127.0.0.1 pokud server běží na stejném počítači)
     * @param port (předem domluvená hodnota, ideálně v rozsahu 1000+ )
     * @return 0
     * @throws IOException pokud není možné navázat spojení (server neběží nebo již nemá volné místo atd.)
     */
    public int connect(String IP, int port) throws IOException;
    
    /**
     * ukončí existující spojení
     * @return 0
     * @throws IOException 
     */
    public int disconnect() throws IOException;
    
    /**
     * dotaz na server, jaký je stav, buď hra skončila, poté vrací výsledek, nebo neskončila a vrací WAIT, nebo PLAY, podle situace kdo hraje
     * @return současný stav
     * @throws IOException 
     */
    public State getStatus() throws IOException;
    
    /**
     * vrátí velikost mřížky (celková velikost pole n, tedy souřadnice v poli jsou v rozsahu 0 - (n-1) )
     * @return velikost hrací mřížky
     * @throws IOException 
     */
    public int getSize() throws IOException;
    
    /**
     * dotaz na přiřazený symbol
     * @return 'X' nebo 'O'
     * @throws IOException 
     */
    public char getColor() throws IOException;
    
    /**
     * dotaz na symbol na pozici v poli
     * @param x 
     * @param y
     * @return 'X', 'Y', nebo '_' pro prázdné místo, může vrátit jinou hodnotu v případě chyby
     * @throws IOException 
     */
    public char getGrid(int x, int y) throws IOException;
    
    /**
     * požadavek na zahrání na konkrétní souřadnice
     * @param x
     * @param y
     * @return 0 v případě úspěchu, méně jak 0 v případě chyby
     *  -1 = špatné pořadí (má hrát druhý hráč)
     *  -2 = špatné souřadnice, mimo rozsah mřížky
     *  -3 = špatné souřadnice, již hrané pole
     * @throws IOException 
     */
    public String play(int x, int y) throws IOException;
}
