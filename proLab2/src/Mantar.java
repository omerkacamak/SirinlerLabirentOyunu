
import java.awt.Image;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 90545
 */
public class Mantar extends Thread {
public int x,y;
    Random rnd;
    public Image image;
 int dizi[][];
    
    
    public Mantar() {
        
       
        
    }

    public Mantar(int[][] dizi) {
        this.dizi = dizi;
           ImageIcon img = new ImageIcon("src/img/mantar.png");
        image = img.getImage();
          rnd= new Random();
        x=2222;
        y=2222;
    }

    @Override
    public void run() {
             while(true)
         {
                 try {
                     sleep(13000);
                     try {
                         do{
                             x=rnd.nextInt(13);
                             y=rnd.nextInt(11);
                         }while(dizi[y][x]==0 );
                         
                         sleep(7000);
                         x=800;
                         y=700;
                        
                     } catch (InterruptedException ex) {
                         Logger.getLogger(Mantar.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 } catch (InterruptedException ex) {
                     Logger.getLogger(Mantar.class.getName()).log(Level.SEVERE, null, ex);
                 }
         }
    }
    
    
    
}
