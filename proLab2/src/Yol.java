
import java.awt.Image;
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
public class Yol {
    int x,y;
    public Image image;

    public Yol() {
        
         ImageIcon img = new ImageIcon("src/img/yol.png");
        image = img.getImage();
        
        
    }
}
