import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 8. 15..
 * https://www.acmicpc.net/problem/11724
 */
public class Connected_Component {
	
	static class node{
		int name;
		private List<edge> edgeList;
		boolean visited;
		node(int name){
			this.name = name;
			this.edgeList = new LinkedList<>();
			visited = false;
		}
		public void addEdge(edge e){this.edgeList.add(e);}
		public List<edge> getEgdeList(){return this.edgeList;}
		public void setVisited(boolean visit){this.visited = visit;}
		public boolean getVisited(){return this.visited;}
	}
	static class edge{
		int target;
		edge(int t){
			this.target = t;
		}
	}
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		node[] node = new node[N+1];
		for(int i=1;i<=N;i++){
			node[i] = new node(i);
		}
		int M = sc.nextInt();
		
		for(int i=0;i<M;i++){			
			int s = sc.nextInt();
			int t = sc.nextInt();
			node[s].addEdge(new edge(t));
		}
		
		int ans = 0;
		for(int i=1;i<=N;i++){
			if( node[i].getVisited())
				continue;
			ans++;
			Queue<node> q = new LinkedList<>();
			q.add(node[i]);
			node[1].setVisited(true);
			while( !q.isEmpty() ){
				
				node a = q.remove();
				for(edge e : a.getEgdeList()){
					
					if(!node[e.target].getVisited()){
						q.add(node[e.target]);
						node[e.target].setVisited(true);
					}
				}
			}
		}
		System.out.println(ans);
		
	}

}
