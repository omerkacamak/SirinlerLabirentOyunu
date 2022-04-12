
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 90545
 */
public class Dijikstra {

    DosyIslem dos = new DosyIslem();
    int[][] dizi = new int[11][13];
    int satir[] = {-1, 0, 0, 1};  // bir hücreden hareket edilebielcek yönler!
    int sutun[] = {0, -1, 1, 0};
    ArrayList<Node> nodes = new ArrayList<>();

    public Dijikstra() {

    }

    public void NodeKomsuEkle(ArrayList<Node> nodes) {
        dos.DosyaDizi(dizi);
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 13; j++) {
//                         if(dizi[i][j] == 0)
//                         {
//                             nodes.add(new Node(i, j, 0));
//                         }

                if (dizi[i][j] == 1) {
                    nodes.add(new Node(i, j, 1));

                }
            }

        }

        Node komsuNode = null;
        Node nude = null;
        for (int i = 0; i < nodes.size(); i++) {
            for (int k = 0; k < 4; k++) {
                //   nodes.get(i).komsular.add(new Komsuluk(nodes.,1,nodes.get(i).x+satir[k],nodes.get(i).y+sutun[k]));
                // for(int j=0; j<nodes.size();j++)

                nude = nodes.get(i);

                for (int a = 0; a < nodes.size(); a++) {
                    // System.out.println("   " + nude);
                    if (nude.x + satir[k] == nodes.get(a).x && nude.y + sutun[k] == nodes.get(a).y && nodes.get(a).duvar == 1) {
                        komsuNode = nodes.get(a); // ana düğümümn komşu düğümlerini bulduk!

                        //  System.out.println("komsu node : : " +komsuNode);
                        // System.out.println(" BİTTİ");
                        nodes.get(i).komsular.add(new Komsuluk(komsuNode, 1, nodes.get(i).x + satir[k], nodes.get(i).y + sutun[k]));

                    }
                }

                //nodes.get(i).komsular.add(new Komsuluk(komsuNode,1,nodes.get(i).x+satir[k],nodes.get(i).y+sutun[k]));
            }
        }

//        for(int i=0;i<nodes.get(4).komsular.size();i++)
//        {
//          
//            System.out.println("kim ?  : " + nodes.get(4).komsular.get(i));
//            System.out.println(" sss : " + nodes.get(4).komsular.size());
//        }
    }
    
      public void KomsulukMatrisi(int Matris[][]) {

        NodeKomsuEkle(nodes);
        System.out.println(" " + nodes.get(10));
        System.out.println(" " + nodes.get(1).komsular.get(0));

        System.out.println("LANN");
        System.out.println("             \n\n");
        System.out.println("Size : : : " + nodes.size());

        for (int i = 0; i < nodes.size(); i++) {
            for (int j = 0; j < nodes.size(); j++) {
                int deger = 0;
                for (int k = 0; k < nodes.get(i).komsular.size(); k++) {
                    if (nodes.get(i).komsular.get(k).hedefVertex == nodes.get(j)) {
                        deger = 1;
                        Matris[i][j] = 1;
                    }
                }

                if (deger == 0) {
                    Matris[i][j] = 0;
                }
//              
//             
            }
        }

        for (int i = 0; i < nodes.size(); i++) {
            for (int j = 0; j < nodes.size(); j++) {

                System.out.print(" " + Matris[i][j]);

            }
            System.out.print("\n");
        }

    }// Komsuluk matrisi sonu


    public void KisaYol(int kaynakX, int kaynakY, int hedefX, int hedefY) {
        //  NodeKomsuEkle();
        Node kaynakNode = null, hedefNode = null, tmpNode;
        int aktifIndex = 0;
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).x == kaynakX && nodes.get(i).y == kaynakY) {
                kaynakNode = nodes.get(i);
                System.out.println(" Güzel : " + kaynakNode);
                aktifIndex = i;

            }

        }

        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).x == hedefX && nodes.get(i).y == hedefY) {
                hedefNode = nodes.get(i);

            }

        }

//        
        for (int i = 0; i < nodes.size(); i++) {
            nodes.get(i).minMesafe = Integer.MAX_VALUE;
            nodes.get(i).kullanildiMi = false;
        }
