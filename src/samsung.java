import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class samsung {

	public static void main(String[] args) throws FileNotFoundException{
		
		Scanner sc = new Scanner(new FileInputStream("samsung.txt"));
		int T = sc.nextInt();
		for(int test_case = 1; test_case <=T; test_case++){
			
			int M = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			int dir = sc.nextInt();
			int[][] d = new int[M][M];
			boolean[][] v = new boolean[M][M];
			
			for(int i = 0; i < M; i++){
				for(int j = 0; j < M; j++){
					d[i][j] = sc.nextInt();
					System.out.print(d[i][j]);
					v[i][j] = false;
				}
				System.out.println();
			}
			
			v[y][x] = true;
			int i = y;
			int j = x;
			v[i][j] = true;
			d[i][j] = 5;
			int count = 1;
			
			while(true){
				if(dir == 0){
					if(d[i][j-1] != 1 && !v[i][j-1]){
						j = j-1;count++;
						v[i][j] = true;
						dir = 3;
						continue;
					}
					if(d[i-1][j] != 1 && !v[i-1][j]){
						i = i-1;count++;
						v[i][j] = true;
						dir = 0;
						continue;
					}
					if(d[i][j+1] != 1 && !v[i][j+1]){
						j = j+1;count++;
						v[i][j] = true;
						dir = 1;
						continue;
					}
					if(d[i+1][j] == 1) break;
					
					else{
						i = i+1;
					}
				}
				else if(dir == 1){
					if(d[i-1][j] != 1 && !v[i-1][j]){
						i = i-1;count++;
						v[i][j] = true;
						dir = 0;
						continue;
					}
					if(d[i][j+1] != 1 && !v[i][j+1]){
						j = j+1;count++;
						v[i][j] = true;
						dir = 1;
						continue;
					}
					if(d[i+1][j] != 1 && !v[i+1][j]){
						i = i+1;count++;
						v[i][j] = true;
						dir = 2;
						continue;
					}
					if(d[i][j-1] == 1) break;
					else{
						j = j-1;
					}
				}
				else if(dir == 2){
					if(d[i][j+1] != 1 && !v[i][j+1]){
						j = j+1;count++;
						v[i][j] = true;
						dir = 1;
						continue;
					}
					if(d[i+1][j] != 1 && !v[i+1][j]){
						i = i+1;count++;
						v[i][j] = true;
						dir = 2;
						continue;
					}
					if(d[i][j-1] != 1 && !v[i][j-1]){
						j = j-1;count++;
						v[i][j] = true;
						dir = 3;
						continue;
					}
					if(d[i-1][j] == 1) break;
					else{
						i = i-1;
					}
					
				}
				else{
					if(d[i+1][j] != 1 && !v[i+1][j]){
						i = i+1;count++;
						v[i][j] = true;
						dir = 2;
						continue;
					}
					if(d[i][j-1] != 1 && !v[i][j-1]){
						j = j-1;count++;
						v[i][j] = true;
						dir = 3;
						continue;
					}
					if(d[i-1][j] != 1 && !v[i-1][j]){
						i = i-1;count++;
						v[i][j] = true;
						dir = 0;
						continue;
					}
					if(d[i][j+1] == 1) break;
					else{
						j = j+1;
					}
				}
				
			}
			for(int l = 0; l < M; l++){
				for(int k = 0; k <M;k++){
					if(!v[l][k]) System.out.print(d[i][j] + "  ");
					else System.out.print("*  ");
					
				}
				System.out.println();
			}
			System.out.println(count);
			
			
		}
	}
}
