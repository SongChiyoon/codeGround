/*
 * https://www.acmicpc.net/problem/11650
 */
import java.util.*;
public class PointSort {
	
	static class point implements Comparable<point>{
		int y, x;
		point(int x, int y){
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(point other) {
			
			if(this.x == other.x){
				return Integer.compare(this.y, other.y);
			}
			else{
				return Integer.compare(this.x, other.x);
			}
		}
	}
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		point[] ps = new point[N];
		for(int i=0;i<N;i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			ps[i] = new point(x,y);
		}
		Arrays.sort(ps);
		StringBuilder result = new StringBuilder();
		for(int i=0;i<N;i++){
			result.append(ps[i].x +" "+ps[i].y +"\n");
		}
		System.out.println(result);
		
	}
}
