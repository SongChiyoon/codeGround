import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 8. 17..
 * problem : https://www.acmicpc.net/problem/14503
 */
public class RobotCleaner {

	static int N,M;
	static int[][] d;
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		d = new int[N][M];
		boolean[][] v= new boolean[N][M];
		int sy = sc.nextInt();
		int sx = sc.nextInt();
		int state = sc.nextInt();  //0 북쪽 / 2 남쪽 / 1 동쪽 / 2 서쪽
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				d[i][j] =sc.nextInt();
		
		v[sy][sx] = true;
		int x = sx;
		int y = sy;
		int count = 0;
		int ans = 1;
		
		while(sy-1>=0 && sx-1>=0 && sy+1<N && sx+1 <M && d[sy][sx] != 1){
			//go(v, state);
			if(count == 4){
				count = 0;

				if(state == 0){
					sy += 1;
				}
				else if(state == 1){
					sx -= 1;
				}
				else if(state == 2){
					sy -= 1;
				}
				else{
					sx += 1;
				}
				continue;
			}
			
			if(state == 0){  //북쪽을 바라본다면
				if(sx-1>=0 && d[sy][sx-1] == 0 && !v[sy][sx-1]){
					ans ++ ;
					v[sy][sx-1] = true;
					state = 3;
					sx -= 1;
					count = 0;
					continue;
				}
				else{
					state = 3;
					count++;
					continue;
				}
			}
			else if(state == 1){
				if(sy-1>=0 && d[sy-1][sx] == 0 && !v[sy-1][sx]){
					ans ++ ;
					v[sy-1][sx] = true;
					state =0;
					sy -= 1;
					count = 0;
					continue;
				}
				else{
					state = 0;
					count++;
					continue;
				}
			}
			else if(state == 2){
				if(sx+1<M && d[sy][sx+1] == 0 && !v[sy][sx+1]){
					ans ++ ;
					v[sy][sx+1] = true;
					state = 1;
					sx += 1;
					count = 0;
					continue;
				}
				else{
					state = 1;
					count++;
					continue;
				}
			}
			else{   // state == 3
				if(sy+1<N && d[sy+1][sx] == 0 && !v[sy+1][sx]){
					ans ++ ;
					v[sy+1][sx] = true;
					state = 2;
					sy += 1;
					count = 0;
					continue;
				}
				else{
					state = 2;
					count++;
					continue;
				}
			}
			
			
			
		}
		
		System.out.println(ans);
		
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(v[i][j])
					System.out.print(3+" ");
				else
					System.out.print(d[i][j] +" ");
			}
			System.out.println();
		}
		
	}
	
	static void go(boolean[][] v, int state){
		if(state == 0){
			System.out.println("북");
		}
		else if(state==1){
			System.out.println("동");

		}
		else if(state == 2){
			System.out.println("남");

		}
		else{
			System.out.println("서");

		}
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(v[i][j])
					System.out.print(3+" ");
				else
					System.out.print(d[i][j] +" ");
			}
			System.out.println();
		}
		System.out.println();

	}
	
}
