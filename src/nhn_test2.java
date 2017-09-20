package NHN_preTest1;

import java.util.Scanner;

public class test2 {
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] d = new int[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++){
				d[i][j] = sc.nextInt();
			}
		
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(d[j][i] + " ");
			}
			System.out.println();
		}
	}
}