//        
        kaynakNode.minMesafe = 0;
        // System.out.println(" aktif: " + aktifIndex);
        nodes.get(aktifIndex).minMesafe = 0;
        Node aktifNode = nodes.get(aktifIndex);
        //   System.out.println("kaynak : : " + kaynakNode);

        for (int i = 0; i < nodes.get(aktifIndex).komsular.size(); i++) {
            nodes.get(aktifIndex).komsular.get(i).hedefVertex.minMesafe = nodes.get(aktifIndex).komsular.get(i).mesafe;

            nodes.get(aktifIndex).komsular.get(i).hedefVertex.parent = aktifNode;

        }

        int aktifNodeIndex = 8;
        int tmp = Integer.MAX_VALUE;

        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).minMesafe < tmp && nodes.get(i).kullanildiMi != true) {
                tmp = nodes.get(i).minMesafe;
                aktifNodeIndex = i;
                System.out.println("İndex : " + aktifNodeIndex);
            }
        }

        aktifNode = nodes.get(aktifNodeIndex);
        System.out.println("İlk AKTİF : " + nodes.get(aktifNodeIndex) + "  ------   " + nodes.get(aktifIndex));

        for (int i = 0; i < (nodes.size() - 1); i++) {
            aktifNode.kullanildiMi = true;
            for (int j = 0; j < nodes.get(aktifNodeIndex).komsular.size(); j++) {
                if ((nodes.get(aktifNodeIndex).komsular.get(j).mesafe + aktifNode.minMesafe) < nodes.get(aktifNodeIndex).komsular.get(j).hedefVertex.minMesafe) {
                    nodes.get(aktifNodeIndex).komsular.get(j).hedefVertex.minMesafe = (nodes.get(aktifNodeIndex).komsular.get(j).mesafe + aktifNode.minMesafe);
                    nodes.get(aktifNodeIndex).komsular.get(j).hedefVertex.parent = aktifNode;
                }
            }

            tmp = Integer.MAX_VALUE;

            for (int k = 0; k < nodes.size(); k++) {// sıradaki şehri belirler, şehrin kullanılıp kullanılmadığına ve kullanılan şehrin dışındakilere bakar. 
                if (nodes.get(k).minMesafe < tmp && nodes.get(k).kullanildiMi != true) {
                    tmp = nodes.get(k).minMesafe;    //minimum mesafeyi veriyor(kontrol amaçlı)
                    aktifNodeIndex = k;   //şehrin indeksini tutar                
                }
            }
            if (aktifNode == hedefNode) {
                System.out.println("Ulaşıldı : " + aktifNode);
            }

            aktifNode = nodes.get(aktifNodeIndex);

        }

        System.out.println("ikinci aktif : " + aktifNode);

    }

   
    
   Dijikstra dam = new Dijikstra();
//     DosyIslem dos = new DosyIslem();
//      int [][] dizi = new int [11][13];
       ArrayList<Node> nodeA= new ArrayList<>();
    
    static final int V = 78;
    int minDistance(int dist[], Boolean sptSet[])
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;
  
        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
               
            }
  
        return min_index;
    }
  
    // A utility function to print the constructed distance array
    void printSolution(int dist[], int n)
    {
     
        dam.NodeKomsuEkle(nodeA);
        
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i +" " + nodeA.get(i) + "olan uzaklığı : "  + " \t " + dist[i]);
    }
  
    // Function that implements Dijkstra's single source shortest path
    // algorithm for a graph represented using adjacency matrix
    // representation
    void dijkstra(int graph[][], int src)
    {
         dam.NodeKomsuEkle(nodeA);
        int dist[] = new int[V]; // The output array. dist[i] will hold
        // the shortest distance from src to i
  
        // sptSet[i] will true if vertex i is included in shortest
        // path tree or shortest distance from src to i is finalized
        Boolean sptSet[] = new Boolean[V];
  
        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
  
        // Distance of source vertex from itself is always 0
        dist[src] = 0;
  
        // Find shortest path for all vertices
        for (int count = 0; count < V - 1; count++) {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            int u = minDistance(dist, sptSet);
           
            // Mark the picked vertex as processed
            sptSet[u] = true;
            
            //System.out.println("bağırdım : " +u);
  
            // Update dist value of the adjacent vertices of the
            // picked vertex.
            for (int v = 0; v < V; v++)
            {
                // Update dist[v] only if is not in sptSet, there is an
                // edge from u to v, and total weight of path from src to
                // v through u is smaller than current value of dist[v]
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                   
                    dist[v] = dist[u] + graph[u][v];
         
            
              
            }
              
        }
  
        // print the constructed distance array
        printSolution(dist, V);
    }

}
