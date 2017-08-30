import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 8. 29..
 * problem : https://www.acmicpc.net/problem/2931
 */
public class gas_pipe {

	static class coord{
		int y, x;
		coord(int y, int x){
			this.y = y;
			this.x= x;
		}
	}
	static char[][] d;
	static boolean[][] v;
	static int N,M;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		d = new char[N][M];
		v = new boolean[N][M];
		coord start = null;
		for(int i=0;i<N;i++){
			String input = sc.next();
			for(int j=0;j<M;j++){
			
				d[i][j] = input.charAt(j);
				if(d[i][j] == 'M')
					start = new coord(i,j);

			}
		}	
		build = false;
		find = false;
		int x = start.x;
		int y = start.y;
		v[y][x] = true;
		pre = new coord(y,x);
		if(!find && y-1 >=0)
			if(d[y-1][x] != '.' && d[y-1][x] != '-' && d[y-1][x] != '2' && d[y-1][x] !='3'){
				dfs(new coord(y-1, x));					
			}
		if(!find && y+1<N)
			if(d[y+1][x] != '.' && d[y+1][x] != '-' && d[y+1][x] != '1' && d[y+1][x] !='4'){
				dfs(new coord(y+1,x));
			}
		if(!find && x-1>=0)
			if(d[y][x-1] != '.' && d[y][x-1] != '|' && d[y][x-1] != '3' && d[y][x-1] !='4'){
				dfs(new coord(y,x-1));
			}
		if(!find&&x+1<M)
			if(d[y][x+1] != '.' && d[y][x+1] != '|' && d[y][x+1] != '1' && d[y][x+1] !='2'){
				dfs(new coord(y,x+1));
			}
		
		String c = "|-+1234";
		
