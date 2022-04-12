
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
public class TembelSirin extends Oyuncu {

    public TembelSirin() {
    
    ImageIcon img = new ImageIcon("src/img/tembel.png");
        image = img.getImage();
    }
    
     @Override
    public void AzmanDokunma() {
        super.AzmanDokunma();
       skor-=5;
                
        
    }

    @Override
    public void GargamelDokunma() {
        super.GargamelDokunma();
        skor -=15;
    }

    @Override
    public void PuaniGoster() {
        super.PuaniGoster(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Yeni puan : " + getSkor()); 
       
    }

    @Override
    public void Hareket(int dx , int dy) {
     //super.Hareket(dx, dy);
     
     x+=dx;
     y+=dy;
         
    }

    @Override
    public int HareketSinirlari(int x, int y, int[][] dizi,int i, int j) {
       return super.HareketSinirlari(x, y, dizi,i,j); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
}
