import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 8. 23..
 * https://www.acmicpc.net/problem/9205
 */
public class Beer_walking {

	static class coord implements Comparable<coord>{
		int x, y;
		double cost;
		int name;
		coord(int x, int y, int name){
			this.x = x;
			this.y = y;
			this.name = name;
			this.cost = Double.MAX_VALUE;
		}
		@Override
		public int compareTo(coord other) {
			// TODO Auto-generated method stub
			return Double.compare(this.cost, other.cost);
		}
	}
	static coord[] d;
	static boolean[] v;
	static int N;
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;t++){
			
			N = sc.nextInt();
			d = new coord[N+2];
			v = new boolean[N+2];
			for(int i=0;i<=N+1;i++){
				int x = sc.nextInt();
				int y = sc.nextInt();
				d[i] = new coord(x,y, i);
			}
			d[0].cost = 0;
			coord target = d[N+1];
			find = false;
			PriorityQueue<coord> pq = new PriorityQueue<>();
		
			//Queue<coord> pq = new LinkedList<>();
			pq.add(d[0]);
			v[0] = true;
			
			while( !pq.isEmpty() && !find){
				
				coord a = pq.remove();
				//System.out.println(a.name+" cost:"+a.cost);
				for(int i=0;i<=N+1;i++){
					if(v[i])
						continue;
					
					double distance = distance(a, d[i]);
					if(distance <= 20*50){
						if(i == N+1){
							find = true;
							break;
						}
						d[i].cost = distance(d[i], target);
						pq.add(d[i]);
						v[i] = true;
					}
					
				}
			
			}
			if(find)
				System.out.println("happy");
			else
				System.out.println("sad");
			
			
		}
		
	}
	static double distance(coord a, coord b){
		return Math.abs(a.x - b.x) + Math.abs(a.y-b.y);
	}
	static boolean find;
	static void dfs(int current){
		
		if(current == N+1){
			find = true;
			return;
		}
		v[current] = true;
		for(int i=1;i<=N+1;i++){
			
			if(!v[i] && 20*50 >= Math.sqrt(Math.pow(d[current].x-d[i].x, 2)+Math.pow(d[current].y-d[i].y, 2))){
				dfs(i);
				if(find)
					return;
			}
		}
		v[current] = false;
	}
}
