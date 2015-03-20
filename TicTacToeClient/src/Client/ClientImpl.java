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
public class ClientImpl implements Client{

    private Socket clientSocket;
    private DataOutputStream outToServer;
    private BufferedReader inFromServer;
    
    @Override
    public int connect(String IP, int port)  throws IOException {
        clientSocket = new Socket(IP, port);
        outToServer = new DataOutputStream(clientSocket.getOutputStream());
        inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        return 0;
    }

    @Override
    public int disconnect()throws IOException{
        clientSocket.close();
        return 0;
    }

    @Override
    public State getStatus() throws IOException{
        outToServer.writeBytes("STATUS"+"\n");
        String response = inFromServer.readLine();
        System.out.println(response);
        if(response.equals("DEFEAT")){
            return State.DEFEAT;
        }
        if(response.equals("PLAY")){
            return State.PLAY;
        }
        if(response.equals("WAIT")){
            return State.WAIT;
        }
        if(response.equals("WIN")){
            return State.WIN;
        }        
        return null;
    }

    @Override
    public int getSize() throws IOException{
        outToServer.writeBytes("SIZE"+"\n");
        String response = inFromServer.readLine();
        System.out.println(response);
        return Integer.getInteger(response);
    }

    @Override
    public char getColor() throws IOException{
        outToServer.writeBytes("COLOR"+"\n");
        String response = inFromServer.readLine();
        System.out.println(response);
        return response.charAt(0);
    }

    @Override
    public char getGrid(int x, int y) throws IOException{
        outToServer.writeBytes("GRID "+ x + " " + y  +"\n");
        String response = inFromServer.readLine();
        System.out.println(response);
        return response.charAt(0);
    }

    @Override
    public String play(int x, int y) throws IOException {
        outToServer.writeBytes("PLAY "+ x + " " + y  +"\n");
        String response = inFromServer.readLine();
        System.out.println(response);
        return response;
    }
    
}
