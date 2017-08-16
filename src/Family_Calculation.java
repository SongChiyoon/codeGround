import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
/**
 * Created by songchiyun on 2017. 8. 16..
 * problem : https://www.acmicpc.net/problem/2644
 */
public class Family_Calculation {

	static class node implements Comparable<node>{
		int name;
		int cost;
		private List<edge> edgeList;
		node(int name){
			this.name = name;
			this.cost = Integer.MAX_VALUE;
			this.edgeList = new LinkedList<>();
		}
		public void addEdge(edge e){
			this.edgeList.add(e);
		}
		public List<edge> getEdgeList(){return this.edgeList;}
		@Override
		public int compareTo(node other) {
			// TODO Auto-generated method stub
			return Integer.compare(this.cost, other.cost);
		}
		
	}
	static class edge{
		int s, t;
		edge(int s, int t){
			this.s = s;
			this.t = t;
		}
	}
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		node[] d = new node[N+1];
		for(int i=1;i<=N;i++){
			d[i] = new node(i);
		}
		int source = sc.nextInt();
		int target = sc.nextInt();
		int T = sc.nextInt();
		for(int t=0;t<T;t++){
			
			int x = sc.nextInt();  //부모
			int y = sc.nextInt(); //자식
			d[x].addEdge(new edge(x,y));
			d[y].addEdge(new edge(y,x));
		}
		
		d[source].cost = 0;
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.add(d[source]);
		
		while( !pq.isEmpty() ){
			
			node active = pq.remove();
			for(edge e : active.getEdgeList()){
				
				if(d[e.t].cost > active.cost + 1){
					d[e.t].cost = active.cost+1;
					pq.add(d[e.t]);
				}
			}
		}
		int ans = d[target].cost;
		if(ans == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans);
		
		
		
		
		
		
	}
}
