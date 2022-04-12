
import java.awt.Image;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 90545
 */
public class Dusman extends Karakter {
    public int dusmanID;
    public String dusmanAdi;
   public Image image;
   public int hareketIndex;
    public Dusman() {
        
        x=0;
        y=0;
        
    }
    
   
    
  
    public int puanAzalt(int skor)
    {
        // gargamel ve azman classında override edielcek!
        return 0;
    }
    
    
    
    
    
    
    
    public int getDusmanID() {
        return dusmanID;
    }

    public void setDusmanID(int dusmanID) {
        this.dusmanID = dusmanID;
    }

    public String getDusmanAdi() {
        return dusmanAdi;
    }

    public void setDusmanAdi(String dusmanAdi) {
        this.dusmanAdi = dusmanAdi;
    }
    
    
    
}
