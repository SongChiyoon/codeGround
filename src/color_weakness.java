import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 8. 24..
 * https://www.acmicpc.net/problem/10026
 */
public class color_weakness {

	static class coord{
		int x, y;
		coord(int x, int y){
			this.x = x;
			this.y =y;
		}
	}
	static int N;
	static char[][] d;
	static boolean[][] v, v2;
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		d = new char[N][N];
		v = new boolean[N][N];
		v2 = new boolean[N][N];
		for(int i=0;i<N;i++){
			String input = sc.next();
			for(int j=0;j<N;j++){
				d[i][j] = input.charAt(j);
			}
		}

		int ans1, ans2;
		ans1 = 0;
		ans2 = 0;
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(!v[i][j]){
					ans1++;
					bfs_normal(new coord(j,i), d[i][j]);
				}
				if(!v2[i][j]){
					ans2++;
					bfs_weak(new coord(j,i), d[i][j]);
				}
			}
		}
		System.out.println(ans1 +" "+ans2);
	}
	static void bfs_normal(coord current, char c){
		
		Queue<coord> q = new LinkedList<>();
		v[current.y][current.x] = true;
		q.add(current);
		
		while( !q.isEmpty() ){
			
			coord a = q.remove();
			int x = a.x;
			int y = a.y;
			if(x-1>=0 && !v[y][x-1] && d[y][x-1] == c){
				v[y][x-1] = true;
				q.add(new coord(x-1, y));
			}
			if(x+1<N && !v[y][x+1] && d[y][x+1] == c){
				v[y][x+1] = true;
				q.add(new coord(x+1, y));
			}
			if(y-1>=0 && !v[y-1][x] && d[y-1][x] == c){
				v[y-1][x] = true;
				q.add(new coord(x, y-1));
			}
			if(y+1<N && !v[y+1][x] && d[y+1][x] == c){
				v[y+1][x] = true;
				q.add(new coord(x, y+1));
			}
			
		}
		
		
	}
	
	static void bfs_weak(coord current, char c){
		boolean weak = false;
		if(c == 'R' || c == 'G'){
			weak = true;
		}			
		Queue<coord> q = new LinkedList<>();
		v2[current.y][current.x] = true;
		q.add(current);
		while( !q.isEmpty() ){
			
			coord a = q.remove();
			int x = a.x;
			int y = a.y;
			if(x-1>=0 && !v2[y][x-1]){
				if(weak){
					if(d[y][x-1] == 'R' || d[y][x-1] == 'G'){
						v2[y][x-1] = true;
						q.add(new coord(x-1, y));
					}
				}
				else{
					if(d[y][x-1] == c){
						v2[y][x-1] = true;
						q.add(new coord(x-1, y));
					}
				}
			}
			if(x+1<N && !v2[y][x+1]){
				if(weak){
					if(d[y][x+1] == 'R' || d[y][x+1] == 'G'){
						v2[y][x+1] = true;
						q.add(new coord(x+1, y));
					}
				}
				else{
					if(d[y][x+1] == c){
						v2[y][x+1] = true;
						q.add(new coord(x+1, y));
					}
				}
			}
			if(y-1>=0 && !v2[y-1][x]){
				if(weak){
					if(d[y-1][x] == 'R' || d[y-1][x] == 'G'){
						v2[y-1][x] = true;
						q.add(new coord(x, y-1));
					}
				}
				else{
					if(d[y-1][x] == c){
						v2[y-1][x] = true;
						q.add(new coord(x, y-1));
					}
				}
			}
			if(y+1<N && !v2[y+1][x]){
				if(weak){
					if(d[y+1][x] == 'R' || d[y+1][x] == 'G'){
						v2[y+1][x] = true;
						q.add(new coord(x, y+1));
					}
				}
				else{
					if(d[y+1][x] == c){
						v2[y+1][x] = true;
						q.add(new coord(x, y+1));
					}
				}
			}
			
		}
		
		
	}
}
