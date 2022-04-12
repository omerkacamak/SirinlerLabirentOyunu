
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 90545
 */
public class DosyIslem {
    public void DosyaDizi(int dizi[][]) 
{
    Scanner sc;
       
        try {
            sc = new Scanner(new File("harita.txt"));
            while(sc.hasNextInt())
             { 
                 for(int i =0; i<11;i++)
                 {
                     for(int j =0;j<13;j++)
                     {
                         dizi[i][j]=sc.nextInt();
//                         Denemelik.dugumlerTut.add(new Vertex)
                         System.out.print(" " +  dizi[i][j]);
                     }
                     System.out.print("\n");
                 }
   
             }
                      sc.close();
         
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DosyIslem.class.getName()).log(Level.SEVERE, null, ex);
        }
            
             
             
             
}
    
    
    
     public void Dosya () 
    {
        FileReader f = null;
        try {
            Karakter k = new Karakter();
            f = new FileReader("karakterler.txt");
            Scanner sc = new Scanner(f);
            while(sc.hasNext())
            {
                String line = sc.nextLine();
                String[] bolum = line.split(":");
                
              
               
                   Lokasyon.isimTutucu.add(bolum[1]);
                   Lokasyon.kapiTutucu.add(bolum[3]); // kapi numarasini alıyor!!!
                    
                
                
                
                
                
                
                
                
                
                
            }   sc.close();
//         
if(Lokasyon.isimTutucu.get(0).equals("Gargamel"))
{
    Lokasyon.dusmankarakterimiz.add(new Gargamel());
}
else  if(Lokasyon.isimTutucu.get(0).equals("Azman"))
{
    Lokasyon.dusmankarakterimiz.add(new Azman());
}



if(Lokasyon.isimTutucu.get(1).equals("Gargamel"))
{
    Lokasyon.dusmankarakterimiz.add(new Gargamel());
}
else  if(Lokasyon.isimTutucu.get(1).equals("Azman"))
{
    Lokasyon.dusmankarakterimiz.add(new Azman());
}
else
{
    System.out.println("Eklenmedi");
    //Lokasyon.dusmankarakterimiz.add(new Dusman());
    
   // Lokasyon.dusmankarakterimiz.add(null);
   
            
           
}



if(Lokasyon.kapiTutucu.get(0).equals("A"))
{
    Lokasyon.kapiX.add(3);
    Lokasyon.kapiY.add(0);
}
else if(Lokasyon.kapiTutucu.get(0).equals("B"))
{
    Lokasyon.kapiX.add(10);
    Lokasyon.kapiY.add(0);
}
else if(Lokasyon.kapiTutucu.get(0).equals("C"))
{
    Lokasyon.kapiX.add(0);
    Lokasyon.kapiY.add(5);
}
else if(Lokasyon.kapiTutucu.get(0).equals("D"))
{
    Lokasyon.kapiX.add(3);
    Lokasyon.kapiY.add(10);
}


// TXT İÇİNDEKİ İKİNCİ SATIRDAKİ  İKİNCİ DÜŞMAN İÇİN!  kapiX.get(1) olarak alınır!!!!

if(Lokasyon.kapiTutucu.get(1).equals("A"))
{
    Lokasyon.kapiX.add(3);
    Lokasyon.kapiY.add(0);
}
else if(Lokasyon.kapiTutucu.get(1).equals("B"))
{
    Lokasyon.kapiX.add(10);
    Lokasyon.kapiY.add(0);
}
else if(Lokasyon.kapiTutucu.get(1).equals("C"))
{
    Lokasyon.kapiX.add(0);
    Lokasyon.kapiY.add(5);
}
else if(Lokasyon.kapiTutucu.get(1).equals("D"))
{
    Lokasyon.kapiX.add(3);
    Lokasyon.kapiY.add(10);
}

















        } catch (FileNotFoundException ex) {
            Logger.getLogger(DosyIslem.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                f.close();
            } catch (IOException ex) {
                Logger.getLogger(DosyIslem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
      
    }
    
}
