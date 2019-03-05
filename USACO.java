import java.util.*;
import java.io.*;
public class USACO{
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
}
