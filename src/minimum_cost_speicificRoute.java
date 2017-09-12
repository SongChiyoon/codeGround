import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;


/* Created by songchiyun on 2017. 9. 12..
 * problem : https://www.acmicpc.net/problem/1504
 */
public class minimum_cost_speicificRoute {
	static class node implements Comparable<node>{
		List<edge> edgeList;
		int cost;
		int name;
		node(int name){
			this.name = name;
			edgeList = new LinkedList<>();
			this.cost = Integer.MAX_VALUE;
		}
		public void addEdge(edge e){
			this.edgeList.add(e);
		}
		@Override
		public int compareTo(node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.cost, o.cost);
		}
	}
	static class edge{
		int t;
		int cost;
		edge(int t, int cost){
			this.t= t;
			this.cost= cost;
		}
	}
	static int n;
	static node[] d;
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		d = new node[n+1];
		for(int i=1;i<=n;i++)
			d[i] = new node(i);
		int m = sc.nextInt();
		for(int i=0;i<m;i++){
			int s = sc.nextInt();
			int t = sc.nextInt();
			int cost = sc.nextInt();
			d[s].addEdge(new edge(t, cost));
			d[t].addEdge(new edge(s, cost));			
		}
		int t1 = sc.nextInt();
		int t2 = sc.nextInt();
		int ans = Integer.MAX_VALUE;
		for(int i=0;i <= 2;i++){
			
			int cost = 0;
			if(i == 0){
				init();
				int c1 = djktra(1, t1, d);
				init();
				int c2 = djktra(t1, t2, d);
				init();
				int c3 = djktra(t2, n, d);
				ans = Math.min(ans, c1+c2+c3);
			}
			else{
				init();
				int c1 = djktra(1, t2, d);
				init();
				int c2 = djktra(t2, t1, d);
				init();
				int c3 = djktra(t1, n, d);
				ans = Math.min(ans, c1+c2+c3);
			}
			
		}
		System.out.println(ans);
	}
	static void init(){
		for(int i=1;i<=n;i++)
			d[i].cost = Integer.MAX_VALUE;
	}
	static int djktra(int source, int target, node[] d){
		
		PriorityQueue<node> pq = new PriorityQueue<>();
		d[source].cost = 0;
		pq.add(d[source]);
		while( !pq.isEmpty() ){
			
			node a = pq.remove();
			for(edge e : a.edgeList){
				
				if(d[e.t].cost > a.cost + e.cost ){
					d[e.t].cost = a.cost+e.cost;
					pq.add(d[e.t]);
				}
				
			}
		}
		return d[target].cost;
	}
	
}
