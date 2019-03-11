import java.util.*;
import java.io.*;
public class USACO{
  public static void main(String[] args){
    for(int i=1;i<=5;i++){
      System.out.println(bronze("testCases/makelake."+i+".in"));
    }
  }
  public static int bronze(String filename){
    try{
      Scanner sca = new Scanner( new File(filename) );
      int r = sca.nextInt();
      int c = sca.nextInt();
      int e = sca.nextInt();
      int n = sca.nextInt();
      int[][] map = getMap(sca,r,c);
      while(sca.hasNextInt()){
        stomp(sca.nextInt()-1,sca.nextInt()-1,sca.nextInt(),map);
        for(int[] row : map){
          //System.out.println(Arrays.toString(row));
        }
        System.out.println("");
      }
    }catch(FileNotFoundException e){

    }
    return -1;
  }
  public static int[][] getMap(Scanner sca,int r,int c){
    int[][] out = new int[r][c];
    for(int i=0;i<out.length;i++){
      for(int j=0;j<out[i].length;j++){
        out[i][j] = sca.nextInt();
      }
    }
    return out;
  }
  public static void stomp(int r,int c,int depth,int[][] map){
    int maxVal = map[r][c];
    for(int i=0;i<3;i++){
      for(int j=0;j<3;j++){
        if(maxVal < map[r+i][c+j]) maxVal = map[r+i][c+j];
      }
    }
    System.out.println(maxVal);
    int depthTo = maxVal - depth;
    for(int i=r;i<r+3;i++){
      for(int j=c;j<c+3;j++){
        if(map[i][j] > depthTo){
          map[i][j] = depthTo;
        }
      }
    }
  }


  public static int silver(String filename){
    try{
      Scanner sca = new Scanner( new File(filename) );
      int n = sca.nextInt();
      int m = sca.nextInt();
      int t = sca.nextInt();
      int[][] map = getMapSilver(sca,n,m);
      int r1 = sca.nextInt()-1;
      int c1 = sca.nextInt()-1;
      int r2 = sca.nextInt()-1;
      int c2 = sca.nextInt()-1;
      map[r1][c1] = 1;
      for(int i=1;i<=t;i++){
        /* PRINT MAP AT STAGE
        System.out.println("    "+i);
        for(int[] row : map){
          for(int cell : row){
            System.out.print(cell+"\t");
          }
          System.out.println("");
        }
        System.out.println("\n\n");
        */
        map = stepForward(map);
      }
      return map[r2][c2];
    }catch(FileNotFoundException e){
      System.out.println("file not found");
    }
    return -1;
  }
  public static int[][] getMapSilver(Scanner sca,int r,int c){
    int[][] out = new int[r][c];
    for(int i=0;i<r;i++){
      String line = sca.next();
      char[] chrs = line.toCharArray();
      for(int j=0;j<c;j++){
        if(chrs[j] == '*') out[i][j] = -1;
      }
    }
    return out;
  }
  public static int[][] stepForward(int[][] map){
    int[][] out = new int[map.length][map[0].length];
    for(int i=0;i<out.length;i++){
      for(int j=0;j<out[i].length;j++){
        //case: if a tree tile, leave tree tile and stop
        if(map[i][j] == -1){
          out[i][j] = -1;
        }else if(map[i][j] != 0){
        //else: add value of the tile to the four adjacent (non-tree) spaces
          int val = map[i][j];
          //System.out.println("\t"+i+","+j+": "+map[i][j]);
          addToNonTree(map,out,i+1,j,val);
          addToNonTree(map,out,i,j+1,val);
          addToNonTree(map,out,i-1,j,val);
          addToNonTree(map,out,i,j-1,val);
        }
      }
    }
    return out;
  }
  public static void addToNonTree(int[][] orig,int[][]map,int r,int c,int val){
    if(r>=0 && r<orig.length &&
       c>=0 && c<orig[r].length &&
       orig[r][c] != -1){
      map[r][c] += val;
    }
    //else System.out.println("out of bounds "+r+","+c);
  }
}
