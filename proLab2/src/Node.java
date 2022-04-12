
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 90545
 */
public class Node {
     public ArrayList<Komsuluk> komsular = new ArrayList<>(); 
    int x, y, dist;
    Node parent;
    
    int duvar;
     public int minMesafe = 0;
     public boolean kullanildiMi = false;

  public  Node(int x, int y, int duvar, Node parent) {
        this.x = x;
        this.y = y;
        this.duvar = duvar;
        this.parent = parent;
    }

    public Node(int x, int y, Node parent) {
        this.x = x;
        this.y = y;
        this.parent = parent;
    }

    public Node(int x,int y,int duvar) {
        this.x = x;
        this.y=y;
        this.duvar=duvar;
    }

    
  

    @Override
    public String toString() {
        return "{" + x + ", " + y + '}';
    }
}
