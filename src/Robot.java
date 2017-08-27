import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 8. 27..
 * problem : https://www.acmicpc.net/problem/1726
 */
public class Robot {

	static class coord{
		int dir;
		int x, y;
		int cost;
		coord(int y, int x, int dir, int cost){
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cost = cost;
		}
	}
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] d = new int[N+1][M+1];
		int[][] c = new int[N+1][M+1];
		
		boolean[][] v = new boolean[N][M];
		for(int i=1;i<=N;i++)
			for(int j=1;j<=M;j++){
				d[i][j] = sc.nextInt();
				c[i][j] = Integer.MAX_VALUE;
			}
		coord start, target;
		start = null;
		target = null;
		for(int i=0;i<2;i++){
			int s =sc.nextInt();
			int t = sc.nextInt();
			int dir = sc.nextInt();
			if(i == 0){
				start = new coord(s, t, dir, 0);
			}else{
				target = new coord(s,t, dir, 0);
			}
		}
		Queue<coord> q = new LinkedList<>();
		start.cost = 0;
		v[start.y][start.x] = true;
		c[start.y][start.x] = 0;
		q.add(start);
		boolean find = false;
		int ans = Integer.MAX_VALUE;
		while( !q.isEmpty() ){
			
			coord a = q.remove();
			int x = a.x;
			int y = a.y;
			//System.out.println(y +","+x+"-"+a.dir +" :"+c[y][x]);
			if(x == target.x && y == target.y){
				find = true;
				//System.out.println("find!");
			}
			int dir = a.dir;
			int cost = a.cost;
			int temp = dir;
			
			for(int i=0;i<4;i++){
				
				if(i==0){
					// no action
				}else if(i == 1){  //오른쪽
					if(temp == 1)
						dir = 3;
					else if(temp ==2)
						dir = 4;
					else if(temp == 3)
						dir = 2;
					else
						dir = 1;
					cost++;
				}else if(i == 2){  //왼쪽
					if(temp == 1)
						dir = 4;
					else if(temp ==2)
						dir = 3;
					else if(temp == 3)
						dir = 1;
					else
						dir = 2;
				}else{
					if(temp == 1)
						dir = 2;
					else if(temp ==2)
						dir = 1;
					else if(temp == 3)
						dir = 4;
					else
						dir = 3;
					cost++;
				}
				
				
				if(find){
					//System.out.println("i : "+i+" dir :"+dir);
					
					if(target.dir == dir){
						ans = Math.min(ans, cost);
						//System.out.println("find "+ans);
						find = false;
					}
				}
			
				if(dir == 1){  //동
					if(x+1<=M&&d[y][x+1] == 1)
						continue;
					if(x+1<=M && d[y][x+1] != 1 && c[y][x+1]-2 >= cost+1){
						c[y][x+1] = cost+1;
						q.add(new coord(y,x+1,dir, cost+1));
					}
					if(x+2<=M&&d[y][x+2] == 1)
						continue;
					if(x+2<=M && d[y][x+2] != 1&& c[y][x+2]-2 >= cost+1){
						c[y][x+2] = cost+1;
						q.add(new coord(y,x+2,dir, cost+1));
					}
					if(x+3<=M&&d[y][x+3] == 1)
						continue;
					if(x+3<=M && d[y][x+3] != 1&& c[y][x+3]-2 >= cost+1){
						c[y][x+3] = cost+1;
						q.add(new coord(y,x+3,dir, cost+1));
					}
				}
				else if(dir == 2){ //서
					if(x-1>0&&d[y][x-1] == 1)
						continue;
					if(x-1>0 && d[y][x-1] != 1&& c[y][x-1]-2 >= cost+1){
						c[y][x-1] = cost+1;
						q.add(new coord(y,x-1,dir, cost+1));
					}
					if(x-2>0&&d[y][x-2] == 1)
						continue;
					if(x-2>0 && d[y][x-2] != 1 && c[y][x-2]-2 >= cost+1){
						c[y][x-2] = cost+1;
						q.add(new coord(y,x-2,dir, cost+1));
					}
					if(x-3>0&&d[y][x-3] == 1)
						continue;
					if(x-3>0 && d[y][x-3] != 1 && c[y][x-3]-2 >= cost+1){
						c[y][x-3] = cost+1;
						q.add(new coord(y,x-3,dir, cost+1));
					}
				}
				else if(dir == 3){ // 남.
					if(y+1<=N&&d[y+1][x] == 1)
						continue;
					if(y+1<=N && d[y+1][x] != 1 && c[y+1][x]-2 >= cost+1){
						c[y+1][x] = cost+1;
						q.add(new coord(y+1,x,dir,cost+1));
					}
					if(y+2<=N&&d[y+2][x] == 1)
						continue;
					if(y+2<=N && d[y+2][x] != 1 && c[y+2][x]-2 >= cost+1){
						c[y+2][x] = cost+1;
						q.add(new coord(y+2,x,dir,cost+1));
					}
					if(y+3<=N&&d[y+3][x] == 1)
						continue;
					if(y+3<=N && d[y+3][x] != 1  && c[y+3][x]-2 >= cost+1){
						//System.out.println("catch");
						c[y+3][x] = cost+1;
						q.add(new coord(y+3,x,dir, cost+1));
					}
				}
				else{
					if(y-1>0&&d[y-1][x] == 1)
						continue;
					if(y-1>0 && d[y-1][x] != 1  && c[y-1][x]-2 >= cost+1){
						c[y-1][x] = cost+1;
						q.add(new coord(y-1,x,dir, cost+1));
					}
					if(y-2>0&&d[y-2][x] == 1)
						continue;
					if(y-2>0 && d[y-2][x] != 1  && c[y-2][x]-2 >= cost+1){
						c[y-2][x] = cost+1;
						q.add(new coord(y-2,x,dir, cost+1));
					}
					if(y-3>0&&d[y-3][x] == 1)
						continue;
					if(y-3>0 && d[y-3][x] != 1  && c[y-3][x]-2 >= cost+1){
						c[y-3][x] = cost+1;
						q.add(new coord(y-3,x,dir,cost+1));
					}
				}
			}
		}
		System.out.println(ans);
		
	}
}
