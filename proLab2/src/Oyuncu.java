
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
public class Oyuncu extends Karakter {
public String oyuncuAdi;
public int oyuncuID,skor;

    public Oyuncu() {
        
        setX(6);
        setY(5);
        skor=20;
    }

  
    public void PuaniGoster()
    {
        System.out.println("Şirinin puani : " + this.skor);
    }
    public void GargamelDokunma()
    {
        
    }
    
    public void AzmanDokunma()
    {
        
    }
    
   public void Hareket(int dx, int dy)
   {
       
   }
   
    public int HareketSinirlari(int x, int y, int dizi[][], int i, int j) //  bir sonraki adımı kontorl edebilmesi için oluşturulan fonksiyon !! ! ! !
    {
        
        x=x+i;
        y=y+j;
        
        int a;
        
        a = dizi[y][x];
        
        return a;
    }
   
    
    
    
    
    
    public String getOyuncuAdi() {
        return oyuncuAdi;
    }

    public void setOyuncuAdi(String oyuncuAdi) {
        this.oyuncuAdi = oyuncuAdi;
    }


    public int getOyuncuID() {
        return oyuncuID;
    }

    public void setOyuncuID(int oyuncuID) {
        this.oyuncuID = oyuncuID;
    }

    public int getSkor() {
        return skor;
    }

    public void setSkor(int skor) {
        this.skor = skor;
    }
    
    
    
}
