package Client;

import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author LukeMcNemee
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        ClientImpl cl = new ClientImpl();

        cl.connect("127.0.0.1", 3248);
        int i = 0;
        System.out.println("my color is: " + cl.getColor());
        while (cl.getStatus().equals(State.PLAY) || cl.getStatus().equals(State.WAIT)) {

            if (cl.getStatus() == State.WAIT) {
                Thread.sleep(1000);

            } else {
                while (cl.getGrid(i, i) != '_' ) {
                    i++;
                } 
                cl.play(i, i);
                
                Thread.sleep(1000);
            }

        }
        System.out.println("end");
        System.out.println(cl.getStatus());

        //scl.disconnect();
    }

}
