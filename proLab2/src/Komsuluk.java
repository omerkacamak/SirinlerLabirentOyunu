/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 90545
 */
public class Komsuluk {
    
    public  Node hedefVertex;
    public  int mesafe;
    int x,y;

//    public Komsuluk(Node hedefVertex, int mesafe) {
//        this.hedefVertex = hedefVertex;
//        this.mesafe = mesafe;
//    }

    public Komsuluk(Node hedefVertex, int mesafe, int x, int y) {
        this.hedefVertex = hedefVertex;
        this.mesafe = mesafe;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
         //To change body of generated methods, choose Tools | Templates.
         return "{" + x + ", " + y + '}';
    }
    
    

   

    
    
}
