import java.util.*;
import java.io.*;
public class USACO{
  public static void main(String[] args){
    silver("testCases/ctravel.1.in");
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
        stomp(sca.nextInt(),sca.nextInt(),sca.nextInt(),map);
      }
    }catch(FileNotFoundException e){

    }
    return -1;
  }
  public static int[][] getMap(Scanner sca,int r,int c){
    int[][] out = new int[r][c];
    for(int i=0;i<out.length;i++){
      for(int j=0;j<out[i].length;j++){
        out[r][c] = sca.nextInt();
      }
    }
    return out;
  }
  public static void stomp(int r,int c,int depth,int[][] map){

  }


  public static int silver(String filename){
    try{
      Scanner sca = new Scanner( new File(filename) );
      int n = sca.nextInt();
      int m = sca.nextInt();
      int t = sca.nextInt();
      System.out.println(n);
      System.out.println(m);
      System.out.println(t);
      int[][] map = getMapSilver(sca,n,m);
      int r1 = sca.nextInt();
      int c1 = sca.nextInt();
      int r2 = sca.nextInt();
      int c2 = sca.nextInt();
      for(int[] row : map){
        System.out.println(Arrays.toString(row));
      }
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
}
