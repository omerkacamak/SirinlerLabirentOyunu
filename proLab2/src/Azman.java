
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
public class Azman extends Dusman {

    public Azman() {
     ImageIcon img = new ImageIcon("src/img/azman.png");
        image = img.getImage();
        hareketIndex =1;
  
    }

    @Override
    public int puanAzalt(int skor) {
        return skor-=5;
    }

    
    
    
    
}
