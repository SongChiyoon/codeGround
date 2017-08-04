import java.util.Scanner;
import java.util.Stack;

class coord{
	int y, x;
	coord(int y, int x){
		this.y = y;
		this.x = x;
	}
}
public class OrganicCabbage {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;t++){
			int M = sc.nextInt(); //가로길이 
			int N = sc.nextInt(); // 세로 길이
			int[][] d = new int[N][M];
			boolean[][] v = new boolean[N][M];
			int K = sc.nextInt();
			for(int i=0;i<K;i++){
				int a = sc.nextInt();
				int b = sc.nextInt();
				d[b][a] = 1;
			}
		
			int ans = 0;
			Stack<coord> s = new Stack<>();
			for(int i=0;i<N;i++){
				for(int j=0;j<M;j++){
					if(!v[i][j] && d[i][j] == 1){
						coord c = new coord(i, j);
						v[i][j] = true;
						s.push(c);
						while( !s.isEmpty() ){
							coord a = s.pop();
							int x = a.x;
							int y = a.y;
							if(x-1>=0)
								if(d[y][x-1] == 1 && !v[y][x-1]){
								v[y][x-1] = true;
								s.push(new coord(y, x-1));
							}
							if(x+1<M) 
								if(d[y][x+1] == 1 && !v[y][x+1]){
								v[y][x+1] = true;
								s.push(new coord(y, x+1));
							}
							if(y-1>=0)
								if(d[y-1][x]==1 && !v[y-1][x]){
								v[y-1][x] = true;
								s.push(new coord(y-1,x));
							}
							if(y+1<N)
								if(d[y+1][x]==1 && !v[y+1][x]){
								v[y+1][x] = true;
								s.push(new coord(y+1,x));
							}
						}
						ans++;
					}
					
				}
			}
			System.out.println(ans);
		}
		
	}
}
