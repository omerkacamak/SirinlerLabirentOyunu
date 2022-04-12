
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 90545
 */
public class OyunYonetimi extends JPanel {

    Image yol, duvar, sirine,aHarf,bHarf,cHarf,dHarf;
    DosyIslem dosya;
    int pix = 60;
    Oyuncu sirinimiz;
    Dusman dusman1, dusman2;
    EnKisaYol enKisa;
    Yol gidilecekYol1, gidilecekyol2;
    Skor skr,skr2;
    Timer timer;
    Altin altin, altin2;
    ArrayList<Altin> altinListe;
    Mantar mantar;
    
ArrayList<Integer> yeniYolX;
ArrayList<Integer> yeniYolX2;
ArrayList<Integer> yeniYolY;
ArrayList<Integer> yeniYolY2;
    int[][] labirent = new int[11][13];
    JButton jb= new JButton("SKOR");

  
 

   

    
    public OyunYonetimi( ) {
        
          
        setLayout(new FlowLayout(FlowLayout.RIGHT,60,300));

        jb.addActionListener(new Aksiyon());
        altinListe = new ArrayList<>();
       yeniYolX = new ArrayList<>();
       yeniYolX2 = new ArrayList<>();
       yeniYolY = new ArrayList<>();
       yeniYolY2 = new ArrayList<>();
        gidilecekYol1 = new Yol();
        enKisa = new EnKisaYol();
        dosya = new DosyIslem();
        dosya.DosyaDizi(labirent);// txt dosyasındaki harita matrisin içine atıldı.
        dosya.Dosya();
        dusman1 = Lokasyon.dusmankarakterimiz.get(0);
        dusman1.x = Lokasyon.kapiX.get(0);
        dusman1.y = Lokasyon.kapiY.get(0);
        skr2=new Skor();
         add(skr2);
         skr2.setFont(new Font("verdana", Font.BOLD, 20) {
         });
         
        System.out.println("----223" + " " + Lokasyon.dusmankarakterimiz.get(0));
        addKeyListener(new Kontrol());
        setFocusable(true);
        skr = new Skor();
        timer = new Timer(25, new Aksiyon());
        timer.start();

        for (int i = 0; i < 5; i++) {
            altinListe.add(new Altin(labirent));
            altinListe.get(i).start();
        }

        mantar = new Mantar(labirent);
        mantar.start();

        if (Lokasyon.dusmankarakterimiz.size() > 1) {
            dusman2 = Lokasyon.dusmankarakterimiz.get(1);
            dusman2.x = Lokasyon.kapiX.get(1);
            dusman2.y = Lokasyon.kapiY.get(1);
        }

//         if(Lokasyon.kapiY.size()>1)
//        {
//         System.out.println("  1:"+Lokasyon.kapiY.get(1));
//         dusman2.x = Lokasyon.kapiX.get(1);
//        dusman2.y = Lokasyon.kapiY.get(1);
//        }
        sirinimiz = Lokasyon.sirinimiz.get(0);
        ImageIcon img = new ImageIcon("src/img/duvar.png");
        yol = img.getImage();
        img = new ImageIcon("src/img/griDuvar.png");
        duvar = img.getImage();
        img = new ImageIcon("src/img/sirineBuyuk.png");
        sirine = img.getImage();
         img = new ImageIcon("src/img/aHarfi.png");
        aHarf = img.getImage();
         img = new ImageIcon("src/img/bHarfi.png");
        bHarf = img.getImage();
         img = new ImageIcon("src/img/cHarfi.png");
        cHarf = img.getImage();
         img = new ImageIcon("src/img/dHarfi.png");
        dHarf = img.getImage();

        System.out.println("Şirinimiz " + sirinimiz);

    }

