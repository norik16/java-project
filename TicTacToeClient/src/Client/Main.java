/*
 * The MIT License
 *
 * Copyright 2015 LukeMcNemee.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package Client;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

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
                while (cl.getGrid(i, i) != '_') {
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

    public static void play(ClientImpl cl) throws IOException {
        mrizkaImpl mr = new mrizkaImpl(cl.getSize(), cl);

        for (int i = 0; i < mr.getsize(); i++) {
            for (int j = 0; j < mr.getsize() - 3; j++) {
                //if for 4 points
                /*int xd = 0;
                int od = 0;
                int xv = 0;
                int ov = 0;
                int xh = 0;
                int oh = 0;*/
                
                
                Set<point> xh = new HashSet<>();                
                Set<point> oh = new HashSet<>();                
                Set<point> xv = new HashSet<>();                
                Set<point> ov = new HashSet<>();                
                Set<point> xd = new HashSet<>();                
                Set<point> od = new HashSet<>();

                for (int n = 0; n < 5; n++) { 
                    if (mr.zjistitZnak(i + n, j) == 'X') {
                        
                        xh.add(new point(i + n, j)); //tohle udelat pro vsechny zbyle promenne do vsech smeru
                    } else {
                        oh.add(new point(i + n, j));
                    }

                    if (mr.zjistitZnak(i, j + n) == 'X') {
                        xv.add(new point(i, j + n));
                    } else {
                        ov.add(new point(i, j + n));
                    }

                    if (mr.zjistitZnak(i + n, j + n) == 'X') {
                        xd.add(new point(i + n, j + n));
                    } else {
                        od.add(new point(i + n, j + n));
                    }
                } // v promenych xh az od jsou ulozeny pocty jednotlivych znaku
                
               
                if ( xh.size() == 4){
                    
                    four ctverice = new four(new point(i, j), new point(i+1, j), new point(i+2, j), new point(i+3, j), mr.zjistitZnak(i, j));
                    }
                else if (xh.size() == 3) { three trojice = new three (new point(i, j), new point(i+1, j), new point(i+2, j), mr.zjistitZnak(i, j));}
                
                
                if ( oh.size() == 4){
                
                    four ctverice = new four(new point(i, j), new point(i+1, j), new point(i+2, j), new point(i+3, j), mr.zjistitZnak(i, j));   
                }
                else if (oh.size() == 3) { three trojice = new three (new point(i, j), new point(i+1, j), new point(i+2, j), mr.zjistitZnak(i, j));}
                
                
                if ( xv.size() == 4){
                
                    four ctverice = new four(new point(i, j), new point(i, j + 1), new point(i, j + 2), new point(i, j + 3), mr.zjistitZnak(i, j));
                }
                else if (xv.size() == 3) { three trojice = new three (new point(i, j), new point(i, j + 1), new point(i, j + 2), mr.zjistitZnak(i, j));}
                
                
                if ( ov.size() == 4){
                
                    four ctverice = new four(new point(i, j), new point(i, j + 1), new point(i, j + 2), new point(i, j + 3), mr.zjistitZnak(i, j));
                }
                else if (ov.size() == 3) { three trojice = new three (new point(i, j), new point(i, j + 1), new point(i, j + 2), mr.zjistitZnak(i, j));}
                
                
                if ( xd.size() == 4){
                
                    four ctverice = new four(new point(i, j), new point(i + 1, j + 1), new point(i + 2, j + 2), new point(i + 3, j + 3), mr.zjistitZnak(i, j));
                }
                else if (xd.size() == 3) { three trojice = new three (new point(i, j), new point(i+1, j+1), new point(i+2, j+2), mr.zjistitZnak(i, j));}
                
                
                if ( od.size() == 4){
                
                    four ctverice = new four(new point(i, j), new point(i + 1, j + 1), new point(i + 2, j + 2), new point(i + 3, j + 3), mr.zjistitZnak(i, j));
                }
                else if (od.size() == 3) { three trojice = new three (new point(i, j), new point(i+1, j+1), new point(i+2, j+2), mr.zjistitZnak(i, j));}
               
                
                     
                }
            }

            
            

        }
                        
                    three trojice = new three(new point(i,j), new point(i,j+1), new point(i,j+2), mr.zjistitZnak(i, j));
                }

    }
}

}

}
