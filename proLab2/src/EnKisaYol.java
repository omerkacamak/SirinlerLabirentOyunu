
import java.util.ArrayDeque;
import java.util.Queue;



/**
 *
 * @author 90545
 */
public class EnKisaYol {
    public static final int M = 11;
    public static final int N = 13;
    
    public static final int satir[] = { -1, 0, 0, 1 };  
    public static final int sutun[] = { 0, -1, 1, 0 };
    // bir hücreden hareket edilebielcek yönler!
    
    
    
     public static boolean pozGecerliMi (int mat[][], int ziyaret[][],int satir, int sutun)
    {
        return (satir >= 0) && (satir < M) && (sutun >= 0) && (sutun < N)
                && mat[satir][sutun] == 1 && ziyaret[satir][sutun]==0;
    }
     
     
     public static void KisaYol (int mat[][], int i, int j, int x, int y )
     {
         int [][] ziyaret = new int [M][N];
         
         Queue<Node> q = new ArrayDeque<>();
         
         
           ziyaret[i][j] = 1; // kaynak (düşman) başlangıuç konumu 1 oalrak ayarlanır.
        q.add(new Node(i, j, 0, null));
        
        int minDist = Integer.MAX_VALUE;
        Node node = null;
        
         while (!q.isEmpty())
         {
            node = q.poll(); // kuyruğun başındakini at. node'ta sakla. yani node kaynak düğümü saklar.
             i = node.x;  // i ve j kaynağın  x ve y koordinatını tutar.
            j = node.y;
            int dist = node.dist;  
            // System.out.println(" " + i +" " +j);
            
             if (i == x && j == y)   // kaynağın koordinatları hedef koordinata eşit olduğunda DUR!
            {
                minDist = dist;
                break;
            }
             
              for (int k = 0; k < 4; k++)
            {
                
                if (pozGecerliMi(mat, ziyaret, i + satir[k], j + sutun[k]))
                {
                    
                    ziyaret[i +satir[k]][j + sutun[k]] = 1;
                    q.add(new Node (i + satir[k], j + sutun[k], dist + 1, node));
                    System.out.println("--> " + node);
                }
            }
              
             
         }
        
         if (minDist != Integer.MAX_VALUE) {
            System.out.println("En kısa mesafe :  " + minDist);
                    
            yollariGoster(node);
            
        }
        else {
            System.out.println("YOL BULUNAMADI");
        }
         
     }
     
     public static void yollariGoster(Node node)
     {
         if (node == null) {
            return;
        }
         
         yollariGoster(node.parent);
          System.out.println(node);
         
      Lokasyon.xKoordinat.add(node.x);
        Lokasyon.yKoordinat.add(node.y);
        Lokasyon.yolX.add(node.x);
        Lokasyon.yolY.add(node.y); 
     
        
     }
    
}
