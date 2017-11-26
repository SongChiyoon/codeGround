/**
 * Created by songchiyun on 2017. 11. 26..
 * problem : https://www.acmicpc.net/problem/1005
 */
import java.util.*;
public class ACM_Craft {

    static class Building{

        private int name;
        private int cost;
        private int indegree;
        int getTime;
        private List<edge> edgeList;
        Building(int name, int cost){
            this.name = name;
            this.cost = cost;
            this.indegree = 0;
            this.getTime = 0;
            edgeList = new LinkedList<>();
        }
        public void addIndegree(){
            this.indegree++;
        }
        public void deleteIndegree(){
            this.indegree--;
        }
        public int getIndegree(){
            return this.indegree;
        }
        public void addEdge(edge e){this.edgeList.add(e);}
        public List<edge> getEdgeList(){return this.edgeList;}
        public void addCost(int cost){this.cost += cost;}
        public int getCost(){return cost;}
        public int getName(){return name;}

    }
    static class edge{

        int target;
        edge(int target){
            this.target = target;
        }

    }
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=0;t<T;t++){

            int N = sc.nextInt();
            int M = sc.nextInt();
            Building[] buildings = new Building[N+1];

            for(int i=1;i<=N;i++){
                int cost = sc.nextInt();
                buildings[i] = new Building(i, cost);
            }
            for(int i=0;i<M;i++){
                int source = sc.nextInt();
                int target = sc.nextInt();
                buildings[source].addEdge(new edge(target));
                buildings[target].addIndegree();
            }

            int W = sc.nextInt();
            Queue<Building> q = new LinkedList<>();
            for(int i=1;i<=N;i++){
                if(buildings[i].getIndegree() == 0)
                    q.add(buildings[i]);
            }
            while(!q.isEmpty()){

                Building active = q.remove();
                if(active.getName() == W){
                    System.out.println(active.cost + active.getTime);
                    break;
                }
                for(edge e : active.getEdgeList()){
                    buildings[e.target].deleteIndegree();
                    buildings[e.target].getTime = Math.max(active.getCost() + active.getTime, buildings[e.target].getTime);
                    if(buildings[e.target].getIndegree() == 0){

                        q.add(buildings[e.target]);

                    }
                }
            }



        }

    }
}
