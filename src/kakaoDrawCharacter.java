import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * Created by songchiyun on 2017. 8. 05..
 * kakao problem1
 */
public class kakaoDrawCharacter {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int m = 6;
		int n = 4;
		int[][] a = new int[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++)
				a[i][j] = sc.nextInt();
		}
		kakaoDrawCharacter t = new kakaoDrawCharacter();
		int[] result = t.solution(m,n,a);
		System.out.println(result[0]);
		System.out.println(result[1]);
	}
	static class coord{
		int x,y;
		coord(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
    static boolean[][] v;
	public int[] solution(int m, int n, int[][] picture) {
	      int numberOfArea = 0;
	      int maxSizeOfOneArea = 0;
	      v = new boolean[m][n];
	      for(int i=0;i<m;i++){
	    	  for(int j=0;j<n;j++){
	    		  if(picture[i][j] == 0 || v[i][j])
	    			  continue;
	    		  else{
	    			  numberOfArea++;
	    			  maxSizeOfOneArea = bfs(m,n, new coord(j,i), picture,maxSizeOfOneArea);
	    		  }
	    		  
	    		  
	    	  }
	      }
	      
	      
	      
	      int[] answer = new int[2];
	      answer[0] = numberOfArea;
	      answer[1] = maxSizeOfOneArea;
	      return answer;
	  }
	public static int bfs(int m, int n, coord c, int[][] p, int max){
		Queue<coord> q = new LinkedList<>();
		int size = 0;
		q.add(c);
		while( !q.isEmpty() ){
			coord a = q.remove();
			int x = a.x;
			int y = a.y;
			if(x-1>=0){
				if(p[y][x-1] == p[y][x] && !v[y][x-1]){
					v[y][x-1] = true;
					q.add(new coord(x-1,y));
					size++;
				}
			}
			if(x+1<n){
				if(p[y][x+1] == p[y][x] && !v[y][x+1]){
					v[y][x+1] = true;
					q.add(new coord(x+1,y));
					size++;
				}
			}
			if(y-1>=0){
				if(p[y-1][x] == p[y][x] && !v[y-1][x]){
					v[y-1][x] = true;
					q.add(new coord(x,y-1));
					size++;
				}
			}
			if(y+1<m){
				if(p[y+1][x] == p[y][x] && !v[y+1][x]){
					v[y+1][x] = true;
					q.add(new coord(x,y+1));
					size++;
				}
			}
			
			
		}
		return Math.max(max, size);
		
	}
}
