import java.util.LinkedList;
import java.util.Scanner;
/**
 * Created by songchiyun on 2017. 8. 05..
 * kakao problem3
 */
public class kakaoIU {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n =2147483647;

		ans = solution(2147483647);
		System.out.println(ans);
	}
	static long ans = 0;
	static int nump = 0;
	public static int solution(int n) {
	      int answer = 0;
	      int numx = 0;
	      int nump = 0;	  
	      int[] dp = new int[n+1];  // 0 곱해서 온거 / 1 더해서 온거 / 2더해서 온거
	      LinkedList<Integer>[] list = new LinkedList[n+1];
	      for(int i = 1;i < n+1; i++){
	    	  list[i] = new LinkedList<>();
	      }
	      dp[1] = 1;
	      list[1] = new LinkedList<>();
	      list[1].add(0);
	      for(int i = 1;i < n; i++){

	    	  if(dp[i] != 0)
	    	  for(int a : list[i]){
	    		  
	    		  if(a == 0){
	    			  if(i*3 <= n-2){
	    				  dp[(i*3)] += 1;
	    				  list[(i*3)].add(a + 2);
	    			  }
	    		  }
	    		  else{
	    			  if(i+1 <= n){
	    				  dp[(i+1)] +=1;
	    				  list[(i+1)].add(a-1);	    				  
	    			  }
	    			  if(i*3 <= n-2){
	    				  dp[(i*3)] += 1;
	    				  list[(i*3)].add(a + 2);
	    			  }
	    		  }
	    		  
	    	  }
	    	  	 	    	  
	      }

	      for(int a : list[n]){
	    	  if(a == 0){
	    		  
	    		  answer++;
	    	  }
	      }
	      
	      return answer;
	}
	public static void dfs(int n,int a){

		if(a == n){
			if(nump == 0){
				ans++;
				return;
			}
			else{
				return;
			}
		} 
		if(nump != 0){
			if(a+1 <= n){
				nump--;
				dfs(n, a+1);
				nump++;
			}
		}
		if(a*3 <= n-2){
			nump += 2;
			dfs(n, a*3);
			nump -= 2;
		}
		
	}
}
