/**
 * problem : https://www.acmicpc.net/problem/11559
 */
import java.util.*;

public class puyo {

	static class coord{
		int y, x;
		coord(int y,int x){
			this.y =y;
			this.x=x;
		}
	}
	static int N;
	static int M;
	static char[][] d;
	static boolean[][] v;
	public static void main(String[] args) {
		N=12;M=6;
		d = new char[N][M];
		v = new boolean[N][M];
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<12;i++) {
			String line = sc.nextLine();
			for(int j=0;j<M;j++)
				d[i][j]=line.charAt(j);
		}
		init();
		int ans=0;
		List<coord> get;
		boolean flag = false;
		while(true) {
			flag = true;
			List<coord> bomb = new LinkedList<>();
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					
					if(d[i][j] != '.') {
						get = remove(i,j);
						if(get.size() >= 4) {
							flag = false;
							for(coord c : get)
								bomb.add(c);						
						}
						else {
							for(coord c : get)
								v[c.y][c.x] = false;
						}
					}
					
				}
			}
			if(!flag) {
				push(bomb);
				for(coord c : bomb)
					v[c.y][c.x]=false;
				ans++;
			}
			else {
				break;
			}
		}
		System.out.println(ans);
	}
	
	static int[] addy = {1,-1,0,0};
	static int[] addx = {0,0,1,-1};
	static List<coord> remove(int y,int x) {
		Queue<coord> q = new LinkedList<>();
		List<coord> visit = new LinkedList<>();
		v[y][x] = true;
		coord s = new coord(y,x);
		q.add(s);
		visit.add(s);
		while(!q.isEmpty()) {
			coord a = q.remove();
			int ty = a.y;
			int tx = a.x;
			for(int i=0;i<4;i++) {
				if(ty+addy[i]>=0 && ty+addy[i]<N && tx+addx[i]>=0 && tx+addx[i]<M) {
					if(d[ty][tx]==d[ty+addy[i]][tx+addx[i]] && !v[ty+addy[i]][tx+addx[i]]) {

						v[ty+addy[i]][tx+addx[i]] = true;
						coord temp = new coord(ty+addy[i],tx+addx[i]);
						q.add(temp);
						visit.add(temp);
					}
				}
			}
		}

		
		return visit;
		
	}
	static void init() {

		boolean flag = true;
		
		for(int i=N-1;i>0;i--) {
			for(int j=M-1;j>=0;j--) {
				
				if(d[i][j]=='.') {
					
					for(int k=i-1;k>=0;k--) {
						
						if(d[k][j]!='.') {
							if(j==4) {
								//System.out.println(i+" , "+j + "    " + k +" , "+j);
								//System.out.println("debug : "+d[i][j]+" , "+d[k][j]);
							}
							d[i][j] = d[k][j];
							d[k][j] = '.';
							break;
						}
					}
				}
				
			}
		}

		/*
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++)
				System.out.print(d[i][j]);
			System.out.println();
		}
		System.out.println();
		*/
	}
	
	static void push(List<coord> get) {
		for(coord c : get) {
			for(int i=c.y-1;i>=0;i--) {
				
				d[i+1][c.x]=d[i][c.x];
			
			}
			d[0][c.x]='.';
		}

		
	}
}
