
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 90545
 */
public class Main {
    
    int mGenislik=1000;
    int mYukseklik=700;
    JFrame pencere;
    JPanel jp ;
    OyunYonetimi oyun;
    JLabel label;

    
    
    public static void main(String[] args) throws FileNotFoundException {



// String sayi = JOptionPane.showInputDialog("Bir sayı giriniz");
//        
//        // Alınan sayıyı bilgilendirme ekranıyla gösteriyoruz.
//        JOptionPane.showMessageDialog(null, sayi, "Girilen Sayı", JOptionPane.CANCEL_OPTION);
      
    }
Skor skr;
    public Main() {
     
 
        pencere = new JFrame("ŞİRİNLER OYUNU");
      
      oyun=new OyunYonetimi();
       jp= new JPanel(null);
        pencere.setVisible(true);
       JButton buton = new JButton("REST");
       JButton buton1 = new JButton("goll");
       buton.setSize(30, 30);
// pencere.setLocationRelativeTo(null);
        //pencere.setSize(700,700);
        SetDimension(0, 700, pencere);
        
       
         // pencere.add(new OyunYonetimi(null));
         pencere.add(oyun);
         
  
   
         
        pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
      
     
      
    }
    
    public void Restart()
    {
       pencere.setVisible(false);
    }
    
    
     public void SetDimension (int Genislik, int Yukseklik, JFrame pencere)   // hangi pcde olursak olalım ekranın ortasında ve ekrandan taşmayacak şekilde frame açmamıza olanak sağlıyor
    {
       Dimension Dim =  Toolkit.getDefaultToolkit().getScreenSize(); // her pcde ekranın boyutunu alıyor!
       
       
       int PosX =0;
       int PosY;
       
       if(mGenislik+100>Dim.width)
           mGenislik= Dim.width-100;
       
       if(mYukseklik +100> Dim.height)
           mYukseklik =Dim.height-100;
       
       PosX = (Dim.width -mGenislik)/2;
       PosY =(Dim.height-mYukseklik)/2;
       
        pencere.setBounds(PosX, PosY,mGenislik,mYukseklik);
       
    }
    
}
