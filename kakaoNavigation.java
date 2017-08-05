import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by songchiyun on 2017. 8. 05..
 * kakao problem2
 */
public class kakaoNavigation {
	static int MOD = 20170805;
	static int[][] map;
	static boolean[][] v;
	static int[][][] log;
	static int M, N;
	static int ans;
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int m =3;
		int n = 3;
		int[][] a = new int[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				a[i][j] = sc.nextInt();
			}
		}
		kakaoNavigation t = new kakaoNavigation();
		System.out.println(t.solution(m, n, a));
		
	}
	  public int solution(int m, int n, int[][] cityMap) {
	      int answer = 0;
	      ans = 0;
	      M = m;
	      N = n;
	      v = new boolean[m][n];
	      log = new int[m][n][2];
	      map = cityMap;

	      
	      answer = (int)dp();
	      
	      return answer;
	  }
	  static class coord{
		  int x, y;
		  int state;
		  coord(int x,int y, int state){
			  this.x = x;
			  this.y = y;
			  this.state = state;
		  }
	  }
	  public static long dp(){
		  
		  long[][][] dp = new long[M][N][2];  // 0 -> 왼쪽으로 / 1-> 위에서

		  for(int i=0;i<M;i++){
			  if(i==0){
				  dp[0][0][0] = 1;
			  }
			  if(i == 1){
				  dp[0][0][0] = 0;
				  dp[0][0][1] = 1;
			  }
			  for(int j=0;j<N;j++){
				  
				  if(map[i][j] == 1){
					  continue;
				  }
				  
				  else if(map[i][j] == 0){
					  if(j-1>=0){
						 if(map[i][j-1] == 1) dp[i][j][0] = 0;
						 else if(map[i][j-1] ==0){
							 dp[i][j][0] = (dp[i][j-1][0] + dp[i][j-1][1])%MOD;
						 }
						 else dp[i][j][0] = dp[i][j-1][0];
					  }
					  if(i-1>=0){
						 if(map[i-1][j] == 1) dp[i][j][1] = 0;
						 else if(map[i-1][j] ==0) dp[i][j][1] = (dp[i-1][j][0] + dp[i-1][j][1])%MOD;
						 else dp[i][j][1] = dp[i-1][j][1]; 
					  }
				  }
				  else{
					  if(j-1>=0){
						  if(map[i][j-1] == 1) dp[i][j][0] = 0;
							 else if(map[i][j-1] ==0){
								 dp[i][j][0] = (dp[i][j-1][0] + dp[i][j-1][1])%MOD;
							 }
							 else dp[i][j][0] = dp[i][j-1][0];
						  
					  }
					  if(i-1>=0){
						 if(map[i-1][j] == 1) dp[i][j][1] = 0;
						 else if(map[i-1][j] ==0) dp[i][j][1] = (dp[i-1][j][0] + dp[i-1][j][1])%MOD;
						 else dp[i][j][1] = dp[i-1][j][1]; 
					  }
					  
				  }
			  }
		  }
		  
		  
		  return (dp[M-1][N-1][0] + dp[M-1][N-1][1])%MOD;
	  }
	  public static void dfs(coord c){
		  Stack<coord> s = new Stack<>();
		  s.push(c);
		  while( !s.isEmpty() ){
			  
			  coord a = s.pop();
			  int x = a.x;
			  int y = a.y;
			  int state = a.state;
			  v[y][x] = true;
			  if(x == N-1 && y == M-1){
				  ans++;
				  find = true;
				  continue;
			  }
			  
			  if(map[y][x] == 1) continue;
			  else if(map[y][x] == 2){
				  if(state == 0){
					  if(y+1<M)
						  s.push(new coord(x,y+1,0));
				  }
				  else{
					  if(x+1<N)
						  s.push(new coord(x+1,y,1));
				  }
				  
			  }
			  else{
				  if(y+1<M){
					  s.push(new coord(x,y+1,0));
				  }
				  if(x+1<N){
					  s.push(new coord(x+1,y,1));
				  }
				  
			  }
			  
		  }
		  
	  }
	  static boolean find = false;
	  public static void dfs(int state, int x, int y){   //state = 0  아래로  state = 1  왼쪽에서
		  if(x == N-1 && y == M-1){
			  find = true;
			  ans++;
			  return;
		  }
		  
		  if(map[y][x] == 1) return;
		  
		  else if(map[y][x] == 2){
			  if(state == 0){
				  if(y+1<M){
					  if(log[y][x][0] != 0){
						 ans += log[y][x][0]; 
					  }
					  else{
						  dfs(0, x, y+1);
						  if(find){
							  log[y][x][0] += 1;
							  find = false;
						  }
					  }
				  }
			  }
			  else{
				  if(x+1<N){
					  if(log[y][x][1] != 0){
						 ans += log[y][x][1]; 
					  }
					  else{
						  dfs(1, x+1, y);
						  if(find){
							  log[y][x][1] += 1;
							  find = false;
						  }
					  }
				  }
			  }
			  
		  }
		  else{
			  if(y+1<M){
				  if(log[y][x][0] != 0){
					  ans += log[y][x][0];
				  }
				  else{
					  dfs(0, x, y+1);
					  if(find){
						  log[y][x][0] += 1;
						  find = false;
					  }
				  }
			  }
			  if(x+1<N){
				  if(log[y][x][1] != 0){
					  ans += log[y][x][1];
				  }
				  else{
					  dfs(1, x+1, y);
					  if(find){
						  log[y][x][1] += 1;
						  find = false;
					  }
				  }
			  }
			  
		  }		  		  
	  }
}