  @Override
   public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 13; j++) {
                if (labirent[i][j] == 0) {
                    g.drawImage(duvar, j * pix, i * pix, null);

                }
                if (labirent[i][j] == 1) {
                    g.drawImage(yol, j * pix, i * pix, null);

                }
            }
        }
      for(int i=dusman1.hareketIndex+1; i<Lokasyon.yolX.size()-1;i++)
        {
          

          g.drawImage(gidilecekYol1.image, Lokasyon.yolY.get(i)*60,Lokasyon.yolX.get(i)*60 , null);
        
            
        }
            
         g.drawImage(dHarf, 3*pix, 10*pix, null); 
        g.drawImage(cHarf, 0*pix, 5*pix, null);
        g.drawImage(bHarf, 10*pix, 0*pix, null);
        g.drawImage(aHarf, 3*pix, 0*pix, null);
        g.drawImage(sirine, 13 * pix, 7 * pix, null);
        g.drawImage(sirinimiz.image, sirinimiz.x * pix, sirinimiz.y * pix, null);
        g.drawImage(dusman1.image, dusman1.x * pix, dusman1.y * pix, null);
        //System.out.println("Lan noldu : " +Lokasyon.xKoordinat.get(0));
        if (Lokasyon.dusmankarakterimiz.size() > 1) {
            g.drawImage(dusman2.image, dusman2.x * pix, dusman2.y * pix, null);

        }
 
        add(skr);
        String tutucuSkor = Integer.toString(sirinimiz.skor);
        skr.setText(tutucuSkor);
         skr.setFont(new Font("verdana", Font.BOLD, 20) {
         });
        

       
            
     
//            
            
            