		for(int i=0;i<7;i++){
			v = new boolean[N][M];
			v[start.y][start.x] = true;
			d[hole.y][hole.x] = c.charAt(i);
			find = false;
			fail = false;
			if(!find && y-1 >=0)
				if(d[y-1][x] != '.' && d[y-1][x] != '-' && d[y-1][x] != '2' && d[y-1][x] !='3'){
					dfs2(start, new coord(y-1, x));					
				}
			if(!find && y+1<N)
				if(d[y+1][x] != '.' && d[y+1][x] != '-' && d[y+1][x] != '1' && d[y+1][x] !='4'){
					dfs2(start, new coord(y+1,x));
				}
			if(!find && x-1>=0)
				if(d[y][x-1] != '.' && d[y][x-1] != '|' && d[y][x-1] != '3' && d[y][x-1] !='4'){
					dfs2(start, new coord(y,x-1));
				}
			if(!find&&x+1<M)
				if(d[y][x+1] != '.' && d[y][x+1] != '|' && d[y][x+1] != '1' && d[y][x+1] !='2'){
					dfs2(start, new coord(y,x+1));
				}
			
			if(!fail)
				break;
			
			
		}
		System.out.println((hole.y+1) +" "+(hole.x+1)+" "+d[hole.y][hole.x]);
	}
	static boolean build;
	static coord pre;
	static char b;
	static boolean find;
	static coord hole;
	static boolean fail;
	
	static void dfs(coord current){
		
		if(find)
			return;
		if(fail)
			return;
		
		int x = current.x;
		int y = current.y;
		v[y][x] = true;
		if(d[y][x] == '+'){
			pre = current;
			if(x-1>=0 && !v[y][x-1]){
				dfs(new coord(y, x-1));
			}
			if(x+1<M && !v[y][x+1]){
				dfs(new coord(y,x+1));
			}
			if(y-1>=0 && !v[y-1][x]){
				dfs(new coord(y-1,x));
			}
			if(y+1<N && !v[y+1][x]){
				dfs(new coord(y+1,x));
			}
		}
		else if(d[y][x] == '-'){
			pre = current;
			if(!v[y][x-1]){
				dfs(new coord(y,x-1));
			}
			else if(!v[y][x+1]){
				dfs(new coord(y,x+1));
			}
		}
		else if(d[y][x] == '|'){
			pre = current;
			if(!v[y-1][x]){
				dfs(new coord(y-1,x));
			}
			else if(!v[y+1][x]){
				dfs(new coord(y+1,x));
			}
		}
		else if(d[y][x] == '1'){
			pre = current;
			if(!v[y+1][x]){
				dfs(new coord(y+1,x));
			}
			else if(!v[y][x+1]){
				dfs(new coord(y,x+1));
			}
		}
		else if(d[y][x] == '2'){
			pre = current;
			if(!v[y+1][x]){
				dfs(new coord(y+1,x));
			}
			else if(!v[y][x+1]){
				dfs(new coord(y,x+1));
			}
		}
		else if(d[y][x] == '3'){
			pre = current;
			if(!v[y-1][x]){
				dfs(new coord(y-1,x));
			}
			else if(!v[y][x-1]){
				dfs(new coord(y,x-1));
			}
		}
		else if(d[y][x] == '4'){
			pre = current;
			if(!v[y+1][x]){
				dfs(new coord(y+1,x));
			}
			else if(!v[y][x-1]){
				dfs(new coord(y,x-1));
			}
		}
		else if(d[y][x] == '.'){
			if(!build){				
				hole= new coord(y,x);
				find = true;
				build = true;
			}
			else{
				fail = true;
			}
		}
			
		v[y][x] = false;
	}
	static void dfs2(coord pre, coord current){
		
		if(fail)
			return;
		
		int x = current.x;
		int y = current.y;
		v[y][x] = true;

		if(d[y][x] == '+'){
			if(x-1>=0 && !v[y][x-1]){
				dfs2(current,new coord(y, x-1));
			}
			if(x+1<M && !v[y][x+1]){
				dfs2(current,new coord(y,x+1));
			}
			if(y-1>=0 && !v[y-1][x]){
				dfs2(current,new coord(y-1,x));
			}
			if(y+1<N && !v[y+1][x]){
				dfs2(current,new coord(y+1,x));
			}
		}
		else if(d[y][x] == '-'){
			if(pre.x != x-1 && pre.x != x+1){
				fail = true;
				return;
			}
			if(!v[y][x-1]){
				dfs2(current,new coord(y,x-1));
			}
			else if(!v[y][x+1]){
				dfs2(current,new coord(y,x+1));
			}
		}
		else if(d[y][x] == '|'){
			if(pre.y != y-1 && pre.y != y+1){
				fail = true;
				return;
			}
			if(!v[y-1][x]){
				dfs2(current,new coord(y-1,x));
			}
			else if(!v[y+1][x]){
				dfs2(current,new coord(y+1,x));
			}
		}
		else if(d[y][x] == '1'){
			if(pre.x != x+1 && pre.y != y+1){
				fail = true;
				return;
			}
			if(!v[y+1][x]){
				dfs2(current,new coord(y+1,x));
			}
			else if(!v[y][x+1]){
				dfs2(current,new coord(y,x+1));
			}
		}
		else if(d[y][x] == '2'){
			if(pre.y != y-1 && pre.x != x+1){
				fail = true;
				return;
			}
			if(!v[y-1][x]){
				dfs2(current,new coord(y-1,x));
			}
			else if(!v[y][x+1]){
				dfs2(current,new coord(y,x+1));
			}
		}
		else if(d[y][x] == '3'){
			if(pre.y != y-1 && pre.x != x-1){
				fail = true;
				return;
			}
			if(!v[y-1][x]){
				dfs2(current,new coord(y-1,x));
			}
			else if(!v[y][x-1]){
				dfs2(current,new coord(y,x-1));
			}
		}
		else if(d[y][x] == '4'){
			if(pre.x != x-1 && pre.y != y+1){
				fail = true;
				return;
			}
			if(!v[y+1][x]){
				dfs2(current,new coord(y+1,x));
			}
			else if(!v[y][x-1]){
				dfs2(current,new coord(y,x-1));
			}
		}
		else if(d[y][x] == '.'){

				fail = true;
		
		}

		v[y][x] = false;
	}
}
