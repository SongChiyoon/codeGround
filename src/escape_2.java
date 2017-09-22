import java.util.Arrays;
import java.util.*;


/**
	 * Created by songchiyun on 2017. 9. 22..
	 * problem : https://www.acmicpc.net/problem/3055
	 */
public class escape_2 {
	static class coord{
		int y, x;
		public coord(int y, int x){
			this.y = y;
			this.x = x;
		}
	}

	static int N, M;
	static char[][] d;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int sx, sy;
		sx = sy = -1;
		int tx, ty;
		tx = ty = -1;
		d = new char[N][M];
		int[][] cost = new int[N][M];
		Queue<coord> water = new LinkedList<>();
		for(int i=0;i<N;i++){
			
			String input = sc.next();
			for(int j=0;j<M;j++){
				d[i][j] = input.charAt(j);
				cost[i][j] = Integer.MAX_VALUE;
				if(d[i][j] == '*')
					water.add(new coord(i,j));
				
				if(d[i][j] == 'S')
				{
					sx = j;
					sy = i;
				}
				if(d[i][j] == 'D'){
					tx = j;
					ty = i;
				}
			}
		}
		Queue<coord> q = new LinkedList<>();
		Queue<coord> sub = new LinkedList<>();
		q.add(new coord(sy,sx));
		cost[sy][sx] = 0;
		while(!water.isEmpty() || !q.isEmpty()){
			
			while( !water.isEmpty() ){
				coord a = water.remove();
				int y = a.y;
				int x = a.x;
				if(y-1>=0 && d[y-1][x] == '.'){
					d[y-1][x] = '*';
					sub.add(new coord(y-1,x));
				}
				if(x-1>=0 && d[y][x-1] == '.'){
					d[y][x-1] = '*';
					sub.add(new coord(y,x-1));
				}
				if(y+1 < N && d[y+1][x] == '.'){
					d[y+1][x] = '*';
					sub.add(new coord(y+1,x));
				}
				if(x+1<M && d[y][x+1] == '.'){
					d[y][x+1] = '*';
					sub.add(new coord(y,x+1));
				}
				
			}
			while( !sub.isEmpty() ){
				coord s = sub.remove();
				water.add(s);
			}
			while( !q.isEmpty() ){
				coord a = q.remove();
				int y = a.y;
				int x = a.x;
				if(y-1>=0 && d[y-1][x] == '.'){
					cost[y-1][x] = Math.min(cost[y-1][x], cost[y][x] +1);
					d[y-1][x] = 'S';
					sub.add(new coord(y-1,x));
				}
				if(x-1>=0 && d[y][x-1] == '.'){
					cost[y][x-1] = Math.min(cost[y][x-1], cost[y][x] +1);
					d[y][x-1] = 'S';
					sub.add(new coord(y,x-1));
				}
				if(y+1 < N && d[y+1][x] == '.'){
					cost[y+1][x] = Math.min(cost[y+1][x], cost[y][x] +1);
					d[y+1][x] = 'S';
					sub.add(new coord(y+1,x));
				}
				if(x+1<M && d[y][x+1] == '.'){
					cost[y][x+1] = Math.min(cost[y][x+1], cost[y][x] +1);
					d[y][x+1] = 'S';
					sub.add(new coord(y,x+1));
				}			
				
			}
			while(!sub.isEmpty()){
				coord a = sub.remove();
				q.add(a);
			}

			
			
			
		}

		boolean find = false;
		int ans = Integer.MAX_VALUE;
		if(ty-1 >= 0){
			if(d[ty-1][tx] == 'S'){
				ans = Math.min(ans, cost[ty-1][tx]);
				find = true;
			}
		}
		if(ty+1 < N ){
			if(d[ty+1][tx] == 'S'){
				ans = Math.min(ans, cost[ty+1][tx]);
				find = true;
			}
		}
		if(tx-1 >= 0){
			if(d[ty][tx-1] == 'S'){
				ans = Math.min(ans, cost[ty][tx-1]);
			find = true;
		}
		}
		if(tx+1 <M ){
			if(d[ty][tx+1] == 'S'){
				ans = Math.min(ans, cost[ty][tx+1]);
				find = true;
			}
		}
		if(!find)
			System.out.println("KAKTUS");
		else
			System.out.println(ans+1);
		
		
	
	}
}