//        Lokasyon.yolX.clear();
//      Lokasyon.yolY.clear();
        AltinEkle(g);

        g.drawImage(mantar.image, mantar.x * pix, mantar.y * pix, null);
       
    }

    public void AltinEkle(Graphics g) {

        for (int i = 0; i < 5; i++) {
            g.drawImage(altinListe.get(i).image, altinListe.get(i).x * pix, altinListe.get(i).y * pix, null);

        };

    }

    public void oyunKazanır() {
        if (sirinimiz.x == 12 && sirinimiz.y == 7) {
            
            JOptionPane.showMessageDialog(null, "KAZANDINIZ! SKORUNUZ : " +sirinimiz.skor);
            timer.stop();
        }
    }
    
    public void GameOver()
    {
        if (sirinimiz.skor<=0) {
            
            JOptionPane.showMessageDialog(null, "KAYBETTİNİZ ŞİRİNE KURTARILAMADI");
            
            timer.stop();
            
        }
    }

    public class Kontrol extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            int keycode = e.getKeyCode();

            if (keycode == KeyEvent.VK_UP) {
                if (sirinimiz.HareketSinirlari(sirinimiz.x, sirinimiz.y, labirent, 0, -1) != 0) {
                     Lokasyon.yolX.clear();
                    Lokasyon.yolY.clear(); 
                    sirinimiz.Hareket(0, -1);
                    repaint();
                    
                    EnKisaYol.KisaYol(labirent, dusman1.y, dusman1.x, sirinimiz.y, sirinimiz.x);
                    
                 
                    repaint();
                    
                    if (dusman1.hareketIndex >= Lokasyon.yKoordinat.size()) // düşman arada 2 giderken aradaki mesafe de 2 olursa 1 e indiriyor adımı!
                    {
                        dusman1.x = Lokasyon.yKoordinat.get(dusman1.hareketIndex - 1);
                        dusman1.y = Lokasyon.xKoordinat.get(dusman1.hareketIndex - 1);
                    } else {
                        dusman1.x = Lokasyon.yKoordinat.get(dusman1.hareketIndex);
                        dusman1.y = Lokasyon.xKoordinat.get(dusman1.hareketIndex);

                    }
                    Lokasyon.xKoordinat.removeAll(Lokasyon.xKoordinat);
                    Lokasyon.yKoordinat.removeAll(Lokasyon.yKoordinat);

                    if (dusman2 != null) {
//                 Lokasyon.yolX.clear();
//                    Lokasyon.yolY.clear();      
                        EnKisaYol.KisaYol(labirent, dusman2.y, dusman2.x, sirinimiz.y, sirinimiz.x);
                
                        dusman2.x = Lokasyon.yKoordinat.get(dusman2.hareketIndex);
                        dusman2.y = Lokasyon.xKoordinat.get(dusman2.hareketIndex);
                        Lokasyon.xKoordinat.removeAll(Lokasyon.xKoordinat);
                        Lokasyon.yKoordinat.removeAll(Lokasyon.yKoordinat);
                    }

                    repaint();
                }
            }
            if (keycode == KeyEvent.VK_DOWN) {
                if (sirinimiz.HareketSinirlari(sirinimiz.x, sirinimiz.y, labirent, 0, 1) != 0) {
                    Lokasyon.yolX.clear();
                    Lokasyon.yolY.clear();
                    sirinimiz.Hareket(0, 1);
                    repaint();
                    EnKisaYol.KisaYol(labirent, dusman1.y, dusman1.x, sirinimiz.y, sirinimiz.x);
                    repaint();
                    if (dusman1.hareketIndex >= Lokasyon.yKoordinat.size()) // düşman arada 2 giderken aradaki mesafe de 2 olursa 1 e indiriyor adımı!
                    {
                        dusman1.x = Lokasyon.yKoordinat.get(dusman1.hareketIndex - 1);
                        dusman1.y = Lokasyon.xKoordinat.get(dusman1.hareketIndex - 1);
                    } else {
                        dusman1.x = Lokasyon.yKoordinat.get(dusman1.hareketIndex);
                        dusman1.y = Lokasyon.xKoordinat.get(dusman1.hareketIndex);

                    }
                    Lokasyon.xKoordinat.removeAll(Lokasyon.xKoordinat);
                    Lokasyon.yKoordinat.removeAll(Lokasyon.yKoordinat);

                    if (dusman2 != null) {
//                         Lokasyon.yolX.clear();
//                    Lokasyon.yolY.clear(); 
                        EnKisaYol.KisaYol(labirent, dusman2.y, dusman2.x, sirinimiz.y, sirinimiz.x);
                        dusman2.x = Lokasyon.yKoordinat.get(dusman2.hareketIndex);
                        dusman2.y = Lokasyon.xKoordinat.get(dusman2.hareketIndex);
                        Lokasyon.xKoordinat.removeAll(Lokasyon.xKoordinat);
                        Lokasyon.yKoordinat.removeAll(Lokasyon.yKoordinat);
                    }
//                     
                    repaint();
                }
            }
            if (keycode == KeyEvent.VK_LEFT) {
                if (sirinimiz.HareketSinirlari(sirinimiz.x, sirinimiz.y, labirent, -1, 0) != 0) {
                    Lokasyon.yolX.clear();
                    Lokasyon.yolY.clear();
                    sirinimiz.Hareket(-1, 0);
                    repaint();
                    EnKisaYol.KisaYol(labirent, dusman1.y, dusman1.x, sirinimiz.y, sirinimiz.x);
                    if (dusman1.hareketIndex >= Lokasyon.yKoordinat.size()) // düşman arada 2 giderken aradaki mesafe de 2 olursa 1 e indiriyor adımı!
                    {
                        dusman1.x = Lokasyon.yKoordinat.get(dusman1.hareketIndex - 1);
                        dusman1.y = Lokasyon.xKoordinat.get(dusman1.hareketIndex - 1);
                    } else {
                        dusman1.x = Lokasyon.yKoordinat.get(dusman1.hareketIndex);
                        dusman1.y = Lokasyon.xKoordinat.get(dusman1.hareketIndex);

                    }

                    Lokasyon.xKoordinat.removeAll(Lokasyon.xKoordinat);
                    Lokasyon.yKoordinat.removeAll(Lokasyon.yKoordinat);

                    if (dusman2 != null) {
//                    Lokasyon.yolX.clear();
//                    Lokasyon.yolY.clear(); 
                        EnKisaYol.KisaYol(labirent, dusman2.y, dusman2.x, sirinimiz.y, sirinimiz.x);
                        dusman2.x = Lokasyon.yKoordinat.get(dusman2.hareketIndex);
                        dusman2.y = Lokasyon.xKoordinat.get(dusman1.hareketIndex);
                        Lokasyon.xKoordinat.removeAll(Lokasyon.xKoordinat);
                        Lokasyon.yKoordinat.removeAll(Lokasyon.yKoordinat);
                    }
//                     
                    repaint();
                }
            }
            if (keycode == KeyEvent.VK_RIGHT) {
                if (sirinimiz.HareketSinirlari(sirinimiz.x, sirinimiz.y, labirent, 1, 0) != 0) {
                    Lokasyon.yolX.clear();
                    Lokasyon.yolY.clear();
                    sirinimiz.Hareket(1, 0);
                    repaint();
                    EnKisaYol.KisaYol(labirent, dusman1.y, dusman1.x, sirinimiz.y, sirinimiz.x);

                    if (dusman1.hareketIndex >= Lokasyon.yKoordinat.size()) // düşman arada 2 giderken aradaki mesafe de 2 olursa 1 e indiriyor adımı!
                    {
                        dusman1.x = Lokasyon.yKoordinat.get(dusman1.hareketIndex - 1);
                        dusman1.y = Lokasyon.xKoordinat.get(dusman1.hareketIndex - 1);
                    } else {
                        dusman1.x = Lokasyon.yKoordinat.get(dusman1.hareketIndex);
                        dusman1.y = Lokasyon.xKoordinat.get(dusman1.hareketIndex);

                    }

                    Lokasyon.xKoordinat.removeAll(Lokasyon.xKoordinat);
                    Lokasyon.yKoordinat.removeAll(Lokasyon.yKoordinat);

                    if (dusman2 != null) {
//                             Lokasyon.yolX.clear();
//                    Lokasyon.yolY.clear(); 
                        EnKisaYol.KisaYol(labirent, dusman2.y, dusman2.x, sirinimiz.y, sirinimiz.x);
                        dusman2.x = Lokasyon.yKoordinat.get(dusman2.hareketIndex);
                        dusman2.y = Lokasyon.xKoordinat.get(dusman2.hareketIndex);
                        Lokasyon.xKoordinat.removeAll(Lokasyon.xKoordinat);
                        Lokasyon.yKoordinat.removeAll(Lokasyon.yKoordinat);
                    }

                    repaint();
                }
            }

        }
    }

    class Aksiyon implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           
           
            
            
            
            
            if (dusman1.x == sirinimiz.x && dusman1.y == sirinimiz.y) {
                try {
                    sirinimiz.skor = dusman1.puanAzalt(sirinimiz.skor);
                    dusman1.x = Lokasyon.kapiX.get(0);
                    dusman1.y = Lokasyon.kapiY.get(0);
                 

                    Thread.sleep(190);
                    repaint();
                } catch (InterruptedException ex) {
                    Logger.getLogger(OyunYonetimi.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (Lokasyon.dusmankarakterimiz.size() > 1) {
                if (dusman2.x == sirinimiz.x && dusman2.y == sirinimiz.y) {
                    try {
                        sirinimiz.skor = dusman2.puanAzalt(sirinimiz.skor);

                        dusman2.x = Lokasyon.kapiX.get(1);
                        dusman2.y = Lokasyon.kapiY.get(1);
                        Thread.sleep(190);
                        repaint();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(OyunYonetimi.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            for (int i = 0; i < altinListe.size(); i++) {
                if (sirinimiz.x == altinListe.get(i).x && sirinimiz.y == altinListe.get(i).y) {
                    sirinimiz.skor += 5;
                    altinListe.get(i).x = 1000;
                    altinListe.get(i).y = 1000;
                    repaint();
                }
            }

            if (mantar.x == sirinimiz.x && mantar.y == sirinimiz.y) {
                sirinimiz.skor += 50;
                mantar.x = 1000;
                mantar.y = 1000;
                repaint();
            }
            repaint();

            oyunKazanır();
            GameOver();
        }

    }

}
