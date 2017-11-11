/*
 * problem : https://www.acmicpc.net/problem/2580
 */
import java.util.*;
public class sudoku {

	static class coord{
		int y, x;
		coord(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	static int[][] d;
	static int N=9;
	static boolean flag = false;
	static Stack<coord> stack = new Stack<>();
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		d = new int[N][N];
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++) {
				d[i][j] = sc.nextInt();
				if(d[i][j] == 0)
					stack.add(new coord(i,j));
			}
		go();
	}
	static void go() {
		
		if(stack.isEmpty()) {
			//Ãâ·Â
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					System.out.print(d[i][j]+" ");
				}
				System.out.println();
			}
			flag = true;
			return;
		}
		coord current = stack.pop();
		int x = current.x;
		int y = current.y;
		for(int i=1;i<=9;i++) {
			
			if(safe(i,y,x)) {
				d[y][x]=i;
				go();
				if(flag)
					return;
				d[y][x]=0;
			}			
		}
		stack.add(current);
		
	}
	
	
	public static boolean safe(int num, int y, int x) {
		
		for(int i=0;i<N;i++) {
			if(d[y][i]==num)
				return false;
			if(d[i][x]==num)
				return false;
		}
		int sx = x/3;
		int sy = y/3;
		for(int i=3*sy;i<3*sy+3;i++) {
			for(int j=3*sx;j<3*sx+3;j++) {
				if(d[i][j]==num)
					return false;
			}
		}
		return true;
	}
}
