import java.util.Scanner;

public class addArray {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] a = new int[N];
		int[] b = new int[M];
		
		for(int i=0;i<N;i++)
			a[i] = sc.nextInt();
		for(int i=0;i<M;i++)
			b[i] = sc.nextInt();
		
		int[] ans = new int[N+M];
		int i=0;
		int j=0;
		int index=0;
		while( i<N && j<M){
			
			if(a[i] < b[j]){
				ans[index] = a[i];
				i++;
			}
			else{
				ans[index] = b[j];
				j++;
			}
			index++;
		}
		while( i<N ){ans[index] = a[i]; i++; index++;}
		while( j<M ){ans[index] = b[j]; j++; index++;}
		for(int l=0; l<N+M; l++){
			System.out.print(ans[l] + " ");
		}
	}
}
