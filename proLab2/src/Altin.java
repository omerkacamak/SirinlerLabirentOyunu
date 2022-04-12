
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 90545
 */
public class Altin extends Thread {
    public int x,y;
    Random rnd;
    public Image image;
    int [][] labirent = new int[11][13];
    int dizi[][];
    int altınSayisi;

    public Altin(int dizi[][]) {
     
        ImageIcon img = new ImageIcon("src/img/altin.png");
        image = img.getImage();
        rnd= new Random();
        this.dizi=dizi;
        this.x=5555;
        this.y=5555;
      
           System.out.println("X  : :: : " + this.x);
        
    }


    @Override
    public void run() {
        try {
            //To change body of generated methods, choose Tools | Templates.

         while(true)
         {
           sleep(6500);
            do{
                x=rnd.nextInt(13);
                y=rnd.nextInt(11);
            }while(dizi[y][x]==0 );
            
             sleep(5000);
            x=800;
            y=700; 
             
         }
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Altin.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    
    
    
}
