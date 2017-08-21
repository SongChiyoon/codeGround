import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class effectiveHacking {

	static class com implements Comparable<com>{
		int name;
		List<edge> edgeList;
		int get;
		com(int name){
			this.name = name;
			this.get= 0;
			edgeList = new LinkedList<>();
		}
		public void addEdge(edge e){
			this.edgeList.add(e);
		}
		@Override
		public int compareTo(com other) {
			// TODO Auto-generated method stub
			return -Integer.compare(this.get, other.get);
		}
	}
	static class edge{
		int source;
		int target;
		edge(int s, int t){
			this.source = s;
			this.target = t;
		}
	}
	static com[] d;
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		d = new com[N+1];
		for(int i=1;i<=N;i++)
			d[i] = new com(i);

		int M = sc.nextInt();
		for(int i=0;i<M;i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			d[b].addEdge(new edge(b,a));
		}
		PriorityQueue<com> pq = new PriorityQueue<>();
		for(int i=1;i<=N;i++){
			boolean[] v = new boolean[N+1];
			dfs(i,i,v);
			pq.add(d[i]);
		}
		int max = -1;
		while( !pq.isEmpty() ){
			com a = pq.remove();
			if(max != -1 && max > a.get)
				break;

			System.out.print(a.name+" ");
			max = a.get;
		}
		
	}
	static void dfs(int source, int current, boolean[] v){
		//System.out.println(source+":"+d[source].get +", current:"+current);

		v[current] = true;
		for(edge e : d[current].edgeList){
			
			if(!v[e.target]){
				d[source].get++;
				dfs(source, e.target, v);
				
			}
		}
	}
}
