import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class submitClass {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		submitClass sclass = new submitClass();
		int N,M;
		int[] count;
		int[] c;
		boolean[] visited;
		while((N = sc.nextInt()) < 0 || N > 5000){}
		while((M = sc.nextInt()) < 0 || M > 10000){}
	
		c = new int[N];
		count = new int[M];
		visited = new boolean[N];
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<N;i++){
			c[i] = sc.nextInt();
		}
		sc.close();
		int max = Integer.MIN_VALUE;
		
		do{
			for(int i = 0; i < N; i++){
				if(stack.contains(c[i])){
					
				}
	
			}
		}while(!stack.isEmpty());
		
		System.out.println(count[12]);
	}
	public boolean[] clean(int N){
		boolean[] v = new boolean[N];
		for(int i=0;i<N;i++)
			v[i] = false;
		return v;
	}
	
}
