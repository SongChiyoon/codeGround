
	import java.util.*;
	import java.io.FileInputStream;

	public class findShortPath {
		PriorityQueue<vertex> queue = new PriorityQueue<>();
		public Edge getEdge(vertex s, vertex t, int cost){
			Edge edge = new Edge(s,t,cost);
			return edge;
		}
		public vertex getVertex(int name){
			vertex v = new vertex(name);
			return v;
		}
		public class Edge{
			public vertex startVertex;
			public vertex targetVertex;
			public int cost;
			Edge(vertex s, vertex t, int cost){
				this.startVertex = s;
				this.targetVertex = t;
				this.cost = cost;
			}
		}
		public class vertex implements Comparable<vertex>{
			public int name;
			public int cost = Integer.MAX_VALUE;
			public List<Edge> edgeList;
			public vertex procedure;

			public void addEdge(Edge e){
				edgeList.add(e);
			}

			vertex(int name){
				this.name = name;
				procedure = null;
				edgeList = new ArrayList<>();
			}
			public void clear(){
				cost = Integer.MAX_VALUE;
				procedure = null;
			}
			@Override
			public int compareTo(vertex otherVertex) {
				return Integer.compare(cost, otherVertex.cost);
			}
		}

		public void dfs(vertex source){
			queue.offer(source);
			source.cost = 0;

			while(!queue.isEmpty()){

				vertex currentVertex = queue.remove();

				for(Edge e : currentVertex.edgeList){

					if((e.cost + currentVertex.cost) < e.targetVertex.cost){
						e.targetVertex.cost = e.cost + currentVertex.cost;
						e.targetVertex.procedure = currentVertex;
						queue.offer(e.targetVertex);
					}
				}
			}
		}
		public List<vertex> getResultList(vertex target){
			vertex current = target.procedure;
			List<vertex> resultList = new LinkedList<>();
			if(current == null) {
				System.out.println("error check:"+target.name);
				return null;
			}
			while(current.procedure != null){
				resultList.add(current);
				current = current.procedure;
			}
			return resultList;
		}
		public static void main(String args[]) throws Exception {

			Scanner sc = new Scanner(new FileInputStream("sample_input.txt"));

			//Scanner sc = new Scanner(System.in);

			int TC;
			int test_case;

			TC = sc.nextInt();
			findShortPath solution = new findShortPath();

			for (test_case = 1; test_case <= TC; test_case++) {


				int N = sc.nextInt(); //number of university
				int M = sc.nextInt();
				boolean[] visited = new boolean[N];
				vertex[] v = new vertex[N];
				Edge[] edge = new Edge[M];


				for(int i=0;i<N;i++){
					v[i] = solution.getVertex(i);
					visited[i] = false;
				}

				for (int i = 0; i < M; i++) {
					int s,t,cost;
					s = sc.nextInt();
					t = sc.nextInt();
					cost = sc.nextInt();
					edge[i] = solution.getEdge(v[s-1],v[t-1],cost);
					v[s-1].addEdge(edge[i]);
					v[t-1].addEdge(edge[i]);
				}

				for(int i =0;i<N;i++){   //set start vertex;

					solution.dfs(v[i]);

					for(int j=0;j<N;j++){
						if(i != j) {
							System.out.println("source :"+v[i].name+"target :" + v[j].name);
							if(solution.getResultList(v[j]) != null)

							for (vertex vs : solution.getResultList(v[j])) {
								System.out.println(v[i].name+"-" + v[j].name + " : " + vs.name);
								visited[vs.name] = true;
							}
						}
					}
				}
				System.out.print("Case #");
				for(int i =0;i<N;i++){
					if(visited[i] != true)
						System.out.print((i+1)+" ");
				}
				System.out.println();

			}
		}
}
